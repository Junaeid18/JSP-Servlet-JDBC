package com.jdbc.advance.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDAO {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=mydb;user=junaeid;password=1234");
			Statement st = conn.createStatement();
			conn.setAutoCommit(false);
			st.executeUpdate("update userAccount set balance=balance-1000 where lname = 'Junaeid'");
			st.executeUpdate("update userAccount set balance=balance+1000 where lname = 'Alim'");
			conn.commit();
			System.out.println("Done Transaction Boss");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
