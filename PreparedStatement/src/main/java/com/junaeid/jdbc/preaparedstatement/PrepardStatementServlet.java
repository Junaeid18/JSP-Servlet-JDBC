package com.junaeid.jdbc.preaparedstatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class PrepardStatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PreparedStatement st; 
	private ServletContext context;
	private PrintWriter out;
	public void init(ServletConfig config) throws ServletException {
		try {
			context = config.getServletContext();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(context.getInitParameter("dbUrl")+
					context.getInitParameter("dbName")+context.getInitParameter("dbUser")+
					context.getInitParameter("dbPassword"));
			st = conn.prepareStatement("insert into product values(?,?,?,?)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			conn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String desc = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		out = response.getWriter();
		try {
			st.setInt(1, id);	st.setString(2, name);	st.setString(3, desc);	st.setInt(4, price);
			
			int result = st.executeUpdate();
			
			if(result > 0) {
				out.println("<h1>"+result+" no of product added</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
