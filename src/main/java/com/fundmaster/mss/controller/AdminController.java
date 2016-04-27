package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.ejbInterface.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.LOGGER;
import com.fundmaster.mss.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@WebServlet(name = "AdminController", urlPatterns = { "/admin" })
@MultipartConfig
public class AdminController extends HttpServlet implements Serializable {
	private static final String REQUEST_ACTION = "ACTION";
	private static final String LOGO_DIR = "static" + File.separator + "images";
	private static final String BANNER_DIR = "static" + File.separator + "images" + File.separator + "banner";
	LOGGER logger = new LOGGER(this.getClass());
	@EJB
	Helper helper;
	@EJB
	MediaEJB mediaEJB;
	@EJB
	CompanyEJB companyEJB;
	@EJB
	SettingEJB settingEJB;
	@EJB
	CountryEJB countryEJB;
	@EJB
	ProfileNameEJB profileNameEJB;
	@EJB
	ProfileLoginFieldEJB profileLoginFieldEJB;
	@EJB
	UserEJB userEJB;
	@EJB
	MemberPermissionEJB memberPermissionEJB;
	@EJB
	PermissionEJB permissionEJB;
	@EJB
	PasswordPolicyEJB passwordPolicyEJB;
	@EJB
	MemberEJB memberEJB;
	@EJB
	SponsorEJB sponsorEJB;
	@EJB
	SchemeManagerEJB schemeManagerEJB;
	@EJB
	UsedPasswordEJB usedPasswordEJB;
	@EJB
	HelpEJB helpEJB;
	@EJB
	PageContentEJB pageContentEJB;
	@EJB
	ContactCategoryEJB contactCategoryEJB;
	@EJB
	BannerEJB bannerEJB;
	@EJB
	ThemeEJB themeEJB;
	@EJB
	InterestRateColumnEJB interestRateColumnEJB;
	@EJB
	MenuEJB menuEJB;
	@EJB
	SocialEJB socialEJB;

