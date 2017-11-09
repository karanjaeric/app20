package com.fundmaster.mss.controller;

import nl.captcha.Captcha;
import nl.captcha.servlet.CaptchaServletUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "Capture", urlPatterns = {"/captcha", "/captcha/", "/captcha/?*"})
public class Capture extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init( ServletConfig servletConfig ) throws ServletException
	  {
	    super.init( servletConfig );

	    // For this servlet, supported image types are PNG and JPG.
		  String sImgType = servletConfig.getInitParameter("ImageType");
	    sImgType = sImgType ==null ? "png" : sImgType.trim().toLowerCase();
	    if ( !sImgType.equalsIgnoreCase("png") && !sImgType.equalsIgnoreCase("jpg") &&
	    !sImgType.equalsIgnoreCase("jpeg") )
	    {

		}
	  }

	  protected void doGet( HttpServletRequest request, HttpServletResponse response ) 
	  throws ServletException, IOException
	  {
		  HttpSession session = request.getSession(true);
	      Captcha captcha = new Captcha.Builder(250, 50).addText().build();
	      CaptchaServletUtil.writeImage(response, captcha.getImage());
	      session.setAttribute(Captcha.NAME, captcha);
	  }

}
