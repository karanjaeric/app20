package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

		/* configuring the http headers */
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Frame-Options", "DENY");
		response.addHeader("X-Content-Type-Options", "nosniff");

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
					Set set = new HashSet(plf);
					request.setAttribute("loginFields", set);

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

		/* configuring the http headers */
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Frame-Options", "DENY");
		response.addHeader("X-Content-Type-Options", "nosniff");

		if(this.get(request, "ACTION").equals("ACTIVATE_ACCOUNT")) {

			String code  = this.get(request, "code");
			jLogger.i("The Code is " + code);

			User usr = userBeanI.findByActivationCode(code);


			if(usr != null && !usr.isStatus())
			{
				usr.setStatus(true);
				userBeanI.edit(usr);
				request.setAttribute("success", true);

				this.respond(response, true, "<strong>Activation Successful</strong><br /> " +

						"Congratulations! Your account has been Activated on the portal. You can now Login", null);

			}
			else
			{
				request.setAttribute("success", false);
				this.respond(response, false, "Sorry, the Code you entered is invalid. Please try again", null);
			}
		}else {

			HttpSession session = request.getSession();
			String code=this.get(request,"countryCode");


			String userId = this.get(request, "username");
//			userId=code+userId;
			jLogger.i("USER ID" +userId);


			User u = userBeanI.findUser(userId, this.get(request, "password"));
			jLogger.i("FOUND USER");




			if (u != null) {

				String userName =  u.getUsername();

				jLogger.i("=============USERNAME" + userName);
				String zero = "0";
				String plus = "+";
				String memberPhone=userName;
				if(memberPhone.startsWith(zero)){
					userName = memberPhone.substring(1);
					jLogger.i("Appending");
				}else if(userName.startsWith(plus)){
					userName =memberPhone;
				}else{


					userName= u.getUsername();
				}

				if (u.isStatus()) {
					try {

						if (u.getUserProfile().equals(Constants.MEMBER_PROFILE)) {



							XiMember member = apiEJB.memberExists(u.getUserProfile(),userName);

							if (member != null && member.getId() > 0) {

								String memberEmail=member.getEmailAddress();
							//	List<Sponsor> sponsors = apiEJB.getMemberSchemeProducts(memberEmail,this.getSessKey(request, Constants.SCHEME_ID));

								session.setAttribute(Constants.USER, userName);
								session.setAttribute(Constants.UID, u.getId());
								session.setAttribute(Constants.PROFILE_ID, member.getId());
								session.setAttribute(Constants.LOGIN, true);
 								session.setAttribute(Constants.U_PROFILE, member.getProfile());

								session.setAttribute(Constants.SCHEME_ID, member.getSchemeId());
//								if (sponsors!=null) {
//									session.setAttribute(Constants.SPONSOR_ID, sponsors.get(0).getId().toString());
//								}else {
//									session.setAttribute(Constants.SPONSOR_ID, null);
//
//								}

								resetAttempt(this.get(request, "username"));

								logActivity(Constants.ML, "successfully logged in", u.getId().toString(), null, u.getUserProfile());

								SchemeMemberManager smm = schemeManagerBeanI.findByUserID(u.getId());

								String link = "member";
								if (smm != null) {
									session.setAttribute(Constants.MANAGER_PROFILE, Constants.MANAGER);
									link = "admin";
								}
								this.respond(response, true, "", new JSONObject().put("link", link));

								jLogger.i(" Am here Now : ");

							} else {
								logActivity(Constants.ML, "login attempt", "0", null, null);

								this.respond(response, false, "Login Failed!<br />Sorry, but we could not establish your existence in Xi", null);


							}
						} else if (u.getUserProfile().equals(Constants.PENSIONER)) {
							String usrname = u.getUsername();
							XiMember member = apiEJB.memberExists(u.getUserProfile(), usrname);
							if (member != null && member.getId() > 0) {
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
								if (smm != null) {
									session.setAttribute(Constants.MANAGER_PROFILE, Constants.MANAGER);
									link = "admin";
								}
								this.respond(response, true, "", new JSONObject().put("link", link));
							} else {
								logActivity(Constants.ML, "login attempt", "0", null, null);

								this.respond(response, false, "Login Failed!<br />Sorry, but we could not establish your existence in Xi", null);


							}
						} else {
							logActivity(Constants.ML, "login attempt", "0", null, null);

							this.respond(response, false, "Login Failed!<br />Invalid username and/or password<br />Please try again", null);

						}
					} catch (NullPointerException | JSONException npje) {
						npje.printStackTrace();
						// TODO Auto-generated catch block
						logActivity(Constants.ML, "login attempt", "0", null, null);

						this.respond(response, false, "Login Failed!<br />Invalid username and/or password<br />Please try again", null);

					}
				} else {
					logAttempt(this.get(request, "username"));

					this.respond(response, false, "Login Failed!<br />You account has been locked or de-activated. Contact the administrator", null);

				}

			} else {
				logActivity(Constants.ML, "login attempt", "0", null, null);
				logAttempt(this.get(request, "username"));

				this.respond(response, false, "Login Failed!<br />Invalid username and/or password<br />Please try again", null);


			}
		}
	}

}
