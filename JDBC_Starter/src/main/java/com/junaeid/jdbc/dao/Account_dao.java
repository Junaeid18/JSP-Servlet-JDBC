package com.junaeid.jdbc.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account_dao {

	public static void main(String[] args) throws SQLException {
		Connection conn =  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc_crud;user=junaeid;password=1234");
		System.out.println(conn);
		Statement st = conn.createStatement();
		//int result = st.executeUpdate("insert into account values(1003,'Ziaul','Hasan',7000)");
		//System.out.println(result+" rows got inserted");
		
		//int result = st.executeUpdate("update account set balance = 15940 where accno = 1001");
		//System.out.println(result+" rows got updated");
		
		//int result = st.executeUpdate("delete from account where accno between 1002 and 1003");
		//System.out.println(result+" rows got deleted");
		
		ResultSet res = st.executeQuery("select * from account");
		while(res.next()) {
			int acc = res.getInt(1);
			String fname = res.getString(2);
			String lname = res.getString(3);
			int bala = res.getInt(4);
			System.out.println(acc+" "+fname+" "+lname+" "+bala);
		}
	}
}
