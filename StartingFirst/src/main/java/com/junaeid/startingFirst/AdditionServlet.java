package com.junaeid.startingFirst;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		if(req.getParameter("num1") != null && req.getParameter("num2") != null) {
			int num1, num2;
			num1 = Integer.parseInt(req.getParameter("num1"));
			num2 = Integer.parseInt(req.getParameter("num2"));
			
			PrintWriter out = res.getWriter();
			out.println("The sum is : "+ (num1+num2) );
		}
	}
}
