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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
@WebServlet(name = "MemberController", urlPatterns = {"/member"})
public class MemberController extends BaseServlet implements Serializable {
    /**
	 * 
	 */
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
	private final JLogger JLogger = new JLogger(this.getClass());
	@EJB
	ApiEJB apiEJB;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		/* Check if user is already authenticated */
		HttpSession session = request.getSession(false);
		try {
			if(session != null)
			{
				if(!(session.getAttribute(Constants.LOGIN).equals(true) && (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE) || helper.isManager(request))))
				{
					response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
				}
				else
				{
					List<ActivityLog> activityLogs = activityLogBeanI.findAllByUserID(this.getSessKey(request, Constants.UID));
					request.setAttribute("activityLogs", activityLogs);
					Company company = companyBeanI.find();
					request.setAttribute("company", company);
					request.setAttribute("username", this.getSessKey(request, Constants.USER));
					request.setAttribute("path", "member");
					
					String user = this.getSessKey(request, Constants.USER).trim();
					
					List<Scheme> schemes = apiEJB.getProfileSchemes(user, this.getSessKey(request, Constants.U_PROFILE));
					request.setAttribute("schemes", schemes);
					
					XiMember m = apiEJB.getMemberDetails(this.getSessKey(request, Constants.PROFILE_ID),null);
					request.setAttribute("member_id", m.getId());
					session.setAttribute(Constants.PROFILE_ID,m.getId());
					if(schemes != null && schemes.size() > 0) {
						JLogger.i("Scheme is not null. email: "+ this.getSessKey(request, Constants.USER));
						if(this.getSessKey(request, Constants.SCHEME_ID) == null)
						{
							m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.PROFILE_ID),schemes.get(0).getId().toString());
						}
						else
						{
							m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.SCHEME_ID));
						}

					}
					request.setAttribute("member", m);
                    if(m==null)
                    {
                        m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.PROFILE_ID),null);
                    }
                    session.setAttribute(Constants.PROFILE_ID,m.getId());


					if(schemes != null && schemes.size() == 1)
					{
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
                            JLogger.e("NullPointerException was detected: " + npe.getMessage());
                            session.setAttribute(Constants.SCHEME_ID, String.valueOf(schemes.get(0).getId()));
						}
					}

					else if(this.getSessKey(request, Constants.SCHEME_ID) != null)
					{
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
										JLogger.e("NullPointerException was detected: " + npe.getMessage());
										session.setAttribute(Constants.SCHEME_ID, String.valueOf(scheme.getId()));
									}
								}
							}
					}
					request.setAttribute("profile", this.getSessKey(request, Constants.U_PROFILE));
					List<ContactCategory> contactReasons = contactCategoryBeanI.find();
					request.setAttribute("contactReasons", contactReasons);
					request.setAttribute("isManager", helper.isManager(request));
					PasswordPolicy policy = passwordPolicyBeanI.find();
					request.setAttribute("policy", policy);
					if((schemes != null ? schemes.size() : 0) > 1 && this.getSessKey(request, Constants.SCHEME_ID) == null)
						request.getRequestDispatcher("select_scheme.jsp").forward(request, response);
					else
						request.getRequestDispatcher("member.jsp").forward(request, response);
				}
			}
			else
				response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
		}
		catch (NullPointerException npe)
		{
			JLogger.e("NullPointerException or JSONException was detected: " + npe.getMessage());
			response.sendRedirect(getServletContext().getContextPath() + "/sign-in");			
		} 
	}
    @EJB
	PasswordPolicyBeanI passwordPolicyBeanI;
    @EJB
	ContactCategoryBeanI contactCategoryBeanI;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

        String action = this.get(request, "ACTION");

        switch (action) {
            case Actions.SWITCH_SCHEME:
                changeScheme(request, response, session);
                break;
            case Actions.CH:
                getMemberContributions(response, apiEJB.getMemberContributions(this.getSessKey(request, Constants.PROFILE_ID)));
                break;
            case Actions.PRE_CHANGE_PASSWORD:
                preChangePassword(request, response, session);
                break;
            case Actions.LOGOUT:
                logout(request, response, session);
                break;
            case Actions.REASON:
                getReasonsForExit(response, apiEJB.getReasonsForExit());
                break;
            case Actions.CHANGE_SCHEME:
                changeScheme(request, response, session);
                break;
            case Actions.AP:
                getAccountingPeriod(request, response);
                break;
            case Actions.CB:
                getMemberBalances(response, apiEJB.getMemberBalances(this.getSessKey(request, Constants.PROFILE_ID)));

                break;
            case Actions.CURR:
                schemeCurrency(response, apiEJB.getSchemeCurrency(this.getSessKey(request, Constants.SCHEME_ID)));

                break;
            case Actions.BD:
                getBeneficiaries(response, apiEJB.getBeneficiaries(this.getSessKey(request, Constants.PROFILE_ID)));
                break;
            case Actions.CI:
                cummulativeInterest(response, apiEJB.getMemberCummulativeInterest(this.getSessKey(request, Constants.PROFILE_ID)));
                break;
            case Actions.AI:
                averageInterest(response, apiEJB.getMemberAverageInterest(this.getSessKey(request, Constants.PROFILE_ID)));
                break;
        }
	}

    private void getMemberContributions(HttpServletResponse response, JSONObject memberContributions) {
        this.respond(response, true, "", memberContributions);
    }

    private void preChangePassword(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User u = userBeanI.findUserByUsernameAndProfile(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));
        String securityCode = helper.shorterUUID(UUID.randomUUID().toString(), 1);
			/* Shorter code is more user friendly... the UUID was way too long :) */
        u.setSecurityCode(securityCode);
        userBeanI.edit(u);
        XiMember m = null;
        List<Scheme> schemes = apiEJB.getProfileSchemes(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));
        if(schemes != null && schemes.size() >= 1) {
            if(this.getSessKey(request, Constants.SCHEME_ID) == null)
            {
                m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.PROFILE_ID),schemes.get(0).getId().toString());
            }
            else
            {
                m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.SCHEME_ID));
            }
        }
        if(m != null)
            session.setAttribute(Constants.PROFILE_ID,m.getId());
        try {
            Company company = companyBeanI.find();
            boolean status = apiEJB.sendEmail(m != null ? m.getEmailAddress() : null,company.getEmail(), null,"Change Password Request", "Dear " + u.getUsername() + ", " +
                    "You recently requested to change your password. " +
                    "Here is your security code:" +
                    "" + securityCode +
                    "You will require it to be able to change your password", this.getSessKey(request, Constants.SCHEME_ID), false, "");
            if(status)
            {
                    this.respond(response, true, "The change password instructions have been sent to your email address", null);

            }
            else
            {
                this.respond(response, false, "We are sorry, we were unable to send you the change password instructions", null);

            }
        } catch (NullPointerException jnpe) {

            this.respond(response, false, "We are sorry, we encountered a problem obtaining your email address. Please try again", null);

        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        logActivity("", "logged out", this.getSessKey(request, Constants.UID), null, this.getSessKey(request, Constants.U_PROFILE));
        session.invalidate();
        this.respond(response, true, "Logout was successful", null);
    }

    private void getReasonsForExit(HttpServletResponse response, JSONObject reasonsForExit) {
        this.respond(response, true, "", reasonsForExit);
    }

    private void changeScheme(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        audit(session, "Switched between schemes from scheme #" + this.getSessKey(request, Constants.SCHEME_ID)
                + " to scheme #" + this.get(request, "schemeID"));
        JLogger.i("Switched between schemes from scheme #" + this.getSessKey(request, Constants.SCHEME_ID)
                + " to scheme #" + this.get(request, "schemeID"));
        session.setAttribute(Constants.SCHEME_ID, this.get(request, "schemeID"));
        this.respond(response, true, "Scheme changed successfully", null);
    }

    private void getAccountingPeriod(HttpServletRequest request, HttpServletResponse response) {
        DateFormat format_from = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String date_string = this.get(request, "date");
        Date date = null;
        try {
            date = format_from.parse(date_string);
        } catch (ParseException pe) {
            // TODO Auto-generated catch block
            JLogger.e("ParseException was detected: " + pe.getMessage());
        }
        this.respond(response, true, "", apiEJB.getAccountingPeriod(format.format(date), this.getSessKey(request, Constants.SCHEME_ID)));
    }

    private void getMemberBalances(HttpServletResponse response, JSONObject memberBalances) {
        this.respond(response, true, "", memberBalances);
    }

    private void schemeCurrency(HttpServletResponse response, JSONObject schemeCurrency) {
        this.respond(response, true, "", schemeCurrency);
    }

    private void getBeneficiaries(HttpServletResponse response, JSONObject beneficiaries) {
        this.respond(response, true, "", beneficiaries);
    }

    private void cummulativeInterest(HttpServletResponse response, JSONObject memberCummulativeInterest) {
        this.respond(response, true, "", memberCummulativeInterest);
    }

    private void averageInterest(HttpServletResponse response, JSONObject memberAverageInterest) {
        this.respond(response, true, "", memberAverageInterest);
    }


}
