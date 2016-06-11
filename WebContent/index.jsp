<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<link href="${bootstrapCSS}" rel="stylesheet" />
<!-- <link href="./css/bootstrap.css" rel="stylesheet" /> -->
<title>DSCRM</title>
</head>
<body>
    <h1>DSCRM</h1>

<form method="get" action="LoginLogout">
        <div style="text-align: center; display: block;">
            <div style="text-align: center; border: 1px solid grey;">
                User Name: <input type="text" style="padding: 10px; margin: 5px;"
                    name="username"><br></br> Password: <input type="password"
                    style="padding: 10px; margin: 5px;" name="password"> 
                  <input type="submit" id="loginSaveUserRequest" class="btn btn-primary" value="Login" />

                <div>
                    <span class="error" style="padding: 10px; margin: 5px;">${error}</span>
                </div>
            </div>
        </div>
</form>
</body>
</html>