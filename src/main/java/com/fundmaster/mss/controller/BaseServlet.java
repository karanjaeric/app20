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
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * Created by bryanitur on 8/4/16.
 */
public class BaseServlet extends HttpServlet {
    private final JLogger jLogger = new JLogger(this.getClass());
    final Helper helper = new Helper();
    @EJB
    CountryBeanI countryBeanI;
    @EJB
    SettingBeanI settingBeanI;
    @EJB
    SectorBeanI sectorBeanI;
    @EJB
    SponsorBeanI sponsorBeanI;
    @EJB
    ApiEJB apiEJB;
    @EJB
    GenderBeanI genderBeanI;
    @EJB
    MaritalStatusBeanI maritalStatusBeanI;
    @EJB
    MemberBeanI memberBeanI;
    @EJB
    PermissionBeanI permissionBeanI;
    String get(HttpServletRequest req, String param)
    {
        return helper.toString(req.getParameter(param));
    }
    private boolean isManager(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(Constants.MANAGER_PROFILE) != null && session.getAttribute(Constants.MANAGER_PROFILE).equals(Constants.MANAGER);
    }
    @EJB
    AuditTrailBeanI auditTrailBeanI;
    private void logAuditTrail(String username, Date date, String profile, String description)
    {
        AuditTrail at = new AuditTrail();
        at.setDescription(description);
        at.setProfile(profile);
        at.setUsername(username);
        at.setDatetime(date);
        auditTrailBeanI.add(at);
    }
    @EJB
    ActivityLogBeanI activityLogBeanI;
    void logActivity(String access_menu, String description, String userID, String scheme, String userProfile)
    {
        activityLogBeanI.add(new ActivityLog(description, new Date(), helper.toLong(userID), scheme, access_menu, userProfile));

    }
    @EJB
    UserBeanI userBeanI;
    void resetAttempt(String username)
    {
        User user = userBeanI.findByUsername(username);
        if(user != null)
        {
            user.setAttempt(0);
        }
        userBeanI.edit(user);
    }
    @EJB
    PasswordPolicyBeanI passwordPolicyBeanI;
    void logAttempt(String username)
    {
        User user = userBeanI.findByUsername(username);
        PasswordPolicy policy = passwordPolicyBeanI.find();
        if(user != null)
        {
            user.setAttempt(user.getAttempt() + 1);
            jLogger.i("Attempt is: " + user.getAttempt() + ", Policy Count is: " + policy.getLock_after_count_of());
            if(user.getAttempt() >= policy.getLock_after_count_of())
            {
                 user.setStatus(false);
            }
            userBeanI.edit(user);
        }
    }
    void audit(HttpSession session, String description)
    {
        if(session != null)
            logAuditTrail(session.getAttribute(Constants.USER).toString(), new Date(), session.getAttribute(Constants.U_PROFILE).toString(), description);
    }
    Permission getPermissions(HttpServletRequest request)
    {
        Permission permissions;

        if(isManager(request))
        {
            permissions = permissionBeanI.findByProfile(Constants.MANAGER);
        }

        else

            permissions = permissionBeanI.findByProfile(getSessKey(request, Constants.U_PROFILE));

        return permissions;
    }
    void createMember(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession(false);
        Setting settings = settingBeanI.find();
        Country ctry = countryBeanI.findById(helper.toLong(this.get(request, "country")));

        jLogger.i("Being passed from frontend ======================>  " + get(request, "country"));
        jLogger.i("The country is =============================>  " + ctry.getName());

        String country = ctry.getName();

        Gender gender = genderBeanI.findById(helper.toLong(get(request, "gender")));

        MaritalStatus mStatus = maritalStatusBeanI.findById(Long.valueOf(get(request, "maritalStatus")));
        String date_string = request.getParameter("dateOfBirth");
        DateFormat format = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
        Date date = null;
        JSONObject result = null;
        try {
            date = format.parse(date_string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Member m = new Member();
        m.setFirstname(get(request, "firstName"));
        m.setLastname(get(request, "lastName"));
        m.setOthernames(get(request, "otherName"));
        m.setGender(gender);
        m.setMaritalStatus(mStatus);
        m.setIdNumber(get(request, "idNumber"));
        m.setEmailAddress(get(request, "emailAddress"));
        m.setPhoneNumber(get(request, "phoneNumber"));
        m.setResidentialAddress(get(request, "residentialAddress"));
        m.setCity(get(request, "city"));
        m.setCountry(country);
        m.setDateOfBirth(date);

        jLogger.i("The date set is===================================> " + date);

        m.setScheme(get(request, "pension_scheme"));

        if(settings != null && settings.getMemberOnboarding().equals(Constants.BOTH)) {
            m.setPosted();

            jLogger.i("The field posted <<<<<<<<<<<< "+ m.isPosted() +" >>>>>>>>>>>>>>>>>>>>");
        }

        if(session != null && session.getAttribute(Constants.U_PROFILE).equals(Constants.AGENT_PROFILE))
        {
            m.setAgentId();
        }
        if(settings != null)
        {
            boolean status;
            switch (settings.getMemberOnboarding()) {
                case Constants.MSS:
                    if (memberBeanI.add(m) != null)
                        this.respond(response, true, "Member details successfully saved", null);
                    else
                        this.respond(response, false, "Member details could not be saved", null);
                    break;
                case Constants.XI:
                    status = apiEJB.saveOrUpdateMember(xtractMemberFromRequest(request).toString());
                    this.respond(response, status, status ? "Member details were successfully saved" : "Could not save the member details", null);
                    break;
                case Constants.BOTH:
                    status = apiEJB.saveOrUpdateMember(xtractMemberFromRequest(request).toString());
                    if(status)
                        if (memberBeanI.add(m) != null)
                            this.respond(response, true, "Member details were successfully saved", null);
                        else
                            this.respond(response, false, "Could not save the member", null);
                    else
                        this.respond(response, false, "Could not save the member details", null);

            }
        }
    }
    JSONObject xtractMemberFromRequest(HttpServletRequest request)
    {
        Country ctry = countryBeanI.findById(helper.toLong(get(request, "country")));

        jLogger.i("Being passed from frontend ======================>  " + get(request, "country"));
        jLogger.i("The country is =============================>  " + ctry.getName());

        String country = ctry.getName();
        Gender gender = genderBeanI.findById(helper.toLong(get(request, "gender")));
        MaritalStatus mStatus = maritalStatusBeanI.findById(helper.toLong(get(request, "maritalStatus")));

        String date_string = get(request, "dateOfBirth");
        DateFormat format = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
        Date date = null;
        // JSONObject result = null;
        try {
            date = format.parse(date_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String title;
        if(gender.getName().equalsIgnoreCase("male"))
            title = "Mr";
        else
            title = "Mrs";
        DateFormat format_ = new SimpleDateFormat(Constants.MMM_d_yyyy, Locale.ENGLISH);
        JSONObject member = new JSONObject();
        try {
            member.put("member.surname", get(request, "lastName"));
            member.put("member.firstname", get(request, "firstName"));
            member.put("member.othernames", get(request, "otherName"));
            member.put("member.address.email", get(request, "emailAddress"));
            member.put("member.idNo", get(request, "idNumber"));
            member.put("member.address.cellPhone", get(request, "phoneNumber"));
            member.put("member.dob", format_.format(date))
                    .put("member.gender", gender.getName().toUpperCase())
                    .put("member.title", title)
                    .put("member.address.residentialAddress", get(request, "residentialAddress"))
                    .put("member.address.town", get(request, "city"))
                    .put("member.country", country)
                    .put("member.maritalStatus", mStatus.getName().toUpperCase())
                    .put("member.mbshipStatus", "INACTIVE")
                    .put("member.schemeId", get(request, "pension_scheme"));
        } catch (JSONException je) {
            jLogger.e("We have a JSOn Exception" + je.getMessage());
        }
        return member;
    }
    void addSponsor(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String date_string = get(request, "applicationDate");
        Date date = null;
        try {
            date = format.parse(date_string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Sponsor sponsor = new Sponsor();
        sponsor.setApplicationDate(date);
        sponsor.setCity(this.get(request, "city"));
        sponsor.setCompanyAddress(this.get(request, "address"));
        sponsor.setCompanyName(this.get(request, "name"));
        Country country = countryBeanI.findById(helper.toLong(this.get(request, "country")));
        sponsor.setCountry(country);
        sponsor.setEmailAddress(this.get(request, "email"));
        sponsor.setEmployerRefNo(this.get(request, "employerNo"));
        sponsor.setPhoneNumber(this.get(request, "phone"));
        sponsor.setPinNumber(this.get(request, "pinNo"));
        sponsor.setScheme(this.get(request, "scheme"));
        Setting settings = settingBeanI.find();
        if(session != null && session.getAttribute(Constants.U_PROFILE).equals(Constants.AGENT_PROFILE))
        {
            sponsor.setAgentId();
        }

        Sector sector = sectorBeanI.findById(helper.toLong(this.get(request, "sector")));
        sponsor.setSector(sector);

        if(settings != null && settings.getSponsorOnboarding().equals(Constants.BOTH)) {
            sponsor.setPosted();
            jLogger.i("The field posted <<<<<<<<<<<< "+ sponsor.isPosted() +" >>>>>>>>>>>>>>>>>>>>");
        }
        if(settings != null)
        {
            boolean status;
            switch (settings.getSponsorOnboarding()) {
                case Constants.MSS:
                {
                    if(sponsorBeanI.add(sponsor) != null)
                        this.respond(response, true, "Sponsor details have been successfully saved.", null);
                    else
                        this.respond(response, false, "Sponsor details could not be saved. We apologise for the inconvenience.", null);
                }
                case Constants.XI:
                    status = apiEJB.saveOrUpdateSponsor(xtractSponsorFromRequest(request).toString());
                    this.respond(response, status, status ? "Sponsor details have been successfully saved." : "Sponsor details could not be saved. We apologise for the inconvenience.", null);
                    break;
                case Constants.BOTH: {
                    status = apiEJB.saveOrUpdateSponsor(xtractSponsorFromRequest(request).toString());
                    if(status)
                    {
                        if(sponsorBeanI.add(sponsor) != null)
                            this.respond(response, true, "Sponsor details have been successfully saved.", null);
                        else
                            this.respond(response, false, "Sponsor details could not be saved. We apologise for the inconvenience.", null);
                    }
                    else
                        this.respond(response, false, "Sponsor details could not be saved. We apologise for the inconvenience.", null);

                }
            }
        }
    }
    JSONObject xtractSponsorFromRequest(HttpServletRequest request) {
        Country ctry = countryBeanI.findById(helper.toLong(this.get(request, "country")));
        jLogger.i("Being passed from frontend ======================>  " + this.get(request, "country"));
        jLogger.i("The country is =============================>  " + ctry.getName());
        String country = ctry.getName();
        Sector sectr = sectorBeanI.findById(helper.toLong(this.get(request, "sector")));
        String sector = sectr.getName();
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String date_string = this.get(request, "applicationDate");
        Date date = null;
        try {
            date = format.parse(date_string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DateFormat format_ = new SimpleDateFormat(Constants.YYYY_MM_DD, Locale.ENGLISH);
        JSONObject jsponsor = new JSONObject();
        try {
            jsponsor.put("sponsor.name", this.get(request, "name"))
                    .put("sponsor.applicationDate", format_.format(date))
                    .put("sponsor.address.residentialAddress", this.get(request, "address"))
                    .put("sponsor.address.fixedPhone", this.get(request, "phone"))
                    .put("sponsor.address.email", this.get(request, "email"))
                    .put("sponsor.address.town", this.get(request, "city"))
                    .put("sponsor.address.country", country)
                    .put("sponsor.sector", sector)
                    .put("sponsor.employerpin", this.get(request, "employerNo"))
                    .put("sponsor.pin", this.get(request, "pinNo"))
                    .put("sponsor.status", "POTENTIAL_SPONSOR");
        } catch (JSONException je) {
            jLogger.e("We have a JSON Exception " + je.getMessage());
        }
        return jsponsor;
    }
    void respond(HttpServletResponse resp, boolean status, String message, JSONObject json)
    {
        if(json != null)
            jLogger.i("Object is : " + json.toString());
        try {
            String response = helper.result(status, message, json);
            jLogger.i(response);
            resp.getWriter().write(response);
        } catch (IOException ioe) {
            jLogger.e("Problem sending response" + ioe.getMessage());
        }

    }
    String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    String baseUrl()
    {
        return getServletContext().getContextPath() + "/";
    }
    String getSessKey(HttpServletRequest req, String param)
    {
        HttpSession session = req.getSession(false);
        return session != null ? helper.toString(session.getAttribute(param)) : null;
    }
    String getBasePath()
    {
        return getServletContext().getRealPath("/") + "/";
    }
    void redirect(HttpServletResponse resp, String page)
    {
        try {
            resp.sendRedirect(getServletContext().getContextPath() + page);
        } catch (IOException ioe) {
            jLogger.e("Sorry, we have an io exception: " + ioe.getMessage());
        }
    }
}
