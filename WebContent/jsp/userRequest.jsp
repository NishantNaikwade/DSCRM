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
	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Employee Details</h3>
			</div>
			<div class="panel-body">
				<form:form id="employeeRegisterForm" cssClass="form-horizontal"
					modelAttribute="userRequest" method="post"
					onsubmit="return validateFormOnSubmit(this)"
					action="sendEmail">

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="name">Name</form:label>
						</div>
						<div class="col-xs-6">
							<form:hidden path="id" value="${userObject.id}" />
							<form:input cssClass="form-control" path="name"
								value="${userObject.name}" />
						</div>
					</div>

					<div class="form-group">
						<form:label path="email" cssClass="control-label col-xs-3">Email</form:label>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="email"
								value="${userObject.email}" />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="mobile">Mobile</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="mobile"
								value="${userObject.mobile}" />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="mobile">Description</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="requirementDescription"
								value="${userObject.requirementDescription}" />
						</div>
					</div>


					<div class="form-group">
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<input type="submit" id="saveUserRequest"
									class="btn btn-primary" value="Save" />
							</div>
							<div class="col-xs-4"></div>
						</div>
					</div>

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