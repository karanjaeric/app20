package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.beans.ejbInterface.*;
import com.fundmaster.mss.common.Helper;
import org.json.JSONException;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.Scheme;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
@WebServlet(name = "InterestRateController", urlPatterns = {"/interest-rates"})
public class InterestRateController extends GenericController {

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

	public InterestRateController() {
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = helper.getCompany();
		request.setAttribute("company", company);
		Social social = helper.getSocial();
		request.setAttribute("social", social);
		List<Scheme> schemes = null;
		try {
			schemes = helper.getSchemes(0, 10000);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("schemes", schemes);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		Theme theme = themeEJB.find();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = helpEJB.findHelp(Constants.PAGE_INTEREST_RATES);
		request.setAttribute("help", help);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_INTEREST_RATES);
		request.setAttribute("content", content);
		helper.logActivity(Constants.PAGE_INTEREST_RATES, "accesed interest rates page", "0", null, null);
		request.getRequestDispatcher("interest-rate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = response.getWriter();
		if(request.getParameter("scheme") != null)
		{
			String interestRates = null;
			try {
				interestRates = helper.getSchemeInterestRates(request.getParameter("scheme"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.write(interestRates != null ? interestRates : null);
			}
			catch (Exception ex)
			{
				try {
					out.write(helper.result(false, "Failed to obtain interest rates history").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
