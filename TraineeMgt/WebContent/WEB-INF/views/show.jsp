<%@page import="com.app.traineemgt.model.service.Trainee"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Trainees</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	Welcome ${user}
	<br>!
	<a href="LogoutController">Logout</a>
	<br>
	<div class="row">
    <div class="col-sm-8">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Trainee Id</th>
				<th>Name</th>
				<th>Branch</th>
				<th>Percentage</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trainees}" var="trainee">
				<tr>
					<td><c:out value="${trainee.traineeId }" /></td>
					<td><c:out value="${trainee.traineeName}" /></td>
					<td><c:out value="${trainee.branch}" /></td>
					<td><c:out value="${trainee.percentage}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    </div>
 </div>  
	<a href="TraineeController.do?action=add">Add Trainee</a>
</body>
</html>