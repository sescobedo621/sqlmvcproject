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
		<li><a href="updateEmployee.do">Update Employees</a></li>
	</ul>
</header>

<div class="body">
	<table id="employee table">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Middle Name</th>
				<th>Last Name</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td><a href="updateEmployee.do?id=${employee.id}">${employee.id}</a></td>
					<td>${employee.firstName}</td>
					<td>${employee.middleName}</td>
					<td>${employee.lastName}</td>
					<td><form action="deleteEmployee.do" method="POST"><input type="hidden" name="id" value ="${employee.id}"><input type="submit" value="DELETE"></form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>