package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.*;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

@WebServlet(name = "UnitPriceController", urlPatterns = {"/unit-prices"})
public class UnitPriceController  extends BaseServlet implements Serializable {

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
    InterestRateColumnBeanI interestEJB;
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
    Helper helper = new Helper();
    private final JLogger jLogger = new JLogger(this.getClass());
    @EJB
    ApiEJB apiEJB;

    private static final String REQUEST_ACTION = "ACTION";
    private static final String UNIT_PRICES_BY_SCHEME = "UNIT_PRICES_BY_SCHEME";
    private static final String UNIT_PRICES_BY_SPONSOR = "UNIT_PRICES_BY_SPONSOR";




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Scheme> schemes = apiEJB.getSchemes(0, 10000);
        request.setAttribute("schemes", schemes);
        Social social = socialBeanI.find();
        request.setAttribute("social", social);
        Menu menu = menuBeanI.find();
        request.setAttribute("menu", menu);
        Theme theme = themeBeanI.find();
        request.setAttribute("theme", theme);
        request.setAttribute("noMenu", false);
        Help help = helpBeanI.findHelp(Constants.PAGE_UNIT_PRICES);
        request.setAttribute("help", help);
        Setting settings = settingBeanI.find();
        request.setAttribute("settings", settings);
        PageContent content = pageContentBeanI.findPageContent(Constants.PAGE_UNIT_PRICES);
        request.setAttribute("content", content);
        logActivity(Constants.PAGE_UNIT_PRICES, "accessed Unit Prices page", "0", null, null);
        request.getRequestDispatcher("unit-price-content.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = this.get(request, REQUEST_ACTION);

        switch (action) {

            case UNIT_PRICES_BY_SPONSOR:
                getUnitPriceBySponsor(request, response);
                break;
            case UNIT_PRICES_BY_SCHEME:
                getUnitPriceByScheme(request, response);
                break;
        }
    }

    private void getUnitPriceByScheme(HttpServletRequest request, HttpServletResponse response) {

     if(this.get(request, "scheme") != null)
        {
            JSONObject unitPrices = apiEJB.getSchemeUnitPrices(request.getParameter("scheme"));
            this.respond(response, true, "", unitPrices);
        }

    }
    private void getUnitPriceBySponsor(HttpServletRequest request, HttpServletResponse response) {

    }


}
