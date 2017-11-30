package com.fundmaster.mss.controller;

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
        session.setAttribute("email", email);
        session.setAttribute("phone", phone);

        this.recoverAccount(request,response);



    }
}

