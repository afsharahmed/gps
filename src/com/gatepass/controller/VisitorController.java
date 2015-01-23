package com.gatepass.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.gatepass.model.Visitor;
import com.gatepass.service.VisitorService;

@Controller
@RequestMapping(value="/secure")
public final class VisitorController 
{	
	private Logger logger = LoggerFactory.getLogger(VisitorController.class);
	
	private VisitorService visitorService;

	@Autowired
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}
	
	@RequestMapping(value="/viewVisitors", method={RequestMethod.GET})
	public ModelAndView getVisitors()
	{
		View view = new InternalResourceView("/jsp/ViewVisitors.jsp");
		ModelAndView mv = new ModelAndView(view);
		
		List<Visitor> visitors = visitorService.getAllVisitors();
		logger.info("Total Visitors found:"+visitors.size());
		
		mv.addObject("visitors", visitors);
		return mv;
	}
	
	
	@RequestMapping(value="/getVisitorDetails", method=RequestMethod.POST)
	public ModelAndView getDetails( @RequestParam(value="visitorID") Integer visitorID)
	{
		View view = new InternalResourceView("/jsp/UpdateVisitor.jsp");
		ModelAndView mv = new ModelAndView(view);	
		
		try 
		{
			Visitor visitor = visitorService.getVisitorById(visitorID);
			
			Blob blob = visitor.getPhoto();
			String s;
			
			if(blob != null)
			{
				byte[] bdata = blob.getBytes(1, (int) blob.length());
				s = new String(bdata);	
			}
			else
				s = "";
			
			mv.addObject("imageData", s);
			mv.addObject("visitorObj", visitor);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mv;		
	}

	@RequestMapping(value="/printVisitorDetails", method=RequestMethod.GET)
	public ModelAndView printDetails( HttpServletRequest request)
	{
		View view = new InternalResourceView("/jsp/PrintGatePass.jsp");
		ModelAndView mv = new ModelAndView(view);	
		
		try 
		{
			Visitor visitor = (Visitor) request.getSession(false).getAttribute("visitor");
			
			Blob blob = visitor.getPhoto();
			String s;
			
			if(blob != null)
			{
				byte[] bdata = blob.getBytes(1, (int) blob.length());
				s = new String(bdata);	
			}
			else
				s = "";
			
			mv.addObject("imageData", s);
			mv.addObject("visitorObj", visitor);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mv;		
	}

	
	
	@RequestMapping(value="/addVisitor", method=RequestMethod.POST)
	public void addVisitor(@RequestParam(value="visitorname") String visitorName,
							@RequestParam(value="visitortype") String visitorType,
							@RequestParam(value="address") String address,
							@RequestParam(value="purpose") String purpose,
							@RequestParam(value="comingfrom") String comingFrom,
							@RequestParam(value="contactperson") String contactPerson,
							@RequestParam(value="contactnumber") String contactNumber,
							@RequestParam(value="vehiclenumber") String vehicleNumber,
							@RequestParam(value="timein") String timeIn,
							@RequestParam(value="timeout") String timeOut,
							@RequestParam(value="helmetissued") String helmetIssued,
							@RequestParam(value="numberofvisitors") String numberOfVisitors,
							@RequestParam(value="date") String date,
							@RequestParam(value="imageData") String imageData,
							HttpServletRequest request, HttpServletResponse response)
	{
		Visitor newVisitor= new Visitor();

		//request.getSession(false).setAttribute("viewVisitorPageMessage", "Visitor added sucessfully!");
		
		try 
		{ 
			
			Blob photo = null;
					
			if(imageData != null && !imageData.isEmpty())
			{
				byte[] buff = imageData.getBytes();
				photo = new SerialBlob(buff);	
			}
			else
				logger.info("[WARNING] No image data in request!");
			
			newVisitor.setVisitorName(visitorName);
			newVisitor.setVisitorType(visitorType);
			newVisitor.setAddress(address);
			newVisitor.setPurpose(purpose);
			newVisitor.setComingFrom(comingFrom);
			newVisitor.setContactPerson(contactPerson);
			newVisitor.setContactNumber(contactNumber);
			newVisitor.setVehicleNumber(vehicleNumber);
			newVisitor.setTimeIn(timeIn);
			newVisitor.setTimeOut(timeOut);
			newVisitor.setHelmetIssued(helmetIssued);
			newVisitor.setNumberOfVisitors(numberOfVisitors);
			newVisitor.setDate(date);	
			newVisitor.setPhoto(photo);
			
			visitorService.addVisitor(newVisitor);
			
			HttpSession httpSession = request.getSession(false);

			if(httpSession == null)
				httpSession = request.getSession();
			
			httpSession.setAttribute("visitor", newVisitor);
			
			response.sendRedirect("/gps/secure/printVisitorDetails"); 
//			response.sendRedirect("/gps/viewVisitors/"); 
		
		} catch (IOException|SQLException e) { }	

	}
	
	@RequestMapping(value="/updateVisitor", method=RequestMethod.POST)
	public void updateVisitor(  @RequestParam(value="visitorID") Integer visitorID,
										@RequestParam(value="visitorname") String visitorName,
										@RequestParam(value="visitortype") String visitorType,
										@RequestParam(value="address") String address,
										@RequestParam(value="purpose") String purpose,
										@RequestParam(value="comingfrom") String comingFrom,
										@RequestParam(value="contactperson") String contactPerson,
										@RequestParam(value="contactnumber") String contactNumber,
										@RequestParam(value="vehiclenumber") String vehicleNumber,
										@RequestParam(value="timein") String timeIn,
										@RequestParam(value="timeout") String timeOut,
										@RequestParam(value="helmetissued") String helmetIssued,
										@RequestParam(value="numberofvisitors") String numberOfVisitors,
										@RequestParam(value="date") String date,
										@RequestParam(value="imageData") String imageData,
										HttpServletRequest request, HttpServletResponse response)
			
	{
		Visitor updatedVisitor = new Visitor();
	
		try 
		{
			Blob photo = null;
					
			if(imageData != null && !imageData.isEmpty())
			{
				byte[] buff = imageData.getBytes();
				photo = new SerialBlob(buff);	
			}
			else
				logger.info("[WARNING] No image data in request!");
			
			// Populate updated form data
			 updatedVisitor.setVisitornumber(visitorID);
			 updatedVisitor.setVisitorName(visitorName);
			 updatedVisitor.setVisitorType(visitorType);
			 updatedVisitor.setAddress(address);
			 updatedVisitor.setPurpose(purpose);
			 updatedVisitor.setComingFrom(comingFrom);
			 updatedVisitor.setContactPerson(contactPerson);
			 updatedVisitor.setContactNumber(contactNumber);
			 updatedVisitor.setVehicleNumber(vehicleNumber);
			 updatedVisitor.setTimeIn(timeIn);
			 updatedVisitor.setTimeOut(timeOut);
			 updatedVisitor.setHelmetIssued(helmetIssued);
			 updatedVisitor.setNumberOfVisitors(numberOfVisitors);
			 updatedVisitor.setDate(date);
			 updatedVisitor.setPhoto(photo);
	
	  		visitorService.updateVisitor(updatedVisitor);
			
	  		HttpSession httpSession = request.getSession(false);

	  		if(httpSession == null)
				httpSession = request.getSession();
			
			httpSession.setAttribute("visitor", updatedVisitor);
			httpSession.setAttribute("viewVisitorPageMessage", "Visitor '"+visitorName+"' updated sucessfully!");
	  		
            response.sendRedirect("/gps/secure/viewVisitors"); 
         } catch (IOException|SQLException e) { e.printStackTrace(); }
	}
	
	
	@RequestMapping(value="/deleteVisitor", method=RequestMethod.POST)
	public void deleteVisitor(@RequestParam(value="visitorID") Integer visitorNumber, 
								HttpServletRequest request, HttpServletResponse response)
	{
		visitorService.deleteVisitor(visitorNumber);

		HttpSession httpSession = request.getSession(false);

		if(httpSession == null)
			httpSession = request.getSession();
		
		httpSession.setAttribute("viewVisitorPageMessage", "Visitor deleted sucessfully!");
		
		try { response.sendRedirect("/gps/secure/viewVisitors"); } catch (IOException e) { }		
	}

}