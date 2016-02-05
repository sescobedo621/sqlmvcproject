<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="normalize.css">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Edit Employees</title>
</head>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="body">
	<table>
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
					<td id="employeelink"><a href="updateEmployee.do?id=${employee.id}">${employee.id}</a></td>
					<td>${employee.firstName}</td>
					<td>${employee.middleName}</td>
					<td>${employee.lastName}</td>
					<td><form action="deleteEmployee.do" method="POST" id="delete"><input type="hidden" name="id" value ="${employee.id}"><input type="submit" value="DELETE"></form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>