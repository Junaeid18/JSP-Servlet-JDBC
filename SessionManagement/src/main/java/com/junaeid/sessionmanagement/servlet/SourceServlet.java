package com.junaeid.sessionmanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i = 0; i < cookies.length; ++i) {
				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
			} 			
		}
		String name = request.getParameter("userName");
		HttpSession session = request.getSession();
		session.setAttribute("user", name);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='targetServlet'>Click here to get the User Name.</a>");
	}
}


/*  <servlet>
  	<servlet-name>sourceServlet</servlet-name>
  	<servlet-class>com.junaeid.sessionmanagement.servlet.SourceServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>sourceServlet</servlet-name>
  	<url-pattern>sourceServlet</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>targetServlet</servlet-name>
  	<servlet-class>com.junaeid.sessionmanagement.servlet.TargetServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>targetServlet</servlet-name>
  	<url-pattern>targetServlet</url-pattern>
  </servlet-mapping>
  
 */