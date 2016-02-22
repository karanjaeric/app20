package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.beans.ejbInterface.*;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.Banner;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.InterestRateColumns;
import com.fundmaster.mss.model.MemberPermission;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.Ordinal;
import com.fundmaster.mss.model.PasswordPolicy;
import com.fundmaster.mss.model.Permission;
import com.fundmaster.mss.model.ProfileLoginField;
import com.fundmaster.mss.model.ProfileName;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
@WebServlet(name = "MenuController", urlPatterns = {"/menu"})
public class MenuController extends HttpServlet implements Serializable {
	public MenuController() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
    @EJB
    Helper helper;
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
    BannerEJB bannerEJB;
    @EJB
    PermissionEJB permissionEJB;
    @EJB
    PasswordPolicyEJB passwordPolicyEJB;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String REPO_FOLDER = "menu";
		if(request.getParameter(REPO_FOLDER).toUpperCase().equals("SETUP".toUpperCase()))
		{
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
			List<Banner> banners = bannerEJB.find();
			request.setAttribute("banners", banners);
			List<Ordinal> ordinals = helper.getOrdinals();
			request.setAttribute("ordinals", ordinals);
			InterestRateColumns irc = helper.getInterestRateColumns();
			request.setAttribute("interestRateColumns", irc);
			Permission permissions = helper.getPermissions(request);
			request.setAttribute("permissions", permissions);
			request.getRequestDispatcher(REPO_FOLDER + "/setup.jsp").forward(request, response);
		}
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("SCHEME".toUpperCase()))
			request.getRequestDispatcher(REPO_FOLDER + "/scheme.jsp").forward(request, response);
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("CONTENT".toUpperCase()))
		{
			Permission permissions = helper.getPermissions(request);
			request.setAttribute("permissions", permissions);
			request.getRequestDispatcher(REPO_FOLDER + "/content.jsp").forward(request, response);
		}
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEMBER".toUpperCase()))
			request.getRequestDispatcher(REPO_FOLDER + "/member.jsp").forward(request, response);
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEDIA".toUpperCase()))
		{
			List<ProfileName> profiles = profileNameEJB.find();
			request.setAttribute("profiles", profiles);
			request.getRequestDispatcher(REPO_FOLDER + "/media.jsp").forward(request, response);
		}
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("UAC".toUpperCase()))
		{
			MemberPermission memberPermission = helper.getMemberPermissions();
			request.setAttribute("memberPermission", memberPermission);
			List<ProfileLoginField> pfs = helper.getProfileLoginFields();
			request.setAttribute("plfs", pfs);
			List<ProfileName> profileNames = profileNameEJB.find();
			request.setAttribute("profileNames", profileNames);
			List<Ordinal> ordinals = helper.getOrdinals();
			request.setAttribute("ordinals", ordinals);
			Permission permissions = helper.getPermissions(request);
			request.setAttribute("permissions", permissions);
			PasswordPolicy policy = passwordPolicyEJB.find();
			request.setAttribute("policy", policy);
			request.getRequestDispatcher(REPO_FOLDER + "/uac.jsp").forward(request, response);
		}
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("ANALYTICS".toUpperCase()))
			request.getRequestDispatcher(REPO_FOLDER + "/analytics.jsp").forward(request, response);
	}
}
