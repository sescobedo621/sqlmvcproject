
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="normalize.css">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Update Employee</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="body">
	<form method="POST" action="updateEmployee.do">
		<input type="hidden" name="id" value="${employee.id }">First Name: <input
			type="text" name="firstName" value="${employee.firstName }" /> <br>Middle Name: <input
			type="text" name="middleName" value="${employee.middleName }"/> <br>Last Name:<input
			type="text" name="lastName" value="${employee.lastName }" /><br>
			Salary: <input type="text" name="salary" value="${employee.salary }"> <br>
			Street Address: <input type="text" name="address" value="${employee.address }"/>
			City: <input type="text" name="city" value="${employee.city }"/>
			</select>
			<br>zipcode:
			<input type="text" name="zipcode" value="${employee.zipcode}"/>
			<input type="submit" value="Update Employee"/>

	</form>
</div>
</body>
</html>