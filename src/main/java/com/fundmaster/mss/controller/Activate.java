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

import com.fundmaster.mss.beans.ejb.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.Banner;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.Gender;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.Logo;
import com.fundmaster.mss.model.MaritalStatus;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
import com.fundmaster.mss.model.User;

@WebServlet(name = "Activate", urlPatterns = {"/activate/*"})
public class Activate extends HttpServlet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -347116347501412506L;
    @EJB
	Helper helper;
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
    LogoEJB logoEJB;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		User u = userEJB.findBySecurityCode(request.getQueryString());
		if(u != null && !u.isStatus())
		{
			u.setStatus(true);
			userEJB.edit(u);
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
		String plf = helper.getLoginField(Constants.MEMBER_PROFILE);
		request.setAttribute("plf", plf);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		List<Banner> banners = bannerEJB.find();
		request.setAttribute("banners", banners);
		List<Logo> logos = logoEJB.find();
		request.setAttribute("logos", logos);
		/*List<Logo> logos = logoEJB.find();
		request.setAttribute("logos", logos);*/
		Theme theme = themeEJB.find();
		request.setAttribute("theme", theme);
		Help help = helpEJB.findHelp(Constants.PAGE_HOME);
		request.setAttribute("help", help);
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_HOME);
		request.setAttribute("content", content);
		request.setAttribute("noMenu", false);
		request.getRequestDispatcher("activate.jsp").forward(request, response);
	}
}
