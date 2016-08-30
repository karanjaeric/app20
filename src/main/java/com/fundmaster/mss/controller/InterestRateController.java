package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;
import org.json.JSONException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
	ProfileNameBeanI profileNameBeanI;
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
	InterestRateColumnBeanI interestEJB;
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
	PermissionBeanI permissionBeanI;
	JLogger JLogger = new JLogger(this.getClass());
	@EJB
	ApiEJB apiEJB;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = companyBeanI.find();
		request.setAttribute("company", company);
		Social social = socialBeanI.find();
		request.setAttribute("social", social);
		List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
		request.setAttribute("schemes", schemes);
		Menu menu = menuBeanI.find();
		request.setAttribute("menu", menu);
		InterestRateColumns interest = interestEJB.find();
		request.setAttribute("interest", interest);
		Theme theme = themeBeanI.find();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = helpBeanI.findHelp(Constants.PAGE_INTEREST_RATES);
		request.setAttribute("help", help);
		Setting settings = settingBeanI.find();
		request.setAttribute("settings", settings);
		PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_INTEREST_RATES);
		request.setAttribute("content", content);
		logActivity(Constants.PAGE_INTEREST_RATES, "accesed interest rates page", "0", null, null);
		request.getRequestDispatcher("interest-rate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		if(this.get(request, "scheme") != null)
		{
			//this.respond(response, true, "", apiEJB.getSchemeInterestRates(this.get(request, "scheme")));

			String interestRates = null;
			try {
				interestRates = apiEJB.getSchemeInterestRates(request.getParameter("scheme"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Interest rates "+interestRates);
				out.write(interestRates);
			}
			catch (NullPointerException npe)
			{
				//out.write(this.respond(response, false, "Failed to obtain interest rates history", null));

			}
		}
		
	}

}
