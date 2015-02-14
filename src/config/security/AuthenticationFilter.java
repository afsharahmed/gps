package config.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class AuthenticationFilter

@WebFilter( dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ERROR }, 
			asyncSupported  = true, 
			urlPatterns 	= { "/secure*", "/jsp*" } // If some urls need to be by-passed, then put only those urls that need to be authenticated. Eg. { "/login*","/secure*", .. } or { "/*" }
		   ) */
public class AuthenticationFilter implements Filter 
{
	private Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);
//	private ServletContext context;
	
    public AuthenticationFilter() { }

	public void init(FilterConfig filterConfig) throws ServletException {
//        this.context = filterConfig.getServletContext();
        logger.info("AuthenticationFilter initialized.");
    }

	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> params = req.getParameterNames();
		boolean userLoggedOut = false;
	
		logger.info("Passing through AUTHENTICATION filter. Request URI - "+req.getRequestURI()+",  ContextPath - "+req.getContextPath()+" - "+req.getServletPath());

		while (params.hasMoreElements()) {
			String name = params.nextElement();
			String value = request.getParameter(name);
			logger.info(req.getRemoteAddr() + "::Request Params::{" + name + "=" + value + "}");
			
		//	if(name.equals("logout"))
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				logger.info(req.getRemoteAddr() + "::Cookie::{" + cookie.getName() + "," + cookie.getValue() + "}");
			}
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	// SOme imp methods
	/* request.getRequestURI()
	 * 
	 */

}
