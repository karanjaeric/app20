package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import com.fundmaster.mss.common.Common;
import com.fundmaster.mss.model.AuditTrail;
import com.fundmaster.mss.model.Beneficiary;
import com.fundmaster.mss.model.BenefitPayment;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.ContactCategory;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.Gender;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.MaritalStatus;
import com.fundmaster.mss.model.Media;
import com.fundmaster.mss.model.Member;
import com.fundmaster.mss.model.MemberPermission;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.Ordinal;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.Permission;
import com.fundmaster.mss.model.Scheme;
import com.fundmaster.mss.model.SchemeMemberManager;
import com.fundmaster.mss.model.SchemeReceipt;
import com.fundmaster.mss.model.Sector;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Sponsor;
import com.fundmaster.mss.model.User;
import com.fundmaster.mss.model.XiMember;
@WebServlet(name = "DashboardController", urlPatterns = {"/dashboard"})
public class DashboardController extends GenericController {

	private static final String PAGE_CONTENT = "PAGE_CONTENT";
	private static final String SCHEME = "SCHEME";
	/**
	 * 
	 */
	String REPO_FOLDER = "dashboard";
	int PER_PAGE = 20;
	int BATCH = 20;
	private static final long serialVersionUID = 1L;

	public DashboardController() {
		// TODO Auto-generated constructor stub
		super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  

    	PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session.getAttribute(Common.LOGIN).equals(true) && (isManagerial(session.getAttribute(Common.U_PROFILE).toString()) || isManager(request)))
		{
			/* Administrative Dashboards */
			if(request.getParameter(REPO_FOLDER).toUpperCase().equals("SETUP".toUpperCase()))
			{
				Company company = getCompany();
				request.setAttribute("company", company);
				Menu menu = getMenu();
				request.setAttribute("menu", menu);
				logActivity("SETUP", "Accessed setup menu and details", session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed setup menu and details");
				request.getRequestDispatcher(REPO_FOLDER + "/setup.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("HELP".toUpperCase()))
			{
				List<Help> helps = getHelp();
				request.setAttribute("helps", helps);
				logActivity("HELP CONTENT", "Accessed help content",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed help content");
				request.getRequestDispatcher(REPO_FOLDER + "/help.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("VIEW_MEMBER".toUpperCase()))
			{
				String memberID = request.getParameter("id");
				Member m = getMemberByID(memberID);
				request.setAttribute("member", m);
				logActivity("PORTAL MEMBERS", "Viewed member details for potential member",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed member details for a potential member");
				request.getRequestDispatcher(REPO_FOLDER + "/VIEW_MEMBER.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).equals("VIEW_SPONSOR"))
			{
				Sponsor sponsor = getSponsor(request.getParameter("id"));
				request.setAttribute("sponsor", sponsor);
				logActivity("PORTAL MEMBERS", "Viewed sponsor details for potential sponsor",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed sponsor details for a potential sponsor");
				request.getRequestDispatcher(REPO_FOLDER + "/VIEW_SPONSOR.jsp").forward(request, response);	
			}
			else if(request.getParameter(REPO_FOLDER).equals("ANALYTICS_REPORT"))
			{
				if(request.getParameter("report").equals("locked_user_accounts"))
				{
					List<User> users = findByStatus(0);
					request.setAttribute("users", users);
					Logger.getAnonymousLogger().info("Dispatching...");
					Permission permissions = getPermissions(request);
					request.setAttribute("permissions", permissions);
					request.getRequestDispatcher(REPO_FOLDER + "/locked_accounts.jsp").forward(request, response);	
				}
				else if(request.getParameter("report").equals("frequent_members"))
				{	
					request.getRequestDispatcher(REPO_FOLDER + "/frequent_members.jsp").forward(request, response);	
				}
				else if(request.getParameter("report").equals("non_frequent_members"))
				{	
					request.getRequestDispatcher(REPO_FOLDER + "/non_frequent_members.jsp").forward(request, response);	
				}
			}
			else if(request.getParameter(REPO_FOLDER).equals("USER_ACCESS_REPORTS"))
			{
				logActivity("USER ACCESS REPORTS", "Accessed user access reports",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed user access reports");
				request.getRequestDispatcher(REPO_FOLDER + "/user_access_reports.jsp").forward(request, response);	
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("CONTACT_REASONS".toUpperCase()))
			{
				List<ContactCategory> contactReasons = getContactReasons();
				request.setAttribute("contactReasons", contactReasons);
				logActivity("CONTACT CATEGORIES", "Viewed email contact categories",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed email contact categories");
				request.getRequestDispatcher(REPO_FOLDER + "/contact_reasons.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals(PAGE_CONTENT.toUpperCase()))
			{
				List<PageContent> contents = getPageContent();
				request.setAttribute("contents", contents);
				logActivity("PAGE CONTENT", "Accessed page content",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed page content");
				request.getRequestDispatcher(REPO_FOLDER + "/page_content.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEMBER_OPERATIONS".toUpperCase()))
			{
				Permission permissions = getPermissions(request);
				request.setAttribute("permissions", permissions);
				logActivity("MEMBER OPERATIONS", "Accessed administrative member operations",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed administrative member operations");
				request.getRequestDispatcher(REPO_FOLDER + "/member_operations.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("SCHEME_MANAGER".toUpperCase()))
			{
				List<SchemeMemberManager> schememanagers = getSchemeManagers();
				request.setAttribute("schememanagers", schememanagers);
				Permission permissions = getPermissions(request);
				request.setAttribute("permissions", permissions);
				logActivity("SCHEME MANAGERS", "Viewed Scheme Managers",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed Scheme Managers");
				request.getRequestDispatcher(REPO_FOLDER + "/scheme_managers.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals(SCHEME.toUpperCase()))
			{
				List<Scheme> schemes = null;
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page").toString());
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search = null;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = null;
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch").toString());
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int count = getAuditCount(search);
				int pages = (count / PER_PAGE);
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				request.setAttribute("begin", begin);
				request.setAttribute("pages", pages);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("search", search);
				try {
					schemes = getSchemes(start, PER_PAGE);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
				request.setAttribute("schemes", schemes);
				logActivity("SCHEMES", "Viewed Schemes",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed Schemes");
				request.getRequestDispatcher(REPO_FOLDER + "/scheme.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEMBER".toUpperCase()))
			{
				List<XiMember> members = null;
				int page = 0;
				int batch;
				String profile = null;
				String identifier = null;
				String search;
				try {
					batch = Integer.parseInt(request.getParameter("batch").toString());
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				try {
					page = Integer.parseInt(request.getParameter("page").toString());
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
					
				}
				try {
					profile = request.getParameter("profile");
					request.setAttribute("profile", profile);
				} catch(Exception ex)
				{
					ex.printStackTrace();
				}
				try {
					identifier = request.getParameter("identifier");
					request.setAttribute("identifier", identifier);
				} catch (Exception ex)
				{
					ex.printStackTrace();
				}
				try {
					search = request.getParameter("search");
					request.setAttribute("search", search);
				} catch (Exception ex)
				{
					search = null;
				}
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				try {
					Logger.getAnonymousLogger().info("identifier: " + identifier + ", profile: " + profile + ", search: " + search);
					if(identifier != null && profile != null && search != "")
						members = searchProfiles(search, identifier, profile, session.getAttribute(Common.SCHEME_ID).toString(), start, PER_PAGE);
					else
						members = getMemberListing(session.getAttribute(Common.PROFILE_ID).toString(), session.getAttribute(Common.U_PROFILE).toString(), session.getAttribute(Common.SCHEME_ID).toString(), start, PER_PAGE);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int count = Common.RECORD_COUNT;
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				int pages = (count / PER_PAGE);
				request.setAttribute("begin", begin);
				request.setAttribute("pages", pages);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("search", search);
				List<Ordinal> ordinals = getOrdinals();
				request.setAttribute("ordinals", ordinals);
				request.setAttribute("members", members);
				Permission permissions = getPermissions(request);
				logActivity("MEMBERS", "Viewed members for scheme #" + session.getAttribute(Common.SCHEME_ID),session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed members for scheme #" + session.getAttribute(Common.SCHEME_ID));
				request.setAttribute("permissions", permissions);
				request.getRequestDispatcher(REPO_FOLDER + "/member.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).equals("RECEIPT"))
			{
				List<SchemeReceipt> receipts = null;
				int page = 0;
				int batch;
				DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
				String date_from_string;
				String date_to_string;
				Date date_from = null;
				Date date_to = null;
				try {
					date_from_string = request.getParameter("from").toString();
					date_from = (Date) format.parse(date_from_string);
					request.setAttribute("dateFrom", request.getParameter("from").toString());
				} catch (Exception e) {
					e.printStackTrace(out);
					date_from = null;
				}
				try {
					date_to_string = request.getParameter("to").toString();
					date_to = (Date) format.parse(date_to_string);
					request.setAttribute("dateTo", request.getParameter("to").toString());
				} catch (Exception e) {

					e.printStackTrace(out);
					date_to = null;
				}
				try {
					batch = Integer.parseInt(request.getParameter("batch").toString());
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				try {
					page = Integer.parseInt(request.getParameter("page").toString());
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
					
				}
				int count = Common.RECORD_COUNT;
				int pages = (count / PER_PAGE);
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				request.setAttribute("begin", begin);
				request.setAttribute("pages", pages);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				DateFormat format_ = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
				try {
					if(date_from != null && date_to != null)
						receipts = searchReceipts(session.getAttribute(Common.SCHEME_ID).toString(), format_.format(date_from), format_.format(date_to), start, PER_PAGE);
					else
						receipts  = getSchemeReceipts(session.getAttribute(Common.SCHEME_ID).toString(), start, PER_PAGE);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("receipts", receipts);
				logActivity("SCHEME RECEIPTS", "Viewed scheme receipts for scheme #" + session.getAttribute(Common.SCHEME_ID),session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session,  "Viewed scheme receipts for scheme #" + session.getAttribute(Common.SCHEME_ID));
				request.getRequestDispatcher(REPO_FOLDER + "/receipts.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("CONTENT"))
			{
				List<Help> helps = getHelp();
				request.setAttribute("helps", helps);
				logActivity("HELP CONTENT", "Accessed help content",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed help content");
				request.getRequestDispatcher(REPO_FOLDER + "/help.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("PAYMENT"))
			{
				List<BenefitPayment> payments = null;
				int page = 0;
				int batch;

				DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
				String date_from_string;
				String date_to_string;
				Date date_from = null;
				Date date_to = null;
				try {
					date_from_string = request.getParameter("from").toString();
					date_from = (Date) format.parse(date_from_string);
					request.setAttribute("dateFrom", request.getParameter("from").toString());
				} catch (Exception e) {
					
					date_from = null;
				}
				try {
					date_to_string = request.getParameter("to").toString();
					date_to = (Date) format.parse(date_to_string);
					request.setAttribute("dateTo", request.getParameter("to").toString());
				} catch (Exception e) {

					date_to = null;
				}
				try {
					batch = Integer.parseInt(request.getParameter("batch").toString());
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				try {
					page = Integer.parseInt(request.getParameter("page").toString());
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
					
				}
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				DateFormat format_ = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
				try {
					if(date_from != null && date_to != null)
						payments  = searchPayments(session.getAttribute(Common.SCHEME_ID).toString(), format_.format(date_from), format_.format(date_to), start, PER_PAGE);
					else
						payments  = getBenefitPayments(session.getAttribute(Common.SCHEME_ID).toString(), start, PER_PAGE);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int count = Common.RECORD_COUNT;
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				int pages = (count / PER_PAGE);
				request.setAttribute("begin", begin);
				request.setAttribute("pages", pages);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("payments", payments);
				logActivity("SCHEME PAYMENTS", "Viewed scheme payments for scheme #" + session.getAttribute(Common.SCHEME_ID),session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed scheme payments for scheme #" + session.getAttribute(Common.SCHEME_ID));
				request.getRequestDispatcher(REPO_FOLDER + "/payments.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEDIA".toUpperCase()))
			{
				List<Media> medias = getMedia(session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).equals(Common.ADMIN_PROFILE));
				request.setAttribute("medias", medias);
				Permission permissions = getPermissions(request);
				request.setAttribute("permissions", permissions);
				logActivity("MEDIA & FILES", "Accessed media & files (documents)",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed media & files (documents)");
				request.getRequestDispatcher(REPO_FOLDER + "/media.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).equals("PORTAL_MEMBER"))
			{
				Permission permissions = getPermissions(request);
				request.setAttribute("permissions", permissions);
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page").toString());
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search = null;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = null;
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch").toString());
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int count = countPortalMembers(search);
				int pages = (count / PER_PAGE);
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				request.setAttribute("begin", begin);
				request.setAttribute("pages", pages);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("search", search);
				String agentId = null;
				if(session.getAttribute(Common.U_PROFILE).equals(Common.AGENT_PROFILE))
					agentId = session.getAttribute(Common.PROFILE_ID).toString();
				List<Member> members = getPortalMembers(agentId, search, start, PER_PAGE);
				request.setAttribute("members", members);
				request.setAttribute("pages", pages);
				List<Country> countries = getCountries();
				request.setAttribute("countries",  countries);
				List<Gender> genders = getGenders();
				request.setAttribute("genders",  genders);
				List<MaritalStatus> marital_statuses = getMaritalStatuses();
				request.setAttribute("maritalStatuses",  marital_statuses);
				List<Scheme> memberSchemes = null;
				try {
					memberSchemes = getSchemeByPlanType("INDIVIDUAL_PENSION_FUND");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("memberSchemes", memberSchemes);
				request.getRequestDispatcher(REPO_FOLDER + "/portal_members.jsp").forward(request, response);	
			}
			else if(request.getParameter(REPO_FOLDER).equals("SPONSOR"))
			{
				Permission permissions = getPermissions(request);
				request.setAttribute("permissions", permissions);
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page").toString());
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search = null;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = null;
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch").toString());
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int count = countSponsors(search);
				int pages = (count / PER_PAGE);
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				request.setAttribute("begin", begin);
				request.setAttribute("pages", pages);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("search", search);
				String agentId = null;
				if(session.getAttribute(Common.U_PROFILE).equals(Common.AGENT_PROFILE))
					agentId = session.getAttribute(Common.PROFILE_ID).toString();
				List<Sponsor> sponsors = getPortalSponsors(agentId, search, start, PER_PAGE);
				request.setAttribute("sponsors", sponsors);
				List<Country> countries = getCountries();
				request.setAttribute("countries",  countries);
				request.setAttribute("pages", pages);
				List<Scheme> sponsorSchemes = null;
				try {
					sponsorSchemes = getSchemeBySchemeModeAndPlanType("UMBRELLA", "INDIVIDUAL_PENSION_FUND");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("sponsorSchemes", sponsorSchemes);
				request.getRequestDispatcher(REPO_FOLDER + "/portal_sponsors.jsp").forward(request, response);	
			}
			else if(request.getParameter(REPO_FOLDER).equals("AUDIT_TRAIL"))
			{
				Permission permissions = getPermissions(request);
				request.setAttribute("permissions", permissions);
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page").toString());
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search = null;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = null;
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch").toString());
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int count = getAuditCount(search);
				int pages = (count / PER_PAGE);
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				request.setAttribute("begin", begin);
				request.setAttribute("pages", pages);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("search", search);
				List<AuditTrail> auditTrails = getAuditTrails(search, start, PER_PAGE);
				request.setAttribute("auditTrails", auditTrails);
				request.setAttribute("pages", pages);
				logActivity("AUDIT TRAIL", "Viewed Audit Trails",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed Audit Trails");
				request.getRequestDispatcher(REPO_FOLDER + "/audit_trail.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("USER"))
			{
				List<User> users;
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page").toString());
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search = null;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = "";
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch").toString());
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int count = countUsers(search);
				int pages = (count / PER_PAGE);
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				request.setAttribute("begin", begin);
				request.setAttribute("pages", pages);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("search", search);
				request.setAttribute("pages", pages);
				users  = getUsers(search, start, PER_PAGE);
				request.setAttribute("users", users);
				Permission permissions = getPermissions(request);
				request.setAttribute("permissions", permissions);
				logActivity("USERS", "Viewed portal users",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed portal users");
				request.getRequestDispatcher(REPO_FOLDER + "/users.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("UAC".toUpperCase()))
			{
				Permission permissions = getPermissions(request);
				request.setAttribute("permissions", permissions);
				logActivity("USER ACCESS CONTROL", "Accessed User Access Control Panel",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed User Access Control Panel");
				request.getRequestDispatcher(REPO_FOLDER + "/uac.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("ANALYTICS".toUpperCase()))
			{
				logActivity("PORTAL ANALYTICS", "Accessed portal analytics & reporting",session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed portal analytics & reporting");
				request.getRequestDispatcher(REPO_FOLDER + "/analytics.jsp").forward(request, response);
			}
		}
		if(session.getAttribute("LOGIN").equals(true) && (session.getAttribute(Common.U_PROFILE).equals(Common.MEMBER_PROFILE) || isManager(request) || isManagerial(session.getAttribute(Common.U_PROFILE).toString())))
		{
			if(request.getParameter(REPO_FOLDER).equals("PI"))
			{
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
				XiMember m = null;
				String member_id;
				try {
					member_id = request.getParameter("memberID").toString();
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Common.PROFILE_ID).toString();
				}
				Logger.getAnonymousLogger().info("Member ID: " + member_id);
				try {
					m = getMemberDetails(member_id);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("member", m);
				List<Beneficiary> beneficiaries = getBeneficiaries(member_id);
				request.setAttribute("beneficiaries", beneficiaries);
				logActivity("MEMBER PERSONAL INFORMATION", "Viewed editable member personal information", session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed  editable  member personal information");
				request.getRequestDispatcher("member/PI.jsp").forward(request, response);			
			}
			else if(request.getParameter(REPO_FOLDER).equals("CH"))
			{
				Company company = getCompany();
				request.setAttribute("company", company);
				Setting settings = getSettings();
				request.setAttribute("settings", settings);
				request.setAttribute("scheme_id", session.getAttribute(Common.SCHEME_ID));
				String member_id;
				try {
					member_id = request.getParameter("memberID").toString();
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Common.PROFILE_ID).toString();
				}
				request.setAttribute("member_id", member_id);
				logActivity("MEMBER CONTRIBUTION HISTORY", "Viewed member contribution history", session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed member contribution history");
				request.getRequestDispatcher("member/CH.jsp").forward(request, response);				
			}
			else if(request.getParameter(REPO_FOLDER).equals("SA"))
			{
				Setting setting = getSettings();
				request.setAttribute("settings", setting);
				request.setAttribute("scheme_id", session.getAttribute(Common.SCHEME_ID));
				String member_id;
				try {
					member_id = request.getParameter("memberID").toString();
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Common.PROFILE_ID).toString();
				}
				request.setAttribute("member_id", member_id);
				logActivity("MEMBER STATEMENT OF ACCOUNT", "Viewed member statement of account", session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed member statement of account");
				request.getRequestDispatcher("member/SA.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("BP"))
			{
				Setting setting = getSettings();
				request.setAttribute("settings", setting);
				request.setAttribute("scheme_id", session.getAttribute(Common.SCHEME_ID));
				request.setAttribute("planType", session.getAttribute(Common.SCHEME_TYPE));
				Logger.getAnonymousLogger().info("PlanType: " + session.getAttribute(Common.SCHEME_TYPE));
				String member_id;
				try {
					member_id = request.getParameter("memberID").toString();
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Common.PROFILE_ID).toString();
				}
				request.setAttribute("member_id", member_id);
				logActivity("MEMBER BENEFITS PROJECTION", "Viewed member benefits projection", session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed member benefits projection");
				request.getRequestDispatcher("member/BP.jsp").forward(request, response);	
			}
			else if(request.getParameter(REPO_FOLDER).equals("MF"))
			{
				List<Media> medias = getMedia(session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).equals(Common.ADMIN_PROFILE));
				request.setAttribute("medias", medias);
				logActivity("MEDIA FILES", "Accessed media & files (documents)", session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed media & files (documents)");
				request.getRequestDispatcher("member/MF.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("WIA"))
			{
				PageContent content = getPageContentByPage(Common.PAGE_WHAT_IF_ANALYSIS);
				request.setAttribute("content", content);
				request.setAttribute("showScript", session.getAttribute(Common.U_PROFILE).equals(Common.MEMBER_PROFILE));
				logActivity("WHAT IF ANALYSIS", "Accessed what if analysis page", session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Accessed what if analysis page");
				request.getRequestDispatcher("what-if-content.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("BH"))
			{
				Setting settings = getSettings();
				request.setAttribute("settings", settings);
				request.setAttribute("scheme_id", session.getAttribute(Common.SCHEME_ID));
				String member_id;
				try {
					member_id = request.getParameter("memberID").toString();
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Common.PROFILE_ID).toString();
				}
				request.setAttribute("member_id", member_id);
				logActivity("MEMBER BALANCES HISTORY", "Viewed member balances history", session.getAttribute(Common.UID).toString(), session.getAttribute(Common.SCHEME_ID).toString(), session.getAttribute(Common.U_PROFILE).toString());
				audit(session, "Viewed member balances history");
				request.getRequestDispatcher("member/BH.jsp").forward(request, response);	
				
			}
		}
	}

}
