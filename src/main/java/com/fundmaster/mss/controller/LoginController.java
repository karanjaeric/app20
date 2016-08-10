package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.ejb.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;


@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends BaseServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Helper helper = new Helper();
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
	ImageBannerEJB imageBannerEJB;
	@EJB
	PermissionEJB permissionEJB;
	
	JLogger JLogger = new JLogger(this.getClass());
	
	@EJB
	ApiEJB apiEJB;
	
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
				if((session.getAttribute(Constants.LOGIN).equals(true) && (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.ADMIN_PROFILE) || helper.isManager(request))))
				{
					response.sendRedirect(getServletContext().getContextPath() + "/admin");
					
				}
				else
				{
					request.setAttribute("noMenu", true);
					request.getRequestDispatcher("admin_login.jsp").forward(request, response);
				}
			}
			catch (NullPointerException npe)
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
	JLogger jLogger = new JLogger(this.getClass());
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* On Successful Authentication */
		HttpSession session = request.getSession();
    	
		User u = userEJB.findUser(this.get(request, "username"), this.get(request, "password"));

		if(u != null)
		{
			jLogger.i("User found was " + u.getUsername());
			if(u.isStatus())
			{
				try {
					if(u.getUserProfile().equals(Constants.ADMIN_PROFILE)  || u.getUserProfile().equals(Constants.SPONSOR) || u.getUserProfile().equals(Constants.AGENT_PROFILE)
							|| u.getUserProfile().equals(Constants.TRUSTEE) || u.getUserProfile().equals(Constants.MANAGER) || u.getUserProfile().equals(Constants.CUSTOMER_RELATIONSHIP_EXECUTIVE)
							|| u.getUserProfile().equals(Constants.CUSTOMER_RELATIONSHIP_MANAGER)
							)
					{
						XiMember xiMember = apiEJB.memberExists(u.getUserProfile(), u.getUsername());
						if(xiMember != null && xiMember.getId() > 0)
						{
							jLogger.i("XiMember found was " + xiMember.getId());
							session.setAttribute(Constants.USER, u.getUsername());
							session.setAttribute(Constants.UID, u.getId());
							session.setAttribute(Constants.PROFILE_ID, xiMember.getId());
							session.setAttribute(Constants.LOGIN, true);
							session.setAttribute(Constants.U_PROFILE, u.getUserProfile());
							
							resetAttempt(this.get(request, "username"));
							logActivity(Constants.AL, "successfully logged in", u.getId().toString(), null, u.getUserProfile());
							
							this.respond(response, true, "login successful", null);
							
						}
						else
							{
								jLogger.i("Xi Member was not found");
							this.respond(response, false, "Login failed.<br /> We were unable to authenticate you against FundMaster Xi.<br /> Please try again", null);

							}
					}
					else
					{
						logActivity(Constants.AL, "login attempt", "0", null, null);

							this.respond(response, false, "Login Failed!<br />Invalid username and/or password<br />Please try again", null);

					}
				} catch (NullPointerException npe) {
					// TODO Auto-generated catch block
					logActivity(Constants.AL, "login attempt", "0", null, null);

						this.respond(response, false, "Login Failed!<br />Invalid username and/or password<br />Please try again", null);

				}
			}
			else
			{
				logAttempt(this.get(request, "username"));

					this.respond(response, false, "Login Failed!<br />You account has been locked or de-activated. Contact the administrator", null);

			}
			
		}
		else
		{
			logActivity(Constants.AL, "login attempt", "0", null, null);
			logAttempt(this.get(request, "username"));

				this.respond(response, false, "Login Failed!<br />Invalid username and/or password<br />Please try again", null);

			
		}
		
	} 

}
