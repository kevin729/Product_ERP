<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<h1>Products</h1>
	
	<table>
		<tbody>
			<c:forEach items="${context.products}" var="item">
				<tr>
					<td>
						${item.key}
					</td>
					<td>
						${item.value[0] / item.value[1] * 100}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
