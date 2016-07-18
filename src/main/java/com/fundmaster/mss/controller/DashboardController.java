package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.ejbInterface.AuditTrailEJB;
import com.fundmaster.mss.beans.ejbInterface.UserEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.*;
import org.json.JSONException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
@WebServlet(name = "DashboardController", urlPatterns = {"/dashboard"})
public class DashboardController extends HttpServlet implements Serializable {

	private static final String PAGE_CONTENT = "PAGE_CONTENT";
	private static final String SCHEME = "SCHEME";

	private static final String YYYY_MM_DD = "yyyy-MM-dd";
	private static final String DD_MM_YYYY = "dd-MM-yyyy";
	private static final long serialVersionUID = 1L;
    @EJB
    Helper helper;
	@EJB
	AuditTrailEJB auditTrailEJB;
    @EJB
    UserEJB userEJB;
	public DashboardController() {
		// TODO Auto-generated constructor stub
		super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		
    	PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		/*

	 */
		String REPO_FOLDER = "dashboard";
		if(session.getAttribute(Constants.LOGIN).equals(true) && (helper.isManagerial(session.getAttribute(Constants.U_PROFILE).toString()) || helper.isManager(request)))
		{
			/* Administrative Dashboards */
			int BATCH = 20;
			int PER_PAGE = 20;
			if(request.getParameter(REPO_FOLDER).toUpperCase().equals("SETUP".toUpperCase()))
			{
				Company company = helper.getCompany();
				request.setAttribute("company", company);
				InterestRateColumns interest = helper.getInterestRateColumns();
				request.setAttribute("interest", interest);
				Menu menu = helper.getMenu();
				request.setAttribute("menu", menu);
				helper.logActivity("SETUP", "Accessed setup menu and details", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed setup menu and details");
				request.getRequestDispatcher(REPO_FOLDER + "/setup.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("CALC-LOG".toUpperCase()))
			{
				/*Company company = helper.getCompany();
				request.setAttribute("company", company);
				Menu menu = helper.getMenu();
				request.setAttribute("menu", menu);
				helper.logActivity("CALC-LOG", "Accessed calculator log menu and details", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed calculator log menu and details");
				request.getRequestDispatcher(REPO_FOLDER + "/calc-log.jsp").forward(request, response);*/
				List<BenefitCalculation> calclogs = null;
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = null;
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch"));
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				request.setAttribute("begin", begin);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("search", search);
				try {
					calclogs = helper.getCalclogs(start, PER_PAGE);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
				int count = Constants.RECORD_COUNT;
				int pages = (count / PER_PAGE);
				request.setAttribute("pages", pages);
				request.setAttribute("calclogs", calclogs);
				helper.logActivity("CALC-LOG", "Viewed Schemes", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed Schemes");
				request.getRequestDispatcher(REPO_FOLDER + "/calc-log.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("HELP".toUpperCase()))
			{
				List<Help> helps = helper.getHelp();
				request.setAttribute("helps", helps);
				helper.logActivity("HELP CONTENT", "Accessed help content", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed help content");
				request.getRequestDispatcher(REPO_FOLDER + "/help.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("VIEW_POTENTIAL_MEMBER".toUpperCase()))
			{
				String memberID = request.getParameter("id");
				Member m = helper.getMemberByID(memberID);
				request.setAttribute("member", m);
				helper.logActivity("PORTAL MEMBERS", "Viewed member details for potential member", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed member details for a potential member");
				request.getRequestDispatcher(REPO_FOLDER + "/VIEW_POTENTIAL_MEMBER.jsp").forward(request, response);
			}
			
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("VIEW_PORTAL_MEMBER".toUpperCase()))
			{
				String memberID = request.getParameter("id");
				Member m = helper.getMemberByID(memberID);
				request.setAttribute("member", m);
				helper.logActivity("PORTAL MEMBERS", "Viewed member details for potential member", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed member details for a potential member");
				request.getRequestDispatcher(REPO_FOLDER + "/VIEW_PORTAL_MEMBER.jsp").forward(request, response);
			}
			
			else if(request.getParameter(REPO_FOLDER).equals("VIEW_SPONSOR"))
			{
				Sponsor sponsor = helper.getSponsor(request.getParameter("id"));
				request.setAttribute("sponsor", sponsor);
				helper.logActivity("PORTAL MEMBERS", "Viewed sponsor details for potential sponsor", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed sponsor details for a potential sponsor");
				request.getRequestDispatcher(REPO_FOLDER + "/VIEW_SPONSOR.jsp").forward(request, response);	
			}
			else if(request.getParameter(REPO_FOLDER).equals("ANALYTICS_REPORT"))
			{
				if(request.getParameter("report").equals("locked_user_accounts"))
				{
					List<User> users = helper.findByStatus();
					request.setAttribute("users", users);
					Permission permissions = helper.getPermissions(request);
					request.setAttribute("permissions", permissions);
					request.getRequestDispatcher(REPO_FOLDER + "/locked_accounts.jsp").forward(request, response);	
				}
				else if(request.getParameter("report").equals("frequent_users"))
				{	
					SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD, Locale.ENGLISH);
					List<AuditTrail> auditTrails = auditTrailEJB.frequenters(format.format(helper.dateFromString(request.getParameter("from"), DD_MM_YYYY)), format.format(helper.dateFromString(request.getParameter("to"), DD_MM_YYYY)));
					request.setAttribute("users", auditTrails);
					request.getRequestDispatcher(REPO_FOLDER + "/frequent_users.jsp").forward(request, response);	
				}
				else if(request.getParameter("report").equals("non_frequent_users"))
				{	
					SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD, Locale.ENGLISH);
					List<User> users = userEJB.dormants(format.format(helper.dateFromString(request.getParameter("from"), DD_MM_YYYY)), format.format(helper.dateFromString(request.getParameter("to"), DD_MM_YYYY)));
					request.setAttribute("users", users);
					request.getRequestDispatcher(REPO_FOLDER + "/non_frequent_users.jsp").forward(request, response);	
				}
			}
			else if(request.getParameter(REPO_FOLDER).equals("USER_ACCESS_REPORTS"))
			{
				helper.logActivity("USER ACCESS REPORTS", "Accessed user access reports", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed user access reports");
				request.getRequestDispatcher(REPO_FOLDER + "/user_access_reports.jsp").forward(request, response);	
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("CONTACT_REASONS".toUpperCase()))
			{
				List<ContactCategory> contactReasons = helper.getContactReasons();
				request.setAttribute("contactReasons", contactReasons);
				helper.logActivity("CONTACT CATEGORIES", "Viewed email contact categories", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed email contact categories");
				request.getRequestDispatcher(REPO_FOLDER + "/contact_reasons.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals(PAGE_CONTENT.toUpperCase()))
			{
				List<PageContent> contents = helper.getPageContent();
				request.setAttribute("contents", contents);
				helper.logActivity("PAGE CONTENT", "Accessed page content", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed page content");
				request.getRequestDispatcher(REPO_FOLDER + "/page_content.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEMBER_OPERATIONS".toUpperCase()))
			{
				Permission permissions = helper.getPermissions(request);
				request.setAttribute("permissions", permissions);
				helper.logActivity("MEMBER OPERATIONS", "Accessed administrative member operations", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed administrative member operations");
				request.getRequestDispatcher(REPO_FOLDER + "/member_operations.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("SCHEME_MANAGER".toUpperCase()))
			{
				List<SchemeMemberManager> schememanagers = helper.getSchemeManagers();
				request.setAttribute("schememanagers", schememanagers);
				Permission permissions = helper.getPermissions(request);
				request.setAttribute("permissions", permissions);
				helper.logActivity("SCHEME MANAGERS", "Viewed Scheme Managers", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed Scheme Managers");
				request.getRequestDispatcher(REPO_FOLDER + "/scheme_managers.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals(SCHEME.toUpperCase()))
			{
				List<Scheme> schemes = null;
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = null;
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch"));
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				int begin = ((batch * BATCH) - BATCH) + 1;
				if(begin < 1)
					begin = 1;
				request.setAttribute("begin", begin);
				request.setAttribute("batch", batch);
				request.setAttribute("page", page);
				request.setAttribute("per_page", PER_PAGE);
				request.setAttribute("search", search);
				try {
					schemes = helper.getSchemes(start, PER_PAGE);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(out);
				}
				int count = Constants.RECORD_COUNT;
				int pages = (count / PER_PAGE);
				request.setAttribute("pages", pages);
				request.setAttribute("schemes", schemes);
				helper.logActivity("SCHEMES", "Viewed Schemes", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed Schemes");
				request.getRequestDispatcher(REPO_FOLDER + "/scheme.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEMBER".toUpperCase()))
			{
				List<XiMember> members = null;
				int page;
				int batch;
				String profile = null;
				String identifier = null;
				String search;
				try {
					batch = Integer.parseInt(request.getParameter("batch"));
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				try {
					page = Integer.parseInt(request.getParameter("page"));
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
					if(identifier != null && profile != null && !Objects.equals(search, ""))
						members = helper.searchProfiles(search, identifier, profile, session.getAttribute(Constants.SCHEME_ID).toString(), start, PER_PAGE);
					else
						members = helper.getMemberListing(session.getAttribute(Constants.PROFILE_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), start, PER_PAGE);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int count = Constants.RECORD_COUNT;
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
				List<Ordinal> ordinals = helper.getOrdinals();
				request.setAttribute("ordinals", ordinals);
				request.setAttribute("members", members);
				Permission permissions = helper.getPermissions(request);
				helper.logActivity("MEMBERS", "Viewed members for scheme #" + session.getAttribute(Constants.SCHEME_ID), session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed members for scheme #" + session.getAttribute(Constants.SCHEME_ID));
				request.setAttribute("permissions", permissions);
				request.getRequestDispatcher(REPO_FOLDER + "/member.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).equals("RECEIPT"))
			{
				List<SchemeReceipt> receipts = null;
				int page;
				int batch;
				DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
				String date_from_string;
				String date_to_string;
				Date date_from;
				Date date_to;
				try {
					date_from_string = request.getParameter("from");
					date_from = format.parse(date_from_string);
					request.setAttribute("dateFrom", request.getParameter("from"));
				} catch (Exception e) {
					e.printStackTrace(out);
					date_from = null;
				}
				try {
					date_to_string = request.getParameter("to");
					date_to = format.parse(date_to_string);
					request.setAttribute("dateTo", request.getParameter("to"));
				} catch (Exception e) {

					e.printStackTrace(out);
					date_to = null;
				}
				try {
					batch = Integer.parseInt(request.getParameter("batch"));
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
					
				}
				int count = Constants.RECORD_COUNT;
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
						receipts = helper.searchReceipts(session.getAttribute(Constants.SCHEME_ID).toString(), format_.format(date_from), format_.format(date_to), start, PER_PAGE);
					else
						receipts  = helper.getSchemeReceipts(session.getAttribute(Constants.SCHEME_ID).toString(), start, PER_PAGE);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("receipts", receipts);
				helper.logActivity("SCHEME RECEIPTS", "Viewed scheme receipts for scheme #" + session.getAttribute(Constants.SCHEME_ID), session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed scheme receipts for scheme #" + session.getAttribute(Constants.SCHEME_ID));
				request.getRequestDispatcher(REPO_FOLDER + "/receipts.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("CONTENT"))
			{
				List<Help> helps = helper.getHelp();
				request.setAttribute("helps", helps);
				helper.logActivity("HELP CONTENT", "Accessed help content", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed help content");
				request.getRequestDispatcher(REPO_FOLDER + "/help.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("PAYMENT"))
			{
				List<BenefitPayment> payments = null;
				int page;
				int batch;

				DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
				String date_from_string;
				String date_to_string;
				Date date_from;
				Date date_to;
				try {
					date_from_string = request.getParameter("from");
					date_from = format.parse(date_from_string);
					request.setAttribute("dateFrom", request.getParameter("from"));
				} catch (Exception e) {
					
					date_from = null;
				}
				try {
					date_to_string = request.getParameter("to");
					date_to = format.parse(date_to_string);
					request.setAttribute("dateTo", request.getParameter("to"));
				} catch (Exception e) {

					date_to = null;
				}
				try {
					batch = Integer.parseInt(request.getParameter("batch"));
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
					
				}
				int start = (PER_PAGE * (page - 1)) * (batch - 1);
				DateFormat format_ = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
				try {
					if(date_from != null && date_to != null)
						payments  = helper.searchPayments(session.getAttribute(Constants.SCHEME_ID).toString(), format_.format(date_from), format_.format(date_to), start, PER_PAGE);
					else
						payments  = helper.getBenefitPayments(session.getAttribute(Constants.SCHEME_ID).toString(), start, PER_PAGE);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int count = Constants.RECORD_COUNT;
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
				helper.logActivity("SCHEME PAYMENTS", "Viewed scheme payments for scheme #" + session.getAttribute(Constants.SCHEME_ID), session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed scheme payments for scheme #" + session.getAttribute(Constants.SCHEME_ID));
				request.getRequestDispatcher(REPO_FOLDER + "/payments.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEDIA".toUpperCase()))
			{
				List<Media> medias = helper.getMedia(session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString(), session.getAttribute(Constants.PROFILE_ID).toString());
				request.setAttribute("medias", medias);
				Permission permissions = helper.getPermissions(request);
				request.setAttribute("permissions", permissions);
				helper.logActivity("MEDIA & FILES", "Accessed media & files (documents)", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed media & files (documents)");
				request.getRequestDispatcher(REPO_FOLDER + "/media.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).equals("PORTAL_MEMBER"))
			{
				Permission permissions = helper.getPermissions(request);
				request.setAttribute("permissions", permissions);
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = null;
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch"));
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int count = helper.countPortalMembers(search);
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
				if(session.getAttribute(Constants.U_PROFILE).equals(Constants.AGENT_PROFILE))
					agentId = session.getAttribute(Constants.PROFILE_ID).toString();
				List<Member> members = helper.getPortalMembers(agentId, search, start, PER_PAGE);
				request.setAttribute("members", members);
				request.setAttribute("pages", pages);
				List<Country> countries = helper.getCountries();
				request.setAttribute("countries",  countries);
				List<Gender> genders = helper.getGenders();
				request.setAttribute("genders",  genders);
				List<MaritalStatus> marital_statuses = helper.getMaritalStatuses();
				request.setAttribute("maritalStatuses",  marital_statuses);
				List<Scheme> memberSchemes = null;
				try {
					memberSchemes = helper.getSchemeByPlanType("INDIVIDUAL_PENSION_FUND");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("memberSchemes", memberSchemes);
				request.getRequestDispatcher(REPO_FOLDER + "/portal_members.jsp").forward(request, response);	
			}
			else if(request.getParameter(REPO_FOLDER).equals("SPONSOR"))
			{
				Permission permissions = helper.getPermissions(request);
				request.setAttribute("permissions", permissions);
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = null;
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch"));
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int count = helper.countSponsors(search);
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
				if(session.getAttribute(Constants.U_PROFILE).equals(Constants.AGENT_PROFILE))
					agentId = session.getAttribute(Constants.PROFILE_ID).toString();
				List<Sponsor> sponsors = helper.getPortalSponsors(agentId, search, start, PER_PAGE);
				request.setAttribute("sponsors", sponsors);
				
				List<Sector> sectors = helper.getSectors();
				request.setAttribute("sectors", sectors);
				
				List<Country> countries = helper.getCountries();
				request.setAttribute("countries",  countries);
				request.setAttribute("pages", pages);
				List<Scheme> sponsorSchemes = null;
				try {
					sponsorSchemes = helper.getSchemeBySchemeModeAndPlanType("UMBRELLA", "INDIVIDUAL_PENSION_FUND");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("sponsorSchemes", sponsorSchemes);
				request.getRequestDispatcher(REPO_FOLDER + "/portal_sponsors.jsp").forward(request, response);	
			}
			else if(request.getParameter(REPO_FOLDER).equals("AUDIT_TRAIL"))
			{
				Permission permissions = helper.getPermissions(request);
				request.setAttribute("permissions", permissions);
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = null;
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch"));
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int count = helper.getAuditCount(search);
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
				List<AuditTrail> auditTrails = helper.getAuditTrails(search, start, PER_PAGE);
				request.setAttribute("auditTrails", auditTrails);
				request.setAttribute("pages", pages);
				helper.logActivity("AUDIT TRAIL", "Viewed Audit Trails", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed Audit Trails");
				request.getRequestDispatcher(REPO_FOLDER + "/audit_trail.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("USER"))
			{
				List<User> users;
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception ex)
				{
					ex.printStackTrace(out);
					page = 1;
				}
				String search;
				try {
					search = request.getParameter("search");
				} catch (Exception ex)
				{
					search = "";
				}
				int batch;
				try {
					batch = Integer.parseInt(request.getParameter("batch"));
				}
				catch (Exception ex)
				{
					batch = 1;
				}
				int count = helper.countUsers(search);
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
				users  = helper.getUsers(search, start, PER_PAGE);
				request.setAttribute("users", users);
				Permission permissions = helper.getPermissions(request);
				request.setAttribute("permissions", permissions);
				helper.logActivity("USERS", "Viewed portal users", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed portal users");
				request.getRequestDispatcher(REPO_FOLDER + "/users.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("UAC".toUpperCase()))
			{
				Permission permissions = helper.getPermissions(request);
				request.setAttribute("permissions", permissions);
				helper.logActivity("USER ACCESS CONTROL", "Accessed User Access Control Panel", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed User Access Control Panel");
				request.getRequestDispatcher(REPO_FOLDER + "/uac.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("ANALYTICS".toUpperCase()))
			{
				helper.logActivity("PORTAL ANALYTICS", "Accessed portal analytics & reporting", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed portal analytics & reporting");
				request.getRequestDispatcher(REPO_FOLDER + "/analytics.jsp").forward(request, response);
			}
		}
		if(session.getAttribute("LOGIN").equals(true) && (session.getAttribute(Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE) || helper.isManager(request) || helper.isManagerial(session.getAttribute(Constants.U_PROFILE).toString())))
		{
			if(request.getParameter(REPO_FOLDER).equals("PI"))
			{
				
				//System.out.println("request.getParameter  "+request.getParameter("memberID") +" Alt: "+ session.getAttribute(Constants.PROFILE_ID));
				List<Country> countries = helper.getCountries();
				request.setAttribute("countries",  countries);
				List<Gender> genders = helper.getGenders();
				request.setAttribute("genders",  genders);
				List<MaritalStatus> marital_statuses = helper.getMaritalStatuses();
				request.setAttribute("maritalStatuses",  marital_statuses);
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
					e.printStackTrace();
				}
				request.setAttribute("schemes", schemes);
				MemberPermission memberPermission = helper.getMemberPermissions();
				request.setAttribute("memberPermission", memberPermission);
				XiMember m = null;
				String member_id;
				try {
					member_id = request.getParameter("memberID");
					if(member_id==null)
					{
						member_id=session.getAttribute(Constants.PROFILE_ID).toString();
					}
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Constants.PROFILE_ID).toString();
				}
				try {
					m = helper.getMemberDetails(member_id,null);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("member", m);
				List<Beneficiary> beneficiaries = helper.getBeneficiaries(member_id);
				request.setAttribute("beneficiaries", beneficiaries);
				helper.logActivity("MEMBER PERSONAL INFORMATION", "Viewed editable member personal information", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed  editable  member personal information");
				request.getRequestDispatcher("member/personal_information.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).equals("CH"))
			{
				Company company = helper.getCompany();
				request.setAttribute("company", company);
				Setting settings = helper.getSettings();
				request.setAttribute("settings", settings);
				request.setAttribute("scheme_id", session.getAttribute(Constants.SCHEME_ID));
				String member_id;
				try {
					member_id = request.getParameter("memberID");
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Constants.PROFILE_ID).toString();
				}
				request.setAttribute("member_id", member_id);
				helper.logActivity("MEMBER CONTRIBUTION HISTORY", "Viewed member contribution history", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed member contribution history");
				request.getRequestDispatcher("member/contribution_history.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).equals("SA"))
			{
				Setting setting = helper.getSettings();
				request.setAttribute("settings", setting);
				request.setAttribute("scheme_id", session.getAttribute(Constants.SCHEME_ID));
				String member_id;
				try {
					member_id = request.getParameter("memberID");
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Constants.PROFILE_ID).toString();
				}
				request.setAttribute("member_id", member_id);
				helper.logActivity("MEMBER STATEMENT OF ACCOUNT", "Viewed member statement of account", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed member statement of account");
				request.getRequestDispatcher("member/statement_of_account.jsp").forward(request, response);
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("BP"))
			{
				Setting setting = helper.getSettings();
				request.setAttribute("settings", setting);
				request.setAttribute("scheme_id", session.getAttribute(Constants.SCHEME_ID));
				request.setAttribute("planType", session.getAttribute(Constants.SCHEME_TYPE));
				String member_id;
				try {
					member_id = request.getParameter("memberID");
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Constants.PROFILE_ID).toString();
				}
				request.setAttribute("member_id", member_id);
				helper.logActivity("MEMBER BENEFITS PROJECTION", "Viewed member benefits projection", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed member benefits projection");
				request.getRequestDispatcher("member/benefits_projection.jsp").forward(request, response);
			}
			else if(request.getParameter(REPO_FOLDER).equals("MF"))
			{
				List<Media> medias = helper.getMedia(session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString(), session.getAttribute(Constants.PROFILE_ID).toString());
				request.setAttribute("medias", medias);
				helper.logActivity("MEDIA FILES", "Accessed media & files (documents)", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed media & files (documents)");
				request.getRequestDispatcher("member/media_files.jsp").forward(request, response);
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("WIA"))
			{
				PageContent content = helper.getPageContentByPage(Constants.PAGE_WHAT_IF_ANALYSIS);
				request.setAttribute("content", content);
				request.setAttribute("showScript", session.getAttribute(Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE));
				helper.logActivity("WHAT IF ANALYSIS", "Accessed what if analysis page", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Accessed what if analysis page");
				request.getRequestDispatcher("what-if-content.jsp").forward(request, response);	
				
			}
			else if(request.getParameter(REPO_FOLDER).equals("BH"))
			{
				Setting settings = helper.getSettings();
				request.setAttribute("settings", settings);
				request.setAttribute("scheme_id", session.getAttribute(Constants.SCHEME_ID));
				String member_id;
				try {
					member_id = request.getParameter("memberID");
				}
				catch (Exception ex)
				{
					member_id = session.getAttribute(Constants.PROFILE_ID).toString();
				}
				request.setAttribute("member_id", member_id);
				helper.logActivity("MEMBER BALANCES HISTORY", "Viewed member balances history", session.getAttribute(Constants.UID).toString(), session.getAttribute(Constants.SCHEME_ID).toString(), session.getAttribute(Constants.U_PROFILE).toString());
				helper.audit(session, "Viewed member balances history");
				request.getRequestDispatcher("member/balance_history.jsp").forward(request, response);
				
			}
		}
	}

}
