package com.gatepass.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionUtil {
	
	private static Logger logger = LoggerFactory.getLogger(SessionUtil.class);

	public static void logSessionDetails(HttpServletRequest request)
	{
		// invalidate the session if exists
				HttpSession session = request.getSession(false);
				
				if (session != null) 
				{
					logger.debug("User=" + session.getAttribute("user"));
					session.invalidate();
				}
				
				Cookie[] cookies = request.getCookies();
				if (cookies != null) 
				{
					for (Cookie cookie : cookies) 
					{
						if (cookie.getName().equals("JSESSIONID")) 
						{
							logger.debug("JSESSIONID=" + cookie.getValue());
							
							break;
						}
					}
				}
	}

}
