package com.junaeid.jdbc.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Account_dao {

	public static void main(String[] args) throws SQLException {
		Connection conn =  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc_crud;user=junaeid;password=1234");
		System.out.println(conn);
		Statement st = conn.createStatement();
		int result = st.executeUpdate("insert into account values(1003,'Ziaul','Hasan',7000)");
		System.out.println(result+" rows got inserted");
	}
}
