package com.gatepass.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.gatepass.model.Executive;
import com.gatepass.service.ExecutiveService;

@Controller
@RequestMapping(value="/secure")
public class ExecutiveController
{
	private Logger logger = LoggerFactory.getLogger(ExecutiveController.class);

	private ExecutiveService executiveService;
/*	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}*/

	@Autowired
	public void setExecutiveService(ExecutiveService executiveService) {
		this.executiveService = executiveService;
	}

	
	@RequestMapping(value="/executiveLogin", method=RequestMethod.POST)
	public ModelAndView loginExecutive(@RequestParam(value="username") String username,
										@RequestParam(value="password") String password )
	{
		ModelAndView mv;
		
		boolean userExists = executiveService.isValidUser(username, password);
		String path;
		
		if(userExists)
			path = "/jsp/ExecutivePage.jsp";
		else
			path = "/jsp/IncorrectPassword.jsp";
		
		
		View view = new InternalResourceView(path);
		mv = new ModelAndView(view);
		
		return mv;
	}
	
	
	@RequestMapping(value="/viewExecutives", method={RequestMethod.GET})
	public ModelAndView getExecutives()
	{
		View view = new InternalResourceView("/jsp/ViewExecutives.jsp");
		ModelAndView mv = new ModelAndView(view);
		
		List<Executive> executives = executiveService.getAllExecutives();
		
		if(executives.isEmpty())
			logger.info("No Executive found.");
		else
			logger.info("Total Executives found:"+executives.size());
		
		mv.addObject("executives", executives);
		
		return mv;
	}

	@RequestMapping(value="/getExecutiveDetails", method=RequestMethod.POST)
	public ModelAndView getDetails( @RequestParam(value="executiveId") Integer executiveId)
	{
		View view = new InternalResourceView("/jsp/UpdateExecutive.jsp");
		ModelAndView mv = new ModelAndView(view);	
		
		Executive executive = executiveService.getExecutiveById(executiveId);
		mv.addObject("executive", executive);
		
		return mv;		
	}

	@RequestMapping(value="/addExecutive", method=RequestMethod.POST)
	public String addExecutiveUser(@RequestParam(value="username") String username,
							@RequestParam(value="password") String password,
							@RequestParam(value="firstname") String firstName,
							@RequestParam(value="lastname") String lastName,
							@RequestParam(value="dob") String dob,
							@RequestParam(value="gender") Integer gender,
							@RequestParam(value="mobile") String mobile,
							@RequestParam(value="address") String address,
							HttpServletRequest request, HttpServletResponse response)
	{
		Executive newExecutive= new Executive();
		newExecutive.setUsername(username);
		newExecutive.setPassword(password);
		newExecutive.setRole("EXECUTIVE");
		newExecutive.setFirstName(firstName);
		newExecutive.setLastName(lastName);
		
		if(dob == null || dob.isEmpty())
			newExecutive.setDob(null);
		else
			newExecutive.setDob(dob);
		
		newExecutive.setGender(gender);
		newExecutive.setMobile(mobile);
		newExecutive.setAddress(address);

		executiveService.addExecutiveUser(newExecutive);

		return "redirect:/secure/viewExecutives";
	}

	
	@RequestMapping(value="/updateExecutive", method=RequestMethod.POST)
	public String updateExecutiveUser( @RequestParam(value="execId") Integer executiveId, @RequestParam(value="username") String username, @RequestParam(value="password") String password,
									@RequestParam(value="firstname") String firstName, @RequestParam(value="lastname") String lastName,
									@RequestParam(value="dob") String dob,
									@RequestParam(value="gender") Integer gender,
									@RequestParam(value="mobile") String mobile,
									@RequestParam(value="address") String address,
									HttpServletRequest request, HttpServletResponse response)
			
	{
		Executive updatedExecutive = new Executive();
				
		// Pouplate updated form data
		updatedExecutive.setExecutiveId(executiveId);
		updatedExecutive.setUsername(username);
		updatedExecutive.setPassword(password);
		updatedExecutive.setRole("EXECUTIVE");
		updatedExecutive.setFirstName(firstName);
		updatedExecutive.setLastName(lastName);

		if(dob == null || dob.isEmpty())
			updatedExecutive.setDob(null);
		else
			updatedExecutive.setDob(dob);
		
		updatedExecutive.setGender(gender);
		updatedExecutive.setMobile(mobile);
		updatedExecutive.setAddress(address);
		 		 
  		executiveService.updateExecutive(updatedExecutive);
		
  		return "redirect:/secure/viewExecutives";
	}
	
	
	@RequestMapping(value="/deleteExecutive", method=RequestMethod.POST)
	public String deleteExecutive(@RequestParam(value="executiveId") Integer executiveId, 
								HttpServletRequest request, HttpServletResponse response)
	{
		executiveService.deleteExecutive( executiveId );
		
		request.getSession(false).setAttribute("viewExecutivesPageMessage", "Executive deleted sucessfully!");
		
		return "redirect:/secure/viewExecutives";	
	}
}
