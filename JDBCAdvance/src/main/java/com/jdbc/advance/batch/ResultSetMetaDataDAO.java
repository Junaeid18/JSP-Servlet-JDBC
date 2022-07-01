package com.jdbc.advance.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataDAO {
	public static void main(String[] args) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:sqlserver://localhost:1433;databaseName=mydb;user=junaeid;password=1234");
				Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery("select * from userAccount");
			ResultSetMetaData mt = rs.getMetaData();
			int columns = mt.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				System.out.println(mt.getColumnName(i));
				System.out.println(mt.getColumnClassName(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
