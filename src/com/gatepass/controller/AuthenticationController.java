package com.gatepass.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.gatepass.service.ExecutiveService;
import com.gatepass.util.SessionUtil;

@Controller
public class AuthenticationController 
{
	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
/*
	private ExecutiveService executiveService;
	
	@Autowired
	public void setExecutiveService(ExecutiveService executiveService) {
		this.executiveService = executiveService;
	}*/
	
//	private UserService userService;
//
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
	

	/*
	 * @see http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-redirecting
	 */
/*	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value="error", required=false) String error,
							  @RequestParam(value="loggedout", required=false) String logout,
							  HttpServletRequest request) 
	{
		ModelAndView mv;
		View view = new InternalResourceView("/jsp/login.jsp");
		mv = new ModelAndView(view);
		logger.debug("error="+error+", logout="+logout);
		if (error != null) {
			mv.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			mv.addObject("msg", "You've been logged out successfully.");
		}
		
		logger.debug("Redirecting to login.jsp");
		//SessionUtil.logSessionDetails(request);
		return mv;
	}

	@RequestMapping(value="/auth", method=RequestMethod.POST)
	public String loginUser(@RequestParam(value="username") String username,
								  @RequestParam(value="password") String password,
								  HttpServletRequest request, HttpServletResponse response)
	{
		logger.debug("username="+username+", password="+password);
		//boolean userExists = userService.isValidUser(username, password);
		boolean userExists = executiveService.isValidUser(username, password);
		//SessionUtil.logSessionDetails(request);
		String path = "redirect:login?error=true"; //redirect:/gps
		
		if(userExists)
		{
			path = "redirect:secure/home";
			
		}
			
		return path;
	}
*/	
	@RequestMapping(value="/secure/home", method={RequestMethod.GET})
	public ModelAndView gpsLoginUser(HttpServletRequest request)/*( @RequestParam(value="username") String username,
									@RequestParam(value="password") String password)*/
	{
		ModelAndView mv;
		logger.debug("Redirecting to home.jsp");
		//SessionUtil.logSessionDetails(request);
		
		View view = new InternalResourceView("/jsp/home.jsp");
		mv = new ModelAndView(view);
		
		
		//mv.addObject("firstName", "afshar");
		
		return mv;
	}
	/*
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logoutUser(HttpServletRequest request, HttpServletResponse response)
	{
		//SessionUtil.logSessionDetails(request);
		HttpSession session = request.getSession(false);
		logger.debug("User=" + session.getAttribute("user"));
		session.invalidate();
		logger.debug( "Session invalidated...." );	
		return "redirect:login?loggedout=true";
	}*/
}
