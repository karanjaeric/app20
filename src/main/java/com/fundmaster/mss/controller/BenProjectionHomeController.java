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


@WebServlet(name = "BenProjectionHomeController", urlPatterns = {"/benefit-projection-home"})
public class BenProjectionHomeController  extends BaseServlet implements Serializable {
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




        logActivity(Constants.PAGE_BENEFIT_PROJECTION, "accessed benefit projection page", "0", null, null);
        request.getRequestDispatcher("benefit-projection.jsp").forward(request, response);



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String presentValue = this.get(request, "presentValue");
        if(presentValue.equalsIgnoreCase("")){
            presentValue ="0";
        }


        this.respond(response, true, "", apiEJB.calculateBenefitProjection(this.get(request, "interestRate"),
                this.get(request, "years"), this.get(request, "paymentFrequency"), this.get(request, "paymentAmount"),
                presentValue));

    }



}



