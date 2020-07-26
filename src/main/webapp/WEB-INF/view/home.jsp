<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title> Spring security home page</title>
</head>
<body>
	<h2>Spring security home page--Yahoo</h2>
	<p>
		User : <security:authentication property="principal.username"/>
		<br><br>
		Roles: <security:authentication property="principal.authorities"/>
	</p>
	
	<security:authorize access="hasRole('MANAGER')">
	<p> Manager travel itinerary : <a href="${pageContext.request.contextPath}/leaders/internationalConference">Travel itinerary</a></p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<p> System Admin page : <a href="${pageContext.request.contextPath}/system/adminHomePage">Admin home</a></p>
	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout"  method="POST">
		<input type="submit" value="logout"/>
	</form:form>
</body>
</html>