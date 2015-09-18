package com.fundmaster.mss.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.common.Common;
import com.fundmaster.mss.model.ActivityLog;
import com.fundmaster.mss.model.Banner;
import com.fundmaster.mss.model.Beneficiary;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.ContactCategory;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.Gender;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.InterestRateColumns;
import com.fundmaster.mss.model.MaritalStatus;
import com.fundmaster.mss.model.Media;
import com.fundmaster.mss.model.Member;
import com.fundmaster.mss.model.MemberPermission;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.PasswordPolicy;
import com.fundmaster.mss.model.Permission;
import com.fundmaster.mss.model.ProfileLoginField;
import com.fundmaster.mss.model.Scheme;
import com.fundmaster.mss.model.SchemeMemberManager;
import com.fundmaster.mss.model.Sector;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Sponsor;
import com.fundmaster.mss.model.Theme;
import com.fundmaster.mss.model.User;
import com.fundmaster.mss.model.XiMember;
import com.fundmaster.mss.service.BannerService;
import com.fundmaster.mss.service.CompanyService;
import com.fundmaster.mss.service.ContactCategoryService;
import com.fundmaster.mss.service.CountryService;
import com.fundmaster.mss.service.HelpService;
import com.fundmaster.mss.service.InterestRateColumnsService;
import com.fundmaster.mss.service.MediaService;
import com.fundmaster.mss.service.MemberPermissionService;
import com.fundmaster.mss.service.MemberService;
import com.fundmaster.mss.service.MenuService;
import com.fundmaster.mss.service.PageContentService;
import com.fundmaster.mss.service.PasswordPolicyService;
import com.fundmaster.mss.service.PermissionService;
import com.fundmaster.mss.service.ProfileLoginFieldService;
import com.fundmaster.mss.service.SchemeMemberManagerService;
import com.fundmaster.mss.service.SettingService;
import com.fundmaster.mss.service.SocialService;
import com.fundmaster.mss.service.SponsorService;
import com.fundmaster.mss.service.ThemeService;
import com.fundmaster.mss.service.UserService;
@WebServlet(name = "AdminController", urlPatterns = {"/admin"})
@MultipartConfig
public class AdminController  extends GenericController{
	private static final String REQUEST_ACTION = "ACTION";
	private static String LOGO_DIR = "static" + File.separator + "images";
	private static String BANNER_DIR = "static" + File.separator + "images" + File.separator + "banner";
	private static String MEDIA_DIR = "media";
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
			if(session != null)
			{
				if(!(session.getAttribute(Common.LOGIN).equals(true) && (isManagerial(session.getAttribute(Common.U_PROFILE).toString()) || isManager(request))))
				{
					response.sendRedirect(getServletContext().getContextPath() + "/login");
				}
				else
				{
					Company company = getCompany();
					List<ActivityLog> activityLogs = getActivityLogs(session.getAttribute(Common.UID).toString());
					request.setAttribute("activityLogs", activityLogs);
					request.setAttribute("company", company);
					List<Scheme> schemes;
					if(session.getAttribute(Common.U_PROFILE).equals(Common.ADMIN_PROFILE))
						schemes = getSchemes(0, 10000);
					else
						schemes = getProfileSchemes(session.getAttribute(Common.USER).toString(), session.getAttribute(Common.U_PROFILE).toString());
					request.setAttribute("schemes", schemes);
					PasswordPolicy policy = getPasswordPolicy();
					request.setAttribute("policy", policy);
					request.setAttribute("username", session.getAttribute(Common.USER).toString());
					if(schemes != null)
					{
						try {
							
							Logger.getAnonymousLogger().info("Scheme ID:" + session.getAttribute(Common.SCHEME_ID).toString());

							if(session.getAttribute(Common.SCHEME_ID) == null)
							{
								session.setAttribute(Common.SCHEME_TYPE, schemes.get(0).getPlanType());
								session.setAttribute(Common.SCHEME_ID, schemes.get(0).getId().toString());
								session.setAttribute(Common.SCHEME_NAME, schemes.get(0).getName().toString());
								request.setAttribute("scheme_id", schemes.get(0).getId().toString());
							}
							else
							{
								for(int i = 0; i < schemes.size(); i ++)
								{
									if(session.getAttribute(Common.SCHEME_ID).equals(String.valueOf(schemes.get(i).getId()).toString()))
									{
										Logger.getAnonymousLogger().info("Here2:" + schemes.get(i).getPlanType());
										session.setAttribute(Common.SCHEME_TYPE, schemes.get(i).getPlanType());
										break;
									}
								}
								request.setAttribute("scheme_id", session.getAttribute(Common.SCHEME_ID));
							}
							Logger.getAnonymousLogger().info("SCHEME TYPE: " + session.getAttribute(Common.SCHEME_TYPE));
						} catch(Exception ex)
						{
							ex.printStackTrace(out);
								session.setAttribute(Common.SCHEME_ID, String.valueOf(schemes.get(0).getId()).toString());
								session.setAttribute(Common.SCHEME_NAME, schemes.get(0).getName().toString());
						}
					}
					request.setAttribute("path", "admin");
					request.setAttribute("profile", session.getAttribute(Common.U_PROFILE));
					Permission permissions = getPermissions(request);
					request.setAttribute("permissions", permissions);
					request.setAttribute("isManager", isManager(request));
					request.getRequestDispatcher("admin.jsp").forward(request, response);
				}
			}
			else
				response.sendRedirect(getServletContext().getContextPath() + "/login");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			response.sendRedirect(getServletContext().getContextPath() + "/login");			
		} 
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);
        	PrintWriter out = response.getWriter();
			if (request.getParameter(REQUEST_ACTION).equals("COMPANY"))
			{
				
				/* Company Details Update Request */
				CountryService cService = new CountryService();
				Country country = cService.findById(Long.valueOf(request.getParameter("country")).longValue());
				Company company = new Company(Long.valueOf(request.getParameter("company_id").toString()).longValue(), request.getParameter("companyName").toString(), request.getParameter("streetAddress").toString(), request.getParameter("telephone").toString(), request.getParameter("fax").toString(), request.getParameter("emailAddress").toString(), request.getParameter("email").toString(), request.getParameter("city").toString(), country, request.getParameter("geolocation"));
				CompanyService companyService = new CompanyService();
				try {
					companyService.update(company);
					audit(session, "Updated company details");
					out.write(result(true, "success").toString());
				}
				catch (Exception e)
				{
					try {
						out.write(result(false, "failed").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("SC"))
			{
				try {
					String result = getSchemeContributions(session.getAttribute(Common.SCHEME_ID).toString());
					out.write(result);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					try {
						out.write(result(false, "Sorry, an error was encountered loading the scheme contribution history, please try again" + e.getMessage()).toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("EDIT_BENEFICIARY"))
			{
				JSONObject b = new JSONObject();
				String beneficiary_id = request.getParameter("beneficiary_id").toString();
				String memberID = request.getParameter("memberID").toString();
				String relationshipCategory = request.getParameter("relationshipCategory").toString();
				String surname = request.getParameter("surname").toString();
				String lumpsum = request.getParameter("lumpsum").toString();
				String firstname = request.getParameter("firstname").toString();
				String gender = request.getParameter("gender").toString();
				String maritalStatus = request.getParameter("maritalStatus").toString();
				String status = request.getParameter("status").toString();
				String othernames = request.getParameter("othernames").toString();
				String relationship = request.getParameter("relationship").toString();
				try {
					if( request.getParameter("type").equalsIgnoreCase("EDIT"))
					{
						b.put("ben.memberId", memberID)
						.put("ben.relationship", relationship)
						.put("ben.relShipCategory", relationshipCategory)
						.put("ben.surname", surname)
						.put("ben.firstname", firstname)
						.put("ben.othernames", othernames)
						.put("ben.dob", "").put("ben.gender", gender)
						.put("ben.monthlyEntitlement", 0)
						.put("ben.lumpsumEntitlement", lumpsum)
						.put("ben.idNo", "")
						.put("ben.address.postalAddress", "")
						.put("ben.mstatus", maritalStatus)
						.put("ben.physicalCondition", "")
						.put("ben.status", status);
					} else if(request.getParameter("type").equalsIgnoreCase("ADD"))
					{
						b.put("beneficiary.id", beneficiary_id)
						.put("ben.relationship", relationship)
						.put("ben.relShipCategory", relationshipCategory)
						.put("ben.surname", surname)
						.put("ben.firstname", firstname)
						.put("ben.othernames", othernames)
						.put("ben.dob", "").put("ben.gender", gender)
						.put("ben.monthlyEntitlement", 0)
						.put("ben.lumpsumEntitlement", lumpsum)
						.put("ben.idNo", "")
						.put("ben.address.postalAddress", "")
						.put("ben.mstatus", maritalStatus)
						.put("ben.physicalCondition", "")
						.put("ben.status", status);
					}
					try {
						String res = saveOrUpdateBeneficiary(b.toString());
						out.write(res);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						out.write(result(false, "Sorry, something didn't work out right. Couldn't save the beneficiary details").toString());
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					try {
						out.write(result(false, "Sorry, something didn't work out right. Couldn't save the beneficiary details").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("UPDATE_MEMBER"))
			{

				JSONObject member = new JSONObject();
				String firstname = request.getParameter("firstname");
				String surname = request.getParameter("surname");
				String othernames = request.getParameter("othernames");
				String postalAddress = request.getParameter("postalAddress");
				String maritalStatus = request.getParameter("maritalStatus");
				String phoneNumber = request.getParameter("phoneNumber");
				String emailAddress = request.getParameter("emailAddress");
				String memberID = request.getParameter("memberID");
				String city = request.getParameter("city");
				try {
					member.put("member.person.surname", surname)
					.put("member.person.firstname", firstname)
					.put("member.person.othernames", othernames)
					.put("member.person.biodata.town", city)
					.put("member.id", memberID)
					.put("member.person.biodata.email", emailAddress)
					.put("member.person.biodata.cellPhone", phoneNumber)
					.put("member.person.biodata.postalAddress", postalAddress)
					.put("member.person.biodata.maritalStatus", maritalStatus);
					try {
						String res = saveOrUpdateBeneficiary(member.toString());
						out.write(res);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						out.write(result(false, "Sorry, something didn't work out right. Couldn't save the member details").toString());
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					try {
						out.write(result(false, "Sorry, something didn't work out right. Couldn't save the member details").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				}
			}
			
			else if(request.getParameter(REQUEST_ACTION).equals("GET_BENEFICIARY"))
			{
				if(request.getParameter("type").equals("EDIT"))
				{
					List<Beneficiary> beneficiaries = getBeneficiaries(request.getParameter("memberID").toString());
					request.setAttribute("beneficiaries", beneficiaries);
				}
				request.setAttribute("beneficiary_id", request.getParameter("beneficiaryID"));
				request.setAttribute("type", request.getParameter("type"));
				request.getRequestDispatcher("member/beneficiary.jsp").forward(request, response);
				
			}
			else if(request.getParameter(REQUEST_ACTION).equals("GET_PERMISSION"))
			{
				Permission perm = getPermissions(request.getParameter("profile"));
				request.setAttribute("permissions", perm);
				request.getRequestDispatcher("dashboard/permissions.jsp").forward(request, response); 
			}
			else if(request.getParameter(REQUEST_ACTION).equals("SAVE_PERMISSION"))
			{
				audit(session, "Updated permissions and privileges for " + request.getParameter("profile").toString());
				Permission perm = getPermissions(request.getParameter("profile"));
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
				perm.setSetup_banner(request.getParameter("setup_banner").equalsIgnoreCase("true"));
				perm.setSetup_company(request.getParameter("setup_company").equalsIgnoreCase("true"));
				perm.setSetup_contact_reason(request.getParameter("setup_contact_reason").equalsIgnoreCase("true"));
				perm.setSetup_interest_rate(request.getParameter("setup_interest_rate").equalsIgnoreCase("true"));
				perm.setSetup_logo(request.getParameter("setup_logo").equalsIgnoreCase("true"));
				perm.setSetup_menu(request.getParameter("setup_menu").equalsIgnoreCase("true"));
				perm.setSetup_other(request.getParameter("setup_other").equalsIgnoreCase("true"));
				perm.setSetup_social(request.getParameter("setup_social").equalsIgnoreCase("true"));
				perm.setSetup_theme(request.getParameter("setup_theme").equalsIgnoreCase("true"));
				perm.setOperation_balance_history(request.getParameter("operation_balance_history").equalsIgnoreCase("true"));
				perm.setOperation_benefit_projection(request.getParameter("operation_benefit_projection").equalsIgnoreCase("true"));
				perm.setOperation_contribution_history(request.getParameter("operation_contribution_history").equalsIgnoreCase("true"));
				perm.setOperation_personal_info(request.getParameter("operation_personal_info").equalsIgnoreCase("true"));
				perm.setOperation_statement_of_account(request.getParameter("operation_statement_of_account").equalsIgnoreCase("true"));
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
				PermissionService pService = new PermissionService();
				pService.update(perm);
				try {
					out.write(result(true, "Permissions successfully saved").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("SET_PASSWORD_POLICY"))
			{
				PasswordPolicy p = getPasswordPolicy();
				p.setId(Long.valueOf(request.getParameter("password_policy_id")).longValue());
				p.setExpiry_days(Integer.parseInt(request.getParameter("expiry_days").toString()));
				p.setLength(Integer.parseInt(request.getParameter("length").toString()));
				p.setLock_after_count_of(Integer.parseInt(request.getParameter("lock_after_count_of").toString()));
				p.setLowercase(request.getParameter("lowercase").equalsIgnoreCase("true"));
				p.setNumbers(request.getParameter("numbers").equalsIgnoreCase("true"));
				p.setPassword_reuse(request.getParameter("password_reuse").equalsIgnoreCase("true"));
				p.setUppercase(request.getParameter("uppercase").equalsIgnoreCase("true"));
				PasswordPolicyService pService = new PasswordPolicyService();
				try {
					pService.update(p);
					try {
						out.write(result(true, "Password policy successfully saved").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(out);
					}
				} catch (Exception ex)
				{
					try {
						out.write(result(true, "Password policy could not be saved").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(out);
					}
				}
				
			}
			else if(request.getParameter(REQUEST_ACTION).equals("PROFILE_LOGIN_FIELD"))
			{
				String[] profiles = listProfiles();
				for(int i = 0; i < profiles.length; i ++)
				{
					ProfileLoginFieldService plfService = new ProfileLoginFieldService();
					ProfileLoginField plf = getProfileLoginField(profiles[i]);
					Logger.getAnonymousLogger().info("Profile: " + plf.getProfile() + ", value: " + request.getParameter(plf.getProfile()).toString());
					plf.setOrdinal(request.getParameter(plf.getProfile()).toString());
					plf.setPublished(request.getParameter(plf.getProfile() + "_PUBLISHED").equalsIgnoreCase("true"));
					plfService.update(plf);
					audit(session, "Updated profile login settings");
				}
				out.write("true");
			}
			else if(request.getParameter(REQUEST_ACTION).equals("FRONTPAGE_ACCESS"))
			{
				try {
					String result = frontPageAccessByPage();
					out.write(result);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
				
			}
			else if(request.getParameter(REQUEST_ACTION).equals("DELETE_PORTAL_SPONSOR"))
			{
				SponsorService sService = new SponsorService();
				Sponsor s = sService.findById(Long.valueOf(request.getParameter("id").toString()).longValue());
				try {
					sService.delete(s);
					out.write(result(true, "Potential sponsor record successfully deleted").toString());
				} catch (Exception ex)
				{

					try {
						out.write(result(false, "Potential sponsor record could not be deleted").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(out);
					}
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("ADD_MEMBER"))
			{
				JSONObject result = createMember(request);
				out.write(result.toString());
			}
			else if(request.getParameter(REQUEST_ACTION).equals("ADD_SPONSOR"))
			{
				JSONObject result = createSponsor(request);
				out.write(result.toString());
			}
			else if(request.getParameter(REQUEST_ACTION).equals("SUBMIT_PORTAL_MEMBER"))
			{
				String memberID = request.getParameter("id");
				Member m = getMemberByID(memberID);
				JSONObject result = postMemberToXi(m);
				out.write(result.toString());
			}
			else if(request.getParameter(REQUEST_ACTION).equals("SUBMIT_PORTAL_SPONSOR"))
			{
				String sponsorID = request.getParameter("id");
				Sponsor s = getSponsor(sponsorID);
				JSONObject result = postSponsorToXi(s);
				out.write(result.toString());
			}
			else if(request.getParameter(REQUEST_ACTION).equals("DELETE_PORTAL_MEMBER"))
			{
				MemberService mService = new MemberService();
				Member m = mService.findById(Long.valueOf(request.getParameter("id").toString()).longValue());
				try {
					mService.delete(m);
					out.write(result(true, "Potential member record successfully deleted").toString());
				} catch (Exception ex)
				{
					ex.printStackTrace();
					try {
						out.write(result(false, "Potential member record could not be deleted").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(out);
					}
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("SEARCH_MEMBER"))
			{
				JSONObject result = searchProfilesJSON(request.getParameter("search").toString(), request.getParameter("identifier").toString(), request.getParameter("profile").toString(), session.getAttribute(Common.SCHEME_ID).toString());

				audit(session, "Searched members with search parameter " + request.getParameter("search"));
				out.write(result.toString());
			}
			else if(request.getParameter(REQUEST_ACTION).equals("PROFILE_ACCESS"))
			{
				try {
					String result = profileAccess();
					out.write(result);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
				
			}
			else if(request.getParameter(REQUEST_ACTION).equals("MOST_BY_MANAGER"))
			{
				try {
					String result = mostAccesssedByManagers();
					out.write(result);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
				
			}
			else if(request.getParameter(REQUEST_ACTION).equals("MOST_BY_MEMBER"))
			{
				try {
					String result = mostAccessedByMembers();
					out.write(result);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
				
			}
			else if(request.getParameter(REQUEST_ACTION).equals("USER_TOGGLE"))
			{
				String userID = request.getParameter("userID");
				UserService uService = new UserService();
				User u = getUser(Long.valueOf(userID).longValue());
				try {
					u.setStatus(!u.isStatus());
					uService.update(u);
					audit(session, "Updated user status for " + u.getUserProfile() + " " + u.getUsername());
					try {
						out.write(result(false, "The user status was successfully changed").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				} catch (Exception e)
				{
					try {
						out.write(result(false, "We are sorry, the user status could not be changed").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("NEW"))
			{
				String res = getNewMembersInYear(session.getAttribute(Common.SCHEME_ID).toString());
				out.write(res);
			}
			else if(request.getParameter(REQUEST_ACTION).equals("AGENT_COMMISSION"))
			{
				String res = getAgentCommission(session.getAttribute(Common.PROFILE_ID).toString());
				out.write(res);
			}
			else if(request.getParameter(REQUEST_ACTION).equals("EXITS"))
			{
				String res = getExitsInYear(session.getAttribute(Common.SCHEME_ID).toString());
				out.write(res);
			}
			else if(request.getParameter(REQUEST_ACTION).equals("SEARCH_SCHEMES"))
			{
				String res = searchSchemes(request.getParameter("search").toString());
				audit(session, "Searched schemes with parameter " + request.getParameter("search"));
				out.write(res);
			}
			else if(request.getParameter(REQUEST_ACTION).equals("CHANGE_SCHEME"))
			{
				audit(session, "Switched between schemes from scheme #" + session.getAttribute(Common.SCHEME_ID) + " to scheme #" + request.getParameter("schemeID"));
				session.setAttribute(Common.SCHEME_ID, request.getParameter("schemeID"));
				try {
					out.write(result(true, "Scheme changed successfully").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					try {
						out.write(result(true, "Scheme could not be changed").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("GET_MEMBER"))
			{
				XiMember xm = null;
				try {
					xm = getMemberDetails(request.getParameter("memberID").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<Country> countries = getCountries();
				request.setAttribute("countries",  countries);
				List<Gender> genders = getGenders();
				request.setAttribute("genders",  genders);
				List<MaritalStatus> marital_statuses = getMaritalStatuses();
				request.setAttribute("maritalStatuses",  marital_statuses);
				Company company = getCompany();
				request.setAttribute("company", company);
				Social social = getSocial();
				request.setAttribute("social", social);
				List<Sector> sectors = getSectors();
				request.setAttribute("sectors", sectors);
				List<Scheme> schemes = null;
				try {
					schemes = getSchemes(0, 10000);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("schemes", schemes);
				MemberPermission memberPermission = getMemberPermissions();
				request.setAttribute("memberPermission", memberPermission);
				request.setAttribute("member", xm);
				audit(session, "Accessed editable view for member " + xm.getName());
				request.getRequestDispatcher("member/PI.jsp").forward(request, response);	
			}
			else if(request.getParameter(REQUEST_ACTION).equals("DELINK_SCHEME_MANAGER"))
			{
				
				SchemeMemberManagerService smmService = new SchemeMemberManagerService();
				SchemeMemberManager smm = smmService.findById(Long.valueOf(request.getParameter("id")).longValue());
				Logger.getAnonymousLogger().info(smm.getName());
				try {
					smmService.delete(smm);
					audit(session, "De-linked scheme manager #" + smm.getName());
					out.write(result(true, "Scheme member successfully delinked from scheme managers").toString());					
				} catch (Exception ex)
				{
					try {
						out.write(result(true, "Scheme member could not be delinked from scheme managers").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(out);
					}						
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("ADD_SCHEME_MANAGER"))
			{
				String profile = request.getParameter("profile");
				String email = request.getParameter("email");
				try {
					String ordinal = getLoginField(profile);
					String ordinal_key = getOrdinalKey(ordinal);
					JSONObject res = searchProfilesJSON(email, "EMAIL", profile, session.getAttribute(Common.SCHEME_ID).toString());
					Logger.getAnonymousLogger().info(res.toString());
					String username = null;
					try
					{
						JSONArray json_arr = (JSONArray) res.get("rows");
							
						JSONObject obj = json_arr.getJSONObject(0);
						
						username = obj.getString(ordinal_key);
						
						User u = findByUsernameAndProfile(username, profile);
						SchemeMemberManager smm = new SchemeMemberManager(Long.valueOf("0").longValue(), Long.valueOf(u.getId()).longValue(), profile, session.getAttribute(Common.SCHEME_ID).toString(), obj.get("name").toString(), session.getAttribute(Common.SCHEME_NAME).toString());
						SchemeMemberManagerService smmService = new SchemeMemberManagerService();
						smmService.update(smm);
						audit(session, "Added a new scheme manager " + smm.getName());
						out.write(result(true, "Scheme member successfully added as scheme manager").toString());
					}
					catch (Exception ex)
					{
						out.write(result(false, "Scheme member could not be added as a scheme manager").toString());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						out.write(result(false, "Scheme member could not be added as a scheme manager").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("VIEW_MEMBER"))
			{
				XiMember xm = null;
				try {
					xm = getMemberDetails(request.getParameter("memberID").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MemberPermission memberPermission = getMemberPermissions();
				request.setAttribute("memberPermission", memberPermission);
				request.setAttribute("member", xm);
				audit(session, "Viewed member details for member #" + xm.getName());
				request.getRequestDispatcher("member/PI_VIEW.jsp").forward(request, response);	
			}
			else if(request.getParameter(REQUEST_ACTION).equals("CURR"))
			{
				String result = getSchemeCurrency(session.getAttribute(Common.SCHEME_ID).toString());
				out.write(result);
			}
			else if(request.getParameter(REQUEST_ACTION).equals("ML"))
			{
				String result = null;
				try {
					result = listMembers(session.getAttribute(Common.SCHEME_ID).toString());
					audit(session, "Accessed scheme member listing");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.write(result);
			}
			else if(request.getParameter(REQUEST_ACTION).equals("PRE_CHANGE_PASSWORD"))
			{
				User u = findByUsernameAndProfile(session.getAttribute(Common.USER).toString(), session.getAttribute(Common.U_PROFILE).toString());
				String securityCode = shorterUUID(UUID.randomUUID().toString());
				/* Shorter code is more user friendly... the UUID was way too long :) */
				u.setSecurityCode(securityCode);
				UserService uService = new UserService();
				uService.update(u);
				XiMember m = null;
				try {
					m = getMemberDetails(session.getAttribute(Common.PROFILE_ID).toString());
				} catch (JSONException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					JSONObject resp = sendNotification("EMAIL", m.getEmailAddress(), "Change Password Request", "Dear " + u.getUsername() + ", " +
							"You recently requested to change your password. " +
							"Here is your security code:" +
							"" + securityCode +
									"You will require it to be able to change your password", session.getAttribute(Common.SCHEME_ID).toString(), false, "");
					if(resp.get("success").equals(true))
					{
						try {
							out.write(result(true, "The change password instructions have been sent to your email address").toString());
						} catch (Exception ex)
						{
							ex.printStackTrace();
						}
					}
					else
					{
						try {
							out.write(result(true, "We are sorry, we were unable to send you the change password instructions").toString());
						} catch (Exception ex)
						{
							ex.printStackTrace();
						}
					}
					try {
						out.write(result(true, "Security policy enforced").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(out);
					}
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					try {
						out.write(result(true, "We are sorry, we encountered a problem obtaining your email address. Please try again").toString());
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
				} catch (NullPointerException npe) {
					try {
						out.write(result(true, "We are sorry, we encountered a problem obtaining your email address. Please try again").toString());
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
				
			}
			else if(request.getParameter(REQUEST_ACTION).equals("CHANGE_PASSWORD"))
			{
				PasswordPolicy policy = getPasswordPolicy();
				String securityCode = request.getParameter("securityCode");
				String username = session.getAttribute(Common.USER).toString();
				String password = request.getParameter("currentPassword");
				String new_password = request.getParameter("newPassword").toString();
				User u = login(username, password);
				if(u != null) 
				{
					if(u.getSecurityCode().equalsIgnoreCase(securityCode))
					{
						if(!(isUsedPassword(new_password) && policy.isPassword_reuse()))
						{
							try
							{
								u.setPassword(hash(new_password));
								Date password_expiry = addDays(new Date(), policy.getExpiry_days());
								u.setPassword_expiry(password_expiry);
								UserService uService = new UserService();
								uService.update(u);
								audit(session, "Changed password");
								out.write(result(true, "Your password was changed successfully").toString());
							}
							catch(Exception e)
							{
								try {
									out.write(result(false, "Sorry, your password could not be changed").toString());
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
				else
				{
					try {
						out.write(result(false, "The current password you entered is wrong. Please try again.").toString());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(out);
					}
				}
				
			}
			else if(request.getParameter(REQUEST_ACTION).equals("AP"))
			{

				DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
				Date date = new Date();
				String result = getAccountingPeriod(format.format(date).toString(), session.getAttribute(Common.SCHEME_ID).toString());
				out.write(result);
			}
			else if(request.getParameter(REQUEST_ACTION).equals("FV"))
			{
				String result = getFundValue(request.getParameter("accountingPeriodId"), session.getAttribute(Common.SCHEME_ID).toString());
				out.write(result);
			}
			else if(request.getParameter(REQUEST_ACTION).equals("HELP"))
			{
				HelpService hService = new HelpService();
				Help h = new Help(Long.valueOf(request.getParameter("ID").toString()).longValue(), request.getParameter("page").toString(), request.getParameter("description").toString());
				try
				{
					hService.update(h);
					audit(session, "Updated portal help content for page " + request.getParameter("page"));
					out.write("true");
				}
				catch (Exception e)
				{
					out.write("false");
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("REMOVE_BANNER"))
			{
				BannerService bService = new BannerService();
				Banner b = bService.findById(Long.valueOf(request.getParameter("id").toString()).longValue());
				File file = new File(request.getServletContext().getRealPath("") + File.separator + BANNER_DIR + File.separator  + b.getName());
				Logger.getAnonymousLogger().info(file.toString());
				try {
					if(file.delete())
					{
						bService.delete(b);
						out.write(result(true, "Banner image successfully deleted").toString());
					}
					else
					{
						out.write(result(false, "Banner image could not be deleted").toString());
					}
				} catch (Exception ex)
				{

					try {
						out.write(result(false, "Banner image could not be deleted").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(out);
					}
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("PAGE_CONTENT"))
			{
				PageContentService pcService = new PageContentService();
				PageContent pc = new PageContent(Long.valueOf(request.getParameter("ID").toString()).longValue(), request.getParameter("page").toString(), request.getParameter("description").toString(), request.getParameter("position").toString(), request.getParameter("publish").equalsIgnoreCase("true"));
				try
				{
					pcService.update(pc);
					audit(session, "Updated portal page content for page " + request.getParameter("page"));
					out.write("true");
				}
				catch (Exception e)
				{
					out.write("false");
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("THEME"))
			{
				ThemeService themeService = new ThemeService();
				Theme theme = new Theme(Long.valueOf(request.getParameter("theme_id")).longValue(), request.getParameter("major"), request.getParameter("minor"), request.getParameter("font"), request.getParameter("other"), request.getParameter("header"), request.getParameter("content"), request.getParameter("footer"));
				try
				{
					themeService.update(theme);
					audit(session, "Updated portal theme settings");
					out.write("true");
				}
				catch (Exception e)
				{
					out.write("false");
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("INTEREST_RATE_COLUMNS"))
			{
				boolean accountingPeriod = request.getParameter("accountingPeriod").equalsIgnoreCase("true");
				boolean contributions = request.getParameter("contributions").equalsIgnoreCase("true");
				boolean dateDeclared = request.getParameter("dateDeclared").equalsIgnoreCase("true");
				boolean openingBalances = request.getParameter("openingBalances").equalsIgnoreCase("true");
				boolean pensionDrawDown = request.getParameter("pensionDrawDown").equalsIgnoreCase("true");
				boolean year = request.getParameter("year").equalsIgnoreCase("true");
				InterestRateColumns irc = new InterestRateColumns(Long.valueOf(request.getParameter("id").toString()).longValue(), dateDeclared, year, contributions, openingBalances, pensionDrawDown, accountingPeriod, request.getParameter("dateDeclaredText"), request.getParameter("yearText"), request.getParameter("contributionsText"), request.getParameter("openingBalancesText"), request.getParameter("pensionDrawDownText"), request.getParameter("accountingPeriodText"));
				InterestRateColumnsService iService = new InterestRateColumnsService();				
				try {
					iService.update(irc);
					audit(session, "Updated interest rate column settings");
					out.write("true");
				}
				catch (Exception e)
				{
					out.write("false");
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("SETTINGS"))
			{
				SettingService sService = new SettingService();
				Setting settings = getSettings();
				if(request.getParameter("encrypt").toString().equalsIgnoreCase("true"))
				{
					settings.setXiPath(encrypt(request.getParameter("fundmasterXi").toString()));
					settings.setUsername(encrypt(request.getParameter("username").toString()));
					settings.setPassword(encrypt(request.getParameter("password").toString()));
					settings.setPortalBaseURL(encrypt(request.getParameter("portalBaseURL").toString()));
					settings.setXiReportPath(encrypt(request.getParameter("xiReportPath").toString()));
					settings.setXiReportUsername(encrypt(request.getParameter("xiReportUsername").toString()));
					settings.setXiReportPassword(encrypt(request.getParameter("xiReportPassword").toString()));					
				}
				else
				{
					settings.setXiPath(request.getParameter("fundmasterXi").toString());
					settings.setUsername(request.getParameter("username").toString());
					settings.setPassword(request.getParameter("password").toString());
					settings.setPortalBaseURL(request.getParameter("portalBaseURL").toString());
					settings.setXiReportPath(request.getParameter("xiReportPath").toString());
					settings.setXiReportUsername(request.getParameter("xiReportUsername").toString());
					settings.setXiReportPassword(request.getParameter("xiReportPassword").toString());
				}
				settings.setMemberOnboarding(request.getParameter("memberOnboarding").toString());
				settings.setSponsorOnboading(request.getParameter("sponsorOnboarding").toString());
				settings.setEncrypt(request.getParameter("encrypt").toString().equalsIgnoreCase("true"));
				try {
					sService.update(settings);
					audit(session, "Updated other portal settings and configurations");
					out.write("true");
				}
				catch (Exception e)
				{
					out.write("false");
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("MENU"))
			{
				/* Menu Update Request */
				MenuService mService = new MenuService();
				boolean annuityQuotationActive = request.getParameter("annuityQuotationActive").equalsIgnoreCase("true");
				boolean interestRatesActive = request.getParameter("interestRatesActive").equalsIgnoreCase("true");
				boolean whatIfAnalysisActive = request.getParameter("whatIfAnalysisActive").equalsIgnoreCase("true");
				boolean contactUsActive = request.getParameter("contactUsActive").equalsIgnoreCase("true");
				Menu menu = new Menu(Long.valueOf(request.getParameter("menu_id").toString()).longValue(), annuityQuotationActive, interestRatesActive, whatIfAnalysisActive, contactUsActive, request.getParameter("annuityQuotationName").toString(), request.getParameter("interestRatesName").toString(), request.getParameter("whatIfAnalysisName").toString(), request.getParameter("contactUsName").toString());
				try {
					mService.update(menu);
					audit(session, "Updated portal menu configuration settings");
					out.write("true");
				}
				catch (Exception e)
				{
					out.write("false");
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("LOGOUT"))
			{
				/* Logout Request */
				try {
					logActivity("", "logged out", session.getAttribute(Common.UID).toString(), null, session.getAttribute(Common.U_PROFILE).toString());
					audit(session, "Logged out of the portal");
					session.invalidate();
					out.write("true");
				}
				catch (Exception e)
				{
					e.printStackTrace(out);
					out.write("false");
				}
			}
			else if (request.getParameter(REQUEST_ACTION).equals("SOCIAL"))
			{
				/* Social Media Links Update Request */
				SocialService sService = new SocialService();
				Social social = new Social(Long.valueOf(request.getParameter("social_id").toString()).longValue(), request.getParameter("twitter"), request.getParameter("facebook"), request.getParameter("linkedin"), request.getParameter("google"), request.getParameter("youtube"), request.getParameter("pinterest"));
				try {
					sService.update(social);
					audit(session, "Updated portal social network settings");
					out.write("true");
				}
				catch (Exception e)
				{
					out.write("false");
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("REMOVE_CONTACT_REASON"))
			{
				ContactCategoryService ccService = new ContactCategoryService();
				ContactCategory cc = ccService.findById(Long.valueOf(request.getParameter("id").toString()).longValue());
				ccService.delete(cc);
				audit(session, "Deleted a contact category: " + cc.getName());
				try {
					out.write(result(true, "Contact category was successfully deleted").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("REMOVE_MEDIA"))
			{
				Long mediaID = Long.valueOf(request.getParameter("id")).longValue();
				Media m = getMediaById(mediaID);
				deleteMedia(m);
				audit(session, "Deleted a media/file: " + m.getName());
				try {
					out.write(result(true, "Media/File was successfully deleted").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
			}
			else if(request.getParameter(REQUEST_ACTION).equals("MEMBER_PERMISSION"))
			{
				MemberPermission mp = new MemberPermission(Long.valueOf(request.getParameter("member_permission_id").toString()).longValue(), false, request.getParameter("memberNo").equalsIgnoreCase("true"), false, request.getParameter("partyRefNo").equalsIgnoreCase("true"), request.getParameter("partnerNo").equalsIgnoreCase("true"), request.getParameter("policyNo").equalsIgnoreCase("true"), request.getParameter("staffNo").equalsIgnoreCase("true"), request.getParameter("name").equalsIgnoreCase("true"), request.getParameter("idNumber").equalsIgnoreCase("true"), false, request.getParameter("pinNo").equalsIgnoreCase("true"), request.getParameter("postalAddress").equalsIgnoreCase("true"), request.getParameter("phoneNumber").equalsIgnoreCase("true"), request.getParameter("emailAddress").equalsIgnoreCase("true"), request.getParameter("gender").equalsIgnoreCase("true"), false, request.getParameter("dateOfBirth").equalsIgnoreCase("true"), request.getParameter("maritalStatus").equalsIgnoreCase("true"), false, false, request.getParameter("country").equalsIgnoreCase("true") , request.getParameter("town").equalsIgnoreCase("true"), request.getParameter("annualPensionableSalary").equalsIgnoreCase("true"));
				MemberPermissionService mpService = new MemberPermissionService();
				audit(session, "Updated member edit permissions");
				mpService.update(mp);
				out.write("true");
			}
			else if(request.getParameter(REQUEST_ACTION).equals("PLF"))
			{
				ProfileLoginFieldService plfs = new ProfileLoginFieldService();
				List<ProfileLoginField> pfs = getProfileLoginFields();
				for(ProfileLoginField plf: pfs)
				{
					plf.setOrdinal(request.getParameter(String.valueOf(plf.getId()).toString()));
					audit(session, "Updated the profile unique login fields for the various user profiles");
					plfs.update(plf);
				}
				out.write("true");
			}
			else if(request.getParameter(REQUEST_ACTION).equals("ADD_CONTACT_REASON"))
			{
				if(request.getParameter("type").equalsIgnoreCase("ADD"))
				{
					ContactCategory cc = new ContactCategory();
					cc.setName(request.getParameter("name"));
					ContactCategoryService ccService = new ContactCategoryService();
					ccService.update(cc);
					audit(session, "Added a new contact category " + request.getParameter("name"));
				}
				else
				{
					ContactCategoryService ccService = new ContactCategoryService();
					ContactCategory cc = ccService.findById(Long.valueOf(request.getParameter("id")).longValue());
					cc.setName(request.getParameter("name"));
					ccService.update(cc);
					audit(session, "Updated a contact category " + request.getParameter("name"));
				}
				out.write("true");
			}
			else if (request.getParameter(REQUEST_ACTION).equals("LOGO"))
			{
	            try {
					 for (Part part : request.getParts()) {
				            String fileName = extractFileName(part);
				            if(!fileName.equals(""))
				            {
				            	part.write(request.getServletContext().getRealPath("") + File.separator + LOGO_DIR + File.separator + fileName);
				            	Setting settings = getSettings();
				            	settings.setLogoFile(fileName);
				            	SettingService sService = new SettingService();
				            	sService.update(settings);
				            	audit(session, "Uploaded portal logo");
								out.write("true");
				            }
				        }
				 
	            } catch (Exception ex) {
	            	ex.printStackTrace();
	            	out.write("false");
	            } 
			}
			else if (request.getParameter(REQUEST_ACTION).equals("BANNER"))
			{
		            try {
						 for (Part part : request.getParts()) {
					            String fileName = extractFileName(part);
					            if(!fileName.equals(""))
					            {
					            	part.write(request.getServletContext().getRealPath("") + File.separator + BANNER_DIR + File.separator + fileName);
						            BannerService bService = new BannerService();
						            Banner banner = new Banner(null, fileName);
						            bService.persist(banner);
									audit(session, "Uploaded a banner for the portal");
									out.write("true");
					            }
					        }
					 
		            } catch (Exception ex) {
		            	ex.printStackTrace(out);
		            	out.write("false");
		            } 
			}
			else if (request.getParameter(REQUEST_ACTION).equals("MEDIA"))
			{
		            try {
						 for (Part part : request.getParts()) {
					            String fileName = extractFileName(part);
					            if(!fileName.equals(""))
					            {
						            part.write(request.getServletContext().getRealPath("") + File.separator + MEDIA_DIR + File.separator + fileName);
						            MediaService mService = new MediaService();
						            Date date = new Date();
						            Media media = new Media(null, fileName, session.getAttribute(Common.SCHEME_ID).toString(), request.getParameter("description"), request.getParameter("access"), date);
						            mService.persist(media);
									audit(session, "Uploaded a downloadable media/file");
									out.write("true");
					            }
					        }
					 
		            } catch (Exception ex) {
		            	ex.printStackTrace(out);
		            	out.write("false");
		            } 
			}
			else if (request.getParameter(REQUEST_ACTION).equals("EMAIL"))
			{
					String url = request.getRequestURL().toString();
					String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
					boolean attachment = false;
					String attachment_url = null;
		            try {
						 for (Part part : request.getParts()) {
					            String fileName = extractFileName(part);
					            if(!fileName.equals(""))
					            {
						            part.write(request.getServletContext().getRealPath("") + File.separator + MEDIA_DIR + File.separator + fileName);
						            attachment_url = baseURL + MEDIA_DIR + File.separator + fileName;
						            Logger.getAnonymousLogger().info("Uploaded file path: " + attachment_url);
						            attachment = true;
					            }
					        }
						 String subject = request.getParameter("subject").toString() + " [" + request.getParameter("category") + "]";
						 String message = request.getParameter("message");
						 Company company = getCompany();
						 JSONObject resp = sendNotification("EMAIL", company.getEmail(), subject, message, session.getAttribute(Common.SCHEME_ID).toString(), attachment, attachment_url);
						 if(resp.get("success").equals(true))
							{
								try {
									out.write(result(true, "The email was successfully sent").toString());
								} catch (Exception ex)
								{
									ex.printStackTrace();
								}
							}
							else
							{
								try {
									out.write(result(true, "We are sorry, but we were unable to send the email address").toString());
								} catch (Exception ex)
								{
									ex.printStackTrace();
								}
							}
		            } catch (Exception ex) {
		            	try {
							out.write(result(false, "Email could not be sent").toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace(out);
						}
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
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
