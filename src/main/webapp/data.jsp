<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Data Utilities</h1>
	
<input type="text" />

<article>
	<c:forEach items="${context.logs}" var="log">
	<span>
		<h1>${log.logTitle}</h1>
		<span>${log.logText}</span>
	</span>
	</c:forEach>
</article>
