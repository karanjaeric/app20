package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Actions;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.dto.BalanceHistoryDTO;
import com.fundmaster.mss.dto.ContributionHistorySummary;
import com.fundmaster.mss.dto.ContributionsHistoryDTO;
import com.fundmaster.mss.dto.CumulativeMemberStatement;
import com.fundmaster.mss.model.*;
import com.fundmaster.mss.util.MssUtil;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "Dashboard", urlPatterns = {"/dashboard"})
public class Dashboard extends BaseServlet implements Serializable {

    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String DD_MM_YYYY = "dd-MM-yyyy";
    private static final long serialVersionUID = 1L;

    Helper helper = new Helper();
    JLogger jLogger = new JLogger(this.getClass());

    @EJB
    AuditTrailBeanI auditTrailBeanI;
    @EJB
    UserBeanI userBeanI;
    @EJB
    ApiEJB apiEJB;
    @EJB
    ClientSetupI clientSetupI;
    @EJB
    DBMenuBeanI dbMenuBeanI;

    @EJB
    InterestRateColumnBeanI interestRateColumnBeanI;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        HttpSession session = request.getSession(false);

        String REPO_FOLDER = "dashboard";
        String action = this.get(request, REPO_FOLDER);
        if (session.getAttribute(Constants.LOGIN).equals(true) && (helper.isManagerial(this.getSessKey(request, Constants.U_PROFILE)) || helper.isManager(request))) {
            /* Administrative Dashboards */
            int BATCH = 20;
            int PER_PAGE = 20;
            switch (action) {
                case Actions.DASHBOARD_SETUP:
                    showSetup(request, response, session, REPO_FOLDER);
                    break;
                case Actions.DASHBOARD_CALC_LOGS:
                    showCalcLogs(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.DASHBOARD_HELP:
                    showHelp(request, response, session, REPO_FOLDER);
                    break;
                case Actions.DASHBOARD_VIEW_POTENTIAL_MEMBER:
                    showPotentialMembers(request, response, session, REPO_FOLDER);
                    break;
                case Actions.DASHBOARD_VIEW_PORTAL_MEMBER:
                    showPortalMemberView(request, response, session, REPO_FOLDER);
                    break;
                case Actions.DASHBOARD_VIEW_SPONSOR:
                    showSponsorView(request, response, session, REPO_FOLDER);
                    break;
                case Actions.DASHBOARD_ANALYTICS_REPORT:
                    showAnalyticsReport(request, response, REPO_FOLDER);
                    break;
                case Actions.DASHBOARD_USER_ACCESS_REPORTS:
                    showUserAccessReports(request, response, session, REPO_FOLDER);
                    break;
                case Actions.CONTACT_REASONS:
                    showContactReasons(request, response, session, REPO_FOLDER);
                    break;
                case Actions.PAGE_CONTENT:
                    showPageContent(request, response, session, REPO_FOLDER);
                    break;
                case Actions.FAQ_CONTENT:
                    showFaqContent(request, response, session, REPO_FOLDER);
                    break;
                case Actions.MEMBER_OPERATIONS:
                    showMemberOperations(request, response, session, REPO_FOLDER);
                    break;
                case Actions.MEMBER_LISTING:
                    showMemberListing(request, response, session, REPO_FOLDER);
                    break;
                case Actions.SPONSOR_BENEFIT_PAYMENT:
                    showSponsorBenefitPayments(request, response, session, REPO_FOLDER);
                    break;
                case Actions.CORPORATE_STATEMENT:
                    showCorporateStatement(request, response, session, REPO_FOLDER);
                    break;
                case Actions.SCHEME_MANAGER:
                    showSchemeManagers(request, response, session, REPO_FOLDER);
                    break;
                case Actions.SCHEME:
                    showSchemes(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.MEMBER:
                    showMembers(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.RECEIPT:
                    showReceipts(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);

                    break;
                case Actions.CONTENT:
                    showPageContent(request, response, session, REPO_FOLDER);
                    break;
                case Actions.PAYMENT:
                    showPayments(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.MEMBERPAYMENT:
                    showMemberPayments(request, response, session);
                    break;
                case Actions.MEDIA:
                    showMedia(request, response, session, REPO_FOLDER);
                    break;
                case Actions.PORTAL_MEMBER:
                    showPortalMembers(request, response, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.SPONSOR:
                    showSponsors(request, response, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.AUDIT_TRAIL:
                    showAuditTrails(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.USER:
                    showUsers(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.UAC:
                    showUserAccessControls(request, response, session, REPO_FOLDER);
                    break;
                case Actions.ANALYTICS:
                    showAnalytics(request, response, session, REPO_FOLDER);
                    break;
                case Actions.COMMISSIONS:
                    showAgentCommissions(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);
                    break;

                case Actions.CLIENTS:
                    showAgentClients(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.WITHDRAWAL_STATEMENT:
                    showWithdrawalStatements(request, response, session, REPO_FOLDER);
                    break;
                case Actions.WITHDRAWAL_SETTLEMENTS:
                    showWithdrawalSettlements(request, response, session, REPO_FOLDER);
                    break;
                case Actions.MEMBER_MOVEMENT:
                    showMemberMovements(request, response, session, REPO_FOLDER);
                    break;
                case Actions.FUND_MOVEMENT:
                    showFundMovement(request, response, session, REPO_FOLDER);
                    break;
                case Actions.PENDING_CONTRIBUTION:
                    showPendingContributions(request, response, session, REPO_FOLDER);
                    break;
                case Actions.RECEIPT_SUMMARY:
                    showReceiptSummary(request, response, session, REPO_FOLDER);
                    break;
                case Actions.ADMIN_FEE_LISTING:
                    showAdminFeeListing(request, response, session, REPO_FOLDER);
                    break;

            }
        }
        if (session.getAttribute("LOGIN").equals(true) && (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE)
                || helper.isManager(request) || helper.isManagerial(this.getSessKey(request, Constants.U_PROFILE)))) {
            int BATCH = 20;
            int PER_PAGE = 20;
            switch (action) {
                case Actions.MEMBER_PERSONAL_INFORMATION:
                    showMemberPersonalInformation(request, response, session);
                    break;
                case Actions.MEMBER_CONTRIBUTION_HISTORY:
                    showMemberContributionHistory(request, response, session);
                    break;
                case Actions.MEMBER_CONTRIBUTION_HISTORY_GRID:
                    showMemberContributionHistoryGrid(request, response, session, REPO_FOLDER, BATCH, PER_PAGE);
                    break;
                case Actions.MEMBER_STATEMENT_OF_ACCOUNT:
                    showMemberStatementOfAccount(request, response, session);
                    break;
                case Actions.MEMBER_STATEMENT_OF_ACCOUNT_GRID:
                    showMemberStatementOfAccountGrid(request, response, session);
                    break;
                case Actions.MEMBER_UNITIZED_STATEMENT:
                    showMemberUnitizedStatement(request, response, session);
                    break;

                case Actions.MEMBERSHIP_CERTIFICATE:
                    showMemberCertificate(request, response, session);
                    break;
                case Actions.MEMBER_BENEFIT_PROJECTIONS:
                    showMemberBenefitProjections(request, response, session);
                    break;
                case Actions.ANNUAL_CONTRIBUTION_STATEMENT:
                    showAnnualContributionStatement(request, response, session);
                    break;
                case Actions.PROVISIONAL_MEMBER_STATEMENT:
                    showProvisionalMemberStatement(request, response, session);
                    break;
                case Actions.MEMBER_BENEFIT_PROJECTIONS_GRID:
                    showMemberBenefitProjectionsGrid(request, response, session);
                    break;
                case Actions.ANNUAL_CONTRIBUTIONS_GRID:
                    showAnnualContributionsGrid(request, response, session);
                    break;
                case Actions.MEMBER_MEDIA_FILES:
                    showMemberMedia(request, response, session);
                    break;
                case Actions.DOCUMENTS:
                    showMemberDocument(request, response, session);
                    break;
                case Actions.MEMBER_CLAIMS:
                    showMemberClaims(request, response, session);
                    break;
                case Actions.MEMBER_WHAT_IF_ANALYSIS:
                    showWhatIfAnalysis(request, response, session);

                    break;
                case Actions.CALCULATE_BENEFIT_PROJECTION:
                    showBenefitProjectionPage(request, response, session);

                    break;
                case Actions.MEMBER_CUMULATIVE_STATEMENT_GRID:
            {
                try {
                    showCumulativeStatement(request, response, session);
                } catch (JSONException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                    break;

                case Actions.SPONSOR_BENEFIT_PROJECTION:
                    showSponsorBenefitProjectionPage(request, response, session);

                    break;

                case Actions.MEMBER_BALANCE_HISTORY:
                    showMemberBalanceHistory(request, response, session);
                    break;
                case Actions.MEMBER_BALANCE_HISTORY_GRID:
                    showMemberBalanceHistoryGrid(request, response, session);
                    break;
                case Actions.MEMBER_BALANCE_HISTORY_GRID1:
                    showMemberBalanceHistoryGrid1(request, response, session);
                    break;

            }
        }
        if (session.getAttribute("LOGIN").equals(true) && (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.PENSIONER)
                || helper.isManager(request) || helper.isManagerial(this.getSessKey(request, Constants.U_PROFILE)))) {

            jLogger.i("Good, we here!!");

            switch (action) {
                case Actions.PENSIONER_PERSONAL_INFORMATION:
                    showPensionerInformation(request, response, session);
                    break;
                case Actions.PENSION_DETAILS:
                    showPensionDetails(request, response, session);
                    break;
                case Actions.PENSION_ADVICE:
                    showPensionAdvice(request, response, session);
                    break;
                case Actions.PENSION_ADVICE_GRID:
                    showPensionAdviceGrid(request, response, session);
                    break;
            }
        }
    }

    private void showAgentCommissions(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {

        int page;
        int batch;

        try {
            batch = Integer.parseInt(this.get(request, "batch"));
        } catch (NumberFormatException nfe) {
            batch = 1;
        }
        try {
            page = Integer.parseInt(this.get(request, "page"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            page = 1;
        }

        int count = Constants.RECORD_COUNT;
        int pages = (count / PER_PAGE);
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        request.setAttribute("begin", begin);
        request.setAttribute("pages", pages);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);

        String agent_id;
        agent_id = this.get(request, "memberID");

        if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.AGENT_PROFILE)) {
            agent_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("agent_id", agent_id);

        List<AgentCommission> agentCommissions = new ArrayList<>();

        try {
            agentCommissions = apiEJB.getAgentCommissions(agent_id, start, PER_PAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jLogger.i("Agent commissions returned >>>>>>>>>>>>>> " + agentCommissions + " <<<<<<<<<<<<<<<<");

        request.setAttribute("commissions", agentCommissions);
        request.setAttribute("pages", pages);
        logActivity("AGENT COMMISSIONS", "Viewed agents commissions", this.getSessKey(request, Constants.UID),
                this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed agents commissions");
        request.getRequestDispatcher(REPO_FOLDER + "/agent_commissions.jsp").forward(request, response);
    }

    private void showWithdrawalStatements(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("sponsor_id", this.getSessKey(request, Constants.PROFILE_ID));

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("WITHDRAWAL STATEMENT", "Viewed withdrawal statement", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed withdrawal statement");
        request.getRequestDispatcher(REPO_FOLDER + "/withdrawal_statements.jsp").forward(request, response);
    }

    private void showWithdrawalSettlements(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("sponsor_id", this.getSessKey(request, Constants.PROFILE_ID));

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        jLogger.i("The schemeId passed: >>>>>>>> " + this.getSessKey(request, Constants.SCHEME_ID));
        logActivity("WITHDRAWAL SETTLEMENTS", "Viewed withdrawal settlements", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed withdrawal settlements");
        request.getRequestDispatcher(REPO_FOLDER + "/withdrawal_settlements.jsp").forward(request, response);
    }

    private void showMemberMovements(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);

        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("sponsor_id", this.getSessKey(request, Constants.PROFILE_ID));

        //request.setAttribute("profile", this.getSessKey(request, Constants.U_PROFILE));
        String profile = this.getSessKey(request, Constants.U_PROFILE);
        jLogger.i("The User profile: " + profile);

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        jLogger.i("The sponsor_id passed: " + this.getSessKey(request, Constants.PROFILE_ID));

        logActivity("MEMBER MOVEMENT", "Viewed member movement", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member movement");

        if (profile.equalsIgnoreCase("SPONSOR")) {
            jLogger.i("============ Great, profile is indeed sponsor ====================");
            request.getRequestDispatcher(REPO_FOLDER + "/sponsor_member_movement.jsp").forward(request, response);

        } else {
            jLogger.i("============ Great, profile isn't sponsor ====================");
            request.getRequestDispatcher(REPO_FOLDER + "/member_movement.jsp").forward(request, response);
        }

    }

    private void showFundMovement(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("sponsor_id", this.getSessKey(request, Constants.PROFILE_ID));

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("FUND MOVEMENT", "Viewed fund movement", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed fund movement");
        request.getRequestDispatcher(REPO_FOLDER + "/fund_movement.jsp").forward(request, response);
    }

    private void showPendingContributions(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("sponsor_id", this.getSessKey(request, Constants.PROFILE_ID));

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("PENDING_CONTRIBUTION", "Viewed pending  contributions", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed pending contributions");
        request.getRequestDispatcher(REPO_FOLDER + "/pending_contribution.jsp").forward(request, response);
    }

    private void showReceiptSummary(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("sponsor_id", this.getSessKey(request, Constants.PROFILE_ID));

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("RECEIPT SUMMARY", "Viewed receipt summary", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed receipt summary");
        request.getRequestDispatcher(REPO_FOLDER + "/receipt_summary.jsp").forward(request, response);
    }

    private void showAdminFeeListing(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("ADMIN FEE LISTING", "Viewed admin fee listing", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed admin fee listing");
        request.getRequestDispatcher(REPO_FOLDER + "/admin_fee_listing.jsp").forward(request, response);
    }

    private void showMemberListing(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));

        String userName = this.getSessKey(request, Constants.USER);
        jLogger.i("Username is ===============> " + userName);

        User usr = userBeanI.findByUsername(userName);
        String userProfile = usr.getUserProfile();
        XiMember mbr = apiEJB.memberExists(userProfile, userName);
        String memberName = mbr.getName();
        request.setAttribute("memberName", memberName);
        String sponsorId = null;
        if (usr.getUserProfile().equals("SPONSOR")) {
            sponsorId = String.valueOf(apiEJB.getSchemeSponsorId(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID)));
            jLogger.i("Sponsor Id =============== > " + sponsorId);
            request.setAttribute("sponsorId", sponsorId);

            ReportDetails reportDetails;
            reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
            request.setAttribute("report_details", reportDetails);

            logActivity("MEMBER LISTING", "Viewed member listing per sponsor", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
            this.audit(session, "Viewed member listing per sponsor");
            request.getRequestDispatcher(REPO_FOLDER + "/member_listing_per_sponsor.jsp").forward(request, response);
        } else {

            logActivity("MEMBER LISTING", "Viewed member listing", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
            this.audit(session, "Viewed member listing ");
            request.getRequestDispatcher(REPO_FOLDER + "/member_listing.jsp").forward(request, response);

        }

    }

    private void showSponsorBenefitPayments(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);

        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        String schemeId = this.getSessKey(request, Constants.SCHEME_ID);
        jLogger.i("Scheme ID: " + schemeId);
        Long spId = apiEJB.getSchemeSponsorId(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID));
        String sponsorId = String.valueOf(spId);
        jLogger.i("Sponsor ID: " + sponsorId);
        request.setAttribute("sponsorId", sponsorId);

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("SPONSOR_BENEFIT_PAYMENT LISTING", "Viewed sponsor BenefitPayments listing", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member listing");
        request.getRequestDispatcher(REPO_FOLDER + "/sponsorBenefitPayments.jsp").forward(request, response);
    }

    private void showCorporateStatement(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        String schemeId = this.getSessKey(request, Constants.SCHEME_ID);
        jLogger.i("Scheme ID: " + schemeId);
        String sponsorId = String.valueOf(apiEJB.getSchemeSponsorId(this.getSessKey(request,
                Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID)));
        jLogger.i("Sponsor ID: " + sponsorId);
        request.setAttribute("sponsorId", sponsorId);

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("CORPORATE STATEMENT", "Viewed corporate statement", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed corporate statement");
        request.getRequestDispatcher(REPO_FOLDER + "/corporate-statement.jsp").forward(request, response);
    }

    private void showWhatIfAnalysis(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        String schemeId = "";
        schemeId = this.getSessKey(request, Constants.SCHEME_ID);
        jLogger.i("============ Member Scheme ID is: " + schemeId + " ===================");
        String planType = apiEJB.getSchemeType(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("scheme_id", schemeId);

        String member_id = this.getSessKey(request, Constants.PROFILE_ID);
        request.setAttribute("member_id", member_id);
        String schemeType = Constants.SCHEME_TYPE;
        request.setAttribute("scheme_type", schemeType);
        jLogger.i("============ Member Scheme type is: " + planType + " ===================");

        PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_WHAT_IF_ANALYSIS);
        request.setAttribute("content", content);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("showScript", this.getSessKey(request, Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE));
        logActivity("WHAT IF ANALYSIS", "Accessed what if analysis page", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed what if analysis page");
        if (planType.equalsIgnoreCase("Defined Benefit")) {
            request.getRequestDispatcher("dbprojection.jsp").forward(request, response);
            return;
        } else {
            request.getRequestDispatcher("what-if-content.jsp").forward(request, response);
        }

    }

    private void showBenefitProjectionPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_BENEFIT_PROJECTION);
        request.setAttribute("content", content);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
//    request.setAttribute("showScript", this.getSessKey(request, Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE));
        logActivity("BENEFIT PROJECTION", "Accessed benefit projection calculator page", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed benefit projection calculator page");
        request.getRequestDispatcher("member/benefit-projection-content.jsp").forward(request, response);
    }
//showSponsorBenefitProjectionPage

    private void showSponsorBenefitProjectionPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_BENEFIT_PROJECTION);
        request.setAttribute("content", content);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
//    request.setAttribute("showScript", this.getSessKey(request, Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE));
        logActivity("SPONSOR BENEFIT PROJECTION", "Accessed benefit projection calculator page", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed benefit projection calculator page as Sponsor");
        request.getRequestDispatcher("sponsor/benefit-projection-content.jsp").forward(request, response);
    }

    private void showMemberBalanceHistory(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        String member_id;

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);
        logActivity("MEMBER BALANCES HISTORY", "Viewed member balances history", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member balances history");

        JSONArray balancesHistory1 = null;
        List<BalanceHistoryDTO> balancesHistoryDTOList = new ArrayList<>();
        try {
            balancesHistory1 = apiEJB.getBalancesHistory(session.getAttribute(Constants.PROFILE_ID).toString()).getJSONArray("rows");
        } catch (JSONException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < balancesHistory1.length(); i++) {
            try {
                BalanceHistoryDTO balanceHistoryDTO = new BalanceHistoryDTO();
                String asAt = balancesHistory1.getJSONObject(i).get("as_at").toString();
                System.err.println("as at is" + asAt);

                // String eeBaltr = balancesHistory1.get(1).toString();
                BigDecimal eeBal = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("ee_bal"));
                System.err.println("eebal  is" + eeBal);

                // String eeContrStr = balancesHistory1.get(2).toString();
                BigDecimal eeContr = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_contr"));
                System.err.println("eeContrib  is" + eeContr);

                //  String eeIntrStr = balancesHistory1.get(3).toString();
                BigDecimal eeIntr = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("ee_intr"));
                System.err.println("eeIntr is " + eeIntr);

                //String erBaltr = balancesHistory1.get(4).toString();
                BigDecimal erBal = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_bal"));
                System.err.println("erBal is" + erBal);

                //String erContrStr = balancesHistory1.get(5).toString();
                BigDecimal erContr = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_contr"));
                System.err.println("ercontr  is" + erContr);

                // String erIntrStr = balancesHistory1.get(6).toString();
                BigDecimal erIntr = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_intr"));
                System.err.println("erIntr  is" + erIntr);

                asAt = asAt.substring(0, 10);

                BigDecimal eeClose = eeBal.add(eeContr).add(eeIntr);
                BigDecimal erClose = erBal.add(erContr).add(erIntr);
                balanceHistoryDTO.setAsAt(asAt);
                balanceHistoryDTO.setEeClose(eeClose);
                balanceHistoryDTO.setErClose(erClose);
                balanceHistoryDTO.setEeBal(eeBal);
                balanceHistoryDTO.setEeContr(eeContr);
                balanceHistoryDTO.setEeIntr(eeIntr);
                balanceHistoryDTO.setErBal(erBal);
                balanceHistoryDTO.setErContr(erContr);
                balanceHistoryDTO.setErIntr(erIntr);
                balanceHistoryDTO.setGrandTotal(eeClose.add(erClose));
                balancesHistoryDTOList.add(balanceHistoryDTO);

            } catch (JSONException ex) {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.print("size of list is" + balancesHistoryDTOList.size());

        request.setAttribute("closingBalancesList", balancesHistoryDTOList);
        request.getRequestDispatcher("member/balance_history.jsp").forward(request, response);
    }

    private void showCumulativeStatement(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException, JSONException {
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        String member_id;

        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);
        logActivity("MEMBER BALANCES HISTORY", "Viewed member balances history", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member balances history");

        JSONObject cumulativeObj = null;

        try {
            cumulativeObj = (JSONObject) apiEJB.getCumulativeStatement(session.getAttribute(Constants.PROFILE_ID).toString(), session.getAttribute(Constants.SCHEME_ID).toString()).getJSONArray("rows").get(0);
        } catch (JSONException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }

        CumulativeMemberStatement cumulativeMemberStatement = new CumulativeMemberStatement();
        //Opening balances
        cumulativeMemberStatement.setOpeningEEReg(MssUtil.castToBigDecimal(cumulativeObj.get("ob_ee_reg").toString()));
        cumulativeMemberStatement.setOpeningEEUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("ob_ee_unreg").toString()));

        cumulativeMemberStatement.setOpeningERReg(MssUtil.castToBigDecimal(cumulativeObj.get("ob_er_reg").toString()));
        cumulativeMemberStatement.setOpeningERUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("ob_er_unreg").toString()));

        cumulativeMemberStatement.setOpeningAVCReg(MssUtil.castToBigDecimal(cumulativeObj.get("ob_avc_reg").toString()));
        cumulativeMemberStatement.setOpeningAVCUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("ob_avc_unreg").toString()));
        //interest on opening balances
        cumulativeMemberStatement.setIntrOpeningEEReg(MssUtil.castToBigDecimal(cumulativeObj.get("int_ee_reg").toString()));
        cumulativeMemberStatement.setIntrOpeningEEUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("int_ee_unreg").toString()));

        cumulativeMemberStatement.setIntrOpeningERReg(MssUtil.castToBigDecimal(cumulativeObj.get("int_er_reg").toString()));
        cumulativeMemberStatement.setIntrOpeningERUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("int_er_unreg").toString()));

        cumulativeMemberStatement.setIntrOpeningAVCReg(MssUtil.castToBigDecimal(cumulativeObj.get("int_avc_reg").toString()));
        cumulativeMemberStatement.setIntrOpeningAVCUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("int_avc_unreg").toString()));

        //contributions
        cumulativeMemberStatement.setContrEEReg(MssUtil.castToBigDecimal(cumulativeObj.get("cont_ee_reg").toString()));
        cumulativeMemberStatement.setContrEEUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("cont_ee_unreg").toString()));

        cumulativeMemberStatement.setContrERReg(MssUtil.castToBigDecimal(cumulativeObj.get("cont_er_reg").toString()));
        cumulativeMemberStatement.setContrERUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("cont_er_unreg").toString()));

        cumulativeMemberStatement.setContrAVCReg(MssUtil.castToBigDecimal(cumulativeObj.get("cont_avc_reg").toString()));
        cumulativeMemberStatement.setContrAVCUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("cont_avc_unreg").toString()));

