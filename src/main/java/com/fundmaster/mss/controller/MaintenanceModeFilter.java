package com.fundmaster.mss.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MaintenanceModeFilter implements Filter{

    public static final int MODE_NORMAL_OPERATION = 0;

    protected int    mode              = MODE_NORMAL_OPERATION;
    protected String maintenanceUrl    = null;
    protected String maintenanceGuiUrl = null;
    protected String password          = null;
    protected String comment           = null;


    public void init(FilterConfig filterConfig) throws ServletException {
        this.maintenanceUrl    = filterConfig
                .getInitParameter("maintenanceUrl");
        this.maintenanceGuiUrl = filterConfig
                .getInitParameter("maintenanceGuiUrl");
        this.password          = filterConfig
                .getInitParameter("password");
    }


    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest  = (HttpServletRequest)  request;

        if(request.getParameter("maintenance-mode") != null){

            if(password.equals(request.getParameter("password"))){
                mode    = Integer.parseInt(
                        request.getParameter("maintenance-mode"));
                comment = request.getParameter("aComment");
                request.getRequestDispatcher(this.maintenanceGuiUrl)
                        .include(request, response);
            }
            return;
        }

        if(mode != MODE_NORMAL_OPERATION){
            if(!httpRequest.getServletPath().equals(maintenanceGuiUrl)){
                request.setAttribute("comment", comment);
                request.getRequestDispatcher(this.maintenanceUrl)
                        .include(request, response);
                return;
            }
        }

        //option: increment active requests count inside a synchronized section

        filterChain.doFilter(request, response);

        //option: decrement active requests count inside a synchronized section
    }


    public void destroy() {

    }
}