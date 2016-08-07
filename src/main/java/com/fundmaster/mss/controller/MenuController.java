package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.ejb.*;
import com.fundmaster.mss.common.Actions;
import com.fundmaster.mss.common.Helper;
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
	@EJB
	ProfileNameEJB profileNameEJB;
    @EJB
    UserEJB userEJB;
    @EJB
    CountryEJB countryEJB;
    @EJB
    SettingEJB settingEJB;
    @EJB
    GenderEJB genderEJB;
    @EJB
    CompanyEJB companyEJB;
    @EJB
    SocialEJB socialEJB;
    @EJB
    MenuEJB menuEJB;
    @EJB
    ThemeEJB themeEJB;
    @EJB
    HelpEJB helpEJB;
    @EJB
    PageContentEJB pageContentEJB;
    @EJB
    MaritalStatusEJB maritalStatusEJB;
    @EJB
    ProfileLoginFieldEJB profileLoginFieldEJB;
    @EJB
	ImageBannerEJB imageBannerEJB;
    @EJB
    LogoEJB logoEJB;
    @EJB
    PermissionEJB permissionEJB;
    @EJB
    PasswordPolicyEJB passwordPolicyEJB;
	@EJB
	InterestRateColumnEJB interestRateColumnEJB;
    @EJB
    MemberPermissionEJB memberPermissionEJB;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        MemberPermission memberPermission = memberPermissionEJB.find();
        request.setAttribute("memberPermission", memberPermission);
        List<ProfileLoginField> pfs = profileLoginFieldEJB.find();
        request.setAttribute("plfs", pfs);
        List<ProfileName> profileNames = profileNameEJB.find();
        request.setAttribute("profileNames", profileNames);
        List<Ordinal> ordinals = helper.getOrdinals();
        request.setAttribute("ordinals", ordinals);
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        PasswordPolicy policy = passwordPolicyEJB.find();
        request.setAttribute("policy", policy);
        request.getRequestDispatcher(REPO_FOLDER + "/uac.jsp").forward(request, response);
    }
    private void showMedia(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
        List<ProfileName> profiles = profileNameEJB.find();
        request.setAttribute("profiles", profiles);
        request.getRequestDispatcher(REPO_FOLDER + "/media.jsp").forward(request, response);
    }
    private void showMember(HttpServletRequest request, HttpServletResponse response, String REPO_FOLDER) throws ServletException, IOException {
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
        List<Country> countries = countryEJB.find();
        request.setAttribute("countries",  countries);
        Company company = companyEJB.find();
        request.setAttribute("company", company);
        Social social = socialEJB.find();
        request.setAttribute("social", social);
        Menu menu = menuEJB.find();
        request.setAttribute("menu", menu);
        Setting settings = settingEJB.find();
        request.setAttribute("settings", settings);
        Theme theme = themeEJB.find();
        request.setAttribute("theme", theme);
        List<ImageBanner> imageBanners = imageBannerEJB.find();
        request.setAttribute("imageBanners", imageBanners);
        List<Logo> logos = logoEJB.find();
        request.setAttribute("logos", logos);
        List<Ordinal> ordinals = helper.getOrdinals();
        request.setAttribute("ordinals", ordinals);
        InterestRateColumns irc = interestRateColumnEJB.find();
        request.setAttribute("interestRateColumns", irc);
        Permission permissions = getPermissions(request);
        request.setAttribute("permissions", permissions);
        request.getRequestDispatcher(REPO_FOLDER + "/setup.jsp").forward(request, response);
    }
}
