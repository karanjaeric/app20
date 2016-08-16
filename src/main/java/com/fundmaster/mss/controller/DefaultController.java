package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.beans.*;
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
	ActivityLogBeanI activityLogBeanI;
	@EJB
	ProfileNameBeanI profileNameBeanI;
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
	SocialBeanI socialBeanI;
	@EJB
	MenuBeanI menuBeanI;
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
	ImageBannerBeanI imageBannerBeanI;
	@EJB
	LogoBeanI logoBeanI;
	@EJB
	PermissionBeanI permissionBeanI;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		logActivity("HOME", "accesed home page", "0", null, null);
		List<Country> countries = countryBeanI.find();
		request.setAttribute("countries",  countries);
		List<Gender> genders = genderBeanI.find();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = maritalStatusBeanI.find();
		request.setAttribute("maritalStatuses",  marital_statuses);
		Company company = companyBeanI.find();
		request.setAttribute("company", company);
		Social social = socialBeanI.find();
		request.setAttribute("social", social);
		Setting settings = settingBeanI.find();
		request.setAttribute("settings", settings);
		String plf = profileLoginFieldBeanI.findByProfile(Constants.MEMBER_PROFILE);
		request.setAttribute("plf", plf);
		Menu menu = menuBeanI.find();
		request.setAttribute("menu", menu);
		List<com.fundmaster.mss.model.ImageBanner> imageBanners = imageBannerBeanI.find();
		request.setAttribute("imageBanners", imageBanners);
	
		Theme theme = themeBeanI.find();
		request.setAttribute("theme", theme);
		
		List<Logo> logos = logoBeanI.find();
		request.setAttribute("logos", logos);
		
		Help help = helpBeanI.findHelp(Constants.PAGE_HOME);
		request.setAttribute("help", help);
		PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_HOME);
		request.setAttribute("content", content);
		request.setAttribute("noMenu", false);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
	}

}
