<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>

	<h1>Index page</h1>

	<p>List of users:</p>

	<c:forEach var="user" items="${listUser}">
		<tr>
			<td><c:out value="${user.id}" /></td>
			<td><c:out value="${user.name}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.password}" /></td>
		</tr>
	</c:forEach>

</body>
</html>