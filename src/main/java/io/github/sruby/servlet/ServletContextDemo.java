package io.github.sruby.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextDemo implements ServletContextListener
{
	private ServletContext servletContext;

	
	public ServletContext getServletContext()
	{
		return servletContext;
	}

	
	public void setServletContext(ServletContext servletContext)
	{
		this.servletContext = servletContext;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		this.servletContext = sce.getServletContext();
		servletContext.setAttribute("p", 1);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		
	}
	
}
