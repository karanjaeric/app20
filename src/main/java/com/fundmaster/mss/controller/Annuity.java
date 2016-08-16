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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "Annuity", urlPatterns = {"/annuity-quotation"})
public class Annuity extends BaseServlet implements Serializable {

	Helper helper = new Helper();
	private static final String YYYY_MM_DD = "yyyy-MM-dd";
	private static final String DD_MM_YYYY = "dd-MM-yyyy";
	/**
	 * 
	 */
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
	private static final long serialVersionUID = 1L;
	@EJB
	ApiEJB apiEJB;
	private final JLogger jLogger = new JLogger(this.getClass());
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = companyBeanI.find();
		request.setAttribute("company", company);
		Setting settings = settingBeanI.find();
		request.setAttribute("settings", settings);
		Social social = socialBeanI.find();
		request.setAttribute("social", social);
		Menu menu = menuBeanI.find();
		request.setAttribute("menu", menu);
		Theme theme = themeBeanI.find();
		request.setAttribute("theme", theme);
		List<Country> countries = countryBeanI.find();
		request.setAttribute("countries",  countries);
		List<Gender> genders = genderBeanI.find();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = maritalStatusBeanI.find();
		request.setAttribute("maritalStatuses",  marital_statuses);
		List<AnnuityProduct> annuityProducts;
		annuityProducts = apiEJB.getAnnuityProducts();
		jLogger.i("The Annuity Products passed: " + annuityProducts);
		request.setAttribute("annuityProducts", annuityProducts);
		request.setAttribute("noMenu", false);
		Help help = helpBeanI.findHelp(Constants.PAGE_ANNUITY_QUOTATION);
		request.setAttribute("help", help);
		PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_ANNUITY_QUOTATION);
		request.setAttribute("content", content);
		logActivity(Constants.PAGE_ANNUITY_QUOTATION, "accesed annuity quotation page", "0", null, null);
		request.getRequestDispatcher("annuity-quotation.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	DateFormat format;
		Date purchaseDate;
		Date pensionStartDate;
		Date dateOfBirth;
		Date spouseDateOfBirth;

    	purchaseDate = helper.dateFromString(this.get(request, "purchaseDate"), DD_MM_YYYY);
    	
    	jLogger.i("************* Purchase date is: " + purchaseDate+ " ***********************");
    	
    	pensionStartDate = helper.dateFromString(this.get(request, "commencementDate"), DD_MM_YYYY);
    	
    	jLogger.i("************* Pension start date is: " + pensionStartDate+ " ***********************");
    	
    	format = new SimpleDateFormat(YYYY_MM_DD, Locale.ENGLISH);

    	dateOfBirth = helper.dateFromString(this.get(request, "dateOfBirth"), DD_MM_YYYY);
    	
    	jLogger.i("************* Date of birth is: " + dateOfBirth+ " ***********************");
    	
    	spouseDateOfBirth = helper.dateFromString(this.get(request, "spouseDateOfBirth"), DD_MM_YYYY);
    	
    	jLogger.i("************* Spouse Date of birth is: " + spouseDateOfBirth+ " ***********************");
		if(spouseDateOfBirth == null) {
        		spouseDateOfBirth = new Date();
		}
    	
    	
    	//String firstName, lastName, otherNames;
    	
    	String firstName = this.get(request, "firstName");
    	String lastName = this.get(request, "lastName");
    	String otherNames = this.get(request, "otherNames");
    		
		if(otherNames == null) {

			otherNames = "";
		}

		jLogger.i("************* Other name is: " + otherNames+ " ***********************");

    	
		String calculationMode = this.get(request, "calculationMode");
		
		jLogger.i("************* Calculation Mode is : " + calculationMode + " ***********************");
		
		String targetPension = this.get(request, "targetPension");
		
		jLogger.i("************* Target Pension is : " + targetPension + " ***********************");
		
		String spouseReversal = this.get(request, "spouseReversal");
		
		jLogger.i("************* Spouse reversal is : " + spouseReversal + " ***********************");
		
		Boolean displayable = Boolean.TRUE;
		
		
		//Boolean displayable = Boolean.valueOf(this.get(request, "displayable") != null);
				
		jLogger.i("Value of displayable is :::::::::::::::::::::::::::>  " + displayable);
		
		Gender gender = genderBeanI.findById(helper.toLong(this.get(request, "gender")));
		
		jLogger.i("************* Gender is : " + gender.getName() + " ***********************");
		
		Gender spouseGender = genderBeanI.findById(helper.toLong(this.get(request, "spouseGender")));
		
		jLogger.i("************* Spouse Gender is : " + spouseGender.getName() + " ***********************");
		
		String productID = this.get(request, "annuityProduct");
		jLogger.i("************* Product Id is : " + productID + " ***********************");
		this.respond(response, true, "", apiEJB.getAnnuityQuote(calculationMode, productID, lastName, firstName, otherNames, this.get(request, "idNumber"), this.get(request, "residentialAddress"), this.get(request, "emailAddress"), this.get(request, "phoneNumber"), format.format(purchaseDate), format.format(pensionStartDate), format.format(dateOfBirth), gender.getName(), this.get(request, "guaranteePeriod"), this.get(request, "annualPensionIncrease"), this.get(request, "paymentMode"), this.get(request, "paymentFrequency"), this.get(request, "registeredPurchasePrice"), this.get(request, "unRegPurchasePrice"), targetPension, this.get(request, "annuityMode"), spouseReversal, displayable, spouseGender.getName(), format.format(spouseDateOfBirth)));
		
	}
	
}
