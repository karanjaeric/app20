package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.ejb.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "PasswordResetController", urlPatterns = {"/password-reset"})
public class PasswordResetController extends BaseServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6085562604717440895L;

	Helper helper = new Helper();
	@EJB
	UsedPasswordEJB usedPasswordEJB;
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
	@EJB
	PasswordPolicyEJB passwordPolicyEJB;
	@EJB
	ApiEJB apiEJB;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		
		Company company = companyEJB.find();
		request.setAttribute("company", company);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		Social social = socialEJB.find();
		request.setAttribute("social", social);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		Theme theme = themeEJB.find();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		request.getRequestDispatcher("password-reset.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(this.get(request, "ACTION").equals("RESET_PASSWORD"))
		{
			PasswordPolicy policy = passwordPolicyEJB.find();
			String securityCode = this.get(request, "securityCode");
			User u = userEJB.findBySecurityCode(securityCode);
			if(u != null) {
				if(u.getSecurityCode().equalsIgnoreCase(securityCode))
				{
					if(!(usedPasswordEJB.isUsed(this.get(request, "newPassword")) && policy.isPassword_reuse()))
					{
							Date password_expiry = helper.addDays(new Date(), policy.getExpiry_days());
							u.setPassword_expiry(password_expiry);
							u.setPassword(helper.hash(this.get(request, "newPassword")));
							u.setSecurityCode(null);
							if(userEJB.edit(u) != null)
								this.respond(response, true, "Your password has been reset successfully", null);
							else
								this.respond(response, false, "Sorry, your password could not be reset", null);
					}
					else
					{
						this.respond(response, false, "Sorry, the new password entered has already been used once. You cannot re-use the password.", null);

					}
					
				}
				else
				{
					this.respond(response, false, "Sorry, your security code is invalid. Please enter a valid security code.", null);

				}
			}
			else
			{
				this.respond(response, false, "The security code you entered is wrong. Please try again.", null);

			}
		}
		else if(this.get(request, "ACTION").equals("REQUEST_RESET"))
		{
			Setting settings = settingEJB.find();
			Constants.BASE_URL = request.getContextPath() + "password-reset";
			User u = userEJB.findUserByUsernameAndProfile(this.get(request, "email"), Constants.MEMBER_PROFILE);
			if(u != null)
			{
				String securityCode = UUID.randomUUID().toString();
				u.setSecurityCode(securityCode);
				Company company = companyEJB.find();
				XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(),null);

				boolean status = apiEJB.sendEmail(m.getEmailAddress(),company.getEmail(), null, "Password Reset Instructions", "Dear " + u.getUserProfile() + ", " +

						"You recently requested to change your password. " +
						"Your security code is: " + securityCode +
						" Please click this link: '" + settings.getPortalBaseURL() + "password-reset' to complete your request.", null, false, null);
				if(status)
				{
					if(userEJB.edit(u) != null)
						this.respond(response, true, "The password reset instructions have been sent to your email address", null);
					else
						this.respond(response, true, "We are sorry, but we were unable to send you the password reset instructions", null);
				}
				else
				{
					this.respond(response, true, "We are sorry, but we were unable to send you the password reset instructions", null);

				}
			}
			else
			{
					this.respond(response, false, "Sorry, the username you entered is invalid. Please try again", null);

			}
		}
	}

}
