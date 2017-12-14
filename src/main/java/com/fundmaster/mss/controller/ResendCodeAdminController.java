 //ResendCodeAdminController
 package com.fundmaster.mss.controller;

 import com.fundmaster.mss.beans.UserBeanI;
 import com.fundmaster.mss.common.Helper;
 import com.fundmaster.mss.common.JLogger;
 import com.fundmaster.mss.model.User;
 import com.fundmaster.mss.model.XiMember;

 import javax.ejb.EJB;
 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.io.IOException;
 import java.io.Serializable;




 @WebServlet(name = "ResendCodeAdminController", urlPatterns = {"/resend-code-admin"})
 public class ResendCodeAdminController extends BaseServlet implements Serializable {

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


         RequestDispatcher requestDispatcher =request.getRequestDispatcher("resend-code-admin.jsp");
         requestDispatcher.forward(request,response);

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

         if(this.get(request, "ACTION").equals("RESEND_CODE_ADMIN"))
         {

             String userName  = this.get(request, "userName");
             jLogger.i("The Username is " + userName);

             User usr = userBeanI.findByUsername(userName);
             String userProfile = usr.getUserProfile();
             XiMember mbr = apiEJB.memberExists(userProfile, userName);




             if(usr != null)
             {
                 String activationCode = helper.randomNumber().toString();
                 usr.setSmsActivationCode(activationCode);
                 userBeanI.edit(usr);
                 boolean proceedSms;
                 String phoneNumber =mbr.getPhoneNumber();

                 proceedSms = helper.isValidPhone(phoneNumber);

                 if (proceedSms) {




                     apiEJB.sendSMS(phoneNumber, "Dear " + usr.getUserProfile() + ", " +
                             "Your code  has been resend by Enterprise Trustees  Member Self Service Portal. " +
                             "Your Verification Code is " + activationCode + ". To complete the activation process enter the provided code." +
                             " Our call center no is 0302634704");

                     this.respond(response, true, "<strong>Code Resend Successful</strong><br /> " +

                             "Congratulations! Your Code has been resend on Your Phone Number.", null);



                 } else {
                     this.respond(response, false, "<strong>Code Resend Unsuccessful</strong><br /> ! " +
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


