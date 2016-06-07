<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login Page</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form:form id="employeeRegisterForm" cssClass="form-horizontal" modelAttribute="loginUserRequest" method="post" action="loginSaveUserRequest">
<div style="padding: 100px 0 0 250px;">
<div id="login-box">
<h2>Login Page</h2>
Please provide your information

<div id="login-box-name" style="margin-top:20px;">User Name:</div>
<div id="login-box-field" style="margin-top:20px;">
<input name="userId" class="form-login" title="Username" value="" size="30" maxlength="50" />
</div>
<div id="login-box-name">Password:</div>
<div id="login-box-field">
<input name="password" type="password" class="form-login" title="Password" value="" size="30" maxlength="48" />
</div>
<br />
<input style="margin-left:100px;" type="submit" value="Login" />
</div>
</div>
</form:form>
</body>
</html>