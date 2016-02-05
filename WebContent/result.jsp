<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="normalize.css">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Simple Query Result</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="body">
	<table id="query">
		<c:forEach var="results" items="${arrayList }">
			<tr>
				<c:forEach var="result" items="${results }">
					<td>${result}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>