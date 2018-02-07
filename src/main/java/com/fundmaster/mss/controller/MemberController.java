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
import java.util.*;

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
	ClientSetupI clientSetupI;
	@EJB
	SettingBeanI settingBeanI;
	@EJB
	GenderBeanI genderBeanI;
	@EJB
	DBMenuBeanI dbMenuBeanI;
	@EJB
	DBGraphBeanI dbGraphBeanI;
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
	MemberDashboardBeanI memberDashboardBeanI;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		/* configuring the http headers */
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Frame-Options", "DENY");
		response.addHeader("X-Content-Type-Options", "nosniff");

		/* Check if user is already authenticated */
		HttpSession session = request.getSession(false);
		try {
			if(session != null)
			{
				if(!(session.getAttribute(Constants.LOGIN).equals(true) && (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE)
						|| helper.isManager(request))))
				{
					response.sendRedirect(getServletContext().getContextPath() + "/sign-in");
				}
				else
				{
					String schemeId = "";
					String productId ="";
					List<ActivityLog> activityLogs = activityLogBeanI.findAllByUserID(this.getSessKey(request, Constants.UID));
					request.setAttribute("activityLogs", activityLogs);
					Company company = companyBeanI.find();
					request.setAttribute("company", company);
					Emails email = emailsBeanI.find();
					request.setAttribute("email", email);
					request.setAttribute("username", this.getSessKey(request, Constants.USER));
					request.setAttribute("path", "member");
					
					String user = this.getSessKey(request, Constants.USER).trim();

					jLogger.i("Email/Phone hopefully ============ " + user);


					
					List<Scheme> schemes = apiEJB.getProfileSchemes(user, this.getSessKey(request, Constants.U_PROFILE));
					request.setAttribute("schemes", schemes);


					try {
 						schemeId =this.getSessKey(request, Constants.SCHEME_ID);
 						productId = this.getSessKey(request, Constants.SPONSOR_ID);

						jLogger.i("The scheme passed::::::::::::::::: " + schemeId);
						jLogger.i("The sponsor passed::::::::::::::::: " + productId);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

					XiMember m = new XiMember();




					try {
						if (schemeId != null) {
							if (helper.isEmailAddress(user)) {

 								m = apiEJB.getMemberDetailsByScheme(schemeId, user);

							}else if (helper.isValidPhone(user)){

								m=apiEJB.getMemberDetailsBySchemeAndPhone(schemeId,user);
							}
						} else {

							m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.PROFILE_ID),null);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}


					List<Scheme> schemePlan = apiEJB.getProfileSchemes(user, this.getSessKey(request, Constants.U_PROFILE));
					String planType = schemePlan.get(0).getPlanType();
					request.setAttribute("planType", planType);

					DBContributionGraph dbContributionGraph = dbGraphBeanI.find();
					request.setAttribute("contrGraph", dbContributionGraph);

					DBMenu dbMenu = dbMenuBeanI.find();
					request.setAttribute("dbMenu", dbMenu);

					MemberMenu memberMenu = memberMenuBeanI.find();
					request.setAttribute("memberMenu", memberMenu);
					List<ClientSetup> clientsetup = clientSetupI.find();
					request.setAttribute("clientsetup", clientsetup);

					String memberEmail=m.getEmailAddress();
					List<Sponsor> sponsors = apiEJB.getMemberSchemeProducts(memberEmail,this.getSessKey(request, Constants.SCHEME_ID));
					request.getSession().setAttribute("sponsors", sponsors);


					if(schemes != null && schemes.size() > 0) {
						jLogger.i("Scheme is not null. email/phone: "+ this.getSessKey(request, Constants.USER));
						jLogger.i("SchemeId " + schemeId);

						if(this.getSessKey(request, Constants.SCHEME_ID) == null)
						{
							try {
								if (schemeId != null) {

									if (helper.isEmailAddress(user)) {
										jLogger.i("I FOUND AN EMAIL");

										m = apiEJB.getMemberDetailsByScheme(schemeId, user);

									}else if (helper.isValidPhone(user)){
										jLogger.i("I FOUND A PHONE");

										m=apiEJB.getMemberDetailsBySchemeAndPhone(schemeId,user);
									}
								} else {
									m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.PROFILE_ID),schemes.get(0).getId().toString());
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						else
						{
							try {
								if (schemeId != null) {
									if (helper.isEmailAddress(user)) {
										m = apiEJB.getMemberDetailsByScheme(schemeId, user);
										jLogger.i("I FOUND AN EMAIL 2");
									}else if (helper.isValidPhone(user)){

										jLogger.i("I FOUND PHONE 2");

										m=apiEJB.getMemberDetailsBySchemeAndPhone(schemeId,user);
									}								} else {
									m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.SCHEME_ID));
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
                    if(m==null)
                    {
                        m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.PROFILE_ID),null);
                    }
					request.setAttribute("member", m);
                    session.setAttribute(Constants.PROFILE_ID,m.getId());


					if(schemes != null && schemes.size() == 1)
					{
						jLogger.i("Executing this script: 1" );
						jLogger.i("Member is " + m.getId());
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
						jLogger.i("Executing this script: 2" );
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

					request.setAttribute("member_id", m.getId());
					session.setAttribute(Constants.PROFILE_ID,m.getId());
					request.setAttribute("MemberStatus", m.getMbshipStatus());
					String memberName = m.getFirstname();
					request.setAttribute("memberName", memberName);

					jLogger.i("Member found is: " + m.getId() );
					request.setAttribute("profile", this.getSessKey(request, Constants.U_PROFILE));
					MemberDashboardItems memberDashboardItems = memberDashboardBeanI.find();
					request.setAttribute("memberDashboard", memberDashboardItems);
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
			jLogger.e("NullPointerException or JSONException was detected: " + npe.getMessage());
			response.sendRedirect(getServletContext().getContextPath() + "/sign-in");			
		} 
	}
    @EJB
	PasswordPolicyBeanI passwordPolicyBeanI;
	@EJB
	MemberMenuBeanI memberMenuBeanI;
    @EJB
	ContactCategoryBeanI contactCategoryBeanI;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/* configuring the http headers */
		response.addHeader("X-XSS-Protection", "1; mode=block");
		//Enable and block pages with XSS
		response.addHeader("X-Frame-Options", "DENY");
		// prevents any domain from framing the content
		response.addHeader("X-Content-Type-Options", "nosniff");
		/* Used to stop browser from using MIME-sniffing
		     to determine content-type of a resource  */

		HttpSession session = request.getSession(false);

        String action = this.get(request, "ACTION");

        switch (action) {
            case Actions.SWITCH_SCHEME:
                changeScheme(request, response, session);
                break;
            case Actions.CH:
                getMemberContributions(response, apiEJB.getMemberContributions(this.getSessKey(request, Constants.PROFILE_ID)));
                break;
			case Actions.CH_GRID:
				getContributionsGrid(request, response, session);
				break;
			case Actions.BP_GRID:
				getProjectionsGrid(request, response, session);
				break;
			case Actions.AC_GRID:
				getAnnualContributionsGrid(request, response, session);
				break;
			case Actions.SA_GRID:
				getMemberStatementGrid(request, response, session);
				break;
			case Actions.BH_GRID:
				getBalancesGrid(request, response, session);
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
			case Actions.CHANGE_PRODUCT:
				changeProduct(request, response, session);
				break;
            case Actions.AP:
                getAccountingPeriod(request, response);
                break;
            case Actions.CB:
                //getMemberBalances(response, apiEJB.getMemberBalances(this.getSessKey(request, Constants.PROFILE_ID)));
				getMemberBalances(request, response);
                break;
            case Actions.CURR:
                schemeCurrency(response, apiEJB.getSchemeCurrency(this.getSessKey(request, Constants.SCHEME_ID)));

                break;
            case Actions.BD:
                getBeneficiaries(response, apiEJB.getBeneficiaries(this.getSessKey(request, Constants.PROFILE_ID)));
                break;
			case Actions.AB:

				cumulativeBenefit(response, apiEJB.getMemberCummulativeBenefit(this.getSessKey(request, Constants.PROFILE_ID)));
 				break;
            case Actions.CI:
                cummulativeInterest(response, apiEJB.getMemberCummulativeInterest(this.getSessKey(request, Constants.PROFILE_ID)));
                break;
            case Actions.AI:
                averageInterest(response, apiEJB.getMemberAverageInterest(this.getSessKey(request, Constants.PROFILE_ID)));
                break;
                  case Actions.BI:
                benefitsInfo(response, apiEJB.getMemberBenefitsDetails(this.getSessKey(request, Constants.PROFILE_ID),this.getSessKey(request, Constants.SCHEME_ID)));
                break;
        }
	}

    private void getMemberContributions(HttpServletResponse response, JSONObject memberContributions) {
        this.respond(response, true, "", memberContributions);
    }

	private void getContributionsGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		User u = userBeanI.findUserByUsernameAndProfile(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));
		XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
		String member_id = Long.toString(m.getId());
		jLogger.i("Member found ================ > " + member_id);

		DateFormat format_from = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
		DateFormat format = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);

		String fromDate_String = this.get(request, "dateFrom");
		String toDate_String = this.get(request, "dateTo");

		Date fromDate = null;
		Date toDate = null;

		try {
			fromDate = format_from.parse(fromDate_String);
			toDate = format_from.parse(toDate_String);
		} catch (ParseException pe) {
			// TODO Auto-generated catch block
			jLogger.e("ParseException was detected: " + pe.getMessage());
		}

		jLogger.i("From Date ================ > " + fromDate);
		jLogger.i("To Date ================ > " + toDate);

		//JSONObject memberContributions = apiEJB.getMemberFullContributions(member_id);
		JSONObject memberContributions = apiEJB.getContributionsBetweenDates(format.format(fromDate), format.format(toDate), member_id);
		
		this.respond(response, true, "", memberContributions);
	}

	private void getProjectionsGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		User u = userBeanI.findUserByUsernameAndProfile(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));
		XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
		String member_id = Long.toString(m.getId());
		String salary;
		JSONObject memberProjections = new JSONObject();

		jLogger.i("Member found ================ > " + member_id);

		String plan_type = this.get(request, "plan_type");
		jLogger.i("PlanType is ================ > " + plan_type);

		String reasonId = this.get(request, "reason_id");
		jLogger.i("Reason Id ================ > " + reasonId);
		String schemeId = this.get(request, "scheme_id");
		jLogger.i("Scheme Id ================ > " + schemeId);

		salary = this.get(request, "salary");
		jLogger.i("Salary is ================ > " + salary);


		DateFormat format_from = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
		DateFormat format = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);

		String exitDate_String = this.get(request, "dateTo");
		//String calcDate_String = this.get(request, "dateTo");

		Date exitDate = null;
		Date calcDate = new Date();

		try {
			exitDate = format_from.parse(exitDate_String);
			//calcDate = format_from.parse(calcDate_String);
		} catch (ParseException pe) {
			// TODO Auto-generated catch block
			jLogger.e("ParseException was detected: " + pe.getMessage());
		}

		jLogger.i("Exit Date ================ > " + exitDate);
		jLogger.i("Calculation Date ================ > " + calcDate);

		//JSONObject memberContributions = apiEJB.getMemberFullContributions(member_id);

		if (plan_type.equalsIgnoreCase("Defined Benefit") && (salary != null && !salary.isEmpty())) {

			memberProjections = apiEJB.getDBProjections(member_id, reasonId, format.format(exitDate), format.format(calcDate), schemeId, salary);
		} else {

			memberProjections = apiEJB.getMemberProjections(member_id, reasonId, format.format(exitDate), format.format(calcDate), schemeId);
		}

		this.respond(response, true, "", memberProjections);
	}

	private void getMemberStatementGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		User u = userBeanI.findUserByUsernameAndProfile(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));
		XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
		jLogger.i("Member found ================ > " + m.getId());

		String member_id = Long.toString(m.getId());
		jLogger.i("Member found ================ > " + member_id);

		String apId = this.get(request, "ap_id");
		jLogger.i("Reason Id ================ > " + apId);

		String schemeId = this.get(request, "scheme_id");
		jLogger.i("Scheme Id ================ > " + schemeId);

		//JSONObject memberContributions = apiEJB.getMemberFullContributions(member_id);
		JSONObject memberStatement = apiEJB.getMemberStatement(member_id, apId, schemeId);

		this.respond(response, true, "", memberStatement);
	}
	private void getAnnualContributionsGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session){

		User u = userBeanI.findUserByUsernameAndProfile(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));
		XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
		String member_id = Long.toString(m.getId());
		jLogger.i("Member found ================ > " + member_id);

		String apId = this.get(request, "ap_id");
		jLogger.i("Reason Id ================ > " + apId);

		JSONObject memberAnnualContrubution = apiEJB.getAnnualContribution(member_id, apId);

		this.respond(response, true, "", memberAnnualContrubution );

	}

	private void getBalancesGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String member_id = this.get(request, "member_id");
		jLogger.i("Member found ================ > " + member_id);

		/*User u = userBeanI.findUserByUsernameAndProfile(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));
		XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
		String member_id = Long.toString(m.getId());*/

		JSONObject balancesHistory = apiEJB.getBalancesHistory( member_id);

		this.respond(response, true, "", balancesHistory);
	}

    private void preChangePassword(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String userName = this.getSessKey(request, Constants.USER);

		String securityCode = "";
		String smsCode = "";
		User u = new User();

		jLogger.i("The Username has Been Found " + userName);



		if (helper.isValidPhone(userName)) {
			u = userBeanI.findUserByUsernameAndProfile(userName, this.getSessKey(request, Constants.U_PROFILE));

			jLogger.i("User found "+ u.getUserProfile() +" Username " + u.getUsername());

			smsCode = helper.randomNumber().toString();
			jLogger.i("Am here");
			u.setSmsActivationCode(smsCode);
			userBeanI.edit(u);

		} else if (helper.isEmailAddress(userName)) {

			u = userBeanI.findUserByUsernameAndProfile(userName, this.getSessKey(request, Constants.U_PROFILE));

			securityCode = UUID.randomUUID().toString();
			u.setSecurityCode(securityCode);
			userBeanI.edit(u);

		}


		XiMember m = null;

		//m = apiEJB.getMemberDetails(usr.getProfileID().toString(), null);

		List<Scheme> schemes = apiEJB.getProfileSchemes(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));

        /*if(schemes != null && schemes.size() > 0) {
            if(this.getSessKey(request, Constants.SCHEME_ID) == null)
            {
                m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.PROFILE_ID),schemes.get(0).getId().toString());
            }
            else
            {
                m= apiEJB.getMemberDetails(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.SCHEME_ID));
            }

        }*/

		m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);

		if (m != null)
			jLogger.i("Am here with this Username " + userName);
		session.setAttribute(Constants.PROFILE_ID, m.getId());

		try {
		if (helper.isEmailAddress(userName)) {

				Emails emails = emailsBeanI.find();

				List<String> recipients = new ArrayList<>();
				recipients.add(m.getEmailAddress());

				jLogger.i("Member email is: " + m.getEmailAddress());

				boolean status = apiEJB.sendEmail(recipients, emails.getDefaultEmail(), null, "Change Password Request", "Dear " + u.getUsername() + ", " +
						"You recently requested to change your password. " +
						"Here is your security code:" +
						"" + securityCode +
						" You will require it to be able to change your password", this.getSessKey(request, Constants.SCHEME_ID), false, "");
				if (status) {
					this.respond(response, true, "The change password instructions have been sent to your email address", null);

				} else {
					this.respond(response, false, "We are sorry, we were unable to send you the change password instructions", null);

				}
			}
		 else if (helper.isValidPhone(userName)) {


				String memberPhone = m.getPhoneNumber();
				jLogger.i("The Phone Number Is " + memberPhone);

			  apiEJB.sendSMS(memberPhone, "Dear " + u.getUserProfile() + ", You recently requested to change your password.Here is your sms code:" + smsCode +
						" You will require it to be able to change your password");


					this.respond(response, true, "The change password instructions have been sent to your phone number", null);


		}

	} catch (NullPointerException jnpe) {

			this.respond(response, false, "We are sorry, we encountered a problem obtaining your email address / phone. Please try again", null);

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
        jLogger.i("Switched between schemes from scheme #" + this.getSessKey(request, Constants.SCHEME_ID)
                + " to scheme #" + this.get(request, "schemeID"));
        session.setAttribute(Constants.SCHEME_ID, this.get(request, "schemeID"));

		this.respond(response, true, "Scheme changed successfully", null);
    }
	private void changeProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		audit(session, "Switched between sponsor from sponsor #" + this.getSessKey(request, Constants.SPONSOR_ID)
				+ " to sponsor #" + this.get(request, "sponsorID"));
		jLogger.i("Switched between sponsor from sponsor #" + this.getSessKey(request, Constants.SPONSOR_ID)
				+ " to sponsor #" + this.get(request, "sponsorID"));
		session.setAttribute(Constants.SPONSOR_ID, this.get(request, "sponsorID"));

		this.respond(response, true, "Sponsor changed successfully", null);
	}

    private void getAccountingPeriod(HttpServletRequest request, HttpServletResponse response) {
        DateFormat format_from = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
        DateFormat format = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);
        String date_string = this.get(request, "date");
		jLogger.i("Date from frontend ============> " + date_string);
        Date date = null;
        date = new Date(); // TODO Auto-generated catch block
        this.respond(response, true, "", apiEJB.getAccountingPeriod(format.format(date), this.getSessKey(request, Constants.SCHEME_ID)));
    }

	private void getMemberBalances(HttpServletRequest request, HttpServletResponse response) {

		String user = this.getSessKey(request, Constants.USER).trim();
		List<Scheme> scheme = apiEJB.getProfileSchemes(user, this.getSessKey(request, Constants.U_PROFILE));
		String planType = scheme.get(0).getPlanType();
		jLogger.i(">>>>>>>>>>>>>>> Plan Type is: " + planType + " <<<<<<<<<<<<<<<<<<<<<");
		String schemeId = Long.toString(scheme.get(0).getId());
		jLogger.i(">>>>>>>>>>>>>>> Scheme Id is: " + schemeId + " <<<<<<<<<<<<<<<<<<<<<");

			if(planType.equalsIgnoreCase(Constants.DEFINED_BENEFIT)) {
				jLogger.i(">>>>>>>>>>>>> So we're here 1 <<<<<<<<<<<<<<<<<");
				this.respond(response, true, "", apiEJB.getDbMemberBalances(this.getSessKey(request, Constants.PROFILE_ID), schemeId));
			} else {
				jLogger.i(">>>>>>>>>>>>> So we're here 1 <<<<<<<<<<<<<<<<<");
				this.respond(response, true, "", apiEJB.getDcMemberBalances(this.getSessKey(request, Constants.PROFILE_ID)));
			}

	}
    /*private void getMemberBalances(HttpServletResponse response, JSONObject memberBalances) {
        this.respond(response, true, "", memberBalances);
    }*/

    private void schemeCurrency(HttpServletResponse response, JSONObject schemeCurrency) {
        this.respond(response, true, "", schemeCurrency);
    }

    private void getBeneficiaries(HttpServletResponse response, JSONObject beneficiaries) {
        this.respond(response, true, "", beneficiaries);
    }

    private void cummulativeInterest(HttpServletResponse response, JSONObject memberCummulativeInterest) {


        this.respond(response, true, "", memberCummulativeInterest);
    }
	private void cumulativeBenefit(HttpServletResponse response, JSONObject cumulativeBenefit) {
		this.respond(response, true, "", cumulativeBenefit);
	}

    private void averageInterest(HttpServletResponse response, JSONObject memberAverageInterest) {
        this.respond(response, true, "", memberAverageInterest);
    }
    
    private void benefitsInfo(HttpServletResponse response, JSONObject benefitInformation){
        this.respond(response, true, "", benefitInformation);
    
    }


}
