package com.gatepass.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gatepass.model.Visitor;


public class ViewAndPrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(ViewAndPrint.class);
	
	 String JDBC_DRIVER;  
	    String DB_URL;
	    String DB_USERNAME;
	    String DB_PASSWORD;
	    
	    @Override
	    public void init(ServletConfig config) throws ServletException 
	    {
	    	super.init(config);
	    	
	    	ServletContext context = config.getServletContext();
	    	JDBC_DRIVER = context.getInitParameter("JDBC_DRIVER");
	    	DB_URL 		= context.getInitParameter("DB_URL");
	    	DB_USERNAME = context.getInitParameter("DB_USERNAME");
	    	DB_PASSWORD = context.getInitParameter("DB_PASSWORD");
	    }
	   
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException {
	    	
	    	logger.info("Get List of Visitors");
	    	Connection connection = null;
	    	PreparedStatement prepareStatement = null ;
	    	try{
	    		Class.forName("com.mysql.jdbc.Driver");
	    		connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
	    
	    		String query = "SELECT * FROM gpa_visitor";
	    		prepareStatement= connection.prepareStatement(query);
	    	//	ResultSet rs = prepareStatement.executeQuery();
	    	 
	    	 logger.info("Retrieving data from Visitor");
	    	 List<Visitor> visitorlist = new ArrayList<Visitor>();
	    	 /*while (rs.next()) 
	    	 {
	    	 Visitor visitor = new Visitor();
	    	 visitor.setVisitornumber(rs.getInt("visitornumber"));
	    	 visitor.setVisitorname(rs.getString("visitorname"));
	    	 visitor.setAddress(rs.getString("address"));
	    	 visitor.setPurpose(rs.getString("purpose"));
	    	 visitor.setComingfrom(rs.getString("comingfrom"));
	    	 visitor.setContactperson(rs.getString("contactperson"));
	    	 visitor.setContactnumber(rs.getString("contactnumber"));
	    	 visitor.setVehiclenumber(rs.getString("vehiclenumber"));
	    	 visitor.setTimein(rs.getString("timein"));
	    	 visitor.setTimeout(rs.getString("timeout"));
	    	 visitor.setHelmetissued(rs.getString("helmetissued"));
	    	 visitor.setNumberofvisitors(rs.getString("numberofvisitors"));
	    	 visitor.setDate(rs.getString("date"));
	    	 
	    	 visitorlist.add(visitor);
	    	 }
	    	 */
	    	request.setAttribute("visitorlist",visitorlist);
	    	request.getServletContext().getRequestDispatcher("/jsp/PrintVisitor.jsp").forward(request, response);
	    	 
	    	}
			catch(IllegalArgumentException e)
			{
				System.err.println("Invalid"+e.getMessage());
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
					finally{
						try
						{
							connection.close();
						}
						catch(SQLException e)
						{
							
						}
					}
			}
	    
		
	    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	Connection connection = null;
	    	PreparedStatement prepareStatement = null ;
	    	try{
	    		Class.forName("com.mysql.jdbc.Driver");
	    		connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
	    
	    		String query = "SELECT * FROM gpa_visitor";
	    		prepareStatement= connection.prepareStatement(query);
	    	//	ResultSet rs = prepareStatement.executeQuery();
	    	 
	    	 List<Visitor> visitorlist = new ArrayList<Visitor>();
	    	 /*while (rs.next()) 
	    	 {
	    	 Visitor visitor = new Visitor();
	    	 visitor.setVisitornumber(rs.getInt("visitornumber"));
	    	 visitor.setVisitorname(rs.getString("visitorname"));
	    	 visitor.setAddress(rs.getString("address"));
	    	 visitor.setPurpose(rs.getString("purpose"));
	    	 visitor.setComingfrom(rs.getString("comingfrom"));
	    	 visitor.setContactperson(rs.getString("contactperson"));
	    	 visitor.setContactnumber(rs.getString("contactnumber"));
	    	 visitor.setVehiclenumber(rs.getString("vehiclenumber"));
	    	 visitor.setTimein(rs.getString("timein"));
	    	 visitor.setTimeout(rs.getString("timeout"));
	    	 visitor.setHelmetissued(rs.getString("helmetissued"));
	    	 visitor.setNumberofvisitors(rs.getString("numberofvisitors"));
	    	 visitor.setDate(rs.getString("date"));
	    	 
	    	 logger.info(visitor.toString());
	    	 visitorlist.add(visitor);
	    	 }*/
	    	request.getSession().setAttribute("msg", "From Servlet");
	    	request.setAttribute("visitorlist",visitorlist);
	    	request.setAttribute("msg", "new message");
	    	request.getServletContext().getRequestDispatcher("/jsp/PrintVisitor.jsp").forward(request, response);
	    	 
	    	}
			catch(IllegalArgumentException e)
			{
				System.err.println("Invalid"+e.getMessage());
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
					finally{
						try
						{
							connection.close();
						}
						catch(SQLException e)
						{
							
						}
					}
			}
			}
