package com.junaeid.interservletcommunication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		ServletContext context = getServletContext();
		PreparedStatement pst;
		ResultSet res;
		RequestDispatcher rd;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(context.getInitParameter("dbUrl")+
					context.getInitParameter("dbName")+context.getInitParameter("dbUser")+
					context.getInitParameter("dbPassword"));
			pst = conn.prepareStatement("select * from users where email = '"+email+"' and password = '"+password+"' ");
			res = pst.executeQuery();
			rd = request.getRequestDispatcher("homeservlet");
			if(res.next()) {
				request.setAttribute("msg", "Weldone "+ email+ ". You have done it.");
				rd.forward(request, response);
			}else {
				rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
