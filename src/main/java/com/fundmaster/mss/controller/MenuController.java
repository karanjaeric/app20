package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Actions;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@WebServlet(name = "MenuController", urlPatterns = {"/menu"})
public class MenuController extends BaseServlet implements Serializable {

    public MenuController() {
        // TODO Auto-generated constructor stub
    }
    private static final long serialVersionUID = 1L;

    Helper helper = new Helper();
    JLogger jLogger = new JLogger(this.getClass());

    @EJB
    ProfileNameBeanI profileNameBeanI;
    @EJB
    ClientNameBeanI clientNameBeanI;
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
    AccountRecoveryBeanI accountRecoveryBeanI;
    @EJB
    DBMenuBeanI dbMenuBeanI;
    @EJB
    DBGraphBeanI dbGraphBeanI;
    @EJB
    MemberMenuBeanI memberMenuBeanI;
    @EJB
    PensionerMenuBeanI pensionerMenuBeanI;
    @EJB
    MemberDashboardBeanI memberDashboardBeanI;
    @EJB
    AdminDashboardI adminDashboardI;
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
    ClientSetupI clientSetupI;
    @EJB
    ImageBannerBeanI imageBannerBeanI;
    @EJB
    LogoBeanI logoBeanI;
    @EJB
    PermissionBeanI permissionBeanI;
    @EJB
    PasswordPolicyBeanI passwordPolicyBeanI;
    @EJB
    InterestRateColumnBeanI interestRateColumnBeanI;
    @EJB
    SmtpI smtpBean;
    @EJB

