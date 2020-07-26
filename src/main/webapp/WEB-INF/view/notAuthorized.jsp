<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No Authorize</title>
</head>
<body>
<h3>You are not authorized to see this page</h3>
<form:form action="${pageContext.request.contextPath}/logout"  method="POST">
		<input type="submit" value="logout"/>
</form:form>
</body>
</html>