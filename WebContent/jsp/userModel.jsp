
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--validation-->
<script type="text/javascript">
	function checkEmail(value) {
		$('div.alert').hide();
		$.ajax({

			url : '${home}email_Unique',
			type : 'POST',
			data : {
				value : value
			},
			dataType : 'json',
			success : function(result) {
				if (result) {
					//alert("success");
					document.getElementById('email').value = '';
					$("#ajax_div").show();
					$('#email').focus();
				} else {
					//alert("failure");
					$("#ajax_div").hide();
				}

			}
		});

	}
</script>
<script type="text/javascript" src="resources/js/innerHTMLValidation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
<!-- Include JS File Here -->
<link rel='stylesheet'
	href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

<link rel="stylesheet" href="resources/css/style1.css" media="screen"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/registration.js"></script>
</head>
<body>
	<div class="container">
		<div class="content">
			<center>
				<form:form name="form1" modelAttribute="userModel" method="post"
					action="saveUser">
					<fieldset>
						<h2>Create Registration Form</h2>
						<table border='0'>

							<tr>
								<td><LABEL for="firstname">First Name:<sup
										style="color: #F00">*</sup>
								</LABEL></td>
								<td><INPUT type="text" id="firstname" name="firstname"></td>
								<td width="200px"><i style="color: red;" id="pointfn"></i></td>
							</tr>
							<tr>
								<td><LABEL for="lastname">Last Name:<sup
										style="color: #F00">*</sup>
								</LABEL></td>
								<td><INPUT type="text" id="lastname" name="lastname"></td>
								<td width="200px"><i style="color: red;" id="pointln"></i></td>
							</tr>
							<tr>
								<td><LABEL for="email">Email:<sup
										style="color: red;">*</sup>
								</LABEL></td>
								<td><INPUT type="text" id="email" name="email" class="form-control" ></td>
								<td width="200px"><i style="color: red;" id="pointemail"></i></td>
							</tr>
							<tr>
								<td><LABEL for="contctno">Contact Number:<sup
										style="color: #F00">*</sup>
								</LABEL></td>
								<td><INPUT type="text" id="contctno" name="mobile"></td>
								<td width="200px"><i style="color: red;" id="pointcontct"></i></td>
							</tr>
							<tr>
								<td><LABEL for="usernam">User_name:<sup
										style="color: #F00">*</sup>
								</LABEL></td>
								<td><INPUT type="text" id="usernam" name="userName"></td>
								<td width="200px"><i style="color: red;" id="pointname"></i></td>
							</tr>

							<!-- <tr>	<td><input type="text" name="email" id="email"
								value="" placeholder="email" class="form-control"
								onchange="checkEmail(this.value)" /></td>
								</tr> -->
							<tr>
								<td><LABEL for="password1">Password:<sup
										style="color: #F00">*</sup>
								</LABEL></td>
								<td><INPUT type="password" id="password1" name="password"></td>
								<td width="200px"><i style="color: red;" id="pointpassword"></i></td>
							</tr>
							<tr>
								<td></td>
								<td><br /> <INPUT type="submit"
									onClick="return validateForm()" value="Submit"> <INPUT
									type="reset" onClick="return confirmreset()"></td>
							</tr>
							<tr>
								<td></td>
								<td style="font-size: 12px; text-align: right;"><br /> <i
									style="color: red; font-size: 12px; align: right;">All
										fields marked with * are Mandatory</i></td>
							</tr>

						</table>
					</fieldset>

				</form:form>
			</center>
		</div>
	</div>
</body>
</html>