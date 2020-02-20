<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/estilo.css" rel="stylesheet">
</head>
<body>

	<h1>Index page</h1>

	<p>List of users:</p>

	<c:forEach var="user" items="${listUser}">
		<ul>
			<li><c:out value="${user.id}" /></li>
			<li><c:out value="${user.name}" /></li>
			<li><c:out value="${user.email}" /></li>
			<li><c:out value="${user.password}" /></li>
		</ul>
	</c:forEach>
	
<script src="resources/js/jquery-3.4.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/script.js"></script>

</body>
</html>