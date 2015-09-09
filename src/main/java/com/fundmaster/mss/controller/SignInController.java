package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.common.Common;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.ProfileLoginField;
import com.fundmaster.mss.model.SchemeMemberManager;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
import com.fundmaster.mss.model.User;


@WebServlet(name = "SignInController", urlPatterns = {"/sign-in"})
public class SignInController extends GenericController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SignInController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = getCompany();
		request.setAttribute("company", company);
		Social social = getSocial();
		request.setAttribute("social", social);
		Setting settings = getSettings();
		request.setAttribute("settings", settings);
		List<ProfileLoginField> plf = getProfileLoginFields();
		request.setAttribute("loginFields", plf);
		Menu menu = getMenu();
		request.setAttribute("menu", menu);
		Theme theme = getTheme();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = getHelpByPage(Common.PAGE_SIGN_IN);
		request.setAttribute("help", help);
		logActivity(Common.PAGE_SIGN_IN, "accesed home page", "0", null, null);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* On Successful Authentication */
		HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
		User u = login(request.getParameter("username"), request.getParameter("password"));
		if(u != null)
		{

			if(u.isStatus())
			{
				try {
					if(u.getUserProfile().equals(Common.MEMBER_PROFILE))
					{
						JSONObject res = memberExists(u.getUserProfile(), u.getUsername(), false);
						Logger.getAnonymousLogger().info(res.toString());
						if(res.get("success").equals(true) && Integer.parseInt(res.get("memberId").toString()) != 0)
						{
							session.setAttribute(Common.USER, u.getUsername());
							session.setAttribute(Common.UID, u.getId());
							session.setAttribute(Common.PROFILE_ID, res.get("memberId"));
							session.setAttribute(Common.LOGIN, true);
							session.setAttribute(Common.U_PROFILE, res.get("profile"));
							session.setAttribute(Common.SCHEME_ID, res.get("schemeId"));
							resetAttempt(request.getParameter("username"));
							logActivity(Common.ML, "successfully logged in", u.getId().toString(), null, u.getUserProfile());
							SchemeMemberManager smm = getSchemeManager(u.getId());
							String link = "member";
							try {
								if(!smm.equals(null))
								{
									session.setAttribute(Common.MANAGER_PROFILE, Common.MANAGER);
									link = "admin";
								}
							}
							catch (Exception ex)
							{
								
							}
							try {
								out.write(result(true, link).toString());
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace(out);
							}
							
						}
						else
							out.write(res.toString());
					}
					else
					{
						logActivity(Common.ML, "login attempt", "0", null, null);
						try {
							out.write(result(false, "Login Failedd!<br />Invalid username and/or password<br />Please try again").toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace(out);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace(out);
					// TODO Auto-generated catch block
					logActivity(Common.ML, "login attempt", "0", null, null);
					try {
						out.write(result(false, "Login Fadiled!<br />Invalid username and/or password<br />Please try again").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(out);
					}
				}
			}
			else
			{
				logAttempt(request.getParameter("username"));
				try {
					out.write(result(false, "Login Failed!<br />You account has been locked or de-activated. Contact the administrator").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
			}
			
		}
		else
		{
			logActivity(Common.ML, "login attempt", "0", null, null);
			logAttempt(request.getParameter("username"));
			try {
				out.write(result(false, "Login Failed!<br />Invalid username and/or password<br />Please try again").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(out);
			}
			
		}
	}

}
