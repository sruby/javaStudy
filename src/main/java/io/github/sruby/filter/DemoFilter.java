package io.github.sruby.filter;

import io.github.sruby.servlet.ServletContextDemo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * filter demo
 * @author liuwf on Jun 12, 2017 7:47:33 PM
 */
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	System.out.println("doFilter!!!");
    	
    	ServletContextDemo servletContextDemo = new ServletContextDemo();
    	ServletContext servletContext = servletContextDemo.getServletContext();
    	Object attribute = servletContext.getAttribute("p");
    	System.out.println("attribute"+attribute);
    	
    	chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy!!!");
    }
}