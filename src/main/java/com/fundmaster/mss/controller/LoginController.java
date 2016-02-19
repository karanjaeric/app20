package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fundmaster.mss.beans.ejbInterface.*;
import com.fundmaster.mss.common.Helper;
import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
import com.fundmaster.mss.model.User;


@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends GenericController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	Helper helper;
	@EJB
	ProfileNameEJB profileNameEJB;
	@EJB
	UserEJB userEJB;
	@EJB
	CountryEJB countryEJB;
	@EJB
	SettingEJB settingEJB;
	@EJB
	GenderEJB genderEJB;
	@EJB
	CompanyEJB companyEJB;
	@EJB
	SocialEJB socialEJB;
	@EJB
	MenuEJB menuEJB;
	@EJB
	ThemeEJB themeEJB;
	@EJB
	HelpEJB helpEJB;
	@EJB
	PageContentEJB pageContentEJB;
	@EJB
	MaritalStatusEJB maritalStatusEJB;
	@EJB
	ProfileLoginFieldEJB profileLoginFieldEJB;
	@EJB
	BannerEJB bannerEJB;
	@EJB
	PermissionEJB permissionEJB;
	public LoginController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		/* Check if user is already authenticated */
		HttpSession session = request.getSession(false);
		Company company = companyEJB.find();
		request.setAttribute("company", company);
		Social social = socialEJB.find();
		request.setAttribute("social", social);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		Theme theme = themeEJB.find();
		request.setAttribute("theme", theme);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		Help help = helpEJB.findHelp(Constants.PAGE_LOGIN);
		request.setAttribute("help", help);
		if(session != null)
		{
			try {
				if((session.getAttribute(Constants.LOGIN).equals(true) && (helper.isManagerial(session.getAttribute(Constants.U_PROFILE).toString()) || helper.isManager(request))))
				{
					response.sendRedirect(getServletContext().getContextPath() + "/admin");
				}
				else
				{
					request.setAttribute("noMenu", true);
					request.getRequestDispatcher("admin_login.jsp").forward(request, response);	
				}
			}
			catch (Exception e)
			{
				request.setAttribute("noMenu", true);
				request.getRequestDispatcher("admin_login.jsp").forward(request, response);			
			}
		}
		else
		{
			request.setAttribute("noMenu", true);
			request.getRequestDispatcher("admin_login.jsp").forward(request, response); 
		}
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* On Successful Authentication */
		HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
		User u = helper.login(request.getParameter("username"), request.getParameter("password"));
		if(u != null)
		{
			if(u.isStatus())
			{
				JSONObject res = null;
				try {
					res = helper.memberExists(u.getUserProfile(), u.getUsername());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if((res != null && res.get("success").equals(true)) && !res.get("memberId").toString().equals("0"))
					{
						session.setAttribute(Constants.USER, u.getUsername());
						session.setAttribute(Constants.UID, u.getId());
						session.setAttribute(Constants.PROFILE_ID, res.get("memberId"));
						session.setAttribute(Constants.LOGIN, true);
						session.setAttribute(Constants.U_PROFILE, res.get("profile"));
						helper.resetAttempt(request.getParameter("username"));
						helper.logActivity(Constants.AL, "successfully logged in", u.getId().toString(), null, u.getUserProfile());
						try {
							out.write(helper.result(true, "login successful").toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						try {
							out.write(helper.result(false, "Login failed.<br /> Invalid username and/or password.<br /> Please try again").toString());
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace(out);
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						out.write(helper.result(false, "Login failed.<br /> Could not verify your credentials with Xi.<br /> Please try again").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				}
			}
			else
			{
				helper.logAttempt(request.getParameter("username"));
				try {
					out.write(helper.result(false, "Login Failed!<br />You account has been locked or de-activated. Contact the administrator").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
			}
		}
		else
		{
			helper.logActivity(Constants.AL, "login attempt", "0", null, null);
			helper.logAttempt(request.getParameter("username"));
			try {
				out.write(helper.result(false, "Login failed.<br /> Invalid username and/or password.<br /> Please try again").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(out);
			}
			
		}
	}

}
