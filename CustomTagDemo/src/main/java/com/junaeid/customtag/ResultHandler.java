package com.junaeid.customtag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport{
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
	public void release() {
		try {
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
