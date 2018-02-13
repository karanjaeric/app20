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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "WhatIfAnalysis", urlPatterns = {"/what-if-analysis"})
public class WhatIfAnalysis extends BaseServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Helper helper = new Helper();
	@EJB
	CompanyBeanI companyBeanI;
	@EJB
	EmailsBeanI emailsBeanI;
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
	SettingBeanI settingBeanI;

	@EJB
	ApiEJB apiEJB;

	private final JLogger jLogger = new JLogger(this.getClass());

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
		Help help = helpBeanI.findHelp(Constants.PAGE_WHAT_IF_ANALYSIS);
		request.setAttribute("help", help);
		PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_WHAT_IF_ANALYSIS);
		request.setAttribute("content", content);
		Setting settings = settingBeanI.find();
		request.setAttribute("settings", settings);
		logActivity(Constants.PAGE_WHAT_IF_ANALYSIS, "accesed what if analysis page", "0", null, null);
		request.getRequestDispatcher("what-if-analysis.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* configuring the http headers */
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Frame-Options", "DENY");
		response.addHeader("X-Content-Type-Options", "nosniff");
                
                DateFormat format_from = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
		DateFormat format = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);

		String fromDate_String = this.get(request, "dateOfCalc");
		String toDate_String = this.get(request, "dateOfExit");

		Date fromDate = null;
		Date toDate = null;

		try {
			fromDate = format_from.parse(fromDate_String);
			toDate = format_from.parse(toDate_String);
		} catch (ParseException pe) {
			// TODO Auto-generated catch block
			jLogger.e("ParseException was detected: " + pe.getMessage());
		}

		jLogger.i("From Date ================ > " + fromDate);
		jLogger.i("To Date ================ > " + toDate);

			this.respond(response, true, "", apiEJB.calculateBenefitsProjections(this.get(request, "schemeId"),
					this.get(request, "memberId"), format.format(fromDate),
					this.get(request, "reasonforexitid")));
					
	}
}
