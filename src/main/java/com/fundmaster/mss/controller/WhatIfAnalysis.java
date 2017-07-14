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
import java.util.ArrayList;
import java.util.List;

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

		Setting settings = settingBeanI.find();
		String formula = settings.getWhatIfAnalysisFormula();
		jLogger.i("The formula is: " + formula);

		Emails email = emailsBeanI.find();
		jLogger.i("Whats the status: " + email.isSendWhatifEmail());

		if (email.isSendWhatifEmail() == true) {

			try {

				String subject = "What-if-Analysis Calculator details";
				List<String> recipients = new ArrayList<>();
				jLogger.i("Subject: " + subject);
				String message = "Hello," + System.lineSeparator() + "Here are the details from the calculator: " + System.lineSeparator() +
						"Email: " + this.get(request, "emailAddress") + System.lineSeparator() + "Phone Number: " + this.get(request, "phoneNumber") +
						System.lineSeparator(); /*+ "Age: " + this.get(request, "yourAge")*/
				jLogger.i("The message: " + message);
				Company company = companyBeanI.find();
				Emails emails = emailsBeanI.find();
				String recipient = emails.getMarketingEmail();
				jLogger.i("Recipient: " + recipient);
				String senderId = emails.getDefaultEmail();
				jLogger.i("Sender email: " + senderId);
				String senderName = company.getName();
				jLogger.i("Sender name: " + senderName);
				recipients.add(recipient);
				boolean status = apiEJB.sendEmail(recipients, senderId, senderName, subject, message,
						this.getSessKey(request, Constants.SCHEME_ID), false, null);
				jLogger.i("Status is: " + status);

			} catch (Exception ex){
				ex.printStackTrace();
			}
		}

		jLogger.i("=============== Years to project: " + this.get(request, "yearsToProject") + " ====================");

			this.respond(response, true, "", apiEJB.calculateWhatIfAnalysis(this.get(request, "yearsToProject"),
					this.get(request, "contributions"), this.get(request, "rateOfReturn"), this.get(request, "salaryEscalationRate"),
					this.get(request, "inflationRate"),this.get(request, "emailAddress"),this.get(request, "phoneNumber"),
					this.get(request, "yourAge"), formula));
	}
}
