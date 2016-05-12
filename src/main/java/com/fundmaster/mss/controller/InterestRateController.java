package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.ejbInterface.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.LOGGER;
import com.fundmaster.mss.model.*;
import org.json.JSONException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
@WebServlet(name = "InterestRateController", urlPatterns = {"/interest-rates"})
public class InterestRateController extends HttpServlet implements Serializable {

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
	LOGGER logger = new LOGGER(this.getClass());
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
		} catch (JSONException je) {
			// TODO Auto-generated catch block
			logger.i("JSON Exception was detected: " + je.getMessage());
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
				System.out.println("Interest rates "+interestRates);
				out.write(interestRates);
			}
			catch (NullPointerException npe)
			{
					out.write(helper.result(false, "Failed to obtain interest rates history").toString());

			}
		}
		
	}

}
