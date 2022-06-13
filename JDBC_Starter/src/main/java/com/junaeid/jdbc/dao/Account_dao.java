package com.junaeid.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Account_dao {

	public static void main(String[] args) throws SQLException {
		Connection conn =  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TODO;user=junaeid;password=1234");
		System.out.println(conn);
	}
}
