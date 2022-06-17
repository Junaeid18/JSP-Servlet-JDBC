package com.junaeid.preinitialization;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/preinit",loadOnStartup=1)
public class Preinit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello Boss, Talking from the init method");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException {	
		try {
			res.getWriter().write("Boss it's me the second one");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
