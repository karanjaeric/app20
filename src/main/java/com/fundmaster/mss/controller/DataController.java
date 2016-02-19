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
import org.json.JSONObject;

import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.PageContent;

@WebServlet(name = "DataController", urlPatterns = {"/data"})
public class DataController extends GenericController {

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
					obj.put("id", h.getId());
				} catch (JSONException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
        		try {
					obj.put("page", h.getPage());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		try {
					obj.put("description", h.getDescription());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		out.write(obj.toString());
        	}
        	if(request.getParameter("DATA").equals("PAGE_CONTENT"))
        	{
        		PageContent h = pageContentEJB.findById(helper.toLong(request.getParameter("ID")));
        		JSONObject obj = new JSONObject();
        		try {
					obj.put("id", h.getId());
				} catch (JSONException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
        		try {
					obj.put("page", h.getPage());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		try {
					obj.put("text", h.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		try {
					obj.put("position", h.getPosition());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		try {
					obj.put("publish", h.isPublish());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		out.write(obj.toString());
        	}
	}
}
