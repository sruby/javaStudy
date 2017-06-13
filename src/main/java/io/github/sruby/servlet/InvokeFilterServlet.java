package io.github.sruby.servlet;

import io.github.sruby.filter.DemoFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InvokeFilterServlet extends HttpServlet
{
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		HttpServletRequest request;
		HttpServletResponse response;
		
		try
		{
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) res;
			DemoFilter demoFilter = new DemoFilter();
			FilterChain chain = new FilterChain()
			{
				@Override
				public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException
				{
					System.out.println("empty filterchain instance");
				}
			};
			
			try
			{
				demoFilter.doFilter(request, response, chain);
			}
			catch (IOException | ServletException e)
			{
				e.printStackTrace();
			}
		}
		catch (ClassCastException e)
		{
			throw new ServletException("non-HTTP request or response");
		}
	}
}
