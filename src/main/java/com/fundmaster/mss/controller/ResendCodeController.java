package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.UserBeanI;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;




@WebServlet(name = "ResendCodeController", urlPatterns = {"/resend-code"})
public class ResendCodeController extends BaseServlet implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6085562604717440895L;

    Helper helper = new Helper();
    private final JLogger jLogger = new JLogger(this.getClass());


    @EJB
    UserBeanI userBeanI;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        if(this.get(request, "ACTION").equals("RESEND_CODE"))
        {

            String phoneNumber  = this.get(request, "phoneNumber");
            jLogger.i("The Phone Number is " + phoneNumber);

            User usr = userBeanI.findByUsername(phoneNumber);


            if(usr != null)
            {
                String activationCode = helper.randomNumber().toString();
                usr.setSmsActivationCode(activationCode);
                userBeanI.edit(usr);
                boolean proceedSms;
                proceedSms = helper.isValidPhone(phoneNumber);

                if (proceedSms) {




                    apiEJB.sendSMS(phoneNumber, "Dear " + usr.getUserProfile() + ", " +
                            "Your account has been created on the FundMaster Xi Member Self Service Portal. " +
                            "Your Verification Code is " + activationCode + " to complete the activation process enter the provided code");

                    this.respond(response, true, "<strong>Code Resend Successful</strong><br /> " +

                            "Congratulations! Your Code has been resend on Your Phone Number.", null);



                } else {
                    this.respond(response, true, "<strong>Code Resend Unsuccessful</strong><br /> Congratulations! " +
                            "  We were not unable to resend the activation code to your Phone. " +
                            "Please contact the administrator", null);



                }

            }
            else
            {
                 this.respond(response, false, "Sorry, the Phone you does not exist. Please try again", null);
            }



        }}

}

