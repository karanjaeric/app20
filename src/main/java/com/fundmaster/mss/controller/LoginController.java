package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;


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

	public LoginController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		/* Check if user is already authenticated */
		HttpSession session = request.getSession(false);
		Company company = getCompany();
		request.setAttribute("company", company);
		Social social = getSocial();
		request.setAttribute("social", social);
		Menu menu = getMenu();
		request.setAttribute("menu", menu);
		Theme theme = getTheme();
		request.setAttribute("theme", theme);
		Setting settings = getSettings();
		request.setAttribute("settings", settings);
		Help help = getHelpByPage(Common.PAGE_LOGIN);
		request.setAttribute("help", help);
		if(session != null)
		{
			try {
				if(session.getAttribute("login").equals("1"))
				{
					response.sendRedirect(getServletContext().getContextPath() + "/admin");
				}
				else
				{
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
		User u = login(request.getParameter("username"), request.getParameter("password"));
		if(u != null)
		{
			if(u.isStatus())
			{
				JSONObject res = null;
				try {
					res = memberExists(u.getUserProfile(), u.getUsername(), false);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if(res.get("success").equals(true) && !res.get("memberId").toString().equals("0"))
					{
						session.setAttribute(Common.USER, u.getUsername());
						session.setAttribute(Common.UID, u.getId());
						session.setAttribute(Common.PROFILE_ID, res.get("memberId"));
						session.setAttribute(Common.LOGIN, true);
						session.setAttribute(Common.U_PROFILE, res.get("profile"));
						resetAttempt(request.getParameter("username"));
						logActivity(Common.AL, "successfully logged in", u.getId().toString(), null, u.getUserProfile());
						try {
							out.write(result(true, "login successful").toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						try {
							out.write(result(false, "Login failed.<br /> Invalid username and/or password.<br /> Please try again").toString());
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace(out);
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						out.write(result(false, "Login failed.<br /> Could not verify your credentials with Xi.<br /> Please try again").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
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
			logActivity(Common.AL, "login attempt", "0", null, null);
			logAttempt(request.getParameter("username"));
			try {
				out.write(result(false, "Login failed.<br /> Invalid username and/or password.<br /> Please try again").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(out);
			}
			
		}
	}

}
