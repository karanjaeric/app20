package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.UserBeanI;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;


@WebServlet(name = "SmsAccountActivationController", urlPatterns = {"/activate-account"})
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

        RequestDispatcher requestDispatcher =request.getRequestDispatcher("activate-account.jsp");
        requestDispatcher.forward(request,response);
        
     }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
//
//             if(this.get(request, "ACTION").equals("ACTIVATE_ACCOUNT"))
//        {
//
//            String code  = this.get(request, "code");
//            jLogger.i("The Code is " + code);
//
//            User usr = userBeanI.findByActivationCode(code);
//
//
//                if(usr != null && !usr.isStatus())
//                {
//                    usr.setStatus(true);
//                    userBeanI.edit(usr);
//                    request.setAttribute("success", true);
//
//                    this.respond(response, true, "<strong>Activation Successful</strong><br /> " +
//
//                            "Congratulations! Your account has been Activated on the portal. You can now Login", null);
//
//                }
//                else
//                {
//                    request.setAttribute("success", false);
//                    this.respond(response, false, "Sorry, the Code you entered is invalid. Please try again", null);
//                }
//
//
//
//    }
}

}
