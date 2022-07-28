<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management</title>
<link href="main.css" rel="stylesheet" type="text/css"></link>

<script type="text/javascript">
	window.addEventListener("load", () => {	
		let employees = $("#employees").val()
		employees = employees.replace(/[\[\]\s]/g, "").split(",")
		alert(employees)
		
		$("#employeeField").autocomplete({
			minLength: 0,
			source: function(req, res) {
				res(employees)
			}
		})
		
		$("#employeeField").click(() => {
			$("#employeeField").autocomplete("search", "")	
		})
	})
</script>

</head>
<body>
	<h1>HR</h1>
	<input type="hidden" id="employees" value="${context.employees}"/>
	<input id="employeeField"/>
</body>
</html>