package com.fundmaster.mss.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.beans.ejb.MediaEJB;
import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.model.Media;

@WebServlet(name = "DownloadController", urlPatterns = { "/downloads/*" })
@MultipartConfig
public class DownloadController extends BaseServlet implements Serializable {
	
	JLogger JLogger = new JLogger(this.getClass());

    Helper helper = new Helper();
	private static final long serialVersionUID = 1L;

	@EJB
	MediaEJB mediaEJB;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Media m = mediaEJB.findById(helper.toLong(request.getPathInfo().substring(1)));
		
		try {
			String filename = m.getName();
			
			Blob blob = m.getFile();
			InputStream inputStream = blob.getBinaryStream();
			int fileLength = inputStream.available();
			
			System.out.println("Filelength = " + fileLength);
			
			ServletContext context = getServletContext();
			
			String mimeType = context.getMimeType(filename);
			if(mimeType == null) {
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setContentLength(fileLength);
			
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", filename);
			response.setHeader(headerKey, headerValue);
			
			OutputStream outStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
			
			while ((fileLength = inputStream.read(buffer)) > 0){
			    outStream.write(buffer, 0, fileLength);
			}
			
			inputStream.close();
			outStream.close();
			
			} catch (SQLException e) {

				response.getWriter().print("SQL Error: " + e.getMessage());
			} catch (IOException ie) {
				response.getWriter().print("IO Exception: " + ie.getMessage());
		}
	}
}
