package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PotentialMemberController", urlPatterns = {"/potential-member"})
public class PotentialMemberController extends BaseServlet implements Serializable {
	
	private static final String REQUEST_ACTION = "ACTION";

	JLogger jLogger = new JLogger(this.getClass());


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
		
		/*List<Scheme> memberSchemes = apiEJB.getSchemeByPlanType("INDIVIDUAL_PENSION_FUND");
		request.setAttribute("memberSchemes", memberSchemes);*/

		List<Scheme> memberSchemes1 = new ArrayList<>();
		List<Scheme> memberSchemes2 = new ArrayList<>();
		try {
			memberSchemes1 = apiEJB.getSchemeByPlanType("SAVINGS_AND_RETIREMENT");
			memberSchemes2 = apiEJB.getSchemeByPlanType("INDIVIDUAL_PENSION_FUND");
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		List<Scheme> allSchemes = new ArrayList<Scheme>();
		if (memberSchemes1 != null) {
			allSchemes.addAll(memberSchemes1);
		}
		if (memberSchemes2 != null) {
			allSchemes.addAll(memberSchemes2);
		}
		request.setAttribute("memberSchemes", allSchemes);
		
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
