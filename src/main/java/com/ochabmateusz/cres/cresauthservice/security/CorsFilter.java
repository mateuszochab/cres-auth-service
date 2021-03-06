package com.ochabmateusz.cres.cresauthservice.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	public CorsFilter() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		
		//res.setHeader("Access-Control-Allow-Origin", "*");
		//res.setHeader("Access-Control-Allow-Credentials", "true");
		//res.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT");
		//res.setHeader("Access-Control-Max-Age", "3600");
		//res.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, content-type");
		res.setHeader("Access-Control-Expose-Headers", "Authorization");
		if("OPTIONS".equalsIgnoreCase(req.getMethod())) {
			res.setStatus(HttpServletResponse.SC_OK);
		}else {
			chain.doFilter(request, response);
			
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	


	
	
}