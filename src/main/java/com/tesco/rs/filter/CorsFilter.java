package com.tesco.rs.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vagrant
 *
 */
public class CorsFilter implements javax.servlet.Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,PATCH");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept, Authorization,X-Client-Id");
		res.setHeader("DC", "WDC");
		res.setHeader("Access-Control-Expose-Headers", "Location");
		System.out.println("CorsFilter");
		chain.doFilter(request, res);

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
