package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;
import nl.captcha.Captcha;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends BaseServlet implements Serializable {

    private static final String INDIVIDUAL_PENSION_FUND = "INDIVIDUAL_PENSION_FUND";
    private static final String UMBRELLA = "UMBRELLA";

    Helper helper = new Helper();
    @EJB
    ProfileNameBeanI profileNameBeanI;
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
    SectorBeanI sectorBeanI;
    @EJB
    UserBeanI userBeanI;
    @EJB
    ApiEJB apiEJB;
    private static final long serialVersionUID = 1L;

    JLogger jLogger = new JLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        List<Country> countries = countryBeanI.find();
        request.setAttribute("countries", countries);
        List<Gender> genders = genderBeanI.find();
        request.setAttribute("genders", genders);
        List<MaritalStatus> marital_statuses = maritalStatusBeanI.find();
        request.setAttribute("maritalStatuses", marital_statuses);
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Social social = socialBeanI.find();
        request.setAttribute("social", social);
        List<Sector> sectors = sectorBeanI.find();
        request.setAttribute("sectors", sectors);
        List<ProfileName> profileNames = profileNameBeanI.find();
        request.setAttribute("profileNames", profileNames);
        List<Scheme> sponsorSchemes = apiEJB.getSchemeBySchemeModeAndPlanType(UMBRELLA, INDIVIDUAL_PENSION_FUND);
        request.setAttribute("sponsorSchemes", sponsorSchemes);

        List<Scheme> memberSchemes = apiEJB.getSchemeByPlanType(INDIVIDUAL_PENSION_FUND);
        request.setAttribute("memberSchemes", memberSchemes);

        Menu menu = menuBeanI.find();
        request.setAttribute("menu", menu);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        List<ProfileLoginField> plf = profileLoginFieldBeanI.find();
        request.setAttribute("loginFields", plf);
        List<PensionProduct> pensionProducts = null;
        request.setAttribute("pensionProducts", pensionProducts);
        Theme theme = themeBeanI.find();
        request.setAttribute("theme", theme);
        request.setAttribute("noMenu", false);
        Help help = helpBeanI.findHelp(Constants.PAGE_REGISTER);
        request.setAttribute("help", help);
        PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_REGISTER);
        request.setAttribute("content", content);
        PasswordPolicy policy = passwordPolicyBeanI.find();
        request.setAttribute("policy", policy);
        logActivity(Constants.PAGE_REGISTER, "accesed registration page", "0", null, null);
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        // Get the request params.
        @SuppressWarnings("rawtypes")
        Map paramMap = request.getParameterMap();
        if (paramMap.isEmpty()) {
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Post method not allowed without parameters.");
            return;
        }
        String[] arr2 = (String[]) paramMap.get("inCaptchaChars");
        if (arr2 == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Expected parameters were not found.");
            return;
        }

        String sessId = request.getSession().getId();
        String inputChars = arr2.length > 0 ? arr2[0] : "";

        // Check validity and consistency of the data.
        if (sessId == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Browser must support session cookies.");
            return;
        }

        // Validate whether input from user is correct.
        System.out.println("Validating - inputChars are: " + inputChars);

        HttpSession session = request.getSession(true);
        Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
        request.setCharacterEncoding("UTF-8"); // Do this so we can capture non-Latin chars

        boolean passedCaptchaTest = captcha.isCorrect(inputChars);
        session.invalidate();

        if (passedCaptchaTest) {
            Setting settings = settingBeanI.find();
            if (this.get(request, "type").equalsIgnoreCase("member")) {
                this.createMember(request, response);
            } else if (this.get(request, "type").equalsIgnoreCase("sponsor")) {
                this.addSponsor(response, request);
            } else if (this.get(request, "type").equals("EXISTING")) {

                PasswordPolicy policy = passwordPolicyBeanI.find();
                jLogger.i(" >>>>>>>>>>>> The idnumber is: " + this.get(request, "idNumber") + " <<<<<<<<<<<<<<<");

                String idNumber = this.get(request, "idNumber");
                jLogger.i("The idnumber is " + idNumber);
                if (helper.isValidPhone(idNumber)) {

                    String zero = "0";
                    String plus = "+";
                    String memberPhone = idNumber;
                    if (memberPhone.startsWith(zero)) {
//                        idNumber =memberPhone.substring(1);
                    } else if (idNumber.startsWith(plus)) {
                        idNumber = memberPhone;
                    } else {

                        idNumber = memberPhone;

                    }

                }

                XiMember member = apiEJB.memberExists(this.get(request, "category"), idNumber);

                String loginField = idNumber;

                if (helper.isEmailAddress(loginField)) {

                    if (member != null && member.getId() > 0) {
                        if (userBeanI.findUserByUsernameAndProfile(this.get(request, "idNumber"), member.getProfile()) == null) {
                            User u = new User();
                            u.setProfileID(member.getId());
                            u.setUserProfile(member.getProfile());
                            u.setUsername(this.get(request, "idNumber"));
                            u.setPassword(helper.hash(this.get(request, "password")));
                            Date password_expiry = helper.addDays(new Date(), policy.getExpiry_days());
                            u.setPassword_expiry(password_expiry);
                            String securityCode = UUID.randomUUID().toString();
                            u.setSecurityCode(securityCode);
                            userBeanI.edit(u);
                            String email_address = null;
                            String schemeId = null;
                            boolean proceed;

                            if (u.getUserProfile().equals(Constants.PENSIONER)) {
                                /*email_address = this.get(request, "pensionerEmail");
                                jLogger.i("Pensioner email: " + email_address);
                                proceed = helper.isEmailAddress(email_address);
                                jLogger.i("Proceed is " + proceed);*/
                                XiPensioner p = apiEJB.getPensionerDetails(u.getProfileID().toString(), null);
                                email_address = p.getEmail();
                                jLogger.i("Pensioner email: " + email_address);
                                proceed = helper.isEmailAddress(email_address);
                            } else if (u.getUserProfile().equals(Constants.MEMBER_PROFILE)) {
                                XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
                                email_address = m.getEmailAddress();
                                schemeId = member.getSchemeId();
                                proceed = helper.isEmailAddress(email_address);
                            } else {
                                member = apiEJB.memberExists(this.get(request, "category"), this.get(request, "idNumber"));

                                if (member != null) {

                                    email_address = member.getEmailAddress();
                                    /*helper.isEmailAddress(member.getEmailAddress()) ? member.getEmailAddress() : this.get(request, "idNumber");*/

 /*JSONArray json = (JSONArray) resp.get("rows");
                                        JSONObject provider = json.getJSONObject(0);
                                        email_address = provider.getString("user.email");
                                        schemeId = provider.get("user.schemeId").toString();*/
                                    proceed = helper.isEmailAddress(email_address);
                                } else {
                                    proceed = false;
                                }

                            }
                            jLogger.i("The email is: " + email_address);
                            if (proceed) {
                                System.out.println("Trying to send mail");
                                Company company = companyBeanI.find();
                                Emails emails = emailsBeanI.find();
                                String sender = emails.getDefaultEmail();
                                List<String> recipients = new ArrayList<>();
                                recipients.add(email_address);
                                String memberId = u.getProfileID().toString();


                                //api call

                                apiEJB.sendEmail(recipients, sender, null, "MSS Portal Account Activation Instructions",
                                        "Dear " + u.getUserProfile() + ", "
                                        + "Your account has been created on the FundMaster Xi Member Self Service Portal. "
                                        + "Please click this link " + settings.getPortalBaseURL() + "activate?" + securityCode
                                        + " to complete the activation process", schemeId, false, null);

                                this.respond(response, true, "<strong>Registration Successful</strong><br /> "
                                        + "Congratulations! Your account has been created on the portal. "
                                        + "An email has been sent to your email address with account activation instructions.", null);


                                String operationType = "ACCOUNT_REGISTRATION";
                                String operationStatus = "SUCCESS";

                                apiEJB.mssAccountOperation(memberId, operationType, operationStatus,null,null,null);


                            } else {
                                this.respond(response, true, "<strong>Registration Successful</strong><br /> Congratulations! "
                                        + "Your account has been created on the portal. We were however unable to send the activation instructions to your email or Phone. "
                                        + "Please contact the administrator", null);

                            }

                        } else {
                            this.respond(response, false, "<strong>Registration Failed!</strong><br /> You are already registered to use the portal", null);

                        }

                    } else {
                        this.respond(response, false, "<strong>Registration Failed!</strong><br /> You are not an existing " + this.get(request, "category").toLowerCase() + ". Please contact the administrator.", null);

                    }
                } else if (helper.isValidPhone(loginField)) {

                    if (member != null && member.getId() > 0) {
                        if (userBeanI.findUserByUsernameAndProfile(this.get(request, "idNumber"), member.getProfile()) == null) {
                            User u = new User();
                            u.setProfileID(member.getId());
                            u.setUserProfile(member.getProfile());
                            u.setUsername(idNumber);
                            u.setPassword(helper.hash(this.get(request, "password")));
                            Date password_expiry = helper.addDays(new Date(), policy.getExpiry_days());
                            u.setPassword_expiry(password_expiry);
                            String activationCode = helper.randomNumber().toString();
                            u.setSmsActivationCode(activationCode);
                            userBeanI.edit(u);
                            String phone = null;
                            String schemeId = null;
                            boolean proceedSms;

                            if (u.getUserProfile().equals(Constants.PENSIONER)) {
                                /*email_address = this.get(request, "pensionerEmail");
                                jLogger.i("Pensioner email: " + email_address);
                                proceed = helper.isEmailAddress(email_address);
                                jLogger.i("Proceed is " + proceed);*/
                                XiPensioner p = apiEJB.getPensionerDetails(u.getProfileID().toString(), null);
                                phone = p.getCellPhone();
                                proceedSms = helper.isValidPhone(phone);
                            } else if (u.getUserProfile().equals(Constants.MEMBER_PROFILE)) {
                                XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
                                phone = m.getPhoneNumber();
                                schemeId = member.getSchemeId();
                                proceedSms = helper.isValidPhone(phone);
                            } else {
                                member = apiEJB.memberExists(this.get(request, "category"), this.get(request, "idNumber"));

                                if (member != null) {

                                    /*helper.isEmailAddress(member.getEmailAddress()) ? member.getEmailAddress() : this.get(request, "idNumber");*/
                                    phone = member.getPhoneNumber();

                                    /*JSONArray json = (JSONArray) resp.get("rows");
                                        JSONObject provider = json.getJSONObject(0);
                                        email_address = provider.getString("user.email");
                                        schemeId = provider.get("user.schemeId").toString();*/
                                    proceedSms = helper.isValidPhone(phone);
                                } else {
                                    proceedSms = false;
                                }

                            }
                            if (proceedSms) {

                                final String zero = "0";
                                final String plus = "+";
                                String clientNumber = phone;

                                if (clientNumber.startsWith(plus)) {

                                    clientNumber = zero + clientNumber.substring(4);
                                    jLogger.i("The Client Login Number is " + loginField);

                                }

                                String smsrecipient = phone;

                                apiEJB.sendSMS(smsrecipient, "Dear " + u.getUserProfile() + ", "
                                        + "Your account has been created by Enterprise Trustees  Member Self Service Portal. "
                                        + "Your Verification Code is " + activationCode + " .To complete the activation process, enter the provided code and log in using your cell phone as " + loginField + " and the Password that you provided during Registration Process."
                                        + "In Case of any challenges, please contact our Call Center 0302634704");

                                this.respond(response, true, "<strong>Registration Successful</strong><br /> "
                                        + "Congratulations! Your account has been created on the portal. A SMS notification has been sent", null);

                            } else {
                                this.respond(response, true, "<strong>Registration Successful</strong><br /> Congratulations! "
                                        + "Your account has been created on the portal. We were however unable to send the activation instructions to your email or Phone. "
                                        + "Please contact the administrator", null);

                            }

                        } else {
                            this.respond(response, false, "<strong>Registration Failed!</strong><br /> You are already registered to use the portal", null);

                        }

                    } else {
                        this.respond(response, false, "<strong>Registration Failed!</strong><br /> You are not an existing " + this.get(request, "category").toLowerCase() + ". Please contact the administrator.", null);

                    }

                }

            }
        } else {
            this.respond(response, false, "<strong>Authorization Failed!</strong><br /> You did not pass our robot test.", null);

        }

    }

}
