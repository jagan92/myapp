package com.myapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myapp.logging.LogManager;
import com.myapp.logging.Logger;

public class CustomFilter implements Filter {

	HttpSession session;
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		try {
			String contextPath = httpRequest.getContextPath();
			session = httpRequest.getSession();
			String requestUri = httpRequest.getRequestURI();
			
			//httpResponse.setHeader("Cache-Control", "no-store, no-cache");
			//httpResponse.setHeader("Pragma", "no-cache");
			chain.doFilter(request, response);	
		} catch (Exception ex) {
			LOGGER.error(CustomFilter.class.getName(), "doFilter", "errorMessage = " + ex);
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {
		if (session != null) {
			session.invalidate();
		}
	}

}
