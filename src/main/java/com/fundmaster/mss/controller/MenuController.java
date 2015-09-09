package com.fundmaster.mss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.model.Banner;
import com.fundmaster.mss.model.Company;
import com.fundmaster.mss.model.Country;
import com.fundmaster.mss.model.InterestRateColumns;
import com.fundmaster.mss.model.MemberPermission;
import com.fundmaster.mss.model.Menu;
import com.fundmaster.mss.model.Ordinal;
import com.fundmaster.mss.model.PasswordPolicy;
import com.fundmaster.mss.model.Permission;
import com.fundmaster.mss.model.ProfileLoginField;
import com.fundmaster.mss.model.Setting;
import com.fundmaster.mss.model.Social;
import com.fundmaster.mss.model.Theme;
@WebServlet(name = "MenuController", urlPatterns = {"/menu"})
public class MenuController extends GenericController {
	String REPO_FOLDER = "menu";
	public MenuController() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		if(request.getParameter(REPO_FOLDER).toUpperCase().equals("SETUP".toUpperCase()))
		{
			List<Country> countries = getCountries();
			request.setAttribute("countries",  countries);
			Company company = getCompany();
			request.setAttribute("company", company);
			Social social = getSocial();
			request.setAttribute("social", social);
			Menu menu = getMenu();
			request.setAttribute("menu", menu);
			Setting settings = getSettings();
			request.setAttribute("settings", settings);
			Theme theme = getTheme();
			request.setAttribute("theme", theme);
			List<Banner> banners = getBanners();
			request.setAttribute("banners", banners);
			List<Ordinal> ordinals = getOrdinals();
			request.setAttribute("ordinals", ordinals);
			InterestRateColumns irc = getInterestRateColumns();
			request.setAttribute("interestRateColumns", irc);
			Permission permissions = getPermissions(request);
			request.setAttribute("permissions", permissions);
			request.getRequestDispatcher(REPO_FOLDER + "/setup.jsp").forward(request, response);
		}
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("SCHEME".toUpperCase()))
			request.getRequestDispatcher(REPO_FOLDER + "/scheme.jsp").forward(request, response);
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("CONTENT".toUpperCase()))
		{
			Permission permissions = getPermissions(request);
			request.setAttribute("permissions", permissions);
			request.getRequestDispatcher(REPO_FOLDER + "/content.jsp").forward(request, response);
		}
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEMBER".toUpperCase()))
			request.getRequestDispatcher(REPO_FOLDER + "/member.jsp").forward(request, response);
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("MEDIA".toUpperCase()))
				request.getRequestDispatcher(REPO_FOLDER + "/media.jsp").forward(request, response);
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("UAC".toUpperCase()))
		{
			MemberPermission memberPermission = getMemberPermissions();
			request.setAttribute("memberPermission", memberPermission);
			List<ProfileLoginField> pfs = getProfileLoginFields();
			request.setAttribute("plfs", pfs);
			List<Ordinal> ordinals = getOrdinals();
			request.setAttribute("ordinals", ordinals);
			Logger.getAnonymousLogger().info(ordinals.get(0).getCode());
			Permission permissions = getPermissions(request);
			request.setAttribute("permissions", permissions);
			PasswordPolicy policy = getPasswordPolicy();
			request.setAttribute("policy", policy);
			request.getRequestDispatcher(REPO_FOLDER + "/uac.jsp").forward(request, response);
		}
		else if(request.getParameter(REPO_FOLDER).toUpperCase().equals("ANALYTICS".toUpperCase()))
			request.getRequestDispatcher(REPO_FOLDER + "/analytics.jsp").forward(request, response);
	}
}
