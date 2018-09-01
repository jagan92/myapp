package com.myapp.controller;

import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DeploymentListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();

		try {
			ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
			Properties applicationProperties = (Properties) applicationContext.getBean("applicationProperties");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// This method will be invoked only once
		ServletContext context = event.getServletContext();

		// grab the application context
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
		try {
			Thread.sleep(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}