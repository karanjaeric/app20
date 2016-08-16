package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import org.json.JSONException;
import org.json.JSONObject;

import com.fundmaster.mss.model.Help;
import com.fundmaster.mss.model.PageContent;

@WebServlet(name = "DataController", urlPatterns = {"/data"})
public class DataController extends BaseServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Helper helper = new Helper();
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
	private final JLogger JLogger = new JLogger(this.getClass());
	public DataController() {
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        	PrintWriter out = response.getWriter();
        	if(this.get(request, "DATA").equals("HELP"))
        	{
        		Help h = helpBeanI.findById(helper.toLong(this.get(request, "ID")));
        		JSONObject obj = new JSONObject();
        		try {
					obj.put("id", h.getId())
					.put("page", h.getPage())
							.put("description", h.getDescription());
				} catch (JSONException je) {
					// TODO Auto-generated catch block
					JLogger.i("JSON Exception was detected: " + je.getMessage());
				}
        		out.write(obj.toString());
        	}
        	if(this.get(request, "DATA").equals("PAGE_CONTENT"))
        	{
        		PageContent h = pageContentBeanI.findById(helper.toLong(this.get(request, "ID")));
        		JSONObject obj = new JSONObject();
        		try {
					obj.put("id", h.getId())
							.put("page", h.getPage())
							.put("text", h.getText())
							.put("position", h.getPosition())
							.put("publish", h.isPublish());
				} catch (JSONException je) {
					// TODO Auto-generated catch block
					JLogger.i("JSON Exception was detected: " + je.getMessage());
				}
        		out.write(obj.toString());
        	}
	}
}
