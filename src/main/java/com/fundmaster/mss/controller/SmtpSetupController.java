/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.SmtpI;
import com.fundmaster.mss.model.SmtpSetup;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ekaranja
 */
@WebServlet(name = "SmtpSetup", urlPatterns = {"/smtpSetup"})
public class SmtpSetupController extends BaseServlet implements Serializable {

    @EJB
    SmtpI smtpBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SmtpSetup setup=smtpBean.getSmtpSetup();
        if(setup==null)
            setup=new SmtpSetup();
        
        setup.setSmtpHost(this.get(request, "smtpHost"));
        setup.setSmtpPort(this.get(request, "smtpPort"));
        setup.setSmtpUsername(this.get(request, "smtpUsername"));
        setup.setSmtpPassword(this.get(request, "smtpPassword"));
        
        smtpBean.saveSmtpSetup(setup);
        
    this.respond(response, true, "setup was successfully uploaded", null);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
