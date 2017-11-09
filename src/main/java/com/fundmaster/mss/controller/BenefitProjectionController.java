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
import java.math.BigDecimal;

@WebServlet(name = "BenefitProjectionController", urlPatterns = {"/benefit-projection"})
public class BenefitProjectionController  extends BaseServlet implements Serializable {
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
        jLogger.i("Am Here");
        String schemeId  = this.getSessKey(request, Constants.SCHEME_ID);
       // String memberId = this.getSessKey(request, Constants.MEMBER_ID);
        User u = userBeanI.findUserByUsernameAndProfile(this.getSessKey(request, Constants.USER), this.getSessKey(request, Constants.U_PROFILE));
        XiMember m = apiEJB.getMemberDetails(u.getProfileID().toString(), null);
        String memberId = Long.toString(m.getId());

        request.setAttribute("scheme_id", schemeId);
        request.setAttribute("member_id", memberId);

        jLogger.i("SchemeID is " + schemeId);
        jLogger.i("memberId is " +memberId);




        Double currentUnitPrice = apiEJB.getCurrentUnitPrice(schemeId);
        Double memberContribution =apiEJB.getMemberLatestContribution(memberId);
        Double totalMemberUnits = apiEJB.getMemberTotalUnits(memberId);
        BigDecimal PVL = BigDecimal.valueOf(totalMemberUnits*currentUnitPrice).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        jLogger.i("memberContribution in servlet " + memberContribution);
        jLogger.i("PVL in servlet " + PVL);
        jLogger.i("currentUnitPrice in servlet " + currentUnitPrice);
        request.getSession().setAttribute("currentUnitPrice", currentUnitPrice);
        request.getSession().setAttribute("memberContribution", memberContribution);
        request.getSession().setAttribute("PVL", PVL);



        logActivity(Constants.PAGE_BENEFIT_PROJECTION, "accessed benefit projection page", "0", null, null);
        request.getRequestDispatcher("member/benefit-projection.jsp").forward(request, response);



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



