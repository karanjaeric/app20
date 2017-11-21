package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
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

@WebServlet(name = "PotentialSponsorController", urlPatterns = {"/potential-sponsor"})
public class PotentialSponserController extends BaseServlet implements Serializable {
	
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
	SectorBeanI sectorBeanI;
	
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
		/* configuring the http headers */
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Frame-Options", "DENY");
		response.addHeader("X-Content-Type-Options", "nosniff");

		Company company = companyBeanI.find();
		request.setAttribute("company", company);
		Social social = socialBeanI.find();
		request.setAttribute("social", social);
		Menu menu = menuBeanI.find();
		request.setAttribute("menu", menu);
		Theme theme = themeBeanI.find();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = helpBeanI.findHelp(Constants.PAGE_POTENTIAL_SPONSOR);
		request.setAttribute("help", help);
		Setting settings = settingBeanI.find();
		request.setAttribute("settings", settings);
		
		List<Gender> genders = genderBeanI.find();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = maritalStatusBeanI.find();
		request.setAttribute("maritalStatuses",  marital_statuses);
		
		List<Sector> sectors = sectorBeanI.find();
		request.setAttribute("sectors", sectors);
		
		List<Country> countries = countryBeanI.find();
		request.setAttribute("countries",  countries);
		
		List<Scheme> sponsorSchemes = apiEJB.getSchemeBySchemeModeAndPlanType("UMBRELLA", "INDIVIDUAL_PENSION_FUND");

		request.setAttribute("sponsorSchemes", sponsorSchemes);
		
		PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_POTENTIAL_SPONSOR);
		request.setAttribute("content", content);
		logActivity(Constants.PAGE_POTENTIAL_SPONSOR, "accesed Potential Sponsor page", "0", null, null);
		request.getRequestDispatcher("potential-sponsor.jsp").forward(request, response);
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* configuring the http headers */
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Frame-Options", "DENY");
		response.addHeader("X-Content-Type-Options", "nosniff");
			
			if (this.get(request, REQUEST_ACTION).equals("ADD_SPONSOR")) {
				this.addSponsor(response, request);
			}
		
	}
	
	
	

}
