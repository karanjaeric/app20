package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.ejb.*;
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
import java.util.List;
@WebServlet(name = "InterestRateController", urlPatterns = {"/interest-rates"})
public class InterestRateController extends BaseServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Helper helper = new Helper();
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
	InterestRateColumnEJB interestEJB;
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
	PermissionEJB permissionEJB;
	JLogger JLogger = new JLogger(this.getClass());
	@EJB
	ApiEJB apiEJB;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = companyEJB.find();
		request.setAttribute("company", company);
		Social social = socialEJB.find();
		request.setAttribute("social", social);
		List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
		request.setAttribute("schemes", schemes);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		InterestRateColumns interest = interestEJB.find();
		request.setAttribute("interest", interest);
		Theme theme = themeEJB.find();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = helpEJB.findHelp(Constants.PAGE_INTEREST_RATES);
		request.setAttribute("help", help);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_INTEREST_RATES);
		request.setAttribute("content", content);
		logActivity(Constants.PAGE_INTEREST_RATES, "accesed interest rates page", "0", null, null);
		request.getRequestDispatcher("interest-rate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(this.get(request, "scheme") != null)
		{
			this.respond(response, true, "", apiEJB.getSchemeInterestRates(this.get(request, "scheme")));
		}
		
	}

}
