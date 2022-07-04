<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
</head>
<body>
	<form action="productController" method="post">
		<pre>
		Product Name : <input type="text" name="name"> <br>
		Description : <input type="text" name="desc"><br>
		Price : <input type="text" name="price"><br>
		Coupon Code : <input type="text" name="code"><br>
		<button type="submit">Submit</button>		
		</pre>
	</form>
</body>
</html>