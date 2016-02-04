<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="normalize.css">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Insert title here</title>
</head>
<body>
<header>
	<ul>
		<li><h2><a href="index.html">companyRolodex</a></h2></li>
		<li><a href="sql.do">Simple Select Query</a></li>
		<li><a href="update.do">Simple Update</a></li>
		<li><a href="allEmployees.do">List All Employees</a></li>
		<li><a href="addEmployee.do">Add Employee</a></li>
	</ul>
</header>
<div class="body">
	<form method="POST" action="updateEmployee.do">
		ID: <input type="text" name="id" size="8" value="${employee.id }"/><br> First Name: <input
			type="text" name="firstName" value="${employee.firstName }" /> <br>Middle Name: <input
			type="text" name="middleName" value="${employee.middleName }"/> <br>Last Name:<input
			type="text" name="lastName" value="${employee.lastName }" /><br>
			Salary: <input type="text" name="salary" value="${employee.salary }"> <br>
			Street Address: <input type="text" name="address" value="${employee.address }"/>
			City: <input type="text" name="city" value="${employee.city }"/>
			State:<select name="state"> <c:forEach var="st" items="${states}">
			<option value=${st }>${st}</option>
			</c:forEach>
			</select>
			<br>zipcode:
			<input type="text" name="zipcode" value="${employee.zipcode}"/>
			<input type="submit" value="Add Employee"/>

	</form>
</div>
</body>
</html>
</body>
</html>