package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.ejb.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
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
    ProfileNameEJB profileNameEJB;
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
    SectorEJB sectorEJB;
    @EJB
    UserEJB userEJB;
    @EJB
    ApiEJB apiEJB;
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Country> countries = countryEJB.find();
        request.setAttribute("countries", countries);
        List<Gender> genders = genderEJB.find();
        request.setAttribute("genders", genders);
        List<MaritalStatus> marital_statuses = maritalStatusEJB.find();
        request.setAttribute("maritalStatuses", marital_statuses);
        Company company = companyEJB.find();
        request.setAttribute("company", company);
        Social social = socialEJB.find();
        request.setAttribute("social", social);
        List<Sector> sectors = sectorEJB.find();
        request.setAttribute("sectors", sectors);
        List<ProfileName> profileNames = profileNameEJB.find();
        request.setAttribute("profileNames", profileNames);
        List<Scheme> sponsorSchemes = apiEJB.getSchemeBySchemeModeAndPlanType(UMBRELLA, INDIVIDUAL_PENSION_FUND);
        request.setAttribute("sponsorSchemes", sponsorSchemes);
        List<Scheme> memberSchemes = apiEJB.getSchemeByPlanType(INDIVIDUAL_PENSION_FUND);
        request.setAttribute("memberSchemes", memberSchemes);
        Menu menu = menuEJB.find();
        request.setAttribute("menu", menu);
        Setting settings = settingEJB.find();
        request.setAttribute("settings", settings);
        List<ProfileLoginField> plf = profileLoginFieldEJB.find();
        request.setAttribute("loginFields", plf);
        List<PensionProduct> pensionProducts = null;
        request.setAttribute("pensionProducts", pensionProducts);
        Theme theme = themeEJB.find();
        request.setAttribute("theme", theme);
        request.setAttribute("noMenu", false);
        Help help = helpEJB.findHelp(Constants.PAGE_REGISTER);
        request.setAttribute("help", help);
        PageContent content = pageContentEJB.findPageContent(Constants.PAGE_REGISTER);
        request.setAttribute("content", content);
        PasswordPolicy policy = passwordPolicyEJB.find();
        request.setAttribute("policy", policy);
        logActivity(Constants.PAGE_REGISTER, "accesed registration page", "0", null, null);
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

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
            Setting settings = settingEJB.find();
            if (this.get(request, "type").equalsIgnoreCase("member")) {
                this.createMember(request, response);
            } else if (this.get(request, "type").equalsIgnoreCase("sponsor")) {
                this.addSponsor(response, request);
            } else if (this.get(request, "type").equals("EXISTING")) {
                PasswordPolicy policy = passwordPolicyEJB.find();
                    XiMember member = apiEJB.memberExists(this.get(request, "category"), this.get(request, "idNumber"));
                    if (member != null && member.getId() > 0) {
                        if (userEJB.findUserByUsernameAndProfile(this.get(request, "idNumber"), member.getProfile()) == null) {
                            User u = new User();
                            u.setProfileID(member.getId());
                            u.setUserProfile(member.getProfile());
                            u.setUsername(this.get(request, "idNumber"));
                            u.setPassword(helper.encrypt(this.get(request, "password")));
                            Date password_expiry = helper.addDays(new Date(), policy.getExpiry_days());
                            u.setPassword_expiry(password_expiry);
                            String securityCode = UUID.randomUUID().toString();
                            u.setSecurityCode(securityCode);
                            userEJB.edit(u);
                            String email_address = null;
                            String schemeId = null;
                            boolean proceed;
                            if (u.getUserProfile().equals(Constants.MEMBER_PROFILE)) {
                                XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
                                email_address = m.getEmailAddress();
                                schemeId = member.getSchemeId();
                                proceed = helper.isEmailAddress(email_address);
                            } else {
                                    member = apiEJB.getMemberDetails(u.getUserProfile(), this.get(request, "idNumber"));
                                    if (member != null) {
                                        email_address = helper.isEmailAddress(member.getEmailAddress()) ? member.getEmailAddress() : this.get(request, "idNumber");
                                        /*JSONArray json = (JSONArray) resp.get("rows");
                                        JSONObject provider = json.getJSONObject(0);
                                        email_address = provider.getString("user.email");
                                        schemeId = provider.get("user.schemeId").toString();*/
                                        proceed = helper.isEmailAddress(email_address);
                                    }
                                    else
                                        proceed = false;

                            }
                            System.out.println("Email " + email_address);
                            if (proceed) {
                                System.out.println("Trying to send mail");
                                Company company = companyEJB.find();
                                apiEJB.sendEmail(email_address, company.getEmail(), null, "MSS Portal Account Activation Instructions", "Dear " + u.getUserProfile() + ", " +
                                        "Your account has been created on the FundMaster Xi Member Self Service Portal. " +
                                        "Please click this link '" + settings.getPortalBaseURL() + "activate?" + securityCode + "' to complete the activation process", schemeId, false, null);

                                this.respond(response, true, "<strong>Registration Successful</strong><br /> Congratulations! Your account has been created on the portal. An email has been sent to your email address with account activation instructions.", null);

                            } else {
                                this.respond(response, true, "<strong>Registration Successful</strong><br /> Congratulations! Your account has been created on the portal. We were however unable to send the activation instructions to your email. Please contact the administrator", null);

                            }

                        } else {
                            this.respond(response, false, "<strong>Registration Failed!</strong><br /> You are already registered to use the portal", null);

                        }
                    } else {
                        this.respond(response, false, "<strong>Registration Failed!</strong><br /> You are not an existing " + this.get(request, "category").toLowerCase() + ". Please contact the administrator.", null);

                    }

            }
        } else {
            this.respond(response, false, "<strong>Authorization Failed!</strong><br /> You did not pass our robot test.", null);

        }

    }

}
