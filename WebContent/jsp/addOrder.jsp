<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<spring:url value="/resources/css/style.css" var="styleCSS" />
<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />
<title>Add New Order</title>
</head>
<body>

	<form:form id="addOrderForm" cssClass="form-horizontal"
		modelAttribute="orderModel" method="post" onsubmit=""
		action="addNewOrder">
		<div class="add-order">
			<div class="add-order-container">
				<div>
					<label>Client Name</label> 
					<select name="clientId">
						<option>Select</option>
						<c:forEach items="${clientList}" var="client">
						<option value="<c:out value="${client.id}" />"><c:out value="${client.name}" /></option>
						</c:forEach>
					</select>
				</div>
				<div>
					<label>Product Id</label> 
					<select name="productId">
						<option>Select</option>
						<c:forEach items="${productList}" var="product">
						<option value="<c:out value="${product.id}" />"><c:out value="${product.name}" /></option>
						</c:forEach>
					</select>
				</div>
				<div>
					<label>Quantity</label> <input type="text"
						style="padding: 10px; margin: 5px;" name="quantity">
				</div>
				<div>
					<label>Delivery Date</label> <input type="date"
						style="padding: 10px; margin: 5px;" name="deliveryDate">
				</div>
				<input type="submit" class="btn btn-lg btn-block btn-warning"id="loginSaveUserRequest"
					class="btn btn-primary" value="ADD ORDER" />
			</div>
		</div>
	</form:form>

</body>
</html>