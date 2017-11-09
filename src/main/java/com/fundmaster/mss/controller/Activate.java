package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Constants;
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

@WebServlet(name = "Activate", urlPatterns = {"/activate/*"})
public class Activate extends BaseServlet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -347116347501412506L;
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
    Helper helper = new Helper();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		User u = userBeanI.findBySecurityCode(request.getQueryString());
		if(u != null && !u.isStatus())
		{
			u.setStatus(true);
			userBeanI.edit(u);
			request.setAttribute("success", true);
			if(u.getUserProfile().equals(Constants.MEMBER_PROFILE))
				request.setAttribute("page", "sign-in");
			else
				request.setAttribute("page", "login");
		}
		else
		{
			request.setAttribute("success", false);
		}

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
		List<ImageBanner> imageBanners = imageBannerBeanI.find();
		request.setAttribute("imageBanners", imageBanners);
		List<Logo> logos = logoBeanI.find();
		request.setAttribute("logos", logos);
		Theme theme = themeBeanI.find();
		request.setAttribute("theme", theme);
		Help help = helpBeanI.findHelp(Constants.PAGE_HOME);
		request.setAttribute("help", help);
		PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_HOME);
		request.setAttribute("content", content);
		request.setAttribute("noMenu", false);
		request.getRequestDispatcher("activate.jsp").forward(request, response);
	}
}
