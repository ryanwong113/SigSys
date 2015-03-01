<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
	<title>New Visitor</title>
</head>
<body>
	<a href="/SigSys/homepage">Homepage</a>
	<br>
	<form:form action="/SigSys/visitor/add" modelAttribute="newVisitor" method="POST">
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