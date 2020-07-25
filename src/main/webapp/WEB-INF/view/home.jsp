<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title> Spring security home page</title>
</head>
<body>
	<h2>Spring security home page--Yahoo</h2>
	<form:form action="${pageContext.request.contextPath}/logout"  method="POST">
		<input type="submit" value="logout"/>
	</form:form>
</body>
</html>