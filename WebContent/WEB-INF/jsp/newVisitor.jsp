<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>New Visitor</title>
</head>
<body>
	<form:form action="/SigSys/addVisitor" modelAttribute="newVisitor" method="POST">
	   	<label for="firstNameInput">First Name: </label>
      	<form:input id="firstNameInput" path="firstName" />
		<br>
		<label for="lastNameInput">Last Name: </label>
		<form:input id="lastNameInput" path="lastName" />
		<br>
		<label for="fromInput">From: </label>
		<form:input id="fromInput" path="from" />
		<br>
		<input type="submit" value="submit" /> 
	</form:form>
</body>
</html>