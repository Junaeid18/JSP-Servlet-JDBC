package com.junaeid.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addServlet")
public class createUserServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	
    public void init() throws ServletException {
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=mydb;user=junaeid;password=1234");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		try {
			PrintWriter out = response.getWriter();
			Statement st = conn.createStatement();
			int result = st.executeUpdate("insert into users values( '"+fname+"' , '"+lname+"', '"+email+"','"+pass+"')");
			if(result > 0) {
				out.println("<h1>New User Created.</h1>");
			}else out.println("<h1>Error occured.</h1>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		try {
			conn.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
