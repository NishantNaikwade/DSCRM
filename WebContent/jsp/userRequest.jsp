<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Ranga Reddy"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<link href="${bootstrapCSS}" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
<div class="panel panel-success">
<div class="panel-heading">
<h3 class="panel-title">
Employee Details
</h3>
</div>
<div class="panel-body"> 

<form:form id="employeeRegisterForm" cssClass="form-horizontal" method="POST" modelAttribute="userRequest" action="/DSCRM/saveUserRequest">
<div style="display: block;margin:5%;">
<div style="">
<div class="form-group">
<label >Name</label>
     <form:input class="form-control" type="text" style="padding: 10px;margin: 5px;" name="name" path="name" id="name" />
</div>
    <div class="form-group">
<label >Email</label>
    
     <form:input class="form-control" type="text" style="padding: 10px;margin: 5px;" name="email" path="email" id="email" />
     </div>
     <div class="form-group">
<label >Description</label>
    <form:input class="form-control" type="text" style="padding: 10px;margin: 5px;" name="requirementDescription" path="requirementDescription" id="requirementDescription" />
    </div>
    <div class="form-group">
<label >Mobile</label>
 <form:input class="form-control" type="text" style="padding: 10px;margin: 5px;" name="mobile" path="mobile" id="mobile" />
</div>    
    <input class="btn btn-default" type="submit" value="SAVE">
    
    <div>
    <span class="error" style="padding: 10px;margin: 5px;">${error}</span>
    </div>
</div>    
</div>    
</form:form>
</body>
</html>