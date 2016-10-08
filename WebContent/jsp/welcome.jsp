<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<spring:url value="/resources/css/style.css" var="styleCSS" />
<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />
<title>Thank You</title>
</head>
<body>
<h1>Welcome to The  User</h1>
<div class="feature-container">
<div class="feature"><a href="../orders">Order Management</a></div>
<div class="feature"><a href="/rawMaterilas">Raw Material Inventory</a></div>
<div class="feature"><a href="/finishedGoods">Finished Goods Inventory</a></div>
<div class="feature"><a href="/procurement">Procurement</a></div>
<div class="feature"><a href="/operations">Operations</a></div>
<div class="feature"><a href="/resources">Resource Management Management</a></div>
<div class="feature"><a href="/notifications">Notifications</a></div>
<div class="feature"><a href="/reports">Reports</a></div>
</div>
<table class="table table-bordered">
		<thead>
			<tr>
				<th>#</th>
				<th>Column heading</th>
				<th>Column heading</th>
				<th>Column heading</th>
			</tr>
		</thead>

		<tbody>
			<tr class="active">
				<th scope="row">1</th>
				<td>Column content</td>
				<td>Column content</td>
				<td>Column content</td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Column content</td>
				<td>Column content</td>
				<td>Column content</td>
			</tr>
			<tr class="success">
				<th scope="row">3</th>
				<td>Column content</td>
				<td>Column content</td>
				<td>Column content</td>
			</tr>
			<tr>
				<th scope="row">4</th>
				<td>Column content</td>
				<td>Column content</td>
				<td>Column content</td>
			</tr>
			<tr class="info">
				<th scope="row">5</th>
				<td>Column content</td>
				<td>Column content</td>
				<td>Column content</td>
			</tr>
			<tr>
				<th scope="row">6</th>
				<td>Column content</td>
				<td>Column content</td>
				<td>Column content</td>
			</tr>
			<tr class="warning">
				<th scope="row">7</th>
				<td>Column content</td>
				<td>Column content</td>
				<td>Column content</td>
			</tr>
			<tr>
				<th scope="row">8</th>
				<td>Column content</td>
				<td>Column content</td>
				<td>Column content</td>
			</tr>
			<tr class="danger">
				<th scope="row">9</th>
				<td>Column content</td>
				<td>Column content</td>
				<td>Column content</td>
			</tr>
		</tbody>
</table>
</body>
</html>
