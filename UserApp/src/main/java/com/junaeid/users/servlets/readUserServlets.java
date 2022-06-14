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

@WebServlet("/readServlet")
public class readUserServlets extends HttpServlet {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("select * from users");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>");
			out.println("First Name");
			out.println("</th>");
			out.println("<th>");
			out.println("Last Name");
			out.println("</th>");
			out.println("<th>");
			out.println("Email Name");
			out.println("</th>");
			out.println("</tr>");
			while(res.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(res.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.println(res.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.println(res.getString(3));
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
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