        //interest on contributions.
        cumulativeMemberStatement.setIntrContrEEReg(MssUtil.castToBigDecimal(cumulativeObj.get("intcont_ee_reg").toString()));
        cumulativeMemberStatement.setIntrContrEEUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("intcont_ee_unreg").toString()));

        cumulativeMemberStatement.setIntrContrERReg(MssUtil.castToBigDecimal(cumulativeObj.get("intcont_er_reg").toString()));
        cumulativeMemberStatement.setIntrContrERUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("intcont_er_unreg").toString()));

        cumulativeMemberStatement.setIntrContrAVCReg(MssUtil.castToBigDecimal(cumulativeObj.get("intcont_avc_reg").toString()));
        cumulativeMemberStatement.setIntrContrAVCUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("intcont_avc_unreg").toString()));

        //Transfers
        cumulativeMemberStatement.setTransferEEReg(MssUtil.castToBigDecimal(cumulativeObj.get("trans_ee_reg").toString()));
        cumulativeMemberStatement.setTransferEEUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("trans_ee_unreg").toString()));

        cumulativeMemberStatement.setTransferERReg(MssUtil.castToBigDecimal(cumulativeObj.get("trans_er_reg").toString()));
        cumulativeMemberStatement.setTransferERUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("trans_er_unreg").toString()));

        cumulativeMemberStatement.setTransferAVCReg(MssUtil.castToBigDecimal(cumulativeObj.get("trans_avc_reg").toString()));
        cumulativeMemberStatement.setTransferAVCUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("trans_avc_unreg").toString()));

        //payments
        cumulativeMemberStatement.setPayEEReg(MssUtil.castToBigDecimal(cumulativeObj.get("pay_ee_reg").toString()));
        cumulativeMemberStatement.setPayEEUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("pay_ee_unreg").toString()));

        cumulativeMemberStatement.setPayERReg(MssUtil.castToBigDecimal(cumulativeObj.get("pay_er_reg").toString()));
        cumulativeMemberStatement.setPayERUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("pay_er_unreg").toString()));

        cumulativeMemberStatement.setPayAVCReg(MssUtil.castToBigDecimal(cumulativeObj.get("pay_avc_reg").toString()));
        cumulativeMemberStatement.setPayAVCUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("pay_avc_unreg").toString()));

        //totals
        cumulativeMemberStatement.setTotalEEReg(MssUtil.castToBigDecimal(cumulativeObj.get("total_ee_reg").toString()));
        cumulativeMemberStatement.setTotalEEUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("total_ee_unreg").toString()));

        cumulativeMemberStatement.setTotalERReg(MssUtil.castToBigDecimal(cumulativeObj.get("total_er_reg").toString()));
        cumulativeMemberStatement.setTotalERUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("total_er_unreg").toString()));

        cumulativeMemberStatement.setTotalAVCReg(MssUtil.castToBigDecimal(cumulativeObj.get("total_avc_reg").toString()));
        cumulativeMemberStatement.setTotalAVCUnreg(MssUtil.castToBigDecimal(cumulativeObj.get("total_avc_unreg").toString()));
        
        //finally
        cumulativeMemberStatement.setGrandTotal(MssUtil.castToBigDecimal(cumulativeObj.get("grand_total").toString()));
         cumulativeMemberStatement.setFinalTotal(MssUtil.castToBigDecimal(cumulativeObj.get("final_total").toString()));

        request.setAttribute("cumulativeMemberStatement", cumulativeMemberStatement);
        request.getRequestDispatcher("member/cumulative_statement_grid.jsp").forward(request, response);
    }

    private void showMemberBalanceHistoryGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);

        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        String member_id;

        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);

        /*BalancesHistory balancesHistory = apiEJB.getBalancesHistory(member_id);
        jLogger.i("Member Balances Returned ================ > " + balancesHistory);
        request.setAttribute("balances", balancesHistory);*/
        JSONArray balancesHistory1 = null;
        List<BalanceHistoryDTO> balancesHistoryDTOList = new ArrayList<>();
        try {
            balancesHistory1 = apiEJB.getBalancesHistory(session.getAttribute(Constants.PROFILE_ID).toString()).getJSONArray("rows");
        } catch (JSONException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < balancesHistory1.length(); i++) {
            try {
                BalanceHistoryDTO balanceHistoryDTO = new BalanceHistoryDTO();
                String asAt = balancesHistory1.getJSONObject(i).get("as_at").toString();
                System.err.println("as at is" + asAt);

                // String eeBaltr = balancesHistory1.get(1).toString();
                BigDecimal eeBal = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("ee_bal"));
                System.err.println("eebal  is" + eeBal);

                // String eeContrStr = balancesHistory1.get(2).toString();
                BigDecimal eeContr = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_contr"));
                System.err.println("eeContrib  is" + eeContr);

                //  String eeIntrStr = balancesHistory1.get(3).toString();
                BigDecimal eeIntr = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("ee_intr"));
                System.err.println("eeIntr is " + eeIntr);

                //String erBaltr = balancesHistory1.get(4).toString();
                BigDecimal erBal = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_bal"));
                System.err.println("erBal is" + erBal);

                //String erContrStr = balancesHistory1.get(5).toString();
                BigDecimal erContr = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_contr"));
                System.err.println("ercontr  is" + erContr);

                // String erIntrStr = balancesHistory1.get(6).toString();
                BigDecimal erIntr = MssUtil.castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_intr"));
                System.err.println("erIntr  is" + erIntr);

                asAt = asAt.substring(0, 10);

                BigDecimal eeClose = eeBal.add(eeContr).add(eeIntr);
                BigDecimal erClose = erBal.add(erContr).add(erIntr);
                balanceHistoryDTO.setAsAt(asAt);
                balanceHistoryDTO.setEeClose(eeClose);
                balanceHistoryDTO.setErClose(erClose);
                balanceHistoryDTO.setEeBal(eeBal);
                balanceHistoryDTO.setEeContr(eeContr);
                balanceHistoryDTO.setEeIntr(eeIntr);
                balanceHistoryDTO.setErBal(erBal);
                balanceHistoryDTO.setErContr(erContr);
                balanceHistoryDTO.setErIntr(erIntr);
                balanceHistoryDTO.setGrandTotal(eeClose.add(erClose));
                balancesHistoryDTOList.add(balanceHistoryDTO);

            } catch (JSONException ex) {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.print("size of list is" + balancesHistoryDTOList.size());
        request.setAttribute("closingBalancesList", balancesHistoryDTOList);

        logActivity("MEMBER BALANCES HISTORY GRID", "Viewed member balances history grid", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member balances history grid");
        request.getRequestDispatcher("member/balance_history_grid.jsp").forward(request, response);
    }

    private void showMemberBalanceHistoryGrid1(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);

        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        String member_id;

        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);

        request.getRequestDispatcher("testDT/test.jsp").forward(request, response);
    }

    @EJB
    MediaBeanI mediaBeanI;

    private void showMemberMedia(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        String schemeId = "";
        schemeId = this.getSessKey(request, Constants.SCHEME_ID);
        jLogger.i("============ Member Scheme ID is: " + schemeId + " ===================");
        request.setAttribute("scheme_id", schemeId);

        //List<Media> medias = mediaBeanI.findAll(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE), this.getSessKey(request, Constants.PROFILE_ID));
        boolean status = true;
        String profile = this.getSessKey(request, Constants.U_PROFILE);
        String memberId = this.getSessKey(request, Constants.PROFILE_ID);
        jLogger.i("Member ID: " + memberId);
        List<Media> medias = mediaBeanI.findByStatusAndProfile(schemeId, status, profile);
        jLogger.i("Medias found: " + medias.size());

        if (medias == null || medias.size() < 1) {
            medias = mediaBeanI.findByMemberId(schemeId, memberId);
        }
        jLogger.i("Medias found 2: " + medias.size());
        request.setAttribute("medias", medias);

        for (Media media : medias) {
            String mediaScheme = media.getSchemeID();
            jLogger.i("============ Doc Scheme ID is: " + mediaScheme + " ===================");
            jLogger.i("Medias found: " + media);
        }

        logActivity("MEDIA FILES", "Accessed media & files (documents)", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed media & files (documents)");
        request.getRequestDispatcher("member/media_files.jsp").forward(request, response);
    }

    private void showMemberDocument(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        String schemeId = "";
        schemeId = this.getSessKey(request, Constants.SCHEME_ID);
        jLogger.i("============ Member Scheme ID is: " + schemeId + " ===================");
        request.setAttribute("scheme_id", schemeId);

        //List<Media> medias = mediaBeanI.findAll(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE), this.getSessKey(request, Constants.PROFILE_ID));
        boolean status = true;
        String profile = this.getSessKey(request, Constants.U_PROFILE);
        String memberId = this.getSessKey(request, Constants.PROFILE_ID);
        request.setAttribute("member_id", memberId);
        //
        XiMember member = apiEJB.memberExists(profile, this.getSessKey(request, Constants.USER));
        String nationalPenNo = member.getNationalPenNo();
        jLogger.i("The Pen NO IS " + nationalPenNo);

        jLogger.i("Member ID: " + memberId);
        List<Media> documents = mediaBeanI.findByNationalPenNo(nationalPenNo);
        jLogger.i("Medias found: " + documents.size());

        if (documents == null || documents.size() < 1) {
            documents = mediaBeanI.findByMemberId(schemeId, memberId);
        }
        jLogger.i("Medias found 2: " + documents.size());
        request.setAttribute("documents", documents);

        for (Media document : documents) {
            String mediaScheme = document.getSchemeID();
            jLogger.i("============ Doc Scheme ID is: " + mediaScheme + " ===================");
            jLogger.i("Medias found: " + document);
        }

        logActivity("DOCUMENT FILES", "Accessed media & files (documents)", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed media & files (documents)");
        request.getRequestDispatcher("member/document_file.jsp").forward(request, response);
    }

    private void showMemberClaims(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));

        XiMember m;
        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null || member_id.isEmpty()) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        jLogger.i("Member ID is: " + member_id);
        m = apiEJB.getMemberDetails(member_id, null);
        request.setAttribute("member", m);

        String memberNumber = m.getMemberNo();
        jLogger.i("Member Number found is " + memberNumber);

        long schemeId = Long.parseLong(this.getSessKey(request, Constants.SCHEME_ID));
        jLogger.i("Scheme Id found is " + schemeId);

        List<MemberClaims> memberClaims = apiEJB.getMemberClaims(member_id, schemeId);
        request.setAttribute("claims", memberClaims);

        logActivity("MEMBER CLAIMS", "Viewed member claims", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member claims");
        request.getRequestDispatcher("member/claims.jsp").forward(request, response);
    }

    private void showMemberBenefitProjections(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Setting setting = settingBeanI.find();
        request.setAttribute("settings", setting);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("planType", this.getSessKey(request, Constants.SCHEME_TYPE));
        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("MEMBER BENEFITS PROJECTION", "Viewed member benefits projection", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member benefits projection");
        request.getRequestDispatcher("member/benefits_projection.jsp").forward(request, response);
    }

    private void showAnnualContributionStatement(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Setting setting = settingBeanI.find();
        request.setAttribute("settings", setting);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));

        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("ANNUAL CONTRIBUTION STATEMENT", "Viewed annual contribution statement", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed annual contribution statement");
        request.getRequestDispatcher("member/annual_contributions.jsp").forward(request, response);
    }

    private void showProvisionalMemberStatement(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Setting setting = settingBeanI.find();
        request.setAttribute("settings", setting);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));

        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("PROVISIONAL MEMBER STATEMENT", "Viewed provisional member statement", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed provisional member statement");
        request.getRequestDispatcher("member/provisional_member.jsp").forward(request, response);
    }

    private void showMemberBenefitProjectionsGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Setting setting = settingBeanI.find();
        request.setAttribute("settings", setting);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("planType", this.getSessKey(request, Constants.SCHEME_TYPE));
        jLogger.i("Plan type is: " + this.getSessKey(request, Constants.SCHEME_TYPE));
        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);
        logActivity("MEMBER BENEFITS PROJECTION GRID", "Viewed member benefits projection grid", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member benefits projection grid");
        request.getRequestDispatcher("member/benefits_projection_grid.jsp").forward(request, response);
    }

    private void showAnnualContributionsGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Setting setting = settingBeanI.find();
        request.setAttribute("settings", setting);

        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));

        String member_id;
        member_id = this.get(request, "memberID");

        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);

        logActivity("ANNUAL CONTRIBUTION STATEMENT GRID", "Viewed annual contribution statement grid", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed annual contribution statement grid");
        request.getRequestDispatcher("member/annual_contribution_grid.jsp").forward(request, response);
    }

    private void showMemberStatementOfAccount(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Setting setting = settingBeanI.find();
        request.setAttribute("settings", setting);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("MEMBER STATEMENT OF ACCOUNT", "Viewed member statement of account", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member statement of account");
        request.getRequestDispatcher("member/statement_of_account.jsp").forward(request, response);
    }

    private void showMemberStatementOfAccountGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Setting setting = settingBeanI.find();
        request.setAttribute("settings", setting);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = String.valueOf(apiEJB.getMemberId(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID)));
        }
        request.setAttribute("member_id", member_id);
        logActivity("MEMBER STATEMENT OF ACCOUNT GRID", "Viewed member statement of account grid", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member statement of account grid");
        request.getRequestDispatcher("member/statement_of_account_grid.jsp").forward(request, response);
    }

    private void showMemberUnitizedStatement(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Setting setting = settingBeanI.find();
        request.setAttribute("settings", setting);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        jLogger.i("scheme id US " + this.getSessKey(request, Constants.SCHEME_ID));

        String memberId = "";
        memberId = this.get(request, "memberID");
        jLogger.i("member id US " + memberId);
        if (memberId == null) {
            memberId = String.valueOf(apiEJB.getMemberId(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID)));
        }
        request.setAttribute("member_id", memberId);
        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("MEMBER UNITIZED STATEMENT", "Viewed member unitized statement", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member unitized statement");
        request.getRequestDispatcher("member/unitized_statement.jsp").forward(request, response);
    }

    private void showMemberCertificate(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        Setting setting = settingBeanI.find();
        request.setAttribute("settings", setting);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        jLogger.i("scheme id US " + this.getSessKey(request, Constants.SCHEME_ID));
        String memberId = "";
        //this.get(request, "memberID")
        memberId = String.valueOf(apiEJB.getMemberId(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.PROFILE_ID)));
        jLogger.i("member id US " + memberId);
        if (memberId == null) {
            memberId = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", memberId);

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("MEMBER CERTIFICATE STATEMENT", "Viewed member Certificate statement", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member Member statement");
        request.getRequestDispatcher("member/member_certificate.jsp").forward(request, response);
    }

    private void showMemberContributionHistory(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);
        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("member_id", member_id);
        logActivity("MEMBER CONTRIBUTION HISTORY", "Viewed member contribution history", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member contribution history");
        request.getRequestDispatcher("member/contribution_history.jsp").forward(request, response);
    }

    private void showAgentClients(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {

        int page;
        int batch;

        try {
            batch = Integer.parseInt(this.get(request, "batch"));
        } catch (NumberFormatException nfe) {
            batch = 1;
        }
        try {
            page = Integer.parseInt(this.get(request, "page"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            page = 1;
        }

        int count = Constants.RECORD_COUNT;
        int pages = (count / PER_PAGE);
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        request.setAttribute("begin", begin);
        request.setAttribute("pages", pages);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);

        String agent_id;
        agent_id = this.get(request, "memberID");

        if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.AGENT_PROFILE)) {
            agent_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        request.setAttribute("agent_id", agent_id);

        List<AgentClient> agentClients = apiEJB.getAgentClients(agent_id, start, PER_PAGE);
        request.setAttribute("clients", agentClients);
        request.setAttribute("pages", pages);
        logActivity("AGENT CLIENTS", "Viewed agent clients", this.getSessKey(request, Constants.UID),
                this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed agent clients");
        request.getRequestDispatcher(REPO_FOLDER + "/agent_clients.jsp").forward(request, response);
    }

    private void showMemberContributionHistoryGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {

        try {

            Setting settings = settingBeanI.find();
            request.setAttribute("settings", settings);

            Company company = companyBeanI.find();
            request.setAttribute("company", company);

            request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
            String member_id;

            member_id = this.get(request, "memberID");
            if (member_id == null) {
                member_id = this.getSessKey(request, Constants.PROFILE_ID);
            }
            request.setAttribute("member_id", member_id);

            //use dto to get contributions
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

            JSONArray contributionsBetweenDates = null;
            List<ContributionsHistoryDTO> contributionsHistoryDtoList = new ArrayList<>();

            //JSONObject memberContributions = apiEJB.getMemberFullContributions(member_id);
            JSONObject memberContributions = apiEJB.getContributionsBetweenDates(format.format(fromDate), format.format(toDate), session.getAttribute(Constants.PROFILE_ID).toString());

            BigDecimal eeSum = BigDecimal.ZERO;
            BigDecimal erSum = BigDecimal.ZERO;
            BigDecimal avcSum = BigDecimal.ZERO;
            BigDecimal avcErSum = BigDecimal.ZERO;
            BigDecimal salarySum = BigDecimal.ZERO;
            BigDecimal totalSum = BigDecimal.ZERO;

            contributionsBetweenDates = memberContributions.getJSONArray("rows");
            for (int i = 0; i < contributionsBetweenDates.length(); i++) {

                ContributionsHistoryDTO contributionsHistoryDTO = new ContributionsHistoryDTO();
                contributionsHistoryDTO.setDatePaid(contributionsBetweenDates.getJSONObject(i).get("datePaid").toString());
                contributionsHistoryDTO.setMonth(contributionsBetweenDates.getJSONObject(i).get("month").toString());
                contributionsHistoryDTO.setYear(contributionsBetweenDates.getJSONObject(i).get("year").toString());
                contributionsHistoryDTO.setEe(MssUtil.castToBigDecimal(contributionsBetweenDates.getJSONObject(i).get("ee")));
                contributionsHistoryDTO.setEr(MssUtil.castToBigDecimal(contributionsBetweenDates.getJSONObject(i).get("er")));
                contributionsHistoryDTO.setAvc(MssUtil.castToBigDecimal(contributionsBetweenDates.getJSONObject(i).get("avc")));
                contributionsHistoryDTO.setAvcer(MssUtil.castToBigDecimal(contributionsBetweenDates.getJSONObject(i).get("avcer")));
                contributionsHistoryDTO.setSalary(MssUtil.castToBigDecimal(contributionsBetweenDates.getJSONObject(i).get("salary")));
                contributionsHistoryDTO.setType(contributionsBetweenDates.getJSONObject(i).get("type").toString());
                contributionsHistoryDTO.setTotal(MssUtil.castToBigDecimal((contributionsBetweenDates.getJSONObject(i).get("total").toString())));
                contributionsHistoryDTO.setRegUnreg(contributionsBetweenDates.getJSONObject(i).get("status").toString());

                //do appropriate calculations
                eeSum.add(contributionsHistoryDTO.getEe());
                erSum.add(contributionsHistoryDTO.getEr());
                avcSum.add(contributionsHistoryDTO.getAvc());
                avcErSum.add(contributionsHistoryDTO.getAvcer());
                salarySum.add(contributionsHistoryDTO.getSalary());
                totalSum.add(contributionsHistoryDTO.getTotal());

                System.err.println(contributionsHistoryDTO.getEe());
                System.err.println(contributionsHistoryDTO.getEr());
                System.err.println(contributionsHistoryDTO.getTotal());

                contributionsHistoryDtoList.add(contributionsHistoryDTO);
            }
            ContributionHistorySummary contributionHistorySummary = new ContributionHistorySummary();

            contributionHistorySummary.setEeSum(eeSum);
            contributionHistorySummary.setErSum(erSum);
            contributionHistorySummary.setAvcSum(avcSum);
            contributionHistorySummary.setAvcErSum(avcErSum);
            contributionHistorySummary.setSalarySum(salarySum);
            contributionHistorySummary.setTotalSum(totalSum);

            request.setAttribute("contributionsHistoryDtoLists", contributionsHistoryDtoList);
            request.setAttribute("contributionHistorySummary", contributionHistorySummary);
            /*JSONObject memberContributions = apiEJB.getMemberContributions(member_id);
            jLogger.i("Member Contributions Returned ================ > " + memberContributions);*/
            logActivity("MEMBER CONTRIBUTION HISTORY", "Viewed member contribution history", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
            this.audit(session, "Viewed member contribution history");
            request.getRequestDispatcher("member/contribution_history_grid.jsp").forward(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @EJB
    SocialBeanI socialBeanI;
    @EJB
    SectorBeanI sectorBeanI;
    @EJB
    GenderBeanI genderBeanI;
    @EJB
    MaritalStatusBeanI maritalStatusBeanI;
    @EJB
    CompanyBeanI companyBeanI;
    @EJB
    EmailsBeanI emailsBeanI;
    @EJB
    MemberPermissionBeanI memberPermissionBeanI;

    private void showMemberPersonalInformation(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        //System.out.println("request.getParameter  "+this.get(request, "memberID") +" Alt: "+ this.getSessKey(request, Constants.PROFILE_ID));
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
        List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
        request.setAttribute("schemes", schemes);
        MemberPermission memberPermission = memberPermissionBeanI.find();
        request.setAttribute("memberPermission", memberPermission);
        request.setAttribute("profile", this.getSessKey(request, Constants.U_PROFILE));
        ClientSetup clientSetup = new ClientSetup();
        clientSetup = clientSetupI.find().get(0);
        request.setAttribute("clientSetup", clientSetup);
        XiMember m;
        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null || member_id.isEmpty()) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        jLogger.i("Member ID is: " + member_id);
        m = apiEJB.getMemberDetails(member_id, null);
        request.setAttribute("member", m);
        jLogger.i("Member Id found is " + m.getId());

        List<Beneficiary> beneficiaries = apiEJB.getBeneficiariesList(member_id);
        request.setAttribute("beneficiaries", beneficiaries);
        Double totalPercentageLumpsum = apiEJB.getMemberBensTotalEntitlement(member_id);

        jLogger.i("totalPercentageLumpsum" + totalPercentageLumpsum);
        request.setAttribute("totalPercentageLumpsum", totalPercentageLumpsum);

        logActivity("MEMBER PERSONAL INFORMATION", "Viewed editable member personal information", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed  editable  member personal information");
        request.getRequestDispatcher("member/personal_information.jsp").forward(request, response);
    }

    private void showPensionerInformation(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        jLogger.i(">>>>>>>>>> Into the switch <<<<<<<<<<<<<");
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
        List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
        request.setAttribute("schemes", schemes);

        XiPensioner p;
        String pensioner_id;
        pensioner_id = this.get(request, "pensionerID");
        if (pensioner_id == null || pensioner_id.isEmpty()) {
            pensioner_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        jLogger.i("Pensioner ID is: " + pensioner_id);
        p = apiEJB.getPensionerDetails(pensioner_id, null);
        request.setAttribute("pensioner", p);
        jLogger.i("Pensioner Id found is " + p.getId());

        String memberId = p.getMemberId();
        jLogger.i("Member id: " + memberId);
        request.setAttribute("memberId", memberId);
        jLogger.i(" Are we on the right track????? ");
        List<Beneficiary> beneficiaries = apiEJB.getBeneficiariesList(memberId);
        jLogger.i(" Are we on the right track 2 ????? ");
        request.setAttribute("beneficiaries", beneficiaries);

        logActivity("PENSIONER PERSONAL INFORMATION", "Viewed editable pensioner personal information", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed  editable  pensioner personal information");
        request.getRequestDispatcher("pensioner/personal_info.jsp").forward(request, response);
    }

    private void showPensionDetails(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Social social = socialBeanI.find();
        request.setAttribute("social", social);
        List<Sector> sectors = sectorBeanI.find();
        request.setAttribute("sectors", sectors);
        List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
        request.setAttribute("schemes", schemes);

        XiPensioner p;
        String pensioner_id;
        pensioner_id = this.get(request, "pensionerID");
        if (pensioner_id == null || pensioner_id.isEmpty()) {
            pensioner_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        jLogger.i("Pensioner ID is: " + pensioner_id);

        p = apiEJB.getPensionerDetails(pensioner_id, null);
        request.setAttribute("pensioner", p);
        jLogger.i("Pensioner Id found is " + p.getId());

        String memberId = p.getMemberId();
        jLogger.i("Member id: " + memberId);
        request.setAttribute("memberId", memberId);
        jLogger.i(" Are we on the right track????? ");
        List<Beneficiary> beneficiaries = apiEJB.getBeneficiariesList(memberId);
        jLogger.i(" Are we on the right track 2 ????? ");
        request.setAttribute("beneficiaries", beneficiaries);

        logActivity("PENSIONER DETAILS", "Viewed pension details", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed  pension details");
        request.getRequestDispatcher("pensioner/pension_details.jsp").forward(request, response);
    }

    private void showPensionAdvice(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        Social social = socialBeanI.find();
        request.setAttribute("social", social);
        List<Sector> sectors = sectorBeanI.find();
        request.setAttribute("sectors", sectors);
        List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
        request.setAttribute("schemes", schemes);

        XiPensioner p;
        String pensioner_id;
        pensioner_id = this.get(request, "pensionerID");
        if (pensioner_id == null || pensioner_id.isEmpty()) {
            pensioner_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        jLogger.i("Pensioner ID is: " + pensioner_id);

        p = apiEJB.getPensionerDetails(pensioner_id, null);
        request.setAttribute("pensioner", p);
        jLogger.i("Pensioner Id found is " + p.getId());

        String memberId = p.getMemberId();
        jLogger.i("Member id: " + memberId);
        request.setAttribute("memberId", memberId);
        jLogger.i(" Are we on the right track????? ");
        List<Beneficiary> beneficiaries = apiEJB.getBeneficiariesList(memberId);
        jLogger.i(" Are we on the right track 2 ????? ");
        request.setAttribute("beneficiaries", beneficiaries);

        ReportDetails reportDetails;
        reportDetails = apiEJB.getReportDetails(this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("report_details", reportDetails);

        logActivity("PENSION ADVICE", "Viewed pension advice", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed  pension advice");
        request.getRequestDispatcher("pensioner/pension_advice.jsp").forward(request, response);
    }

    private void showPensionAdviceGrid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        Social social = socialBeanI.find();
        request.setAttribute("social", social);
        List<Sector> sectors = sectorBeanI.find();
        request.setAttribute("sectors", sectors);
        List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
        request.setAttribute("schemes", schemes);

        XiPensioner p;
        String pensioner_id;
        pensioner_id = this.get(request, "pensionerID");
        if (pensioner_id == null || pensioner_id.isEmpty()) {
            pensioner_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        jLogger.i("Pensioner ID is: " + pensioner_id);

        p = apiEJB.getPensionerDetails(pensioner_id, null);
        request.setAttribute("pensioner", p);
        jLogger.i("Pensioner Id found is " + p.getId());

        /*String memberId = p.getMemberId();
        jLogger.i("Member id: " + memberId);
        request.setAttribute("memberId", memberId);
        List<Beneficiary> beneficiaries = apiEJB.getBeneficiariesList(memberId);
        request.setAttribute("beneficiaries", beneficiaries);*/
        logActivity("PENSION ADVICE GRID", "Viewed pension advice grid", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed  pension advice grid");
        request.getRequestDispatcher("pensioner/pension_advice_grid.jsp").forward(request, response);
    }

    private void showAnalytics(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        logActivity("PORTAL ANALYTICS", "Accessed portal analytics & reporting", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed portal analytics & reporting");
        request.getRequestDispatcher(REPO_FOLDER + "/analytics.jsp").forward(request, response);
    }

    private void showUserAccessControls(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        DBMenu dbMenu = dbMenuBeanI.find();
        request.setAttribute("dbMenu", dbMenu);
        logActivity("USER ACCESS CONTROL", "Accessed User Access Control Panel", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed User Access Control Panel");
        request.getRequestDispatcher(REPO_FOLDER + "/uac.jsp").forward(request, response);
    }

    private void showUsers(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {
        List<User> users;
        int page;
        try {
            page = Integer.parseInt(this.get(request, "page"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            page = 1;
        }
        String search = this.get(request, "search");
        int batch;
        try {
            batch = Integer.parseInt(this.get(request, "batch"));
        } catch (NumberFormatException nfe) {
            batch = 1;
        }
        int count = userBeanI.countAll(search);
        int pages = (count / PER_PAGE);
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        request.setAttribute("begin", begin);
        request.setAttribute("pages", pages);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("search", search);
        request.setAttribute("pages", pages);
        users = userBeanI.findAll(search, start, PER_PAGE);
        request.setAttribute("users", users);
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        logActivity("USERS", "Viewed portal users", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed portal users");
        request.getRequestDispatcher(REPO_FOLDER + "/users.jsp").forward(request, response);
    }

    private void showAuditTrails(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        int page;
        try {
            page = Integer.parseInt(this.get(request, "page"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            page = 1;
        }
        String search = this.get(request, "search");
        int batch;
        try {
            batch = Integer.parseInt(this.get(request, "batch"));
        } catch (NumberFormatException nfe) {
            batch = 1;
        }
        int count = auditTrailBeanI.countAll(search);
        int pages = (count / PER_PAGE);
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        request.setAttribute("begin", begin);
        request.setAttribute("pages", pages);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("search", search);
        List<AuditTrail> auditTrails = auditTrailBeanI.findAll(search, start, PER_PAGE);
        request.setAttribute("auditTrails", auditTrails);
        request.setAttribute("pages", pages);
        logActivity("AUDIT TRAIL", "Viewed Audit Trails", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed Audit Trails");
        request.getRequestDispatcher(REPO_FOLDER + "/audit_trail.jsp").forward(request, response);
    }

    private void showSponsors(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        int page;
        try {
            page = Integer.parseInt(this.get(request, "page"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            page = 1;
        }
        String search;
        try {
            search = this.get(request, "search");
        } catch (NumberFormatException nfe) {
            search = null;
        }
        int batch;
        try {
            batch = Integer.parseInt(this.get(request, "batch"));
        } catch (NumberFormatException nfe) {
            batch = 1;
        }
        int count = sponsorBeanI.countAll(search);
        int pages = (count / PER_PAGE);
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        request.setAttribute("begin", begin);
        request.setAttribute("pages", pages);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("search", search);
        String agentId = null;
        if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.AGENT_PROFILE)) {
            agentId = this.getSessKey(request, Constants.PROFILE_ID);
        }
        List<Sponsor> sponsors = sponsorBeanI.findAll(agentId, search, start, PER_PAGE);
        request.setAttribute("sponsors", sponsors);

        List<Sector> sectors = sectorBeanI.find();
        request.setAttribute("sectors", sectors);

        List<Country> countries = countryBeanI.find();
        request.setAttribute("countries", countries);
        request.setAttribute("pages", pages);
        List<Scheme> sponsorSchemes;
        sponsorSchemes = apiEJB.getSchemeBySchemeModeAndPlanType("UMBRELLA", "INDIVIDUAL_PENSION_FUND");

        request.setAttribute("sponsorSchemes", sponsorSchemes);
        request.getRequestDispatcher(REPO_FOLDER + "/portal_sponsors.jsp").forward(request, response);
    }

    private void showPortalMembers(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        int page;
        try {
            page = Integer.parseInt(this.get(request, "page"));
        } catch (NumberFormatException nfe) {
            page = 1;
        }
        String search = this.get(request, "search");
        int batch;
        try {
            batch = Integer.parseInt(this.get(request, "batch"));
        } catch (NumberFormatException nfe) {
            batch = 1;
        }
        int count = memberBeanI.countAll(search);
        int pages = (count / PER_PAGE);
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        request.setAttribute("begin", begin);
        request.setAttribute("pages", pages);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("search", search);
        String agentId = null;
        if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.AGENT_PROFILE)) {
            agentId = this.getSessKey(request, Constants.PROFILE_ID);
        }
        List<Member> members = memberBeanI.findAll(agentId, search, start, PER_PAGE);
        request.setAttribute("members", members);
        request.setAttribute("pages", pages);
        List<Country> countries = countryBeanI.find();
        request.setAttribute("countries", countries);
        List<Gender> genders = genderBeanI.find();
        request.setAttribute("genders", genders);
        List<MaritalStatus> marital_statuses = maritalStatusBeanI.find();
        request.setAttribute("maritalStatuses", marital_statuses);
        List<Scheme> memberSchemes = apiEJB.getSchemeByPlanType("INDIVIDUAL_PENSION_FUND");
        request.setAttribute("memberSchemes", memberSchemes);
        request.getRequestDispatcher(REPO_FOLDER + "/portal_members.jsp").forward(request, response);
    }

    private void showMedia(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {

        List<Media> medias = new ArrayList<>();

        String profile = this.getSessKey(request, Constants.U_PROFILE);
        request.setAttribute("profile", profile);

        jLogger.i("The profile is: " + profile);
        boolean status = true;
        String schemeId = "";

        if (!profile.equalsIgnoreCase(Constants.ADMIN_PROFILE)) {

            schemeId = this.getSessKey(request, Constants.SCHEME_ID);
            jLogger.i("============ Scheme ID is: " + schemeId + " ===================");
            medias = mediaBeanI.findByStatusAndProfile(schemeId, status, profile);
        } else {

            medias = mediaBeanI.findAll(this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE), this.getSessKey(request, Constants.PROFILE_ID));
        }
        request.setAttribute("scheme_id", schemeId);
        request.setAttribute("medias", medias);
        List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
        request.setAttribute("schemes", schemes);
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);

        logActivity("MEDIA & FILES", "Accessed media & files (documents)", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed media & files (documents)");
        request.getRequestDispatcher(REPO_FOLDER + "/media.jsp").forward(request, response);
    }

    private int getIntegerFromString(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return 1;
        }
    }

    private void showMemberPayments(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));

        XiMember m;
        String member_id;
        member_id = this.get(request, "memberID");
        if (member_id == null || member_id.isEmpty()) {
            member_id = this.getSessKey(request, Constants.PROFILE_ID);
        }
        jLogger.i("Member ID is: " + member_id);
        m = apiEJB.getMemberDetails(member_id, null);
        request.setAttribute("member", m);

        String memberNumber = m.getMemberNo();
        jLogger.i("Member Number found is " + memberNumber);

        long schemeId = Long.parseLong(this.getSessKey(request, Constants.SCHEME_ID));
        jLogger.i("Scheme Id found is " + schemeId);

        List<BenefitPayment> benefitPayments = apiEJB.getMemberBenefitPayments(member_id, 0, 50);
        request.setAttribute("payments", benefitPayments);

        logActivity("MEMBER PAYMENTS", "Viewed member Payments", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member Payments");
        request.getRequestDispatcher("member/memberpayments.jsp").forward(request, response);
    }

    private void showPayments(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {
        List<BenefitPayment> payments;
        int page;
        int batch;
        Date date_from = getDateFromString(request, "dateFrom", "from");
        Date date_to = getDateFromString(request, "dateTo", "to");
        String sponsorId = "";
        batch = getIntegerFromString(this.get(request, "batch"));
        page = getIntegerFromString(this.get(request, "page"));
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        DateFormat format_ = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.SPONSOR)) {

            sponsorId = this.getSessKey(request, Constants.PROFILE_ID);
            jLogger.i("Sponsor ID " + sponsorId);
        } else if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.MEMBER_PROFILE)) {
            String memberId = this.getSessKey(request, Constants.PROFILE_ID);
            jLogger.i("This is memnerid" + memberId);
        }

        if (sponsorId != null) {
            jLogger.i("::::::::: Fetching Sponsor Benefits :::::::::");
            payments = apiEJB.getBenefitPaymentsPerSponsor(this.getSessKey(request, Constants.SCHEME_ID), sponsorId, start, PER_PAGE);

        } else if (date_from != null && date_to != null) {

            payments = apiEJB.searchPayments(this.getSessKey(request, Constants.SCHEME_ID), format_.format(date_from), format_.format(date_to), start, PER_PAGE);
        } else {

            payments = apiEJB.getBenefitPayments(this.getSessKey(request, Constants.SCHEME_ID), start, PER_PAGE);
        }

        int count = Constants.RECORD_COUNT;
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        int pages = (count / PER_PAGE);
        request.setAttribute("begin", begin);
        request.setAttribute("pages", pages);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("payments", payments);
        logActivity("SCHEME PAYMENTS", "Viewed scheme payments for scheme #" + this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed scheme payments for scheme #" + this.getSessKey(request, Constants.SCHEME_ID));
        request.getRequestDispatcher(REPO_FOLDER + "/payments.jsp").forward(request, response);
    }
    //

    private Date getDateFromString(HttpServletRequest request, String attribute, String param) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String date_from_string;
        Date date_from;
        try {
            date_from_string = this.get(request, param);
            date_from = format.parse(date_from_string);
            request.setAttribute(attribute, date_from_string);
        } catch (ParseException pe) {

            date_from = null;
        }
        return date_from;
    }

    private void showReceipts(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {
        List<SchemeReceipt> receipts;

        int page;
        int batch;
        Date date_from = getDateFromString(request, "dateFrom", "from");
        jLogger.i("Date from: " + date_from);
        Date date_to = getDateFromString(request, "dateTo", "to");
        jLogger.i("Date to: " + date_to);
        batch = getIntegerFromString(this.get(request, "batch"));
        page = getIntegerFromString(this.get(request, "page"));
        int count = Constants.RECORD_COUNT;
        int pages = (count / PER_PAGE);
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        request.setAttribute("begin", begin);
        request.setAttribute("pages", pages);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);
        DateFormat format_ = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        //if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.AGENT_PROFILE))
        if (date_from != null && date_to != null) {
            receipts = apiEJB.searchReceipts(this.getSessKey(request, Constants.SCHEME_ID), format_.format(date_from), format_.format(date_to), start, PER_PAGE);
        } else {
            if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.SPONSOR)) {
                jLogger.i("getting sponsor scheme receipts");

                receipts = apiEJB.getSponsorReceipts(this.getSessKey(request, Constants.PROFILE_ID), this.getSessKey(request, Constants.SCHEME_ID), start, PER_PAGE);

            } else {

                jLogger.i("getting  scheme receipts");
                receipts = apiEJB.getSchemeReceipts(this.getSessKey(request, Constants.SCHEME_ID), start, PER_PAGE);
            }
        }

        request.setAttribute("receipts", receipts);
        logActivity("SCHEME RECEIPTS", "Viewed scheme receipts for scheme #" + this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed scheme receipts for scheme #" + this.getSessKey(request, Constants.SCHEME_ID));
        request.getRequestDispatcher(REPO_FOLDER + "/receipts.jsp").forward(request, response);
    }

    private void showMembers(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {
        List<XiMember> members;
        int page;
        int batch;
        String profile;
        String identifier;
        String search;
        String sponsorId = "";
        String schemeId = "";
        String json = "";

        try {
            batch = Integer.parseInt(this.get(request, "batch"));
        } catch (NumberFormatException nfe) {
            batch = 1;
        }
        try {
            page = Integer.parseInt(this.get(request, "page"));
        } catch (NumberFormatException nfe) {
            page = 1;

        }
        profile = this.get(request, "profile");
        request.setAttribute("profile", profile);
        identifier = this.get(request, "identifier");
        request.setAttribute("identifier", identifier);
        search = this.get(request, "search");
        request.setAttribute("search", search);

        int start = (PER_PAGE * (page - 1)) * (batch - 1);

        if (this.getSessKey(request, Constants.U_PROFILE).equals(Constants.SPONSOR)) {

            sponsorId = this.getSessKey(request, Constants.PROFILE_ID);
            jLogger.i("SponsorId is  " + sponsorId);
        }

        if (identifier != null && profile != null && !Objects.equals(search, "") && sponsorId != null) {
            log("We are Here @ 0 !!!!!!!!");
            members = apiEJB.searchProfilesBySponsor(search, identifier, profile, sponsorId, this.getSessKey(request, Constants.SCHEME_ID));
        } else if (identifier != null && profile != null && !Objects.equals(search, "")) {

            members = apiEJB.searchProfiles(search, identifier, profile, this.getSessKey(request, Constants.SCHEME_ID), start, PER_PAGE);

        } else {
            log("We are Here!!!!!!!!");

            members = apiEJB.getMemberListing(this.getSessKey(request, Constants.PROFILE_ID), this.getSessKey(request, Constants.U_PROFILE), this.getSessKey(request, Constants.SCHEME_ID), 0, 9000);
        }

        int count = Constants.RECORD_COUNT;
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        int pages = (count / PER_PAGE);
        request.setAttribute("begin", begin);
        request.setAttribute("pages", pages);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("search", search);
        List<Ordinal> ordinals = helper.getOrdinals();
        request.setAttribute("ordinals", ordinals);
        List<ClientSetup> clientsetup = clientSetupI.find();
        request.setAttribute("clientsetup", clientsetup);
        request.setAttribute("members", members);
        Permission permissions = getPermissions(request);
        logActivity("MEMBERS", "Viewed members for scheme #" + this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed members for scheme #" + this.getSessKey(request, Constants.SCHEME_ID));
        request.setAttribute("permissions", permissions);
        request.getRequestDispatcher(REPO_FOLDER + "/member.jsp").forward(request, response);
    }

    private void showSchemes(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {
        List<Scheme> schemes;
        int page;
        try {
            page = Integer.parseInt(this.get(request, "page"));
        } catch (NumberFormatException nfe) {
            page = 1;
        }
        String search = this.get(request, "search");
        int batch;
        try {
            batch = Integer.parseInt(this.get(request, "batch"));
        } catch (NumberFormatException nfe) {
            batch = 1;
        }
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        request.setAttribute("begin", begin);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("search", search);
        schemes = apiEJB.getSchemes(start, PER_PAGE);
        int count = Constants.RECORD_COUNT;
        int pages = (count / PER_PAGE);
        request.setAttribute("pages", pages);
        request.setAttribute("schemes", schemes);
        logActivity("SCHEMES", "Viewed Schemes", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed Schemes");
        request.getRequestDispatcher(REPO_FOLDER + "/scheme.jsp").forward(request, response);
    }
    @EJB
    SchemeManagerBeanI schemeManagerBeanI;

    private void showSchemeManagers(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        List<SchemeMemberManager> schememanagers = schemeManagerBeanI.findAll();
        request.setAttribute("schememanagers", schememanagers);
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        logActivity("SCHEME MANAGERS", "Viewed Scheme Managers", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed Scheme Managers");
        request.getRequestDispatcher(REPO_FOLDER + "/scheme_managers.jsp").forward(request, response);
    }

    private void showMemberOperations(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        Permission permissions = getPermissions(request);
        String profile = this.getSessKey(request, Constants.U_PROFILE);
        request.setAttribute("profile", profile);
        jLogger.i("The profile is: " + profile);
        request.setAttribute("permissions", permissions);
        logActivity("MEMBER OPERATIONS", "Accessed administrative member operations", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed administrative member operations");
        request.getRequestDispatcher(REPO_FOLDER + "/member_operations.jsp").forward(request, response);
    }

    @EJB
    PageContentBeanI pageContentBeanI;

    private void showPageContent(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        List<PageContent> contents = pageContentBeanI.find();
        request.setAttribute("contents", contents);
        logActivity("PAGE CONTENT", "Accessed page content", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed page content");
        request.getRequestDispatcher(REPO_FOLDER + "/page_content.jsp").forward(request, response);
    }

    @EJB
    FaqContentBeanI faqContentBeanI;

    private void showFaqContent(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        List<FaqContent> contents = faqContentBeanI.find();
        request.setAttribute("contents", contents);
        logActivity("FAQ CONTENT", "Accessed faq content", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed faq content");
        request.getRequestDispatcher(REPO_FOLDER + "/faq_content.jsp").forward(request, response);
    }

    @EJB
    ContactCategoryBeanI contactCategoryBeanI;

    private void showContactReasons(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        List<ContactCategory> contactReasons = contactCategoryBeanI.find();
        request.setAttribute("contactReasons", contactReasons);
        logActivity("CONTACT CATEGORIES", "Viewed email contact categories", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed email contact categories");
        request.getRequestDispatcher(REPO_FOLDER + "/contact_reasons.jsp").forward(request, response);
    }

    private void showUserAccessReports(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        logActivity("USER ACCESS REPORTS", "Accessed user access reports", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed user access reports");
        request.getRequestDispatcher(REPO_FOLDER + "/user_access_reports.jsp").forward(request, response);
    }

    private void showAnalyticsReport(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        if (this.get(request, "report").equals("locked_user_accounts")) {
            List<User> users = userBeanI.findByStatus();
            request.setAttribute("users", users);
            Permission permissions = getPermissions(request);
            request.setAttribute("permissions", permissions);
            request.getRequestDispatcher(REPO_FOLDER + "/locked_accounts.jsp").forward(request, response);
        } else if (this.get(request, "report").equals("frequent_users")) {
            SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD, Locale.ENGLISH);
            String from = format.format(helper.dateFromString(this.get(request, "from"), DD_MM_YYYY));
            String to = format.format(helper.dateFromString(this.get(request, "to"), DD_MM_YYYY));
            List<AuditTrail> auditTrails = auditTrailBeanI.frequenters(from, to);
            request.setAttribute("users", auditTrails);
            request.getRequestDispatcher(REPO_FOLDER + "/frequent_users.jsp").forward(request, response);
        } else if (this.get(request, "report").equals("non_frequent_users")) {
            SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD, Locale.ENGLISH);
            List<User> users = userBeanI.dormants(format.format(helper.dateFromString(this.get(request, "from"), DD_MM_YYYY)), format.format(helper.dateFromString(this.get(request, "to"), DD_MM_YYYY)));
            request.setAttribute("users", users);
            request.getRequestDispatcher(REPO_FOLDER + "/non_frequent_users.jsp").forward(request, response);
        }
    }

    private void showSponsorView(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        Sponsor sponsor = sponsorBeanI.findById(helper.toLong(this.get(request, "id")));
        request.setAttribute("sponsor", sponsor);
        logActivity("PORTAL MEMBERS", "Viewed sponsor details for potential sponsor", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed sponsor details for a potential sponsor");
        request.getRequestDispatcher(REPO_FOLDER + "/VIEW_SPONSOR.jsp").forward(request, response);
    }

    private void showPortalMemberView(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        String memberID = this.get(request, "id");
        Member m = memberBeanI.findById(helper.toLong(memberID));
        request.setAttribute("member", m);
        logActivity("PORTAL MEMBERS", "Viewed member details for potential member", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member details for a potential member");
        request.getRequestDispatcher(REPO_FOLDER + "/VIEW_PORTAL_MEMBER.jsp").forward(request, response);
    }

    private void showPotentialMembers(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        String memberID = this.get(request, "id");
        Member m = memberBeanI.findById(helper.toLong(memberID));
        request.setAttribute("member", m);
        logActivity("PORTAL MEMBERS", "Viewed member details for potential member", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed member details for a potential member");
        request.getRequestDispatcher(REPO_FOLDER + "/VIEW_POTENTIAL_MEMBER.jsp").forward(request, response);
    }

    @EJB
    HelpBeanI helpBeanI;

    private void showHelp(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        List<Help> helps = helpBeanI.find();
        request.setAttribute("helps", helps);
        logActivity("HELP CONTENT", "Accessed help content", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed help content");
        request.getRequestDispatcher(REPO_FOLDER + "/help.jsp").forward(request, response);
    }

    private void showCalcLogs(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER, int BATCH, int PER_PAGE) throws ServletException, IOException {
        List<BenefitCalculation> calclogs = null;
        int page;
        try {
            page = Integer.parseInt(this.get(request, "page"));
        } catch (NumberFormatException nfe) {
            page = 1;
        }
        String search = this.get(request, "search");
        int batch;
        try {
            batch = Integer.parseInt(this.get(request, "batch"));
        } catch (NumberFormatException nfe) {
            batch = 1;
        }
        int start = (PER_PAGE * (page - 1)) * (batch - 1);
        int begin = ((batch * BATCH) - BATCH) + 1;
        if (begin < 1) {
            begin = 1;
        }
        request.setAttribute("begin", begin);
        request.setAttribute("batch", batch);
        request.setAttribute("page", page);
        request.setAttribute("per_page", PER_PAGE);
        request.setAttribute("search", search);
        calclogs = benefitsCalculationBeanI.findAll(start, PER_PAGE);
        int count = Constants.RECORD_COUNT;
        int pages = (count / PER_PAGE);
        request.setAttribute("pages", pages);
        request.setAttribute("calclogs", calclogs);
        logActivity("CALC-LOG", "Viewed Schemes", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Viewed Schemes");
        request.getRequestDispatcher(REPO_FOLDER + "/calc-log.jsp").forward(request, response);
    }
    @EJB
    BenefitsCalculationBeanI benefitsCalculationBeanI;
    @EJB
    MenuBeanI menuBeanI;

    private void showSetup(HttpServletRequest request, HttpServletResponse response, HttpSession session, String REPO_FOLDER) throws ServletException, IOException {
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Emails email = emailsBeanI.find();
        request.setAttribute("email", email);
        InterestRateColumns interest = interestRateColumnBeanI.find();
        request.setAttribute("interest", interest);
        Menu menu = menuBeanI.find();
        request.setAttribute("menu", menu);
        logActivity("SETUP", "Accessed setup menu and details", this.getSessKey(request, Constants.UID), this.getSessKey(request, Constants.SCHEME_ID), this.getSessKey(request, Constants.U_PROFILE));
        this.audit(session, "Accessed setup menu and details");
        request.getRequestDispatcher(REPO_FOLDER + "/setup.jsp").forward(request, response);
    }

}
