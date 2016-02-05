<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="normalize.css">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Add Employee</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="body">
	<form method="POST" action="addEmployee.do">
		ID: <input type="text" name="id" size="8" /><br> First Name: <input
			type="text" name="firstName" /> <br>Middle Name: <input
			type="text" name="middleName" /> <br>Last Name:<input
			type="text" name="lastName" /><br>
			Street Address: <input type="text" name="address"/>
			City: <input type="text" name="city"/>
			State:<select name="state"> <c:forEach var="st" items="${states}">
			<option value=${st }>${st}</option>
			</c:forEach>
			</select>
			<br>zipcode:
			<input type="text" name="zipcode"/>
			<input type="submit" value="Add Employee"/>

	</form>
</div>
</body>
</html>