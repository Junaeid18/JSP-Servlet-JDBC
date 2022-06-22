<%@ page import="java.sql.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	PreparedStatement ps;
	Connection conn;
	
	public void jspInit(){
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=mydb;user=junaeid;password=1234");
		ps = conn.prepareStatement("insert into userAccount values(? , ? , ? , ? )");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void jspDestroy(){
		try{
			conn.close();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<%
	int acc = Integer.parseInt(request.getParameter("accno"));
	String fname = request.getParameter("firstname");
	String lname = request.getParameter("lastname");
	int balance = Integer.parseInt(request.getParameter("bal"));
	
	ps.setInt(1, acc);
	ps.setString(2, fname);
	ps.setString(3, lname);
	ps.setInt(4, balance);
	
	ps.executeUpdate();
%>

<%@ include file="openaccount.html" %>

