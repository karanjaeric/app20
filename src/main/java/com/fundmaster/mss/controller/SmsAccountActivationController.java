package com.fundmaster.mss.controller;

import com.fundmaster.mss.api.ApiEJB;
import com.fundmaster.mss.beans.*;
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


@WebServlet(name = "PasswordResetController", urlPatterns = {"/activate-account"})
public class SmsAccountActivationController extends BaseServlet implements Serializable {

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

     }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

             if(this.get(request, "ACTION").equals("ACTIVATE_ACCOUNT"))
        {

            String code  = this.get(request, "code");
            User usr = userBeanI.findByActivationCode(code);

            if(usr != null && !usr.isStatus())
            {
                usr.setStatus(true);
                userBeanI.edit(usr);
                request.setAttribute("success", true);

            }
            else
            {
                request.setAttribute("success", false);
            }

            this.respond(response, true, "<strong>Activation Successful</strong><br /> " +

                    "Congratulations! Your account has been Activated on the portal. You can now Login", null);


        }
             else
             {
                 this.respond(response, false, "Sorry, the Phone Number you entered is invalid. Please try again", null);

             }
    }

}
