package com.junaeid.connectionpooling.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ConnectionPoolingServlet")
public class ConnectionPoolingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:comp/env/myds");
			Connection connection = ds.getConnection();
			System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
