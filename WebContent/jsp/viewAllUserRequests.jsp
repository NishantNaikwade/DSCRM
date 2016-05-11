<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<link href="${bootstrapCSS}" rel="stylesheet" />
<title>View All</title>
</head>
<body>

	<table class="table table-striped" >
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Description</th>
			<th>Request Time</th>
			<th>Request Update Time</th>
		</tr>
		<c:forEach var="userRequest" items="${userRequests}">
			<tr>
				<td>${userRequest.id}</td>
				<td>${userRequest.name}</td>
				<td>${userRequest.mobile}</td>
				<td>${userRequest.email}</td>
				<td>${userRequest.requirementDescription}</td>
				<td>${userRequest.requestTime}</td>
				<td>${userRequest.requestUpdateTime}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>