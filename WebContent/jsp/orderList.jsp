<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<spring:url value="/resources/css/style.css" var="styleCSS" />
<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />

<title>Orders</title>
</head>
<body>

<table class="table table-hover table-bordered">
                <thead style="background-color: #bce8f1;">

                    <tr>
                        <th>OrderId</th>
                        <th>Client Name</th>
                        <th>Product Id</th>
                        <th>Delivery Date</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orderList}" var="order">
                        <tr>
                            <td><c:out value="${order.orderId}" /></td>
                            <td><c:out value="${order.clientName}" /></td>
                            <td><c:out value="${order.productId}" /></td>
                            <td><c:out value="${order.deliveryDate}" /></td>
                            <td><c:out value="${order.quantity}" /></td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

</body>
</html>