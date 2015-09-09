package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.fundmaster.mss.common.Common;
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

	public WhatIfAnalysisController() {
		// TODO Auto-generated constructor stub
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = getCompany();
		request.setAttribute("company", company);
		Social social = getSocial();
		request.setAttribute("social", social);
		Menu menu = getMenu();
		request.setAttribute("menu", menu);
		Theme theme = getTheme();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = getHelpByPage(Common.PAGE_WHAT_IF_ANALYSIS);
		request.setAttribute("help", help);
		PageContent content = getPageContentByPage(Common.PAGE_WHAT_IF_ANALYSIS);
		request.setAttribute("content", content);
		Setting settings = getSettings();
		request.setAttribute("settings", settings);
		logActivity(Common.PAGE_WHAT_IF_ANALYSIS, "accesed what if analysis page", "0", null, null);
		request.getRequestDispatcher("what-if-analysis.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

    	PrintWriter out = response.getWriter();
    	
    	try {
    		String result = queryWhatIfAnalysis(request.getParameter("yearsToProject").toString(), request.getParameter("contributions").toString(), request.getParameter("rateOfReturn").toString(), request.getParameter("salaryEscalationRate").toString(), request.getParameter("inflationRate").toString());
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
