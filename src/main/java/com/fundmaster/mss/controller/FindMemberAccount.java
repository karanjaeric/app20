package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.UserBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.Sponsor;
import com.fundmaster.mss.model.XiMember;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@WebServlet(name = "FindMemberAccount", urlPatterns = {"/find-member-account"})
public class FindMemberAccount extends BaseServlet implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -608556717440895L;

    Helper helper = new Helper();
    private final JLogger jLogger = new JLogger(this.getClass());

    @EJB
    UserBeanI userBeanI;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {




        if(this.get(request, "ACTION").equals("FIND_MEMBER")) {


            HttpSession session = request.getSession();


            XiMember member = new XiMember();
            String memberId = this.get(request, "memberNo");//membershipNumber

            request.getSession().setAttribute("memberNumber", memberId);
            //  String ssnit = this.get(request, "ssnit");

            jLogger.i("The Membershp Number is " + memberId);
            // jLogger.i("The SSNIT Number is " + ssnit);


            if (memberId != null) {

                member = apiEJB.checkMemberAccount(this.get(request, "category"), memberId);


            }else this.respond(response,false,"MemberId is Null" ,null);

            if (member != null) {

                String memberExistingEmail = member.getEmailAddress();
                session.setAttribute(Constants.SCHEME_ID, member.getSchemeId());
                session.setAttribute("nationalPenNo" , member.getNationalPenNo());
                session.setAttribute("memberId" , member.getId());
                session.setAttribute("existingPhoneNumber" , member.getPhoneNumber());
                session.setAttribute("memberExistingEmail" , memberExistingEmail);



                List<Sponsor> sponsors = apiEJB.getMemberSchemeProducts(memberExistingEmail, this.getSessKey(request, Constants.SCHEME_ID));
                session.setAttribute(Constants.SPONSOR_ID, sponsors.get(0).getId().toString());


                request.getSession().setAttribute("sponsorName", sponsors.get(0).getCompanyName());


                this.respond(response, true, "<strong>Member Account Found  </strong><br /> " +
                        " You will be redirected to Account recovery Page", null);
            }else this.respond(response,false,"Member NOT found" , null);
        }

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

       /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");





    }
}

