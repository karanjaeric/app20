package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.beans.ejbInterface.CompanyEJB;
import com.fundmaster.mss.beans.ejbInterface.CountryEJB;
import com.fundmaster.mss.beans.ejbInterface.GenderEJB;
import com.fundmaster.mss.beans.ejbInterface.HelpEJB;
import com.fundmaster.mss.beans.ejbInterface.MaritalStatusEJB;
import com.fundmaster.mss.beans.ejbInterface.MenuEJB;
import com.fundmaster.mss.beans.ejbInterface.PageContentEJB;
import com.fundmaster.mss.beans.ejbInterface.SchemeManagerEJB;
import com.fundmaster.mss.beans.ejbInterface.SettingEJB;
import com.fundmaster.mss.beans.ejbInterface.SocialEJB;
import com.fundmaster.mss.beans.ejbInterface.ThemeEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.Gender;
import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.MaritalStatus;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.PageContent;
import com.fundmaster.mss.model.Scheme;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;

@WebServlet(name = "PotentialMemberController", urlPatterns = {"/potential-member"})
public class PotentialMemberController extends HttpServlet implements Serializable {
	
	private static final String REQUEST_ACTION = "ACTION";
	
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
	SettingEJB settingEJB;
	
	@EJB
	PageContentEJB pageContentEJB;
	
	@EJB
	CountryEJB countryEJB;
	
	@EJB
	GenderEJB genderEJB;
	
	@EJB
	MaritalStatusEJB maritalStatusEJB;
	
	@EJB
	SchemeManagerEJB schemeManagerEJB;
	
	private static final long serialVersionUID = 1L;
	
	public PotentialMemberController() {
		super();
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
		Help help = helpEJB.findHelp(Constants.PAGE_POTENTIAL_MEMBER);
		request.setAttribute("help", help);
		Setting settings = settingEJB.find();
		request.setAttribute("settings", settings);
		List<Country> countries = countryEJB.find();
		request.setAttribute("countries",  countries);
		List<Gender> genders = genderEJB.find();
		request.setAttribute("genders",  genders);
		List<MaritalStatus> marital_statuses = maritalStatusEJB.find();
		request.setAttribute("maritalStatuses",  marital_statuses);
		
		List<Scheme> memberSchemes = null;
		/*try {
			memberSchemes = helper.getSchemes(0, 10000);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			memberSchemes = helper.getSchemeByPlanType("INDIVIDUAL_PENSION_FUND");
			
			
		} catch (JSONException e) {
		  e.printStackTrace();
		}
		
		request.setAttribute("memberSchemes", memberSchemes);
		
		PageContent content = pageContentEJB.findPageContent(Constants.PAGE_POTENTIAL_MEMBER);
		request.setAttribute("content", content);
		helper.logActivity(Constants.PAGE_POTENTIAL_MEMBER, "accesed Potential Member page", "0", null, null);
		request.getRequestDispatcher("potential-member.jsp").forward(request, response);
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
			
			if (request.getParameter(REQUEST_ACTION).equals("ADD_MEMBER")) {
				JSONObject result = helper.createMember(request);
				out.write(result.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
