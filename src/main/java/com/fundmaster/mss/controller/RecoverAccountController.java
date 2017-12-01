package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.UserBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.Sponsor;
import com.fundmaster.mss.model.User;
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


@WebServlet(name = "RecoverAccountController", urlPatterns = {"/recover-account"})
public class RecoverAccountController extends BaseServlet implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -608556717440895L;

    Helper helper = new Helper();
    private final JLogger jLogger = new JLogger(this.getClass());

    @EJB
    UserBeanI userBeanI;

    @EJB
    ApiEJB apiEJB;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("recover-account.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

       /* configuring the http headers */
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Frame-Options", "DENY");
        response.addHeader("X-Content-Type-Options", "nosniff");

        HttpSession session = request.getSession();

        String email = this.get(request, "email");//membershipNumber
        String phone = this.get(request, "phoneNumber");//membershipNumber
        String ssnitNumber  =this.get(request, "ssnit");
        String membershipNumber = String.valueOf(session.getAttribute("membershipNumber"));
        String schemeId = String.valueOf(session.getAttribute(Constants.SCHEME_ID));

        jLogger.i("The email set is===================================> " + email);
        jLogger.i("The phone set is===================================> " + phone);
        jLogger.i("The ssnitNumber set is===================================> " + ssnitNumber);
        jLogger.i("The membershipNumber set is===================================> " + membershipNumber);
        jLogger.i("The schemeId is===================================> " + schemeId);


        boolean status;


        status =apiEJB.saveMemberAccountBySchemeAndMembershipNumber(email,phone,ssnitNumber,membershipNumber,schemeId);
        if (status) {
            apiEJB.sendSMS(phone,"Member details have been successfully saved. You Can Now Register To MSS Portal");

            this.respond(response, true, "Member details have been successfully saved. You Can Now Register To MSS Portal" , null);
        }
            else
                this.respond(response, false, "Member details could not be saved. We apologise for the inconvenience.", null);


     //   this.recoverAccount(request,response);



    }
}

