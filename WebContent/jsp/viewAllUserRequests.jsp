<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="${bootstrapCSS}" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>View All</title>
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
				<div class="panel-title">
					<div align="left">
						<b>User List</b>
					</div>
					<div align="right">
						<a href="createUser">Add New User</a>
					</div>
				</div>
			</div>
			</div>
			</div>
			<div class="panel-body">
				<form action="searchUserByMobile">
					<div class="row">
						<div class="col-md-6">
							Mobile Number:<input type="text" name="searchMobile"
								id="searchMobile">
						</div>
					</div>   
					</form>
                     </div>         
					<div class="panel-body">
						<form action="searchUser">
							<div class="row">
								<div class="col-md-6">
									Name:<input type="text" name="searchName" id="searchName">
								</div>
								</div>
							  </form> 
                              </div>
							<div align="right">
								<div class="col-md-4">
									<input class="btn btn-success" type='submit' value='Search' />
                                   </div>
                                    </div>
                                 
                              
                                                    
				<c:if test="${empty userRequests}">
                    There are no User
                </c:if>
				<c:if test="${not empty userRequests}">

					<form action="viewAllUserRequests">


						<table class="table table-hover table-bordered">
							<thead style="background-color: #bce8f1;">

								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Mobile</th>
									<th>Email</th>
									<th>Description</th>
									<th>Request Time</th>
									<th>Request Update Time</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${userRequests}" var="userRequests">
									<tr>
										<th><c:out value="${userRequests.id}" /></th>
										<th><c:out value="${userRequests.name}" /></th>
										<th><c:out value="${userRequests.mobile}" /></th>
										<th><c:out value="${userRequests.email}" /></th>
										<th><c:out value="${userRequests.requirementDescription}" /></th>
										<th><c:out value="${userRequests.requestTime}" /></th>
										<th><c:out value="${userRequests.requestUpdateTime}" /></th>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>	
				</c:if>				
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>