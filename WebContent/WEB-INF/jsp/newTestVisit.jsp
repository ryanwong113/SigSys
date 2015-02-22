<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>New Test Visits</title>
</head>
<body>
	<form:form action="/SigSys/addTestVisit" modelAttribute="testVisitForm" method="POST">
		<label for="numberOfTestVisitsInput">Number of Test Visits: </label>
		<form:input id="numberOfTestVisitsInput" path="numberOfTestVisits" />
		<br>
	   	<input type="submit" value="submit" />  
	</form:form>
</body>
</html>