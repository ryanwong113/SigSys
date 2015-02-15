<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>New Visit</title>
</head>
<body>
	<form:form action="/SigSys/addVisit" modelAttribute="newVisitForm" method="POST">
		<label for="firstNameInput">First Name: </label>
      	<form:input id="firstNameInput" path="visitor.firstName" />
		<br>
		<label for="lastNameInput">Last Name: </label>
		<form:input id="lastNameInput" path="visitor.lastName" />
		<br>
		<label for="fromInput">From: </label>
		<form:input id="fromInput" path="visitor.from" />
		<br>
		<label for="companySelect">Visiting: </label>
		<form:select id="companySelect" path="visit.company">
			<form:option value="">Select Company: </form:option>
			<c:forEach items="${companies}" var="company">
				<form:option value="${company}">${company}</form:option>
		 	</c:forEach>
		</form:select>
		<br>
		<label for="visitReasonInput">Visit Reason: </label>>
		<form:input id="visitReasonInput" path="visit.visitReason" />
		<br>
	   	<input type="submit" value="submit" />  
	</form:form>
</body>
</html>