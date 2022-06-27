package com.junaeid.customtag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport{
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement pst;
	public ResultHandler() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=mydb;user=junaeid;password=1234");
			pst = conn.prepareStatement("select * from customUsers where email=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int doStartTag() throws JspException {
		ServletRequest request = pageContext.getRequest();
		String email =  request.getParameter("email");
		JspWriter out = pageContext.getOut();
		try {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				out.print("<h1> First Name : ");
				out.println(rs.getString(1));
				out.println("</h1>");
				out.println("<br>");
				out.print("<h1> Last Name : ");
				out.println(rs.getString(2));
				out.println("</h1>");
			}else {
				out.println("User not exits");
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}
	
	@Override
	public void release() {
		try {
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
