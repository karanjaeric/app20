/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.CompanyBeanI;
import com.fundmaster.mss.beans.EmailsBeanI;
import com.fundmaster.mss.beans.HelpBeanI;
import com.fundmaster.mss.beans.MenuBeanI;
import com.fundmaster.mss.beans.PageContentBeanI;
import com.fundmaster.mss.beans.SettingBeanI;
import com.fundmaster.mss.beans.SocialBeanI;
import com.fundmaster.mss.beans.ThemeBeanI;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ekaranja
 */
@WebServlet(name = "DbWhatIfAnalysis", urlPatterns = {"/db_whatif_analysis"})
public class DbWhatIfAnalysis extends BaseServlet implements Serializable {
 
    
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
        



     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Frame-Options", "DENY");
		response.addHeader("X-Content-Type-Options", "nosniff");
                
                DateFormat format_from = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
		DateFormat format = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);

		String fromDate_String = this.get(request, "dateOfCalc");
		String toDate_String = this.get(request, "dateOfExit");

		Date fromDate = null;
		Date toDate = null;

		try {
			fromDate = format_from.parse(fromDate_String);
			toDate = format_from.parse(toDate_String);
		} catch (ParseException pe) {
			// TODO Auto-generated catch block
			jLogger.e("ParseException was detected: " + pe.getMessage());
		}

		jLogger.i("From Date ================ > " + fromDate);
		jLogger.i("To Date ================ > " + toDate);

			this.respond(response, true, "", apiEJB.calculateDBBenefitsProjections(this.get(request, "schemeId"),
					this.get(request, "memberId"), format.format(fromDate),
					this.get(request, "reasonforexitid")));
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
