<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Ranga Reddy">
<head>
<script type="text/javascript">
    function validateFormOnSubmit(theForm) {
        var reason = "";
        reason += validateUsername(theForm.name);
        reason += validateEmail(theForm.email);
        reason += validatePhone(theForm.mobile);

        if (reason != "") {
            alert("Some fields need correction:\n" + reason);
            return false;
        }

        alert("All fields are filled correctly");
        return true;
    }
    function validateUsername(fld) {
        var error = "";
        var illegalChars = /\W/; // allow letters, numbers, and underscores

        if (fld.value == "") {
            fld.style.background = 'Yellow';
            error = "You didn't enter a username.\n";
        } else if ((fld.value.length < 4) || (fld.value.length > 15)) {
            fld.style.background = 'Yellow';
            error = "The username is the wrong length.\n";
        } else if (illegalChars.test(fld.value)) {
            fld.style.background = 'Yellow';
            error = "The username contains illegal characters.\n";
        } else {
            fld.style.background = 'White';
        }
        return error;
    }

    function trim(s) {
        return s.replace(/^\s+|\s+$/, '');
    }
    function validateEmail(fld) {
        var error = "";
        var tfld = trim(fld.value); // value of field with whitespace trimmed off
        var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/;
        var illegalChars = /[\(\)\<\>\,\;\:\\\"\[\]]/;

        if (fld.value == "") {
            fld.style.background = 'Yellow';
            error = "You didn't enter an email address.\n";
        } else if (!emailFilter.test(tfld)) { //test email for illegal characters
            fld.style.background = 'Yellow';
            error = "Please enter a valid email address.\n";
        } else if (fld.value.match(illegalChars)) {
            fld.style.background = 'Yellow';
            error = "The email address contains illegal characters.\n";
        } else {
            fld.style.background = 'White';
        }
        return error;
    }
    function validatePhone(fld) {
        var error = "";
        var stripped = fld.value.replace(/[\(\)\.\-\ ]/g, '');

        if (fld.value == "") {
            error = "You didn't enter a phone number.\n";
            fld.style.background = 'Yellow';
        } else if (isNaN(parseInt(stripped))) {
            error = "The phone number contains illegal characters.\n";
            fld.style.background = 'Yellow';
        } else if (!(stripped.length == 10)) {
            error = "The phone number is the wrong length. Make sure you included an area code.\n";
            fld.style.background = 'Yellow';
        }
        return error;
    }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Information</title>
<!-- Bootstrap CSS -->
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style type="text/css">
.myrow-container {
    margin: 20px;
}
</style>
</head>
<body class=".container-fluid">
<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String mobile = request.getParameter("mobile");
    String email = request.getParameter("email");
    String desc = request.getParameter("desc");
    System.out.println("id--->"+id);
    System.out.println("name--->"+name);
    System.out.println("mobile--->"+mobile);
    System.out.println("email--->"+email);
    System.out.println("desc--->"+desc);
%>
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">Employee Details</h3>
            </div>
            <div class="panel-body">
                <form:form id="updateUserAction" cssClass="form-horizontal"
                    modelAttribute="userRequest" method="post"
                    onsubmit="return validateFormOnSubmit(this)"
                    action="updateUserAction">

                    <div class="form-group">
                        <div class="control-label col-xs-3">
                            <label >Name</label>
                        </div>
                        <div class="col-xs-6">
                         <c:forEach items="${updateUserRequests }" var="updateUserRequests">
                            <input type="hidden" id="id" name="id" value="${updateUserRequests.id}" />
                            </c:forEach>
                            <c:forEach items="${updateUserRequests }" var="updateUserRequests">
                            <input type="text" cssClass="form-control" path="name" id="name" name="name"
                                value="${updateUserRequests.name}" />
                                </c:forEach>
                        </div>
                    </div>

                    <div class="form-group">
                    <div class="control-label col-xs-3">
                        <label>Email</label>
                        </div>
                        <div class="col-xs-6">
                        <c:forEach items="${updateUserRequests }" var="updateUserRequests">
                            <input type="text" cssClass="form-control" path="email" id="email" name="email"
                                value="${updateUserRequests.email}" />
                                </c:forEach>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3">
                        <label >Mobile</label>
<%--                            <form:label path="mobile">Mobile</form:label> --%>
                        </div>
                        <div class="col-xs-6">
                        <c:forEach items="${updateUserRequests }" var="updateUserRequests">
                            <input type="text" cssClass="form-control" path="mobile" name="mobile"
                            id="mobile" value="${updateUserRequests.mobile}" />
                        </c:forEach>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3">
                            <label >Description</label>
                        </div>
                        <div class="col-xs-6">
                        <c:forEach items="${updateUserRequests }" var="updateUserRequests">
                            <input type="text" cssClass="form-control" path="requirementDescription" name="requirementDescription"
                                id="requirementDescription" value="${updateUserRequests.requirementDescription }"/>
                                </c:forEach>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4"></div>
                            <div class="col-xs-4">
                                <input type="submit" class="btn btn-primary" value="Save" />
                            </div>
                            <div class="col-xs-4"></div>
                        </div>
                    </div>
                    <tr>
<%--                        <td colspan="2"><c:if test="${!empty userRequest.name}">
                                <input type="submit"
                                    value="<spring:message text="Edit UserRequest"/>" />
                            </c:if> <c:if test="${empty userRequest.name}">
                                <input type="submit"
                                    value="<spring:message text="Add UserRequest"/>" />
                            </c:if></td> --%>
                    </tr>

                </form:form>
            </div>
        </div>
    </div>

    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


</body>
</html>