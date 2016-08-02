package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.beans.ejb.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
@WebServlet(name = "Contact", urlPatterns = {"/contact-us"})
public class Contact extends HttpServlet implements Serializable {

	/**
	 * 
	 */
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
	public Contact() {
		// TODO Auto-generated constructor stub
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = companyEJB.find();
		request.setAttribute("company", company);
		Social social = socialEJB.find();
		request.setAttribute("social", social);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		Theme theme = themeEJB.find();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = helpEJB.findHelp(Constants.PAGE_CONTACT_US);
		request.setAttribute("help", help);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_CONTACT_US);
		request.setAttribute("content", content);
		helper.logActivity(Constants.PAGE_CONTACT_US, "accesed contact us page", "0", null, null);
		request.getRequestDispatcher("contact-us.jsp").forward(request, response);
	}
}
