<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management</title>
<link href="/Product_Management/main.css" rel="stylesheet" type="text/css"></link>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
</head>
<body>
	<h1>Welcome to Product Management</h1>
	
	<c:forEach items="${pages}" var="item">
		<a class="menuBtn" href="/Product_Management/control/${item.value}">${item.key}</a>
	</c:forEach>
	
</body>
</html>