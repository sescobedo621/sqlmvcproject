<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple Update</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="body">
	<form method="POST" action="update.do">
		<input type="text" name="sqltext" size="100" /> <br><input type="submit"
			value="Insert" />
	</form>
	</div>
</body>
</html>