package com.fundmaster.mss.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fundmaster.mss.common.Helper;
import com.fundmaster.mss.common.LOGGER;
import com.fundmaster.mss.model.Banner;
import com.fundmaster.mss.model.Media;

@WebServlet(name = "BannerController", urlPatterns = { "/banners/*" })
@MultipartConfig
public class BannerController extends HttpServlet implements Serializable {
	
	LOGGER logger = new LOGGER(this.getClass());
	
	@EJB
	Helper helper;
	
	String BANNER_DIR = "banner";
	
	public BannerController() {
		
	}
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//List<Banner> banners = helper.getBanners();
		
		Banner bn = helper.getBannerById(helper.toLong(request.getPathInfo().substring(1)));
		
		
		//for(Banner b: banners)
		//{
		try {
			
			String fileName = bn.getName();
			
			Blob blob = bn.getImage();
			InputStream inputstream = blob.getBinaryStream();
			int fileLength = inputstream.available();
			
			System.out.println("Name: "+fileName+"Filelength = " + fileLength);
			
			ServletContext context = getServletContext();
			
			String mimeType = context.getMimeType(fileName);
			if(mimeType == null) {
				mimeType = "application/octet-stream";
			}
	        
			response.setContentType(mimeType);
		    response.setContentLength(fileLength);
	        response.setHeader("Content-Length", String.valueOf(fileLength));
	        response.setHeader("Content-disposition","inline;filename=" + fileName);
			
			String fullpath = request.getServletContext().getRealPath("");
			String savePath = fullpath + File.separator + BANNER_DIR;
			System.out.println("full path is:" + savePath);
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			savePath = fullpath + File.separator + BANNER_DIR + File.separator + fileName;
			
			File file = new File(savePath);
			
			OutputStream fileoutput = response.getOutputStream();
	        //FileOutputStream fileoutput = new FileOutputStream(file);
	        //int read = 0;
	        byte[] buffer = new byte[4096];
	        while ((fileLength = inputstream.read(buffer)) > 0) {
	        	fileoutput.write(buffer, 0, fileLength);
	        }  
	        
	        System.out.println("File is saved here =============>  " + file);
	        
	        
	        inputstream.close();
		    fileoutput.close();
			
	        
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		}
		
	}

//}
