<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="productDetails" class="com.junaeid.jsp.elements.actions.Product" >
		<jsp:setProperty name="productDetails" property="*"/>
	</jsp:useBean>
	<h1>Product Details : </h1>
	<br> ID : <jsp:getProperty property="id" name="productDetails"/>
	<br> Name : <jsp:getProperty property="name" name="productDetails"/>
	<br> Description : <jsp:getProperty property="description" name="productDetails"/>
	<br> Price : <jsp:getProperty property="price" name="productDetails"/>
</body>
</html>