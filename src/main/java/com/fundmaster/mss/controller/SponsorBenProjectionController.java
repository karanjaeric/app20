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



@WebServlet(name = "SponsorBenProjectionController", urlPatterns = {"/sponsor-benefit-projection"})
public class SponsorBenProjectionController  extends BaseServlet implements Serializable {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        response.setContentType( "text/html" );

        Company company = companyBeanI.find();
        request.setAttribute("company", company);
        Social social = socialBeanI.find();
        request.setAttribute("social", social);
        Menu menu = menuBeanI.find();
        request.setAttribute("menu", menu);
        Theme theme = themeBeanI.find();
        request.setAttribute("theme", theme);
        request.setAttribute("noMenu", false);
        Help help = helpBeanI.findHelp(Constants.PAGE_BENEFIT_PROJECTION);
        request.setAttribute("help", help);
        PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_BENEFIT_PROJECTION);
        request.setAttribute("content", content);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);

        String schemeId  = this.getSessKey(request, Constants.SCHEME_ID);

        request.setAttribute("scheme_id", schemeId);
        jLogger.i("SchemeID is " + schemeId);

        Double currentUnitPrice = apiEJB.getCurrentUnitPrice(schemeId);
         request.getSession().setAttribute("currentUnitPrice", currentUnitPrice);

        logActivity(Constants.PAGE_BENEFIT_PROJECTION, "accessed benefit projection page as sponsor", "0", null, null);
        request.getRequestDispatcher("sponsor/benefit-projection.jsp").forward(request, response);



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        String presentValue = this.get(request, "presentValue");
        String userName = this.getSessKey(request, Constants.USER);
        jLogger.i("Username is ===============> " + userName);

        if(presentValue.equalsIgnoreCase("")){
            presentValue ="0";
        }


        this.respond(response, true, "", apiEJB.calculateBenefitProjection(this.get(request, "interestRate"),
                this.get(request, "years"), this.get(request, "paymentFrequency"), this.get(request, "paymentAmount"),
                presentValue,userName));

    }



}



