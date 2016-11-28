package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Actions;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tony on 11/23/16.
 */
@WebServlet(name = "PensionerController", urlPatterns = {"/pensioner"})
public class PensionerController extends BaseServlet implements Serializable {

    private static final long serialVersionUID = 1L;
    Helper helper = new Helper();

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
    private final JLogger jLogger = new JLogger(this.getClass());
    @EJB
    ApiEJB apiEJB;
    @EJB
    ContactCategoryBeanI contactCategoryBeanI;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* Check if user is already authenticated */
        HttpSession session = request.getSession(false);
        try {
            if (session != null) {

                if(!(session.getAttribute(Constants.LOGIN).equals(true) && (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.PENSIONER)
                        || helper.isManager(request))))
                {
                    response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
                }
                else {
                    List<ActivityLog> activityLogs = activityLogBeanI.findAllByUserID(this.getSessKey(request, Constants.UID));
                    request.setAttribute("activityLogs", activityLogs);
                    Company company = companyBeanI.find();
                    request.setAttribute("company", company);
                    Emails email = emailsBeanI.find();
                    request.setAttribute("email", email);
                    request.setAttribute("username", this.getSessKey(request, Constants.USER));
                    request.setAttribute("path", "member");

                    String user = this.getSessKey(request, Constants.USER).trim();
                    jLogger.i("User is: " + user);
                    user = user.replaceAll("/","-");
                    jLogger.i("User after replace is: " + user);
                    List<Scheme> schemes = apiEJB.getProfileSchemes(user, this.getSessKey(request, Constants.U_PROFILE));
                    request.setAttribute("schemes", schemes);
                    jLogger.i("Schemes zimepatikana  >>>>>>>>>> " + schemes.size() + " <<<<<<");

                    XiPensioner pensioner = apiEJB.getPensionerDetails(this.getSessKey(request, Constants.PROFILE_ID), null);
                    request.setAttribute("pensioner_id", pensioner.getId());
                    session.setAttribute(Constants.PROFILE_ID,pensioner.getId());
                    request.setAttribute("PensionStatus", pensioner.getPensionStatus());

                    if(schemes != null && schemes.size() > 0) {
                        jLogger.i("Scheme is not null, Pensioner Number: "+ this.getSessKey(request, Constants.USER));
                        if(this.getSessKey(request, Constants.SCHEME_ID) == null)
                        {
                            pensioner = apiEJB.getPensionerDetails(this.getSessKey(request, Constants.PROFILE_ID),schemes.get(0).getId().toString());
                        }
                        else
                        {
                            pensioner = apiEJB.getPensionerDetails(this.getSessKey(request, Constants.PROFILE_ID), this.getSessKey(request, Constants.SCHEME_ID));
                        }
                    }
                    if(pensioner==null)
                    {
                        pensioner = apiEJB.getPensionerDetails(this.getSessKey(request, Constants.PROFILE_ID),null);
                    }
                    request.setAttribute("pensioner", pensioner);
                    session.setAttribute(Constants.PROFILE_ID,pensioner.getId());

                    if(schemes != null && schemes.size() == 1)
                    {
                        jLogger.i("Executing this script: 1" );
                        jLogger.i("Pensioner is " + pensioner.getId());
                        try {

                            if(this.getSessKey(request, Constants.SCHEME_ID) == null)
                            {
                                session.setAttribute(Constants.SCHEME_TYPE, schemes.get(0).getPlanType());
                                session.setAttribute(Constants.SCHEME_ID, schemes.get(0).getId().toString());
                                request.setAttribute("scheme_id", schemes.get(0).getId().toString());
                            }
                            else
                            {
                                request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
                                session.setAttribute(Constants.SCHEME_TYPE, schemes.get(0).getPlanType());
                            }
                        } catch(NullPointerException npe)
                        {
                            jLogger.e("NullPointerException was detected: " + npe.getMessage());
                            session.setAttribute(Constants.SCHEME_ID, String.valueOf(schemes.get(0).getId()));
                        }
                    }

                    else if(this.getSessKey(request, Constants.SCHEME_ID) != null)
                    {
                        jLogger.i("Executing the script: 2" );
                        if(schemes != null)
                            for(Scheme scheme : schemes)
                            {
                                if(scheme.getId() == helper.toLong(this.getSessKey(request, Constants.SCHEME_ID)))
                                {
                                    try {

                                        if(this.getSessKey(request, Constants.SCHEME_ID) == null)
                                        {
                                            session.setAttribute(Constants.SCHEME_TYPE, scheme.getPlanType());
                                            session.setAttribute(Constants.SCHEME_ID, scheme.getId().toString());
                                            request.setAttribute("scheme_id", scheme.getId().toString());
                                        }
                                        else
                                        {
                                            request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
                                            session.setAttribute(Constants.SCHEME_TYPE, scheme.getPlanType());
                                        }
                                    } catch(NullPointerException npe)
                                    {
                                        jLogger.e("NullPointerException was detected: " + npe.getMessage());
                                        session.setAttribute(Constants.SCHEME_ID, String.valueOf(scheme.getId()));
                                    }
                                }
                            }
                    }

                    jLogger.i("Pensioner found is: " + pensioner.getId() );
                    request.setAttribute("profile", this.getSessKey(request, Constants.U_PROFILE));
                    List<ContactCategory> contactReasons = contactCategoryBeanI.find();
                    request.setAttribute("contactReasons", contactReasons);
                    request.setAttribute("isManager", helper.isManager(request));
                    PasswordPolicy policy = passwordPolicyBeanI.find();
                    request.setAttribute("policy", policy);
                    if((schemes != null ? schemes.size() : 0) > 1 && this.getSessKey(request, Constants.SCHEME_ID) == null)
                        request.getRequestDispatcher("select_scheme.jsp").forward(request, response);
                    else
                        request.getRequestDispatcher("pensioner.jsp").forward(request, response);
                }

            } else {
                response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
            }

        } catch (NullPointerException npe)
        {
            jLogger.e("NullPointerException or JSONException was detected: " + npe.getMessage());
            response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        jLogger.i(">>>>>>>>>>>> Tumeingia hapa <<<<<<<<<<<<<");

        String action = this.get(request, "ACTION");

        switch (action) {
            case Actions.SWITCH_SCHEME:
                changeScheme(request, response, session);
                break;
            case Actions.BENEFICIARY:
                getBeneficiaries(request, response);
                break;
            case Actions.CURR:
                schemeCurrency(response, apiEJB.getSchemeCurrency(this.getSessKey(request, Constants.SCHEME_ID)));
                break;
            case Actions.LOGOUT:
                logout(request, response, session);
                break;
        }
    }

    private void getBeneficiaries(HttpServletRequest request, HttpServletResponse response) {
        XiPensioner pensioner = null;
        pensioner = apiEJB.getPensionerDetails(this.getSessKey(request, Constants.PROFILE_ID), null);

        String memberId = pensioner.getMemberId();
        jLogger.i("Member id: " + memberId);

        JSONObject beneficiaries = apiEJB.getBeneficiaries(memberId);
        jLogger.i("Beneficiaries: " + beneficiaries);

        this.respond(response, true, "", beneficiaries);
    }

    private void changeScheme(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        audit(session, "Switched between schemes from scheme #" + this.getSessKey(request, Constants.SCHEME_ID)
                + " to scheme #" + this.get(request, "schemeID"));
        jLogger.i("Switched between schemes from scheme #" + this.getSessKey(request, Constants.SCHEME_ID)
                + " to scheme #" + this.get(request, "schemeID"));
        session.setAttribute(Constants.SCHEME_ID, this.get(request, "schemeID"));
        this.respond(response, true, "Scheme changed successfully", null);
    }
    private void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        logActivity("", "logged out", this.getSessKey(request, Constants.UID), null, this.getSessKey(request, Constants.U_PROFILE));
        session.invalidate();
        this.respond(response, true, "Logout was successful", null);
    }
    private void schemeCurrency(HttpServletResponse response, JSONObject schemeCurrency) {
        this.respond(response, true, "", schemeCurrency);
    }

}
