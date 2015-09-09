package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.common.Common;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.PasswordPolicy;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
import com.fundmaster.mss.model.User;
import com.fundmaster.mss.model.XiMember;
import com.fundmaster.mss.service.UserService;

@WebServlet(name = "PasswordResetController", urlPatterns = {"/password-reset"})
public class PasswordResetController extends GenericController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6085562604717440895L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		
		Company company = getCompany();
		request.setAttribute("company", company);
		Setting settings = getSettings();
		request.setAttribute("settings", settings);
		Social social = getSocial();
		request.setAttribute("social", social);
		Menu menu = getMenu();
		request.setAttribute("menu", menu);
		Theme theme = getTheme();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		request.getRequestDispatcher("password-reset.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = response.getWriter();
		if(request.getParameter("ACTION").equals("RESET_PASSWORD"))
		{
			PasswordPolicy policy = getPasswordPolicy();
			String securityCode = request.getParameter("securityCode");
			User u = findUserByCode(securityCode);
			try {
				if(u.getSecurityCode().equalsIgnoreCase(securityCode))
				{
					if(!(isUsedPassword(request.getParameter("newPassword").toString()) && policy.isPassword_reuse()))
					{
						try
						{
							Date password_expiry = addDays(new Date(), policy.getExpiry_days());
							u.setPassword_expiry(password_expiry);
							u.setPassword(hash(request.getParameter("newPassword").toString()));
							u.setSecurityCode(null);
							UserService uService = new UserService();
							uService.update(u);
							out.write(result(true, "Your password has been reset successfully").toString());
						}
						catch(Exception e)
						{
							try {
								out.write(result(false, "Sorry, your password could not be reset").toString());
							} catch (JSONException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace(out);
							}
						}
					}
					else
					{
						try {
							out.write(result(false, "Sorry, the new password entered has already been used once. You cannot re-use the password.").toString());
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace(out);
						}
					}
					
				}
				else
				{
					try {
						out.write(result(false, "Sorry, your security code is invalid. Please enter a valid security code.").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				}
			}
			catch (NullPointerException ex)
			{
				try {
					out.write(result(false, "The security code you entered is wrong. Please try again.").toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace(out);
				}
			}
		}
		else if(request.getParameter("ACTION").equals("REQUEST_RESET"))
		{
			Setting settings = getSettings();
			Common.BASE_URL = request.getContextPath() + "password-reset";
			User u = findByUsernameAndProfile(request.getParameter("email").toString(), Common.MEMBER_PROFILE);
			if(u != null)
			{
				String securityCode = UUID.randomUUID().toString();
				u.setSecurityCode(securityCode);
				try {
					XiMember m = getMemberDetails(u.getProfileID().toString());
					JSONObject res = sendNotification("EMAIL", m.getEmailAddress(), "Password Reset Instructions" , "Dear " + u.getUserProfile() + ",<br />" +
							"You recently requested to change your password.<br />" +
							"Your security code is: " + securityCode + 
							" Please click this <a href='" + settings.getPortalBaseURL() + "password-reset'>link</a> to complete your request", null, false, null);
					if(res.get("success").equals(true))
					{
						try {
							out.write(result(true, "The password reset instructions have been sent to your email address").toString());
						} catch (Exception ex)
						{
							ex.printStackTrace();
						}
					}
					else
					{
						try {
							out.write(result(true, "We are sorry, but we were unable to send you the password reset instructions").toString());
						} catch (Exception ex)
						{
							ex.printStackTrace();
						}
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						out.write(result(false, "Sorry, we were unable to get your email address. We cannot advise further on the process").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else
			{
				try {
					out.write(result(false, "Sorry, the username you entered is invalid. Please try again").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
