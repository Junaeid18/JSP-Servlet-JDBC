package com.jdbc.advance.batch;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BatchDAO {
	public static void main(String[] args) {
		try(Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=mydb;user=junaeid;password=1234");
				Statement st = conn.createStatement();	) {
			st.addBatch("insert into userAccount values(21,'Jalal','Miya',1233)");
			st.addBatch("insert into userAccount values(23,'Jasim','Miya',122233)");
				
			int[] result = st.executeBatch();
			
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
			
			ResultSet rs = st.executeQuery("select * from userAccount");
			ResultSetMetaData mt = rs.getMetaData();
			int columns = mt.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				System.out.println(mt.getColumnName(i));
			}
		}catch (Exception e ) {
			e.printStackTrace();
		}
	}
}