    MemberPermissionBeanI memberPermissionBeanI;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        String REPO_FOLDER = "menu";
        String action = this.get(request, REPO_FOLDER);
        switch (action) {
            case Actions.DASHBOARD_SETUP:
                showSetup(request, response, REPO_FOLDER);
                break;
            case Actions.SCHEME:
                showScheme(request, response, REPO_FOLDER);
                break;
            case Actions.DASHBOARD_CALC_LOGS:
                showCalcLog(request, response, REPO_FOLDER);
                break;
            case Actions.CONTENT:
                showContent(request, response, REPO_FOLDER);
                break;
            case Actions.MEMBER:
                showMember(request, response, REPO_FOLDER);
                break;
            case Actions.MEDIA:
                showMedia(request, response, REPO_FOLDER);
                break;
            case Actions.UAC:
                showUserAccessControl(request, response, REPO_FOLDER);
                break;
            case Actions.ANALYTICS:
                showAnalytics(request, response, REPO_FOLDER);
                break;
        }
    }

    private void showAnalytics(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        request.getRequestDispatcher(REPO_FOLDER + "/analytics.jsp").forward(request, response);
    }

    private void showUserAccessControl(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        MemberPermission memberPermission = memberPermissionBeanI.find();
        request.setAttribute("memberPermission", memberPermission);
        DBMenu dbMenu = dbMenuBeanI.find();
        request.setAttribute("dbMenu", dbMenu);
        DBContributionGraph dbContributionGraph = dbGraphBeanI.find();
        request.setAttribute("dbContrGraph", dbContributionGraph);
        MemberMenu memberMenu = memberMenuBeanI.find();
        request.setAttribute("memberMenu", memberMenu);
        PensionerMenu pensionerMenu = pensionerMenuBeanI.find();
        request.setAttribute("pensionerMenu", pensionerMenu);
        MemberDashboardItems memberDashboardItems = memberDashboardBeanI.find();
        request.setAttribute("memberDashboard", memberDashboardItems);
        AdminDashboardItems adminDashboardItems = adminDashboardI.find();
        request.setAttribute("adminDashboard", adminDashboardItems);
        List<ProfileLoginField> pfs = profileLoginFieldBeanI.find();
        request.setAttribute("plfs", pfs);
        List<ClientSetup> clientSetups = clientSetupI.find();
        request.setAttribute("clientSetups", clientSetups);
        jLogger.i("Client clientSetups are >>>>>>>>>>> " + clientSetups + " <<<<<<<<<<<<<<");

        List<ProfileName> profileNames = profileNameBeanI.find();
        request.setAttribute("profileNames", profileNames);
        List<ClientName> clientNames = clientNameBeanI.find();
        request.setAttribute("clientNames", clientNames);
        jLogger.i("Client Names are >>>>>>>>>>> " + clientNames + " <<<<<<<<<<<<<<");
        List<Ordinal> ordinals = helper.getOrdinals();
        jLogger.i("Ordinals are >>>>>>>>>>> " + ordinals + " <<<<<<<<<<<<<<");
        request.setAttribute("ordinals", ordinals);
        List<ClientOrdinal> clientOrdinals = helper.getClientOrdinals();
        jLogger.i("Ordinals are >>>>>>>>>>> " + clientOrdinals + " <<<<<<<<<<<<<<");
        request.setAttribute("clientOrdinals", clientOrdinals);
        List<ClientSetup> clientsetup = clientSetupI.find();
        request.setAttribute("clientsetups", clientsetup);
        request.setAttribute("clientsetupsize", clientsetup.size());
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        PasswordPolicy policy = passwordPolicyBeanI.find();
        request.setAttribute("policy", policy);
        request.getRequestDispatcher(REPO_FOLDER + "/uac.jsp").forward(request, response);
    }

    private void showMedia(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        List<ProfileName> profiles = profileNameBeanI.find();
        request.setAttribute("profiles", profiles);
        List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
        request.setAttribute("schemes", schemes);

        String profile = this.getSessKey(request, Constants.U_PROFILE);
        request.setAttribute("profile", profile);
        jLogger.i("The profile is: " + profile);

        request.getRequestDispatcher(REPO_FOLDER + "/media.jsp").forward(request, response);
    }

    private void showMember(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        MemberMenu memberMenu = memberMenuBeanI.find();
        request.setAttribute("memberMenu", memberMenu);
        request.getRequestDispatcher(REPO_FOLDER + "/member.jsp").forward(request, response);
    }

    private void showContent(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        request.getRequestDispatcher(REPO_FOLDER + "/content.jsp").forward(request, response);
    }

    private void showCalcLog(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        request.getRequestDispatcher(REPO_FOLDER + "/calc-log.jsp").forward(request, response);
    }

    private void showScheme(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        request.getRequestDispatcher(REPO_FOLDER + "/scheme.jsp").forward(request, response);
    }

    private void showSetup(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        List<Country> countries = countryBeanI.find();
        request.setAttribute("countries", countries);
        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Emails email = emailsBeanI.find();
        request.setAttribute("email", email);
        Social social = socialBeanI.find();
        request.setAttribute("social", social);
        Menu menu = menuBeanI.find();
        AccountRecovery accountRecovery = accountRecoveryBeanI.find();
        request.setAttribute("accountRecovery", accountRecovery);
        request.setAttribute("menu", menu);
        DBMenu dbMenu = dbMenuBeanI.find();
        request.setAttribute("dbMenu", dbMenu);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        Theme theme = themeBeanI.find();
        request.setAttribute("theme", theme);
        List<ImageBanner> imageBanners = imageBannerBeanI.find();
        request.setAttribute("imageBanners", imageBanners);
        List<Logo> logos = logoBeanI.find();
        request.setAttribute("logos", logos);
        List<Ordinal> ordinals = helper.getOrdinals();
        request.setAttribute("ordinals", ordinals);
        InterestRateColumns irc = interestRateColumnBeanI.find();
        request.setAttribute("interestRateColumns", irc);
        SmtpSetup setup = smtpBean.getSmtpSetup();
        if(setup==null)
            setup=new SmtpSetup();
        request.setAttribute("setup",setup);
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        request.getRequestDispatcher(REPO_FOLDER + "/setup.jsp").forward(request, response);
    }
}
