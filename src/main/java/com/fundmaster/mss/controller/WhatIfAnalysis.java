package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.ejb.*;
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
@WebServlet(name = "WhatIfAnalysis", urlPatterns = {"/what-if-analysis"})
public class WhatIfAnalysis extends BaseServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Helper helper = new Helper();
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
	SettingEJB settingEJB;

	@EJB
	ApiEJB apiEJB;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = companyEJB.find();
		request.setAttribute("company", company);
		Social social = socialEJB.find();
		request.setAttribute("social", social);
		Menu menu = menuEJB.find();
		request.setAttribute("menu", menu);
		Theme theme = themeEJB.find();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = helpEJB.findHelp(Constants.PAGE_WHAT_IF_ANALYSIS);
		request.setAttribute("help", help);
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_WHAT_IF_ANALYSIS);
		request.setAttribute("content", content);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		logActivity(Constants.PAGE_WHAT_IF_ANALYSIS, "accesed what if analysis page", "0", null, null);
		request.getRequestDispatcher("what-if-analysis.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.respond(response, true, "", apiEJB.calculateWhatIfAnalysis(this.get(request, "yearsToProject"), this.get(request, "contributions"), this.get(request, "rateOfReturn"), this.get(request, "salaryEscalationRate"), this.get(request, "inflationRate"),this.get(request, "emailAddress"),this.get(request, "phoneNumber"),this.get(request, "yourAge")));
	}
}
