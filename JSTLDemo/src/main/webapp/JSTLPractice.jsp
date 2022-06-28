<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<j:set var="mydate" value="29-06-2022"/>	
		<f:parseDate var="parseDate" value="${mydate}" pattern="dd-MM-yyyy"/>
		ParseDate : <j:out value="${parseDate}"></j:out>
	</h1>

	<h1>
		:fmt in Action :- <br>
		<j:set var="i" value="${4000.234}" />
		<f:parseNumber var="i" type="number" value="${i}" />
		String to Number :
		<j:out value="${i}" />
		<br>Number to currency 1 :
		<f:formatNumber value="${i}" type="currency" />
		<br>Number to currency 2:
		<f:formatNumber value="${i}" type="currency" maxFractionDigits="1" />
		<br>Number to currency 3:
		<f:formatNumber value="${i}" type="percent" />
		<br>Number to currency 4:
		<f:formatNumber value="${i}" type="currency" maxIntegerDigits="2" />
		<br>Number to currency 5:
		<f:formatNumber value="${i}" type="number" pattern="@ ###.#####" />
	</h1>

	<h1>
		Out in JSTL :
		<j:out value="${50}"></j:out>
	</h1>
	<h1>
		:set in Action :-
		<j:set var="amount" scope="session" value="${100}" />
		<j:out value="${amount}"></j:out>
	</h1>
	<h1>
		:remove in Action :-
		<j:remove var="amount" />
		<j:out value="${amount}"></j:out>
	</h1>
	<h1>
		:if in Action :-
		<j:set var="amount" scope="session" value="${100}" />
		<j:if test="${amount >=50}">
			<p>Value is greater than or equal to 50.</p>
		</j:if>
		<j:if test="${amount == null}">
			<p>No value</p>
		</j:if>
	</h1>
	<h1>
		:choose (switch in Java) :-

		<j:choose>
			<j:when test="${amount>= 100}">
				<p>It's the best one & it's 100.</p>
			</j:when>
			<j:when test="${amount>= 80}">
				<p>It's the better one & it's 80 or +.</p>
			</j:when>
			<j:otherwise>
				<p>It's nothing you thought.</p>
			</j:otherwise>
		</j:choose>
	</h1>
	<h1>
		:forEach in JSTL:
		<j:forEach var="i" begin="1" end="5">
			<h3>
				Value of var i =
				<j:out value="${i}"></j:out>
			</h3>
		</j:forEach>
		<%
		ArrayList<String> list = new ArrayList<>();
		list.add("Junaeid");
		list.add("Gazi");
		list.add("Jun");
		request.setAttribute("list", list);
		%>
		Another forEach Test :-
		<j:forEach var="name" items="#{list}">
			<br>Name : <j:out value="${name}" />
		</j:forEach>
	</h1>

</body>
</html>