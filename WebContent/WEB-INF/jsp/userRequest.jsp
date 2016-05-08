<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>User Request </h1>

<form:form method="POST" modelAttribute="userRequest" action="saveUserRequest">
<div style="text-align:center;display: block;">
<div style="text-align: center; width: 40%;border: 1px solid grey;">
    NAME : <form:input type="text" style="padding: 10px;margin: 5px;" name="name" path="name" id="name" />
    EMAIL : <form:input type="text" style="padding: 10px;margin: 5px;" name="email" path="email" id="email" />
    DESCRITPION : <form:input type="text" style="padding: 10px;margin: 5px;" name="requirementDescription" path="requirementDescription" id="requirementDescription" />
    MOBILE : <form:input type="text" style="padding: 10px;margin: 5px;" name="mobile" path="mobile" id="mobile" />
    
    <input class="btn btn-default" type="submit" value="SAVE">
    
    <div>
    <span class="error" style="padding: 10px;margin: 5px;">${error}</span>
    </div>
</div>    
</div>    
</form:form>
</body>
</html>