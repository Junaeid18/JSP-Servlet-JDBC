<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Coupon</title>
</head>
<body>
	<form action="couponController" method="post">
		<pre>
		Coupon Code : <input type="text" name="code"> <br>
		Expiry Date : <input type="text" name="exp"><br>
		Discount : <input type="text" name="discount"><br>
		<input type="hidden" name="action" value="create">
		<button type="submit">Submit</button>		
		</pre>
	</form>
</body>
</html>