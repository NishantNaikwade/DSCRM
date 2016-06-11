
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

  function checkForm(form)
  {
    if(form.userName.value == "") {
      alert("Error: Username cannot be blank!");
      form.userName.focus();
      return false;
    }
    re = /^\w+$/;
    if(!re.test(form.userName.value)) {
      alert("Error: Username must contain only letters, numbers and underscores!");
      form.userName.focus();
      return false;
    }

    if(form.userPassword.value != "") {
      if(form.userPassword.value.length < 6) {
        alert("Error: Password must contain at least six characters!");
        form.userPassword.focus();
        return false;
      }
      if(form.userPassword.value == form.userName.value) {
        alert("Error: Password must be different from Username!");
        form.userPassword.focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(form.userPassword.value)) {
        alert("Error: password must contain at least one number (0-9)!");
        form.userPassword.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.userPassword.value)) {
        alert("Error: password must contain at least one lowercase letter (a-z)!");
        form.userPassword.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.userPassword.value)) {
        alert("Error: password must contain at least one uppercase letter (A-Z)!");
        form.userPassword.focus();
        return false;
      }
    }

    alert("You entered a valid password: " + form.userPassword.value);
    return true;
  }

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>DSCRM</h1>

<form:form id="employeeRegisterForm" cssClass="form-horizontal" modelAttribute="loginUserRequest" method="post" onsubmit="return checkForm(this)" action="loginSaveUserRequest">
<div style="text-align:center;display: block;">
<div style="text-align: center; width: 40%;border: 1px solid grey;">
  USERNAME: <input type="text" style="padding: 10px;margin: 5px;" name="userName"><br></br>
  PASSWORD: <input type="password" style="padding: 10px;margin: 5px;" name="userPassword"><br></br>
  <input type="submit" id="loginSaveUserRequest" class="btn btn-primary" value="login"/>
    <div>
    <span class="error" style="padding: 10px;margin: 5px;">${error}</span>
    </div>
</div>    
</div>    
</form:form>

</body>
</html>