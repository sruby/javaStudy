package io.github.sruby.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * test
 * @author liuwf on Jun 12, 2017 7:51:16 PM
 */
public class Client
{
	public static void main(String[] args)
	{
		DemoFilter demoFilter = new DemoFilter();
		FilterChain chain = new FilterChain()
		{
			@Override
			public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException
			{
				System.out.println("empty filterchain instance");
			}
		};
		ServletResponse response = null;
		ServletRequest request = null;
		
		try
		{
			demoFilter.doFilter(request, response, chain);
		}
		catch (IOException | ServletException e)
		{
			e.printStackTrace();
		}
	}
}
