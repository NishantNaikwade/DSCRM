<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>DSCRM</h1>

<form action="login" method="post">
<div style="text-align:center;display: block;">
<div style="text-align: center; width: 40%;border: 1px solid grey;">
    User Name: <input type="text" style="padding: 10px;margin: 5px;" name="username">
    Password: <input type="password" style="padding: 10px;margin: 5px;" name="password">
    <input class="btn btn-default" type="submit" value="LOGIN">
    
    <div>
    <span class="error" style="padding: 10px;margin: 5px;">${error}</span>
    </div>
</div>    
</div>    
</form>
</body>
</html>