package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.fundmaster.mss.common.Common;
import com.fundmaster.mss.model.AnnuityProduct;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.Gender;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.MaritalStatus;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
import com.fundmaster.mss.service.GenderService;
@WebServlet(name = "AnnuityController", urlPatterns = {"/annuity-quotation"})
public class AnnuityController extends GenericController{

	private static final String YYYY_MM_DD = "yyyy-MM-dd";
	private static final String DD_MM_YYYY = "dd-MM-yyyy";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnnuityController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = getCompany();
		request.setAttribute("company", company);
		Setting settings = getSettings();
		request.setAttribute("settings", settings);
		Social social = getSocial();
		request.setAttribute("social", social);
		Menu menu = getMenu();
		request.setAttribute("menu", menu);
		Theme theme = getTheme();
		request.setAttribute("theme", theme);
		List<Country> countries = getCountries();
		request.setAttribute("countries",  countries);
		List<Gender> genders = getGenders();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = getMaritalStatuses();
		request.setAttribute("maritalStatuses",  marital_statuses);
		List<AnnuityProduct> annuityProducts = null;
		try {
			annuityProducts = getAnnuityProducts();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("annuityProducts", annuityProducts);
		request.setAttribute("noMenu", false);
		Help help = getHelpByPage(Common.PAGE_ANNUITY_QUOTATION);
		request.setAttribute("help", help);
		PageContent content = getPageContentByPage(Common.PAGE_ANNUITY_QUOTATION);
		request.setAttribute("content", content);
		logActivity(Common.PAGE_ANNUITY_QUOTATION, "accesed annuity quotation page", "0", null, null);
		request.getRequestDispatcher("annuity-quotation.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	String[] names = request.getParameter("fullName").toString().split(" ");
    	String firstName, lastName, otherNames;
    	try
    	{
    		firstName = names[0];
    	}
    	catch (Exception ex)
    	{
    		firstName = "";
    	}
    	try
    	{
    		lastName = names[1];
    	}
    	catch (Exception ex)
    	{
    		lastName = "";
    	}
    	try
    	{
    		otherNames = names[2];
    	}
    	catch (Exception ex)
    	{
    		otherNames = "";
    	}
		DateFormat format = new SimpleDateFormat(DD_MM_YYYY, Locale.ENGLISH);
		Date purchaseDate = null;
		Date pensionStartDate = null;
		Date dateOfBirth = null;
		Date spouseDateOfBirth = null;

    	purchaseDate = dateFromString(request.getParameter("purchaseDate"), DD_MM_YYYY);
    	pensionStartDate = dateFromString(request.getParameter("commencementDate"), DD_MM_YYYY);

    	dateOfBirth = dateFromString(request.getParameter("dateOfBirth"), DD_MM_YYYY);
		spouseDateOfBirth = dateFromString(request.getParameter("spouseDateOfBirth"), DD_MM_YYYY);
		format = new SimpleDateFormat(YYYY_MM_DD, Locale.ENGLISH);
		String calculationMode = request.getParameter("calculationMode");
		String targetPension = request.getParameter("targetPension");
		String spouseReversal = request.getParameter("spouseReversal");
		Gender gender = new GenderService().findById(Long.valueOf(request.getParameter("gender").toString()).longValue());
		Gender spouseGender = new GenderService().findById(Long.valueOf(request.getParameter("gender").toString()).longValue());
    	try {
    		String result = getAnnuityQuote("0", calculationMode, request.getParameter("annuityProduct"), lastName, firstName, otherNames, request.getParameter("idNumber"), request.getParameter("residentialAddress"), request.getParameter("emailAddress"), request.getParameter("phoneNumber"), format.format(purchaseDate), format.format(pensionStartDate), format.format(dateOfBirth), gender.getName(), request.getParameter("guaranteePeriod"), request.getParameter("annualPensionIncrease"), request.getParameter("paymentMode"), request.getParameter("paymentFrequency"), request.getParameter("registeredPurchasePrice"), request.getParameter("unRegPurchasePrice").toString(), targetPension, request.getParameter("annuityMode"), spouseReversal, spouseGender.getName(), format.format(spouseDateOfBirth));
			out.write(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			try {
				out.write(result(false, "An error was encountered processing your query. Please try again or contact the administrator").toString());
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(out);
			}
		}
		
	}

}