	public AdminController() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Check if user is already authenticated */
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);

		try {
			if (session != null) {
				if (!(session.getAttribute(Constants.LOGIN).equals(true) && (helper.isManagerial(session.getAttribute(Constants.U_PROFILE).toString()) || helper.isManager(request))))
				{
					response.sendRedirect(getServletContext().getContextPath() + "/login");

				} else {
					Company company = helper.getCompany();
					List<ActivityLog> activityLogs = helper
							.getActivityLogs(session.getAttribute(Constants.UID).toString());
					request.setAttribute("activityLogs", activityLogs);
					request.setAttribute("company", company);
					List<Scheme> schemes;
					if (session.getAttribute(Constants.U_PROFILE).equals(Constants.ADMIN_PROFILE))
						try {
							schemes = helper.getSchemes(0, 10000);
						} catch (JSONException je) {
							schemes = null;
						}
					else
						schemes = helper.getProfileSchemes(session.getAttribute(Constants.USER).toString(),
								session.getAttribute(Constants.U_PROFILE).toString());
					request.setAttribute("schemes", schemes);
					PasswordPolicy policy = helper.getPasswordPolicy();
					request.setAttribute("policy", policy);
					request.setAttribute("username", session.getAttribute(Constants.USER).toString());
					if (schemes != null && schemes.size() == 1) {
						try {
							if (session.getAttribute(Constants.SCHEME_ID) == null) {
								session.setAttribute(Constants.SCHEME_TYPE, schemes.get(0).getPlanType());
								session.setAttribute(Constants.SCHEME_ID, schemes.get(0).getId().toString());
								session.setAttribute(Constants.SCHEME_NAME, schemes.get(0).getName());
								request.setAttribute("scheme_id", schemes.get(0).getId().toString());
							} else {
								for (Scheme scheme : schemes) {
									if (session.getAttribute(Constants.SCHEME_ID)
											.equals(String.valueOf(scheme.getId()))) {
										session.setAttribute(Constants.SCHEME_TYPE, scheme.getPlanType());
										break;
									}
								}
								request.setAttribute("scheme_id", session.getAttribute(Constants.SCHEME_ID));
							}
						} catch (Exception ex) {
							ex.printStackTrace(out);
							session.setAttribute(Constants.SCHEME_ID, String.valueOf(schemes.get(0).getId()));
							session.setAttribute(Constants.SCHEME_NAME, schemes.get(0).getName());
						}
					} else if (session.getAttribute(Constants.SCHEME_ID) != null) {
						for (Scheme scheme : schemes != null ? schemes : null) {

							if (scheme.getId()
									.equals(Long.valueOf(session.getAttribute(Constants.SCHEME_ID).toString()))) {

								try {

									if (session.getAttribute(Constants.SCHEME_ID) == null) {
										session.setAttribute(Constants.SCHEME_TYPE, scheme.getPlanType());
										session.setAttribute(Constants.SCHEME_ID, scheme.getId().toString());
										session.setAttribute(Constants.SCHEME_NAME, scheme.getName());
										request.setAttribute("scheme_id", scheme.getId().toString());
									} else {
										for (Scheme scheme1 : schemes) {
											if (session.getAttribute(Constants.SCHEME_ID)
													.equals(String.valueOf(scheme1.getId()))) {
												session.setAttribute(Constants.SCHEME_TYPE, scheme1.getPlanType());
												break;
											}
										}
										request.setAttribute("scheme_id", session.getAttribute(Constants.SCHEME_ID));
									}
								} catch (Exception ex) {
									ex.printStackTrace(out);
									session.setAttribute(Constants.SCHEME_ID, String.valueOf(scheme.getId()));
									session.setAttribute(Constants.SCHEME_NAME, scheme.getName());
								}
								break;
							}
						}
					}
					request.setAttribute("path", "admin");
					request.setAttribute("profile", session.getAttribute(Constants.U_PROFILE));
					Permission permissions = helper.getPermissions(request);
					request.setAttribute("permissions", permissions);
					List<ContactCategory> contactReasons = helper.getContactReasons();
					request.setAttribute("contactReasons", contactReasons);
					request.setAttribute("isManager", helper.isManager(request));
					if ((schemes != null ? schemes.size() : 0) > 1 && session.getAttribute(Constants.SCHEME_ID) == null)
						request.getRequestDispatcher("select_scheme.jsp").forward(request, response);
					else {
						try {
							List<XiMember> due4retirement = helper
									.due4Retirement(session.getAttribute(Constants.SCHEME_ID).toString());
							request.setAttribute("retirement", due4retirement);
						} catch (JSONException je) {
							logger.e("Json Exception detected: " + je.getMessage());
						}
						request.getRequestDispatcher("admin.jsp").forward(request, response);
					}
				}
			} else
				response.sendRedirect(getServletContext().getContextPath() + "/login");
		} catch (NullPointerException jnpe) {
			response.sendRedirect(getServletContext().getContextPath() + "/login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		String MEDIA_DIR = "media";
		if (request.getParameter(REQUEST_ACTION).equals("SWITCH_SCHEME")) {
			session.setAttribute(Constants.SCHEME_ID, request.getParameter("schemeID"));
			out.write(helper.result(true, "success").toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("COMPANY")) {

			/* Company Details Update Request */
			Country country = countryEJB.findById(helper.toLong(request.getParameter("country")));
			Company company = new Company(Long.valueOf(request.getParameter("company_id")).longValue(),
					request.getParameter("companyName"), request.getParameter("streetAddress"),
					request.getParameter("telephone"), request.getParameter("fax"),
					request.getParameter("emailAddress"), request.getParameter("email"), request.getParameter("city"),
					country, request.getParameter("geolocation"));

			if (companyEJB.edit(company) != null) {
				helper.audit(session, "Updated company details");
				out.write(helper.result(true, "success").toString());
			} else
				out.write(helper.result(false, "failed").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("SC")) {
			try {
				String result = helper.getSchemeContributions(session.getAttribute(Constants.SCHEME_ID).toString(),
						session.getAttribute(Constants.PROFILE_ID).toString());
				out.write(result);

			} catch (JSONException e) {

				out.write(helper.result(false,
						"Sorry, an error was encountered loading the scheme contribution history, please try again"
								+ e.getMessage())
						.toString());

			}
		}

		else if (request.getParameter(REQUEST_ACTION).equals("PROFILE_NAMES")) {
			List<ProfileName> pNames = profileNameEJB.find();
			boolean status = true;
			for (ProfileName pName : pNames) {
				pName.setName(request.getParameter(pName.getProfile()));
				status = status && profileNameEJB.edit(pName) != null;
			}
			if (status) {
				helper.audit(session, "Updated profile name settings");
				out.write(helper.result(true, "Profile name settings successfully saved").toString());
			} else
				out.write(helper.result(true, "Profile name settings could not be saved").toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("ADMIN_PWD_RESET")) {
			String userID = request.getParameter("userID");
			User u = userEJB.findById(helper.toLong(userID));
			if (u != null) {
				String password = helper.shorterUUID(UUID.randomUUID().toString(), 0);
				u.setPassword(helper.hash(password));
				String email_address = null;
				String schemeId = null;
				boolean proceed = false;
				JSONObject res;
				String memberID;

				try {
					res = helper.memberExists(u.getUserProfile(), u.getUsername());
					memberID = res.get("memberId").toString();

					System.out.println("memberID " + memberID + " u.getProfileID() " + u.getProfileID());
					if (u.getUserProfile().equals(Constants.MEMBER_PROFILE)) {
						XiMember m = helper.getMemberDetails(u.getProfileID().toString());
						email_address = m.getEmailAddress();
						schemeId = res.get("schemeId").toString();
						proceed = helper.isEmailAddress(email_address);
					} else {
						try {
							JSONObject resp = helper.getProviderDetails(u.getUserProfile(), memberID);
							if (resp.get("success").equals(true)) {
								try {
									JSONArray json = (JSONArray) resp.get("rows");
									JSONObject provider = json.getJSONObject(0);
									email_address = provider.getString("email");
									schemeId = provider.get("schemeId").toString();
									proceed = helper.isEmailAddress(email_address);
								} catch (JSONException e) {
									try {
										JSONArray json = (JSONArray) resp.get("rows");
										JSONObject provider = json.getJSONObject(0);
										email_address = provider.getString("user.email");
										schemeId = provider.get("user.schemeId").toString();
										proceed = helper.isEmailAddress(email_address);
									} catch (JSONException ex) {
										proceed = false;
									}
								}
							}
						} catch (Exception e) {
							proceed = false;

						}
					}
					if (proceed) {
						Setting settings = helper.getSettings();
						helper.sendNotification(email_address, "MSS Portal Password Reset",
								"Dear " + u.getUserProfile() + ",<br />"
										+ "Your password has been reset on the FundMaster Xi Member Self Service Portal. Your new password is "
										+ password + ".<br />Please click this <a href='" + settings.getPortalBaseURL()
										+ "sign-in'>link</a> to gain access to the Self Service Portal",
								schemeId, false, null);

						if (userEJB.edit(u) != null)
							out.write(helper
									.result(true,
											"<strong>Password Reset Successful</strong><br /> Success! The user's password has been reset. An email has been sent to the user with the new password.")
									.toString());
						else
							out.write(helper
									.result(false,
											"We could not complete the requested action as we were unable to obtain the user's email address")
									.toString());

					} else {
						out.write(helper
								.result(false,
										"We could not complete the requested action as we were unable to obtain the user's email address")
								.toString());

					}
				} catch (JSONException je) {
					out.write(helper
							.result(false,
									"We could not complete the requested action as we were unable to obtain the user's email address")
							.toString());

				}
			}
		} else if (request.getParameter(REQUEST_ACTION).equals("EDIT_BENEFICIARY")) {
			JSONObject b = new JSONObject();
			String beneficiary_id = request.getParameter("beneficiary_id");
			String memberID = request.getParameter("memberID");
			String relationshipCategory = request.getParameter("relationshipCategory");
			String surname = request.getParameter("surname");
			String lumpsum = request.getParameter("lumpsum");
			String firstname = request.getParameter("firstname");
			String gender = request.getParameter("gender");
			String maritalStatus = request.getParameter("maritalStatus");
			String status = request.getParameter("status");
			String othernames = request.getParameter("othernames");
			String relationship = request.getParameter("relationship");
			try {
				if (request.getParameter("type").equalsIgnoreCase("EDIT")) {
					b.put("ben.memberId", memberID).put("ben.relationship", relationship)
							.put("beneficiary.id", beneficiary_id)
							.put("ben.relShipCategory", relationshipCategory).put("ben.surname", surname)
							.put("ben.firstname", firstname).put("ben.othernames", othernames).put("ben.dob", "")
							.put("ben.gender", gender).put("ben.monthlyEntitlement", 0)
							.put("ben.lumpsumEntitlement", lumpsum).put("ben.idNo", "")
							.put("ben.address.postalAddress", "").put("ben.mstatus", maritalStatus)
							.put("ben.physicalCondition", "").put("ben.status", status);
				} else if (request.getParameter("type").equalsIgnoreCase("ADD")) {
					b.put("ben.memberId", memberID).put("beneficiary.id", beneficiary_id)
							.put("ben.relationship", relationship).put("ben.relShipCategory", relationshipCategory)
							.put("ben.surname", surname).put("ben.firstname", firstname)
							.put("ben.othernames", othernames).put("ben.dob", "").put("ben.gender", gender)
							.put("ben.monthlyEntitlement", 0).put("ben.lumpsumEntitlement", lumpsum).put("ben.idNo", "")
							.put("ben.address.postalAddress", "").put("ben.mstatus", maritalStatus)
							.put("ben.physicalCondition", "").put("ben.status", status);
				}
				try {
					String res = helper.saveOrUpdateBeneficiary(b.toString());
					out.write(res);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					out.write(helper
							.result(false,
									"Sorry, something didn't work out right. Couldn't save the beneficiary details")
							.toString());
				}
			} catch (JSONException e) {
				out.write(helper
						.result(false, "Sorry, something didn't work out right. Couldn't save the beneficiary details")
						.toString());

			}
		} else if (request.getParameter(REQUEST_ACTION).equals("UPDATE_MEMBER")) {

			JSONObject member = new JSONObject();
			String firstname = request.getParameter("firstname");
			String surname = request.getParameter("surname");
			String othernames = request.getParameter("othernames");
			String postalAddress = request.getParameter("postalAddress");
			String maritalStatus = request.getParameter("maritalStatus");
			String phoneNumber = request.getParameter("phoneNumber");
			String emailAddress = request.getParameter("emailAddress");
			String memberID = request.getParameter("memberID");
			String salary = request.getParameter("currentAnnualPensionableSalary");
			String city = request.getParameter("city");
			DateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
			Date dob = null;
			try {
				dob = df.parse(request.getParameter("dateOfBirth"));
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			String status = "ACTIVE";
			String gender = request.getParameter("gender").toUpperCase();
			DateFormat format_ = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			try {
				member.put("member.surname", surname).put("member.firstname", firstname)

						.put("member.othernames", othernames).put("member.person.biodata.town", city)
						.put("member.dob", format_.format(dob)).put("member.id", memberID).put("member.gender", gender)
						.put("member.mbshipStatus", status).put("member.address.email", emailAddress)
						.put("member.person.biodata.cellPhone", phoneNumber)
						.put("member.currentAnnualPensionableSalary", salary)
						.put("member.person.biodata.postalAddress", postalAddress)
						.put("member.maritalStatus", maritalStatus);
				try {
					JSONObject res = helper.saveOrUpdateMember(member.toString());
					out.write(res.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					out.write(helper
							.result(false, "Sorry, something didn't work out right. Couldn't save the member details")
							.toString());
				}
			} catch (JSONException e) {
				out.write(
						helper.result(false, "Sorry, something didn't work out right. Couldn't save the member details")
								.toString());

			}
		}

		else if (request.getParameter(REQUEST_ACTION).equals("GET_BENEFICIARY")) {
			if (request.getParameter("type").equals("EDIT")) {
				List<Beneficiary> beneficiaries = helper.getBeneficiaries(request.getParameter("memberID"));
				request.setAttribute("beneficiaries", beneficiaries);
			}
			request.setAttribute("beneficiary_id", request.getParameter("beneficiaryID"));
			request.setAttribute("type", request.getParameter("type"));
			request.getRequestDispatcher("member/beneficiary.jsp").forward(request, response);

		} else if (request.getParameter(REQUEST_ACTION).equals("GET_PERMISSION")) {
			Permission perm = helper.getPermissions(request.getParameter("profile"));
			request.setAttribute("permissions", perm);
			request.getRequestDispatcher("dashboard/permissions.jsp").forward(request, response);
		} else if (request.getParameter(REQUEST_ACTION).equals("SAVE_PERMISSION")) {
			helper.audit(session, "Updated permissions and privileges for " + request.getParameter("profile"));
			Permission perm = permissionEJB.findByProfile(request.getParameter("profile"));
			perm.setSetup(request.getParameter("setup").equalsIgnoreCase("true"));
			perm.setContent(request.getParameter("content").equalsIgnoreCase("true"));
			perm.setSchemes(request.getParameter("schemes").equalsIgnoreCase("true"));
			perm.setReceipts(request.getParameter("receipts").equalsIgnoreCase("true"));
			perm.setPayments(request.getParameter("payments").equalsIgnoreCase("true"));
			perm.setOperations(request.getParameter("member_operations").equalsIgnoreCase("true"));
			perm.setMembers(request.getParameter("members").equalsIgnoreCase("true"));
			perm.setMedia(request.getParameter("media").equalsIgnoreCase("true"));
			perm.setUac(request.getParameter("uac").equalsIgnoreCase("true"));
			perm.setAnalytics(request.getParameter("analytics").equalsIgnoreCase("true"));
			perm.setContent_help(request.getParameter("content_help").equalsIgnoreCase("true"));
			perm.setContent_page(request.getParameter("content_page").equalsIgnoreCase("true"));
			perm.setMedia_remove(request.getParameter("media_remove").equalsIgnoreCase("true"));
			perm.setMedia_upload(request.getParameter("media_upload").equalsIgnoreCase("true"));
			perm.setMember_edit(request.getParameter("member_edit").equalsIgnoreCase("true"));
			perm.setMember_view(request.getParameter("member_view").equalsIgnoreCase("true"));
			perm.setMember_edit_permissions(request.getParameter("member_edit_permissions").equalsIgnoreCase("true"));
			perm.setProfile_login_username(request.getParameter("profile_login_username").equalsIgnoreCase("true"));
			perm.setProfile_privileges(request.getParameter("profile_privileges").equalsIgnoreCase("true"));
			perm.setProfile_names(request.getParameter("profile_names").equalsIgnoreCase("true"));
			perm.setSetup_banner(request.getParameter("setup_banner").equalsIgnoreCase("true"));
			perm.setSetup_company(request.getParameter("setup_company").equalsIgnoreCase("true"));
			perm.setSetup_contact_reason(request.getParameter("setup_contact_reason").equalsIgnoreCase("true"));
			perm.setSetup_interest_rate(request.getParameter("setup_interest_rate").equalsIgnoreCase("true"));
			perm.setSetup_logo(request.getParameter("setup_logo").equalsIgnoreCase("true"));
			perm.setSetup_menu(request.getParameter("setup_menu").equalsIgnoreCase("true"));
			perm.setSetup_other(request.getParameter("setup_other").equalsIgnoreCase("true"));
			perm.setSetup_social(request.getParameter("setup_social").equalsIgnoreCase("true"));
			perm.setSetup_theme(request.getParameter("setup_theme").equalsIgnoreCase("true"));
			perm.setOperation_balance_history(
					request.getParameter("operation_balance_history").equalsIgnoreCase("true"));
			perm.setOperation_benefit_projection(
					request.getParameter("operation_benefit_projection").equalsIgnoreCase("true"));
			perm.setOperation_contribution_history(
					request.getParameter("operation_contribution_history").equalsIgnoreCase("true"));
			perm.setOperation_personal_info(request.getParameter("operation_personal_info").equalsIgnoreCase("true"));
			perm.setOperation_statement_of_account(
					request.getParameter("operation_statement_of_account").equalsIgnoreCase("true"));
			perm.setUsers(request.getParameter("users").equalsIgnoreCase("true"));
			perm.setUser_enable_disable(request.getParameter("user_enable_disable").equalsIgnoreCase("true"));
			perm.setAudit_trail(request.getParameter("audit_trail").equalsIgnoreCase("true"));
			perm.setPortal_member_add(request.getParameter("portal_member_add").equalsIgnoreCase("true"));
			perm.setPortal_member_delete(request.getParameter("portal_member_delete").equalsIgnoreCase("true"));
			perm.setPortal_member_process(request.getParameter("portal_member_process").equalsIgnoreCase("true"));
			perm.setPortal_member_view(request.getParameter("portal_member_view").equalsIgnoreCase("true"));
			perm.setPortal_members(request.getParameter("portal_members").equalsIgnoreCase("true"));
			perm.setPortal_sponsor_add(request.getParameter("portal_sponsor_add").equalsIgnoreCase("true"));
			perm.setPortal_sponsor_delete(request.getParameter("portal_sponsor_delete").equalsIgnoreCase("true"));
			perm.setPortal_sponsor_process(request.getParameter("portal_sponsor_process").equalsIgnoreCase("true"));
			perm.setPortal_sponsor_view(request.getParameter("portal_sponsor_view").equalsIgnoreCase("true"));
			perm.setPortal_sponsors(request.getParameter("portal_sponsors").equalsIgnoreCase("true"));
			perm.setPassword_policy(request.getParameter("password_policy").equalsIgnoreCase("true"));

			if (permissionEJB.edit(perm) != null)
				out.write(helper.result(true, "Permissions successfully saved").toString());
			else
				out.write(helper.result(false, "Permissions could not be saved").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("SET_PASSWORD_POLICY")) {
			PasswordPolicy p = passwordPolicyEJB.find();
			p.setExpiry_days(Integer.parseInt(request.getParameter("expiry_days")));
			p.setLength(Integer.parseInt(request.getParameter("length")));
			p.setLock_after_count_of(Integer.parseInt(request.getParameter("lock_after_count_of")));
			p.setLowercase(request.getParameter("lowercase").equalsIgnoreCase("true"));
			p.setNumbers(request.getParameter("numbers").equalsIgnoreCase("true"));
			p.setPassword_reuse(request.getParameter("password_reuse").equalsIgnoreCase("true"));
			p.setUppercase(request.getParameter("uppercase").equalsIgnoreCase("true"));

			if (passwordPolicyEJB.edit(p) != null)
				out.write(helper.result(true, "Password policy successfully saved").toString());
			else
				out.write(helper.result(false, "Password policy could not be saved").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("PROFILE_LOGIN_FIELD")) {
			String[] profiles = helper.listProfiles();
			boolean status = true;
			for (String profile : profiles) {
				ProfileLoginField plf = profileLoginFieldEJB.findByProfile(profile);
				plf.setOrdinal(request.getParameter(plf.getProfile()));
				plf.setPublished(request.getParameter(plf.getProfile() + "_PUBLISHED").equalsIgnoreCase("true"));
				status = status && profileLoginFieldEJB.edit(plf) != null;
			}
			if (status) {
				helper.audit(session, "Updated profile login settings");
				out.write(helper.result(true, "Profile login settings successfully saved").toString());
			} else
				out.write(helper.result(false, "Profile login settings could not be saved").toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("FRONTPAGE_ACCESS")) {
			try {
				String result = helper.frontPageAccessByPage();
				out.write(result);
			} catch (JSONException e) {
				// TODO Auto-generated catch block

			}

		} else if (request.getParameter(REQUEST_ACTION).equals("DELETE_PORTAL_SPONSOR")) {
			Sponsor s = sponsorEJB.findById(helper.toLong(request.getParameter("id")));

			if (sponsorEJB.delete(s))
				out.write(helper.result(true, "Potential sponsor record successfully deleted").toString());
			else
				out.write(helper.result(false, "Potential sponsor record could not be deleted").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("ADD_MEMBER")) {
			JSONObject result = helper.createMember(request);
			out.write(result.toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("ADD_SPONSOR")) {
			JSONObject result = helper.createSponsor(request);
			out.write(result.toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("SUBMIT_PORTAL_MEMBER")) {
			String memberID = request.getParameter("id");
			Member m = helper.getMemberByID(memberID);
			JSONObject result = helper.postMemberToXi(m);
			out.write(result.toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("SUBMIT_PORTAL_SPONSOR")) {
			String sponsorID = request.getParameter("id");
			Sponsor s = helper.getSponsor(sponsorID);
			JSONObject result = helper.postSponsorToXi(s);
			out.write(result.toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("DELETE_PORTAL_MEMBER")) {
			Member m = memberEJB.findById(helper.toLong(request.getParameter("id")));

			if (memberEJB.delete(m))
				out.write(helper.result(true, "Potential member record successfully deleted").toString());
			else
				out.write(helper.result(false, "Potential member record could not be deleted").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("SEARCH_MEMBER")) {
			JSONObject result = helper.searchProfilesJSON(request.getParameter("search"),
					request.getParameter("identifier"), request.getParameter("profile"),
					session.getAttribute(Constants.SCHEME_ID).toString());

			helper.audit(session, "Searched members with search parameter " + request.getParameter("search"));
			out.write(result.toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("PROFILE_ACCESS")) {
			try {
				String result = helper.profileAccess();
				out.write(result);
			} catch (JSONException e) {
				// TODO Auto-generated catch block

			}

		} else if (request.getParameter(REQUEST_ACTION).equals("MOST_BY_MANAGER")) {
			try {
				String result = helper.mostAccesssedByManagers();
				out.write(result);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(out);
			}

		} else if (request.getParameter(REQUEST_ACTION).equals("MOST_BY_MEMBER")) {
			try {
				String result = helper.mostAccessedByMembers();
				out.write(result);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(out);
			}

		} else if (request.getParameter(REQUEST_ACTION).equals("USER_TOGGLE")) {
			User u = userEJB.findById(helper.toLong(request.getParameter("userID")));

			u.setStatus(!u.isStatus());
			u = userEJB.edit(u);
			if (u != null) {
				helper.audit(session, "Updated user status for " + u.getUserProfile() + " " + u.getUsername());

				out.write(helper.result(true, "The user status was successfully changed").toString());
			} else

				out.write(helper.result(false, "We are sorry, the user status could not be changed").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("NEW")) {
			String res = helper.getNewMembersInYear(session.getAttribute(Constants.SCHEME_ID).toString(),
					session.getAttribute(Constants.PROFILE_ID).toString());
			out.write(res);
		} else if (request.getParameter(REQUEST_ACTION).equals("AGENT_COMMISSION")) {
			String res = helper.getAgentCommission(session.getAttribute(Constants.PROFILE_ID).toString());
			out.write(res);
		} else if (request.getParameter(REQUEST_ACTION).equals("EXITS")) {
			String res = helper.getExitsInYear(session.getAttribute(Constants.SCHEME_ID).toString());
			out.write(res);
		} else if (request.getParameter(REQUEST_ACTION).equals("SEARCH_SCHEMES")) {
			String res = helper.searchSchemes(request.getParameter("search"));
			helper.audit(session, "Searched schemes with parameter " + request.getParameter("search"));
			out.write(res);
		} else if (request.getParameter(REQUEST_ACTION).equals("CHANGE_SCHEME")) {
			helper.audit(session, "Switched between schemes from scheme #" + session.getAttribute(Constants.SCHEME_ID)
					+ " to scheme #" + request.getParameter("schemeID"));
			session.setAttribute(Constants.SCHEME_ID, request.getParameter("schemeID"));
			out.write(helper.result(true, "Scheme changed successfully").toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("GET_MEMBER")) {
			XiMember xm = null;
			try {
				logger.i("MemberId "+request.getParameter("memberID"));
				xm = helper.getMemberDetails(request.getParameter("memberID"));
			} catch (JSONException  e) {
				// TODO Auto-generated catch block
				logger.e("JSONException was detected: " + e.getMessage());
			}
			List<Country> countries = helper.getCountries();
			request.setAttribute("countries", countries);
			List<Gender> genders = helper.getGenders();
			request.setAttribute("genders", genders);
			List<MaritalStatus> marital_statuses = helper.getMaritalStatuses();
			request.setAttribute("maritalStatuses", marital_statuses);
			Company company = helper.getCompany();
			request.setAttribute("company", company);
			Social social = helper.getSocial();
			request.setAttribute("social", social);
			List<Sector> sectors = helper.getSectors();
			request.setAttribute("sectors", sectors);
			List<Scheme> schemes = null;
			try {
				schemes = helper.getSchemes(0, 10000);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				logger.e("JSONException was detected: " + e.getMessage());
			}
			List<Beneficiary> beneficiaries = helper.getBeneficiaries(request.getParameter("memberID"));
			request.setAttribute("beneficiaries", beneficiaries);
			request.setAttribute("schemes", schemes);
			MemberPermission memberPermission = helper.getMemberPermissions();
			request.setAttribute("memberPermission", memberPermission);
			request.setAttribute("member", xm);
			helper.audit(session, "Accessed editable view for member " + xm.getName());
			request.getRequestDispatcher("member/personal_information.jsp").forward(request, response);
		} else if (request.getParameter(REQUEST_ACTION).equals("DELINK_SCHEME_MANAGER")) {

			SchemeMemberManager smm = schemeManagerEJB.findById(helper.toLong(request.getParameter("id")));

			if (schemeManagerEJB.delete(smm)) {
				helper.audit(session, "De-linked scheme manager #" + smm.getName());
				out.write(helper.result(true, "Scheme member successfully delinked from scheme managers").toString());
			} else {
				out.write(helper.result(false, "Scheme member could not be delinked from scheme managers").toString());
			}
		} else if (request.getParameter(REQUEST_ACTION).equals("ADD_SCHEME_MANAGER")) {
			String profile = request.getParameter("profile");
			String email = request.getParameter("email");
			String ordinal = helper.getLoginField(profile);
			String ordinal_key = helper.getOrdinalKey(ordinal);
			JSONObject res = helper.searchProfilesJSON(email, "EMAIL", profile,
					session.getAttribute(Constants.SCHEME_ID).toString());
			String username;
			try {
				JSONArray json_arr = (JSONArray) res.get("rows");

				JSONObject obj = json_arr.getJSONObject(0);

				username = obj.getString(ordinal_key);

				User u = helper.findByUsernameAndProfile(username, profile);
				SchemeMemberManager smm = new SchemeMemberManager(Long.valueOf("0").longValue(), u.getId().longValue(),
						profile, session.getAttribute(Constants.SCHEME_ID).toString(), obj.get("name").toString(),
						session.getAttribute(Constants.SCHEME_NAME).toString());
				schemeManagerEJB.add(smm);
				helper.audit(session, "Added a new scheme manager " + smm.getName());
				out.write(helper.result(true, "Scheme member successfully added as scheme manager").toString());
			} catch (JSONException je) {
				out.write(helper.result(false, "Scheme member could not be added as a scheme manager").toString());
			}
		} else if (request.getParameter(REQUEST_ACTION).equals("VIEW_MEMBER")) {
			XiMember xm = null;
			try {
				xm = helper.getMemberDetails(request.getParameter("memberID"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block

			}
			List<Beneficiary> beneficiaries = helper.getBeneficiaries(request.getParameter("memberID"));
			request.setAttribute("beneficiaries", beneficiaries);
			MemberPermission memberPermission = helper.getMemberPermissions();
			request.setAttribute("memberPermission", memberPermission);
			request.setAttribute("member", xm);
			helper.audit(session, "Viewed member details for member #" + xm.getName());
			request.getRequestDispatcher("member/personal_information_view.jsp").forward(request, response);
		} else if (request.getParameter(REQUEST_ACTION).equals("CURR")) {
			String result = helper.getSchemeCurrency(session.getAttribute(Constants.SCHEME_ID).toString());
			out.write(result);
		} else if (request.getParameter(REQUEST_ACTION).equals("ML")) {
			String result = null;
			try {
				result = helper.listMembers(session.getAttribute(Constants.SCHEME_ID).toString(),
						session.getAttribute(Constants.PROFILE_ID).toString());
				helper.audit(session, "Accessed scheme member listing");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.write(result);
		} else if (request.getParameter(REQUEST_ACTION).equals("PRE_CHANGE_PASSWORD")) {
			User u = userEJB.find(session.getAttribute(Constants.USER).toString(),
					session.getAttribute(Constants.U_PROFILE).toString());
			String securityCode = helper.shorterUUID(UUID.randomUUID().toString(), 1);
			/*
			 * Shorter code is more user friendly... the UUID was way too long
			 * :)
			 */
			u.setSecurityCode(securityCode);
			userEJB.edit(u);
			XiMember m = null;
			try {
				m = helper.getMemberDetails(session.getAttribute(Constants.PROFILE_ID).toString());
			} catch (JSONException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				JSONObject resp = helper.sendNotification(m.getEmailAddress(), "Change Password Request",
						"Dear " + u.getUsername() + ", " + "You recently requested to change your password. "
								+ "Here is your security code:" + "" + securityCode
								+ "\nYou will require it to be able to change your password",
						session.getAttribute(Constants.SCHEME_ID).toString(), false, "");
				if (resp.get("success").equals(true)) {
					out.write(
							helper.result(true, "The change password instructions have been sent to your email address")
									.toString());

				} else {
					out.write(helper
							.result(false, "We are sorry, we were unable to send you the change password instructions")
							.toString());

				}
			} catch (JSONException | NullPointerException e1) {

				out.write(helper
						.result(false,
								"We are sorry, we encountered a problem obtaining your email address. Please try again")
						.toString());

			}

		} else if (request.getParameter(REQUEST_ACTION).equals("CHANGE_PASSWORD")) {
			PasswordPolicy policy = helper.getPasswordPolicy();
			String securityCode = request.getParameter("securityCode");
			String username = session.getAttribute(Constants.USER).toString();
			String password = request.getParameter("currentPassword");
			String new_password = request.getParameter("newPassword");
			User u = helper.login(username, password);
			if (u != null) {
				if (u.getSecurityCode().equalsIgnoreCase(securityCode)) {
					if (!(usedPasswordEJB.isUsed(new_password) && policy.isPassword_reuse())) {
						try {
							u.setPassword(helper.hash(new_password));
							Date password_expiry = helper.addDays(new Date(), policy.getExpiry_days());
							u.setPassword_expiry(password_expiry);
							userEJB.edit(u);
							helper.audit(session, "Changed password");
							out.write(helper.result(true, "Your password was changed successfully").toString());
						} catch (Exception e) {
							out.write(helper.result(false, "Sorry, your password could not be changed").toString());

						}
					} else {
						out.write(helper
								.result(false,
										"Sorry, the new password entered has already been used once. You cannot re-use the password.")
								.toString());

					}
				} else {
					out.write(helper
							.result(false, "Sorry, your security code is invalid. Please enter a valid security code.")
							.toString());
				}
			} else {
				out.write(helper.result(false, "The current password you entered is wrong. Please try again.")
						.toString());
			}

		} else if (request.getParameter(REQUEST_ACTION).equals("AP")) {

			DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
			Date date = new Date();
			String result = helper.getAccountingPeriod(format.format(date),
					session.getAttribute(Constants.SCHEME_ID).toString());
			out.write(result);
		} else if (request.getParameter(REQUEST_ACTION).equals("FV")) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date date = new Date();
			// String result =
			// helper.getFundValue(request.getParameter("accountingPeriodId"),
			// session.getAttribute(Constants.SCHEME_ID).toString(),session.getAttribute(Constants.PROFILE_ID).toString());
			String result = helper.getFundValueAsAt(format.format(date), request.getParameter("accountingPeriodId"),
					session.getAttribute(Constants.SCHEME_ID).toString(),
					session.getAttribute(Constants.PROFILE_ID).toString());
			out.write(result);
		} else if (request.getParameter(REQUEST_ACTION).equals("HELP")) {
			Help h = helpEJB.findById(helper.toLong(request.getParameter("ID")));
			h.setPage(request.getParameter("page"));
			h.setDescription(request.getParameter("description"));
			helpEJB.edit(h);
			helper.audit(session, "Updated portal help content for page " + request.getParameter("page"));
			out.write(helper.result(true, "content edited").toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("REMOVE_BANNER")) {
			Banner b = bannerEJB.findById(helper.toLong(request.getParameter("id")));

			if (bannerEJB.delete(b))
				out.write(helper.result(true, "Banner image successfully deleted").toString());
			else
				out.write(helper.result(false, "Banner image could not be deleted").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("PAGE_CONTENT")) {

			PageContent pc = pageContentEJB.findById(helper.toLong(request.getParameter("ID")));
			pc.setPage(request.getParameter("page"));
			pc.setText(request.getParameter("description"));
			pc.setPosition(request.getParameter("position"));
			pc.setPublish(request.getParameter("publish").equalsIgnoreCase("true"));
			if (pageContentEJB.edit(pc) != null) {
				helper.audit(session, "Updated portal page content for page " + request.getParameter("page"));
				out.write(helper.result(true, "Content was successfully updated").toString());
			} else
				out.write(helper.result(true, "Content could not be updated").toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("THEME")) {

			Theme theme = themeEJB.findById(helper.toLong(request.getParameter("theme_id")));
			theme.setMajor(request.getParameter("major"));
			theme.setMinor(request.getParameter("minor"));
			theme.setFont(request.getParameter("font"));
			theme.setOther(request.getParameter("other"));
			theme.setHeader(request.getParameter("header"));
			theme.setContent(request.getParameter("content"));
			theme.setFooter(request.getParameter("footer"));
			if (themeEJB.edit(theme) != null) {
				helper.audit(session, "Updated portal theme settings");
				out.write(helper.result(true, "Theme settings saved").toString());
			} else
				out.write(helper.result(false, "Theme settings not saved").toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("INTEREST_RATE_COLUMNS")) {
			boolean accountingPeriod = request.getParameter("accountingPeriod").equalsIgnoreCase("true");
			boolean contributions = request.getParameter("contributions").equalsIgnoreCase("true");
			boolean dateDeclared = request.getParameter("dateDeclared").equalsIgnoreCase("true");
			boolean openingBalances = request.getParameter("openingBalances").equalsIgnoreCase("true");
			boolean pensionDrawDown = request.getParameter("pensionDrawDown").equalsIgnoreCase("true");
			boolean year = request.getParameter("year").equalsIgnoreCase("true");
			InterestRateColumns irc = interestRateColumnEJB.find();
			irc.setDateDeclared(dateDeclared);
			irc.setYear(year);
			irc.setContributions(contributions);
			irc.setOpeningBalances(openingBalances);
			irc.setPensionDrawDown(pensionDrawDown);
			irc.setAccountingPeriod(accountingPeriod);
			irc.setDateDeclaredText(request.getParameter("dateDeclaredText"));
			irc.setYearText(request.getParameter("yearText"));
			irc.setContributionsText(request.getParameter("contributionsText"));
			irc.setOpeningBalancesText(request.getParameter("openingBalancesText"));
			irc.setPensionDrawDownText(request.getParameter("pensionDrawDownText"));
			irc.setAccountingPeriodText(request.getParameter("accountingPeriodText"));

			if (interestRateColumnEJB.edit(irc) != null) {
				helper.audit(session, "Updated interest rate column settings");
				out.write(helper.result(true, "Interest rate settings successfully saved").toString());
			} else
				out.write(helper.result(false, "Interest rate settings could not be saved").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("SETTINGS")) {
			Setting settings = settingEJB.find();
			if (request.getParameter("encrypt").equalsIgnoreCase("true")) {
				settings.setXiPath(helper.encrypt(request.getParameter("fundmasterXi")));
				settings.setUsername(helper.encrypt(request.getParameter("username")));
				settings.setPassword(helper.encrypt(request.getParameter("password")));
				settings.setPortalBaseURL(helper.encrypt(request.getParameter("portalBaseURL")));
				settings.setXiReportPath(helper.encrypt(request.getParameter("xiReportPath")));
				settings.setXiReportUsername(helper.encrypt(request.getParameter("xiReportUsername")));
				settings.setXiReportPassword(helper.encrypt(request.getParameter("xiReportPassword")));
			} else {
				settings.setXiPath(request.getParameter("fundmasterXi"));
				settings.setUsername(request.getParameter("username"));
				settings.setPassword(request.getParameter("password"));
				settings.setPortalBaseURL(request.getParameter("portalBaseURL"));
				settings.setXiReportPath(request.getParameter("xiReportPath"));
				settings.setXiReportUsername(request.getParameter("xiReportUsername"));
				settings.setXiReportPassword(request.getParameter("xiReportPassword"));
			}
			settings.setMemberOnboarding(request.getParameter("memberOnboarding"));
			settings.setSponsorOnboading(request.getParameter("sponsorOnboarding"));
			settings.setEncrypt(request.getParameter("encrypt").equalsIgnoreCase("true"));

			if (settingEJB.edit(settings) != null) {
				helper.audit(session, "Updated other portal settings and configurations");
				out.write(helper.result(true, "Portal Settings & Configurations successfully saved").toString());
			} else
				out.write(helper.result(true, "Portal Settings & Configurations could not be saved").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("MENU")) {
			/* Menu Update Request */
			boolean annuityQuotationActive = request.getParameter("annuityQuotationActive").equalsIgnoreCase("true");
			boolean interestRatesActive = request.getParameter("interestRatesActive").equalsIgnoreCase("true");
			boolean whatIfAnalysisActive = request.getParameter("whatIfAnalysisActive").equalsIgnoreCase("true");
			boolean contactUsActive = request.getParameter("contactUsActive").equalsIgnoreCase("true");
			Menu menu = menuEJB.find();
			menu.setAnnuityQuotationActive(annuityQuotationActive);
			menu.setInterestRatesActive(interestRatesActive);
			menu.setWhatIfAnalysisActive(whatIfAnalysisActive);
			menu.setContactUsActive(contactUsActive);
			menu.setAnnuityQuotationName(request.getParameter("annuityQuotationName"));
			menu.setInterestRatesName(request.getParameter("interestRatesName"));
			menu.setWhatIfAnalysisName(request.getParameter("whatIfAnalysisName"));
			menu.setContactUsName(request.getParameter("contactUsName"));
			if (menuEJB.edit(menu) != null) {
				helper.audit(session, "Updated portal menu configuration settings");
				out.write(helper.result(true, "Portal menu configurations successfully saved").toString());
			} else
				out.write(helper.result(true, "Portal menu configurations could not be saved").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("LOGOUT")) {
			/* Logout Request */
			helper.logActivity("", "logged out", session.getAttribute(Constants.UID).toString(), null,
					session.getAttribute(Constants.U_PROFILE).toString());
			helper.audit(session, "Logged out of the portal");
			session.invalidate();
			out.write(helper.result(true, "You have been successfully logged out").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("SOCIAL")) {
			/* Social Media Links Update Request */
			Social social = socialEJB.find();
			social.setTwitter(request.getParameter("twitter"));
			social.setFacebook(request.getParameter("facebook"));
			social.setLinkedin(request.getParameter("linkedin"));
			social.setGoogle(request.getParameter("google"));
			social.setYoutube(request.getParameter("youtube"));
			social.setPinterest(request.getParameter("pinterest"));
			if (socialEJB.edit(social) != null) {
				helper.audit(session, "Updated portal social network settings");
				out.write(helper.result(true, "Social network details successfully saved").toString());
			} else
				out.write(helper.result(false, "Social network details could not be saved").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("REMOVE_CONTACT_REASON")) {
			ContactCategory cc = contactCategoryEJB.findById(helper.toLong(request.getParameter("id")));
			if (contactCategoryEJB.delete(cc)) {
				helper.audit(session, "Deleted a contact category: " + cc.getName());

				out.write(helper.result(true, "Contact category was successfully deleted").toString());
			} else
				out.write(helper.result(false, "Contact category could not be deleted").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("REMOVE_MEDIA")) {
			Media m = helper.getMediaById(helper.toLong(request.getParameter("id")));
			if (mediaEJB.delete(m)) {
				helper.audit(session, "Deleted a media/file: " + m.getName());
				out.write(helper.result(true, "Media/File was successfully deleted").toString());
			} else
				out.write(helper.result(true, "Media/File could not be deleted").toString());

		} else if (request.getParameter(REQUEST_ACTION).equals("MEMBER_PERMISSION")) {
			MemberPermission mp = new MemberPermission(
					Long.valueOf(request.getParameter("member_permission_id")).longValue(),
					request.getParameter("memberNo").equalsIgnoreCase("true"),
					request.getParameter("partyRefNo").equalsIgnoreCase("true"),
					request.getParameter("partnerNo").equalsIgnoreCase("true"),
					request.getParameter("policyNo").equalsIgnoreCase("true"),
					request.getParameter("staffNo").equalsIgnoreCase("true"),
					request.getParameter("name").equalsIgnoreCase("true"),
					request.getParameter("idNumber").equalsIgnoreCase("true"),
					request.getParameter("pinNo").equalsIgnoreCase("true"),
					request.getParameter("postalAddress").equalsIgnoreCase("true"),
					request.getParameter("phoneNumber").equalsIgnoreCase("true"),
					request.getParameter("emailAddress").equalsIgnoreCase("true"),
					request.getParameter("gender").equalsIgnoreCase("true"),
					request.getParameter("dateOfBirth").equalsIgnoreCase("true"),
					request.getParameter("maritalStatus").equalsIgnoreCase("true"),
					request.getParameter("country").equalsIgnoreCase("true"),
					request.getParameter("town").equalsIgnoreCase("true"),
					request.getParameter("annualPensionableSalary").equalsIgnoreCase("true"));

			if (memberPermissionEJB.edit(mp) != null) {
				helper.audit(session, "Updated member edit permissions");
				out.write(helper.result(true, "Member edit permissions successfully saved").toString());
			} else
				out.write(helper.result(false, "Member edit permissions could not be saved").toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("PLF")) {
			List<ProfileLoginField> pfs = helper.getProfileLoginFields();
			boolean status = true;
			for (ProfileLoginField plf : pfs) {
				plf.setOrdinal(request.getParameter(String.valueOf(plf.getId())));
				status = status && profileLoginFieldEJB.edit(plf) != null;
			}
			if (status) {
				helper.audit(session, "Updated the profile unique login fields for the various user profiles");
				out.write(helper.result(true, "Profile login ordinals successfully saved").toString());
			} else
				out.write(helper.result(true, "Profile login ordinals could not be saved").toString());
		} else if (request.getParameter(REQUEST_ACTION).equals("ADD_CONTACT_REASON")) {
			if (request.getParameter("type").equalsIgnoreCase("ADD")) {
				ContactCategory cc = new ContactCategory();
				cc.setName(request.getParameter("name"));
				if (contactCategoryEJB.add(cc) != null) {
					helper.audit(session, "Added a new contact category " + request.getParameter("name"));
					out.write(helper.result(true, "Contact category successfully saved").toString());
				} else
					out.write(helper.result(true, "Contact category could not be saved").toString());
			} else {
				ContactCategory cc = helper.findConcactCategoryById(helper.toLong(request.getParameter("id")));
				cc.setName(request.getParameter("name"));
				if (contactCategoryEJB.edit(cc) != null) {
					helper.audit(session, "Updated a contact category " + request.getParameter("name"));
					out.write(helper.result(true, "Contact category successfully saved").toString());
				} else
					out.write(helper.result(true, "Contact category could not be saved").toString());
			}
		} else if (request.getParameter(REQUEST_ACTION).equals("LOGO")) {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (!fileName.equals("")) {
					String fullpath = request.getServletContext().getRealPath("") + File.separator + LOGO_DIR
							+ File.separator + fileName;
					part.write(fullpath);
					Setting settings = settingEJB.find();
					File file = new File(fullpath);
					logger.i("File: " + file);
					byte[] bFile = new byte[(int) file.length()];
					FileInputStream fileInputStream = new FileInputStream(file);
					fileInputStream.read(bFile);
					fileInputStream.close();
					settings.setLogoFile(fullpath);
					settings.setLogo(bFile);
					if (settingEJB.edit(settings) != null) {
						logger.i("Logo has been uploaded");
						helper.audit(session, "Uploaded portal logo");
						out.write(helper.result(true, "Logo was successfully uploaded").toString());
					} else {

						logger.i("Logo has not been uploaded: " + settings.getId());
						out.write(helper.result(false, "Logo could not be uploaded").toString());
					}
				}
			}
		} else if (request.getParameter(REQUEST_ACTION).equals("BANNER")) {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (!fileName.equals("")) {
					String fullpath = request.getServletContext().getRealPath("") + File.separator + BANNER_DIR
							+ File.separator + fileName;
					part.write(fullpath);
					File file = new File(fullpath);

					byte[] bFile = new byte[(int) file.length()];
					FileInputStream fileInputStream = new FileInputStream(file);
					fileInputStream.read(bFile);
					fileInputStream.close();
					Banner banner = new Banner();
					banner.setName(fileName);
					banner.setPath(fullpath);
					banner.setImage(bFile);
					if (bannerEJB.add(banner) != null) {
						helper.audit(session, "Uploaded a banner for the portal");
						out.write(helper.result(true, "Banner image was successfully uploaded").toString());
					} else
						out.write(helper.result(true, "Banner image could not be uploaded").toString());

				}
			}
		} else if (request.getParameter(REQUEST_ACTION).equals("MEDIA")) {

			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (!fileName.equals("")) {
					// Get absolute path (fullpath)
					String fullpath = request.getServletContext().getRealPath("");

					String savePath = fullpath + File.separator + MEDIA_DIR;
					//System.out.println("full path is:" + savePath);

					File fileSaveDir = new File(savePath);
					if (!fileSaveDir.exists()) {
						fileSaveDir.mkdir();
					}

					savePath = fullpath + File.separator + MEDIA_DIR + File.separator + fileName;
					part.write(savePath);
					System.out.println("Complete file path is: " + savePath);

					// Save image into database

					File file = new File(savePath);
					byte[] bFile = new byte[(int) file.length()];

					try {
						FileInputStream fileInputStream = new FileInputStream(file);
						// Convert file into array of bytes
						fileInputStream.read(bFile);
						fileInputStream.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

					Date date = new Date();
					Media media = new Media(fileName, session.getAttribute(Constants.SCHEME_ID).toString(),
							request.getParameter("description"), request.getParameter("access"), date);
					media.setFile(bFile);
					media.setPath(savePath);

					boolean administrator;
					try {
						administrator = request.getParameter(Constants.ADMIN_PROFILE).equals("on");
					} catch (NullPointerException npe) {
						administrator = false;
					}
					boolean member;
					try {
						member = request.getParameter(Constants.MEMBER_PROFILE).equals("on");
					} catch (NullPointerException npe) {
						member = false;
					}
					boolean agent;
					try {
						agent = request.getParameter(Constants.AGENT_PROFILE).equals("on");
					} catch (NullPointerException npe) {
						agent = false;
					}
					boolean sponsor;
					try {
						sponsor = request.getParameter("SPONSOR").equals("on");
					} catch (NullPointerException npe) {
						sponsor = false;
					}
					boolean trustee;
					try {
						trustee = request.getParameter("TRUSTEE").equals("on");
					} catch (NullPointerException npe) {
						trustee = false;
					}
					boolean custodian;
					try {
						custodian = request.getParameter("CUSTODIAN").equals("on");
					} catch (NullPointerException npe) {
						custodian = false;
					}
					boolean crm;
					try {
						crm = request.getParameter("CUSTOMER_RELATIONSHIP_MANAGER").equals("on");
					} catch (NullPointerException npe) {
						crm = false;
					}
					boolean cre;
					try {
						cre = request.getParameter("CUSTOMER_RELATIONSHIP_EXECUTIVE").equals("on");
					} catch (NullPointerException npe) {
						cre = false;
					}
					boolean fm;
					try {
						fm = request.getParameter("FUND_MANAGER").equals("on");
					} catch (NullPointerException npe) {
						fm = false;
					}
					boolean pensioner;
					try {
						pensioner = request.getParameter("PENSIONER").equals("on");
					} catch (NullPointerException npe) {
						pensioner = false;
					}
					media.setAdministrator(administrator);
					media.setAgent(agent);
					media.setCre(cre);
					media.setCrm(crm);
					media.setFundManager(fm);
					media.setCustodian(custodian);
					media.setPensioner(pensioner);
					media.setSponsor(sponsor);
					media.setMember(member);
					media.setTrustee(trustee);
					try {
						media.setMemberId(Long.valueOf(request.getParameter("member_id")));
					} catch (NullPointerException | NumberFormatException npe) {
						media.setMemberId(Long.valueOf("0"));
					}
					if (mediaEJB.add(media) != null) {
						helper.audit(session, "Uploaded a media file");
						out.write(helper.result(true, "Media file successfully uploaded").toString());
					} else
						out.write(helper.result(true, "Media file successfully uploaded").toString());
				}
			}
		} else if (request.getParameter(REQUEST_ACTION).equals("EMAIL")) {
			String url = request.getRequestURL().toString();
			String baseURL = url.substring(0, url.length() - request.getRequestURI().length())
					+ request.getContextPath() + "/";

			boolean attachment = false;
			String attachment_url = null;

			try {
				for (Part part : request.getParts()) {
					String fileName = extractFileName(part);

					if (!fileName.equals("")) {

						//Get absolute path
						String fullpath = request.getServletContext().getRealPath("");

						String savePath = fullpath + File.separator + MEDIA_DIR;
						System.out.println("full path is:" + savePath);

						File fileSaveDir = new File(savePath);
						if (!fileSaveDir.exists()) {
							fileSaveDir.mkdir();
						}

						savePath = fullpath + File.separator + MEDIA_DIR + File.separator + fileName;
						part.write(savePath);
						System.out.println("Complete file path is: " + savePath);

						//part.write(request.getServletContext().getRealPath("") + File.separator + MEDIA_DIR + File.separator + fileName);
						attachment_url = baseURL + MEDIA_DIR + File.separator + fileName;
						attachment = true;
					}
				}
				String subject = request.getParameter("subject") + " [" + request.getParameter("category") + "]";
				String message = request.getParameter("message");
				Company company = helper.getCompany();
				JSONObject resp = helper.sendNotification(company.getEmail(), subject, message,
						session.getAttribute(Constants.SCHEME_ID).toString(), attachment, attachment_url);
				if (resp.get("success").equals(true)) {
					out.write(helper.result(true, "The email was successfully sent").toString());

				} else {
					out.write(helper.result(true, "We are sorry, but we were unable to send the email address")
							.toString());

				}
			} catch (JSONException je) {
				out.write(helper.result(false, "Email could not be sent").toString());
			}
		}
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
