package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.api.ApiEJB;

import com.fundmaster.mss.beans.CompanyBeanI;
import com.fundmaster.mss.beans.CountryBeanI;
import com.fundmaster.mss.beans.GenderBeanI;
import com.fundmaster.mss.beans.HelpBeanI;
import com.fundmaster.mss.beans.MaritalStatusBeanI;
import com.fundmaster.mss.beans.MenuBeanI;
import com.fundmaster.mss.beans.PageContentBeanI;
import com.fundmaster.mss.beans.SchemeManagerBeanI;
import com.fundmaster.mss.beans.SettingBeanI;
import com.fundmaster.mss.beans.SocialBeanI;
import com.fundmaster.mss.beans.ThemeBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.Gender;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.MaritalStatus;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.Scheme;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;

@WebServlet(name = "PotentialMemberController", urlPatterns = {"/potential-member"})
public class PotentialMemberController extends BaseServlet implements Serializable {
	
	private static final String REQUEST_ACTION = "ACTION";


	Helper helper = new Helper();
	
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
	SettingBeanI settingBeanI;
	
	@EJB
	PageContentBeanI pageContentBeanI;
	
	@EJB
	CountryBeanI countryBeanI;
	
	@EJB
	GenderBeanI genderBeanI;
	
	@EJB
	MaritalStatusBeanI maritalStatusBeanI;
	
	@EJB
	SchemeManagerBeanI schemeManagerBeanI;
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	ApiEJB apiEJB;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Company company = companyBeanI.find();
		request.setAttribute("company", company);
		Social social = socialBeanI.find();
		request.setAttribute("social", social);
		Menu menu = menuBeanI.find();
		request.setAttribute("menu", menu);
		Theme theme = themeBeanI.find();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = helpBeanI.findHelp(Constants.PAGE_POTENTIAL_MEMBER);
		request.setAttribute("help", help);
		Setting settings = settingBeanI.find();
		request.setAttribute("settings", settings);
		List<Country> countries = countryBeanI.find();
		request.setAttribute("countries",  countries);
		List<Gender> genders = genderBeanI.find();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = maritalStatusBeanI.find();
		request.setAttribute("maritalStatuses",  marital_statuses);
		
		List<Scheme> memberSchemes = apiEJB.getSchemeByPlanType("INDIVIDUAL_PENSION_FUND");
		request.setAttribute("memberSchemes", memberSchemes);
		
		PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_POTENTIAL_MEMBER);
		request.setAttribute("content", content);
		logActivity(Constants.PAGE_POTENTIAL_MEMBER, "accesed Potential Member page", "0", null, null);
		request.getRequestDispatcher("potential-member.jsp").forward(request, response);
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			if (this.get(request, REQUEST_ACTION).equals("ADD_MEMBER")) {
				this.createMember(request, response);
			}
		
	}

}
