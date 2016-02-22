package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.beans.ejbInterface.*;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.LOGGER;
import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.PageContent;

@WebServlet(name = "DataController", urlPatterns = {"/data"})
public class DataController extends HttpServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	Helper helper;
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
	LOGGER logger = new LOGGER(this.getClass());
	public DataController() {
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        	PrintWriter out = response.getWriter();
        	if(request.getParameter("DATA").equals("HELP"))
        	{
        		Help h = helpEJB.findById(helper.toLong(request.getParameter("ID")));
        		JSONObject obj = new JSONObject();
        		try {
					obj.put("id", h.getId())
					.put("page", h.getPage())
							.put("description", h.getDescription());
				} catch (JSONException je) {
					// TODO Auto-generated catch block
					logger.i("JSON Exception was detected: " + je.getMessage());
				}
        		out.write(obj.toString());
        	}
        	if(request.getParameter("DATA").equals("PAGE_CONTENT"))
        	{
        		PageContent h = pageContentEJB.findById(helper.toLong(request.getParameter("ID")));
        		JSONObject obj = new JSONObject();
        		try {
					obj.put("id", h.getId())
							.put("page", h.getPage())
							.put("text", h.getText())
							.put("position", h.getPosition())
							.put("publish", h.isPublish());
				} catch (JSONException je) {
					// TODO Auto-generated catch block
					logger.i("JSON Exception was detected: " + je.getMessage());
				}
        		out.write(obj.toString());
        	}
	}
}
