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

import com.fundmaster.mss.beans.ejb.CompanyEJB;
import com.fundmaster.mss.beans.ejb.CountryEJB;
import com.fundmaster.mss.beans.ejb.GenderEJB;
import com.fundmaster.mss.beans.ejb.HelpEJB;
import com.fundmaster.mss.beans.ejb.MaritalStatusEJB;
import com.fundmaster.mss.beans.ejb.MenuEJB;
import com.fundmaster.mss.beans.ejb.PageContentEJB;
import com.fundmaster.mss.beans.ejb.SchemeManagerEJB;
import com.fundmaster.mss.beans.ejb.SettingEJB;
import com.fundmaster.mss.beans.ejb.SocialEJB;
import com.fundmaster.mss.beans.ejb.ThemeEJB;
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
	SettingEJB settingEJB;
	
	@EJB
	PageContentEJB pageContentEJB;
	
	@EJB
	CountryEJB countryEJB;
	
	@EJB
	GenderEJB genderEJB;
	
	@EJB
	MaritalStatusEJB maritalStatusEJB;
	
	@EJB
	SchemeManagerEJB schemeManagerEJB;
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	ApiEJB apiEJB;
	
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
		Help help = helpEJB.findHelp(Constants.PAGE_POTENTIAL_MEMBER);
		request.setAttribute("help", help);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		List<Country> countries = countryEJB.find();
		request.setAttribute("countries",  countries);
		List<Gender> genders = genderEJB.find();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = maritalStatusEJB.find();
		request.setAttribute("maritalStatuses",  marital_statuses);
		
		List<Scheme> memberSchemes = apiEJB.getSchemeByPlanType("INDIVIDUAL_PENSION_FUND");
		request.setAttribute("memberSchemes", memberSchemes);
		
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_POTENTIAL_MEMBER);
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
