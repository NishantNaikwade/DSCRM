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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="${bootstrapCSS}" rel="stylesheet" />
<title>View All</title>
<style type="text/css">
.myrow-container {
	margin: 20px;
}
</style>
</head>
<body>
<body class=".container-fluid">
	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">
					<div align="left">
						<b>Employees List</b>
					</div>
					<div align="right">
						<a href="createEmployee">Add New Employee</a>
					</div>
				</h3>
			</div>
			<div class="panel-body">
				<c:if test="${empty employeeList}">
There are no Employees
</c:if>
				<c:if test="${not empty employeeList}">

					<form action="searchEmployee">
						<div class="row">
							<div class="col-md-6">
								<div class="col-md-6">Search Employees:</div>
								<div class="col-md-6">
									<input type="text" name="searchName" id="searchName">
								</div>
							</div>
							<div class="col-md-4">
								<input class="btn btn-success" type='submit' value='Search' />
							</div>
						</div>
					</form>

					<table class="table table-hover table-bordered">
						<thead style="background-color: #bce8f1;">

							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Mobile</th>
								<th>Email</th>
								<th>Description</th>
								<th>Request Time</th>
								<th>Request Update Time</th>
							</tr>
						</thead>
						</tbody>
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
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>