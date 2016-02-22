package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
import com.fundmaster.mss.model.ProfileLoginField;
import com.fundmaster.mss.model.SchemeMemberManager;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
import com.fundmaster.mss.model.User;


@WebServlet(name = "SignInController", urlPatterns = {"/sign-in"})
public class SignInController extends HttpServlet implements Serializable {

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
	public SignInController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {  
			HttpSession session = request.getSession(false);
			boolean proceed;
			if(session != null)
			{
				try {
					if((session.getAttribute(Constants.LOGIN).equals(true) && (session.getAttribute(Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE) || helper.isManager(request))))
					{
						response.sendRedirect("member");
						proceed = false;
					}
					else
						proceed = true;
				} catch (NullPointerException npe) {
					
					proceed = true;
					
				}
			}
			else
			{
				proceed = true;
			}
				if(proceed)
					
				{
					
					Company company = companyEJB.find();
					request.setAttribute("company", company);
					Social social = socialEJB.find();
					request.setAttribute("social", social);
					Setting settings = settingEJB.find();
					request.setAttribute("settings", settings);
					List<ProfileLoginField> plf = helper.getProfileLoginFields();
					request.setAttribute("loginFields", plf);
					Menu menu = menuEJB.find();
					request.setAttribute("menu", menu);
					Theme theme = themeEJB.find();
					request.setAttribute("theme", theme);
					request.setAttribute("noMenu", false);
					Help help = helpEJB.findHelp(Constants.PAGE_SIGN_IN);
					request.setAttribute("help", help);
					helper.logActivity(Constants.PAGE_SIGN_IN, "accesed home page", "0", null, null);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
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
				try {
					if(u.getUserProfile().equals(Constants.MEMBER_PROFILE))
					{
						JSONObject res = helper.memberExists(u.getUserProfile(), u.getUsername());
						if(res.get("success").equals(true) && Long.valueOf(res.get("memberId").toString()) != 0)
						{
							session.setAttribute(Constants.USER, u.getUsername());
							session.setAttribute(Constants.UID, u.getId());
							session.setAttribute(Constants.PROFILE_ID, res.get("memberId"));
							session.setAttribute(Constants.LOGIN, true);
							session.setAttribute(Constants.U_PROFILE, res.get("profile"));
							session.setAttribute(Constants.SCHEME_ID, res.get("schemeId"));
							helper.resetAttempt(request.getParameter("username"));
							helper.logActivity(Constants.ML, "successfully logged in", u.getId().toString(), null, u.getUserProfile());
							SchemeMemberManager smm = helper.getSchemeManager(u.getId());
							String link = "member";
							if(smm != null)
							{
								session.setAttribute(Constants.MANAGER_PROFILE, Constants.MANAGER);
								link = "admin";
							}
							out.write(helper.result(true, link).toString());

							
						}
						else
							{
								helper.logActivity(Constants.ML, "login attempt", "0", null, null);

									out.write(helper.result(false, "Login Failed!<br />Sorry, but we could not establish your existence in Xi").toString());

								
							}
					}
					else
					{
						helper.logActivity(Constants.ML, "login attempt", "0", null, null);

							out.write(helper.result(false, "Login Failed!<br />Invalid username and/or password<br />Please try again").toString());

					}
				} catch (NullPointerException | JSONException npje) {
					// TODO Auto-generated catch block
					helper.logActivity(Constants.ML, "login attempt", "0", null, null);

						out.write(helper.result(false, "Login Failed!<br />Invalid username and/or password<br />Please try again").toString());

				}
			}
			else
			{
				helper.logAttempt(request.getParameter("username"));

					out.write(helper.result(false, "Login Failed!<br />You account has been locked or de-activated. Contact the administrator").toString());

			}
			
		}
		else
		{
			helper.logActivity(Constants.ML, "login attempt", "0", null, null);
			helper.logAttempt(request.getParameter("username"));

				out.write(helper.result(false, "Login Failed!<br />Invalid username and/or password<br />Please try again").toString());

			
		}
	}

}
