package com.example.demo.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 解决前后端跨域问题
 */
public class MyFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hrequest = (HttpServletRequest) request;
		//System.out.println("过滤器this is MyFilter.url" + hrequest.getRequestURL());
		HttpServletResponse response1 = (HttpServletResponse) response;
		String origin = ((HttpServletRequest) request).getHeader("Origin");
		logger.info("当前访问的是：[{}]", origin);
		response1.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		response1.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response1.setHeader("Access-Control-Max-Age", "3600");
		response1.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		response1.addHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
