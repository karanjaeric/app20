package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
@WebServlet(name = "WhatIfAnalysisController", urlPatterns = {"/what-if-analysis"})
public class WhatIfAnalysisController extends GenericController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	Helper helper;
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
	public WhatIfAnalysisController() {
		// TODO Auto-generated constructor stub
	}



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
		helper.logActivity(Constants.PAGE_WHAT_IF_ANALYSIS, "accesed what if analysis page", "0", null, null);
		request.getRequestDispatcher("what-if-analysis.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

    	PrintWriter out = response.getWriter();
    	
    	try {
    		String result = helper.queryWhatIfAnalysis(request.getParameter("yearsToProject"), request.getParameter("contributions"), request.getParameter("rateOfReturn"), request.getParameter("salaryEscalationRate"), request.getParameter("inflationRate"));
			out.write(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			try {
				out.write(helper.result(false, "An error was encountered processing your query. Please try again or contact the administrator").toString());
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(out);
			}
		}
	}
}
