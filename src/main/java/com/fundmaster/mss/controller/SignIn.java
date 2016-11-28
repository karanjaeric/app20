package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;
import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.common.Constants;
@WebServlet(name = "SignIn", urlPatterns = {"/sign-in"})
public class SignIn extends BaseServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLogger jLogger = new JLogger(this.getClass());
    Helper helper = new Helper();
	@EJB
	ProfileNameBeanI profileNameBeanI;
	@EJB
	UserBeanI userBeanI;
	@EJB
	CountryBeanI countryBeanI;
	@EJB
	SettingBeanI settingBeanI;
	@EJB
	GenderBeanI genderBeanI;
	@EJB
	CompanyBeanI companyBeanI;
	@EJB
	EmailsBeanI emailsBeanI;
	@EJB
	SocialBeanI socialBeanI;
	@EJB
	MenuBeanI menuBeanI;
	@EJB
	ThemeBeanI themeBeanI;
	@EJB
	HelpBeanI helpBeanI;
	@EJB
	PageContentBeanI pageContentBeanI;
	@EJB
	MaritalStatusBeanI maritalStatusBeanI;
	@EJB
	ProfileLoginFieldBeanI profileLoginFieldBeanI;
	@EJB
	ImageBannerBeanI imageBannerBeanI;
	@EJB
	PermissionBeanI permissionBeanI;
	@EJB
	ApiEJB apiEJB;
	public SignIn() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {  
			HttpSession session = request.getSession(false);
			boolean proceed;
			
			if(session != null)
			{
				try {
					if((session.getAttribute(Constants.LOGIN).equals(true) && (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE)

							|| helper.isManager(request))))
					{
						response.sendRedirect("member");
						proceed = false;
					}
					else if ((session.getAttribute(Constants.LOGIN).equals(true) && this.getSessKey(request, Constants.U_PROFILE).equals(Constants.PENSIONER)))
					{
						response.sendRedirect("pensioner");
						proceed = false;

					} else
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
					
					Company company = companyBeanI.find();
					request.setAttribute("company", company);
					Emails email = emailsBeanI.find();
					request.setAttribute("email", email);
					Social social = socialBeanI.find();
					request.setAttribute("social", social);
					Setting settings = settingBeanI.find();
					request.setAttribute("settings", settings);
					List<ProfileLoginField> plf = profileLoginFieldBeanI.find();
					request.setAttribute("loginFields", plf);
					Menu menu = menuBeanI.find();
					request.setAttribute("menu", menu);
					Theme theme = themeBeanI.find();
					request.setAttribute("theme", theme);
					request.setAttribute("noMenu", false);
					Help help = helpBeanI.findHelp(Constants.PAGE_SIGN_IN);
					request.setAttribute("help", help);
					logActivity(Constants.PAGE_SIGN_IN, "accesed home page", "0", null, null);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}
	}
	@EJB
	SchemeManagerBeanI schemeManagerBeanI;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
    	
		User u = userBeanI.findUser(this.get(request, "username"), this.get(request, "password"));
		if(u != null)
		{

			if(u.isStatus())
			{
				try {
					if(u.getUserProfile().equals(Constants.MEMBER_PROFILE))
					{
						XiMember member = apiEJB.memberExists(u.getUserProfile(), u.getUsername());
						if(member != null && member.getId() > 0)
						{
							
							session.setAttribute(Constants.USER, u.getUsername());

							session.setAttribute(Constants.UID, u.getId());
							session.setAttribute(Constants.PROFILE_ID, member.getId());
							session.setAttribute(Constants.LOGIN, true);
							session.setAttribute(Constants.U_PROFILE, member.getProfile());
							session.setAttribute(Constants.SCHEME_ID, member.getSchemeId());
							resetAttempt(this.get(request, "username"));
							logActivity(Constants.ML, "successfully logged in", u.getId().toString(), null, u.getUserProfile());
							SchemeMemberManager smm = schemeManagerBeanI.findByUserID(u.getId());
							String link = "member";
							if(smm != null)
							{
								session.setAttribute(Constants.MANAGER_PROFILE, Constants.MANAGER);
								link = "admin";
							}
							this.respond(response, true, "", new JSONObject().put("link", link));
						}
						else
							{
								logActivity(Constants.ML, "login attempt", "0", null, null);

								this.respond(response, false, "Login Failed!<br />Sorry, but we could not establish your existence in Xi", null);

								
							}
					}
					else if(u.getUserProfile().equals(Constants.PENSIONER)) {
						String usrname = u.getUsername();
						jLogger.i("Usrname is " + usrname );
						usrname = usrname.replaceAll("/","-");
						jLogger.i("Usrname after replace is " + usrname );
						XiMember member = apiEJB.memberExists(u.getUserProfile(), usrname);
						if(member != null && member.getId() > 0)
						{
							session.setAttribute(Constants.USER, u.getUsername());
							session.setAttribute(Constants.UID, u.getId());
							session.setAttribute(Constants.PROFILE_ID, member.getId());
							session.setAttribute(Constants.LOGIN, true);
							session.setAttribute(Constants.U_PROFILE, member.getProfile());
							session.setAttribute(Constants.SCHEME_ID, member.getSchemeId());

							resetAttempt(this.get(request, "username"));
							logActivity(Constants.ML, "successfully logged in", u.getId().toString(), null, u.getUserProfile());
							SchemeMemberManager smm = schemeManagerBeanI.findByUserID(u.getId());
							String link = "pensioner";
							if(smm != null)
							{
								session.setAttribute(Constants.MANAGER_PROFILE, Constants.MANAGER);
								link = "admin";
							}
							this.respond(response, true, "", new JSONObject().put("link", link));
						}
						else
						{
							logActivity(Constants.ML, "login attempt", "0", null, null);

							this.respond(response, false, "Login Failed!<br />Sorry, but we could not establish your existence in Xi", null);


						}
					}
					else
					{
						logActivity(Constants.ML, "login attempt", "0", null, null);

							this.respond(response, false, "Login Failed!<br />Invalid username and/or password<br />Please try again", null);

					}
				} catch (NullPointerException | JSONException npje) {
					npje.printStackTrace();
					// TODO Auto-generated catch block
					logActivity(Constants.ML, "login attempt", "0", null, null);

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
			logActivity(Constants.ML, "login attempt", "0", null, null);
			logAttempt(this.get(request, "username"));

			this.respond(response, false, "Login Failed!<br />Invalid username and/or password<br />Please try again", null);

			
		}
	}

}
