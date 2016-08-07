package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.beans.ejb.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.*;

@WebServlet(name = "DefaultController", urlPatterns = {"/index"})
public class DefaultController extends BaseServlet implements Serializable {

	public DefaultController() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	Helper helper = new Helper();
	@EJB
	ActivityLogEJB activityLogEJB;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		logActivity("HOME", "accesed home page", "0", null, null);
		List<Country> countries = countryEJB.find();
		request.setAttribute("countries",  countries);
		List<Gender> genders = genderEJB.find();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = maritalStatusEJB.find();
		request.setAttribute("maritalStatuses",  marital_statuses);
		Company company = companyEJB.find();
		request.setAttribute("company", company);
		Social social = socialEJB.find();
		request.setAttribute("social", social);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		String plf = profileLoginFieldEJB.findByProfile(Constants.MEMBER_PROFILE);
		request.setAttribute("plf", plf);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		List<com.fundmaster.mss.model.ImageBanner> imageBanners = imageBannerEJB.find();
		request.setAttribute("imageBanners", imageBanners);
	
		Theme theme = themeEJB.find();
		request.setAttribute("theme", theme);
		
		List<Logo> logos = logoEJB.find();
		request.setAttribute("logos", logos);
		
		Help help = helpEJB.findHelp(Constants.PAGE_HOME);
		request.setAttribute("help", help);
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_HOME);
		request.setAttribute("content", content);
		request.setAttribute("noMenu", false);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
	}

}
