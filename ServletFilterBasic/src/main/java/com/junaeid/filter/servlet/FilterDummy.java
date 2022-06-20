package com.junaeid.filter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/DemoFilter")
public class FilterDummy extends HttpFilter {
	private static final long serialVersionUID = 1L;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.print("Pre processing filter ->");
		chain.doFilter(request, response);
		out.println("Port processing filter.");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
