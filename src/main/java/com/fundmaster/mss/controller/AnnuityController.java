package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.ejbInterface.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
@WebServlet(name = "AnnuityController", urlPatterns = {"/annuity-quotation"})
public class AnnuityController extends HttpServlet implements Serializable {
	@EJB
	Helper helper;
	private static final String YYYY_MM_DD = "yyyy-MM-dd";
	private static final String DD_MM_YYYY = "dd-MM-yyyy";
	/**
	 * 
	 */
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
	private static final long serialVersionUID = 1L;

	public AnnuityController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = companyEJB.find();
		request.setAttribute("company", company);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		Social social = socialEJB.find();
		request.setAttribute("social", social);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		Theme theme = themeEJB.find();
		request.setAttribute("theme", theme);
		List<Country> countries = countryEJB.find();
		request.setAttribute("countries",  countries);
		List<Gender> genders = genderEJB.find();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = maritalStatusEJB.find();
		request.setAttribute("maritalStatuses",  marital_statuses);
		List<AnnuityProduct> annuityProducts = null;
		try {
			annuityProducts = helper.getAnnuityProducts();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("annuityProducts", annuityProducts);
		request.setAttribute("noMenu", false);
		Help help = helpEJB.findHelp(Constants.PAGE_ANNUITY_QUOTATION);
		request.setAttribute("help", help);
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_ANNUITY_QUOTATION);
		request.setAttribute("content", content);
		helper.logActivity(Constants.PAGE_ANNUITY_QUOTATION, "accesed annuity quotation page", "0", null, null);
		request.getRequestDispatcher("annuity-quotation.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	String[] names = request.getParameter("fullName").split(" ");
    	String firstName, lastName, otherNames;
        firstName = lastName = otherNames = null;
		if(names.length > 0)
		{
			firstName = names[0];
		}
        if(names.length > 1)
        {
            lastName = names[1];
        }
        if(names.length > 2)
        {
            otherNames = names[2];
        }
        else if(names.length ==  0)
        {
            firstName = "";
            lastName = "";
            otherNames = "";
        }

		DateFormat format = new SimpleDateFormat(DD_MM_YYYY, Locale.ENGLISH);
		Date purchaseDate;
		Date pensionStartDate;
		Date dateOfBirth;
		Date spouseDateOfBirth;

    	purchaseDate = helper.dateFromString(request.getParameter("purchaseDate"), DD_MM_YYYY);
    	pensionStartDate = helper.dateFromString(request.getParameter("commencementDate"), DD_MM_YYYY);

    	dateOfBirth = helper.dateFromString(request.getParameter("dateOfBirth"), DD_MM_YYYY);
		spouseDateOfBirth = helper.dateFromString(request.getParameter("spouseDateOfBirth"), DD_MM_YYYY);
		format = new SimpleDateFormat(YYYY_MM_DD, Locale.ENGLISH);
		String calculationMode = request.getParameter("calculationMode");
		String targetPension = request.getParameter("targetPension");
		String spouseReversal = request.getParameter("spouseReversal");
		Gender gender = helper.genderById(Long.valueOf(request.getParameter("gender")));
		Gender spouseGender = helper.genderById(Long.valueOf(request.getParameter("gender")));
    	try {
    		String result = helper.getAnnuityQuote(calculationMode, request.getParameter("annuityProduct"), lastName, firstName, otherNames, request.getParameter("idNumber"), request.getParameter("residentialAddress"), request.getParameter("emailAddress"), request.getParameter("phoneNumber"), format.format(purchaseDate), format.format(pensionStartDate), format.format(dateOfBirth), gender.getName(), request.getParameter("guaranteePeriod"), request.getParameter("annualPensionIncrease"), request.getParameter("paymentMode"), request.getParameter("paymentFrequency"), request.getParameter("registeredPurchasePrice"), request.getParameter("unRegPurchasePrice"), targetPension, request.getParameter("annuityMode"), spouseReversal, spouseGender.getName(), format.format(spouseDateOfBirth==null?new Date():spouseDateOfBirth));
			out.write(result);
		} catch (JSONException e) {

				out.write(helper.result(false, "An error was encountered processing your query. Please try again or contact the administrator").toString());

		}
		
	}
	
}
