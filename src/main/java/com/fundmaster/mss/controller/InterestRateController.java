package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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


	public InterestRateController() {
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		Company company = getCompany();
		request.setAttribute("company", company);
		Social social = getSocial();
		request.setAttribute("social", social);
		List<Scheme> schemes = null;
		try {
			schemes = getSchemes(0, 10000);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("schemes", schemes);
		Menu menu = getMenu();
		request.setAttribute("menu", menu);
		Theme theme = getTheme();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		Help help = getHelpByPage(Common.PAGE_INTEREST_RATES);
		request.setAttribute("help", help);
		Setting settings = getSettings();
		request.setAttribute("settings", settings);
		PageContent content = getPageContentByPage(Common.PAGE_INTEREST_RATES);
		request.setAttribute("content", content);
		logActivity(Common.PAGE_INTEREST_RATES, "accesed interest rates page", "0", null, null);
		request.getRequestDispatcher("interest-rate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = response.getWriter();
		if(!request.getParameter("scheme").equals(null))
		{
			String interestRates = null;
			try {
				interestRates = getSchemeInterestRates(request.getParameter("scheme"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.write(interestRates);
			}
			catch (Exception ex)
			{
				try {
					out.write(result(false, "Failed to obtain interest rates history").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		/*Company company = getCompany();
		request.setAttribute("company", company);
		Social social = getSocial();
		request.setAttribute("social", social);
		List<Scheme> schemes = getSchemes();
		request.setAttribute("schemes", schemes);
		Menu menu = getMenu();
		request.setAttribute("menu", menu);
		Theme theme = getTheme();
		request.setAttribute("theme", theme);
		request.setAttribute("noMenu", false);
		request.getRequestDispatcher("interest-rate.jsp").forward(request, response);*/
		
	}

}
