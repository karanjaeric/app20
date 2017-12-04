package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;



@WebServlet(name = "AdminPasswordResetController", urlPatterns = {"/password-reset-admin"})
public class AdminPasswordResetController extends BaseServlet implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6085562604717440895L;

    Helper helper = new Helper();
    private final JLogger jLogger = new JLogger(this.getClass());

    @EJB
    UsedPasswordBeanI usedPasswordBeanI;
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
    PasswordPolicyBeanI passwordPolicyBeanI;
    @EJB
    ApiEJB apiEJB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		/* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        Social social = socialBeanI.find();
        request.setAttribute("social", social);
        Menu menu = menuBeanI.find();
        request.setAttribute("menu", menu);
        Theme theme = themeBeanI.find();
        request.setAttribute("theme", theme);
        request.setAttribute("noMenu", false);
        request.getRequestDispatcher("password-reset.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

		/* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        if (this.get(request, "ACTION").equals("RESET_PASSWORD")) {
            PasswordPolicy policy = passwordPolicyBeanI.find();
            String securityCode = this.get(request, "securityCode");
            User u = userBeanI.findBySecurityCode(securityCode);
            if (u != null) {
                if (u.getSecurityCode().equalsIgnoreCase(securityCode)) {
                    if (!(usedPasswordBeanI.isUsed(this.get(request, "newPassword")) && policy.isPassword_reuse())) {
                        Date password_expiry = helper.addDays(new Date(), policy.getExpiry_days());
                        u.setPassword_expiry(password_expiry);
                        u.setPassword(helper.hash(this.get(request, "newPassword")));
                        u.setSecurityCode(null);
                        if (userBeanI.edit(u) != null)
                            this.respond(response, true, "Your password has been reset successfully", null);
                        else
                            this.respond(response, false, "Sorry, your password could not be reset", null);
                    } else {
                        this.respond(response, false, "Sorry, the new password entered has already been used once. You cannot re-use the password.", null);

                    }

                } else {
                    this.respond(response, false, "Sorry, your security code is invalid. Please enter a valid security code.", null);

                }
            } else {
                this.respond(response, false, "The security code you entered is wrong. Please try again.", null);

            }
        } else if (this.get(request,"ACTION").equals("REQUEST_RESET_ADMIN")){

            Setting settings = settingBeanI.find();
            Constants.BASE_URL = request.getContextPath() + "password-reset";

            String username = this.get(request, "username-admin");
            User usr = userBeanI.findByUsername(username);
            if (usr != null) {
            String userProfile = usr.getUserProfile();


                    if (helper.isEmailAddress(username)) {

                        String securityCode = UUID.randomUUID().toString();
                    usr.setSecurityCode(securityCode);
                    Company company = companyBeanI.find();
                    Emails emails = emailsBeanI.find();

                    String sender = emails.getDefaultEmail();
                    XiMember m = null;

                    if (usr.getUserProfile().equals(Constants.MEMBER_PROFILE)) {
                        m = apiEJB.getMemberDetails(usr.getProfileID().toString(), null);
                    } else {
                        m = apiEJB.memberExists(userProfile, username);

                    }

                    boolean status = false;
                    List<String> recipients = new ArrayList<>();

                    try {
                        recipients.add(m.getEmailAddress());
                        status = apiEJB.sendEmail(recipients, sender, null, "Password Reset Instructions", "Dear " + usr.getUserProfile() + ", " +

                                "You recently requested to change your password. " +
                                "Your security code is: " + securityCode +
                                " Please click this link: '" + settings.getPortalBaseURL() + "password-reset-admin' to complete your request.", null, false, null);
                        jLogger.i("Your Status is ====== " + status);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }


                    if (status) {
                        if (userBeanI.edit(usr) != null)
                            this.respond(response, true, "The password reset instructions have been sent to your email address", null);
                        else
                            this.respond(response, true, "We are sorry, but we were unable to send you the password reset instructions", null);
                    } else {
                        this.respond(response, true, "We are sorry, but we were unable to send you the password reset instructions", null);

                    }
                }
            }else {
                    this.respond(response, true, "We are sorry, We coul not Find the User with the Username provided", null);

                }


        }






    }
}
