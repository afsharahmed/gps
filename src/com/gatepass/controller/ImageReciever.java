package com.gatepass.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class ImageReciever
 */
public class ImageReciever extends HttpServlet {
	
	private Logger logger = LoggerFactory.getLogger(ImageReciever.class);
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StringBuffer buffer = new StringBuffer();
			Reader reader = request.getReader();
			int current;
			while ((current = reader.read()) >= 0)
				buffer.append((char) current);
			String data = new String(buffer);
			data = data.substring(data.indexOf(",") + 1);
			
			
			//logger.info("PNG image data on Base64: " + data);
			logger.info("getServletContext().getRealPath(images)"+getServletContext().getRealPath("images"));
			String s = getServletContext().getRealPath("images")+"\\userImages\\";
			logger.info(s); 
			//s = "H:\\Workspaces\\Home\\gps\\Web\\images\\userImages\\";
			FileOutputStream output = new FileOutputStream(new File(s + new Random().nextInt(100) + ".png"));
			
			output.write(new BASE64Decoder().decodeBuffer(data));
			output.flush();
			output.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
