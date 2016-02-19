package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.beans.ejbInterface.*;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.*;
import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.common.Constants;

@WebServlet(name = "PasswordResetController", urlPatterns = {"/password-reset"})
public class PasswordResetController extends GenericController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6085562604717440895L;
	@EJB
	Helper helper;
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
	BannerEJB bannerEJB;
	@EJB
	PermissionEJB permissionEJB;
	@EJB
	PasswordPolicyEJB passwordPolicyEJB;
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

    	PrintWriter out = response.getWriter();
		if(request.getParameter("ACTION").equals("RESET_PASSWORD"))
		{
			PasswordPolicy policy = passwordPolicyEJB.find();
			String securityCode = request.getParameter("securityCode");
			User u = userEJB.findBySecurityCode(securityCode);
			try {
				if(u.getSecurityCode().equalsIgnoreCase(securityCode))
				{
					if(!(usedPasswordEJB.isUsed(request.getParameter("newPassword")) && policy.isPassword_reuse()))
					{
						try
						{
							Date password_expiry = helper.addDays(new Date(), policy.getExpiry_days());
							u.setPassword_expiry(password_expiry);
							u.setPassword(helper.hash(request.getParameter("newPassword")));
							u.setSecurityCode(null);
							helper.updateUser(u);
							out.write(helper.result(true, "Your password has been reset successfully").toString());
						}
						catch(Exception e)
						{
							try {
								out.write(helper.result(false, "Sorry, your password could not be reset").toString());
							} catch (JSONException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace(out);
							}
						}
					}
					else
					{
						try {
							out.write(helper.result(false, "Sorry, the new password entered has already been used once. You cannot re-use the password.").toString());
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace(out);
						}
					}
					
				}
				else
				{
					try {
						out.write(helper.result(false, "Sorry, your security code is invalid. Please enter a valid security code.").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				}
			}
			catch (NullPointerException ex)
			{
				try {
					out.write(helper.result(false, "The security code you entered is wrong. Please try again.").toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace(out);
				}
			}
		}
		else if(request.getParameter("ACTION").equals("REQUEST_RESET"))
		{
			Setting settings = settingEJB.find();
			Constants.BASE_URL = request.getContextPath() + "password-reset";
			User u = helper.findByUsernameAndProfile(request.getParameter("email"), Constants.MEMBER_PROFILE);
			if(u != null)
			{
				String securityCode = UUID.randomUUID().toString();
				u.setSecurityCode(securityCode);
				try {
					XiMember m = helper.getMemberDetails(u.getProfileID().toString());
					JSONObject res = helper.sendNotification(m.getEmailAddress(), "Password Reset Instructions", "Dear " + u.getUserProfile() + ",<br />" +
							"You recently requested to change your password.<br />" +
							"Your security code is: " + securityCode +
							" Please click this <a href='" + settings.getPortalBaseURL() + "password-reset'>link</a> to complete your request", null, false, null);
					if(res.get("success").equals(true))
					{
						helper.updateUser(u);
						try {
							out.write(helper.result(true, "The password reset instructions have been sent to your email address").toString());
						} catch (Exception ex)
						{
							ex.printStackTrace();
						}
					}
					else
					{
						try {
							out.write(helper.result(true, "We are sorry, but we were unable to send you the password reset instructions").toString());
						} catch (Exception ex)
						{
							ex.printStackTrace();
						}
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						out.write(helper.result(false, "Sorry, we were unable to get your email address. We cannot advise further on the process").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else
			{
				try {
					out.write(helper.result(false, "Sorry, the username you entered is invalid. Please try again").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
