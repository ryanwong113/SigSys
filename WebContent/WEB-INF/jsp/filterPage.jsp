<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<head>
<title>Filter</title>
</head>
<body>
	<p>
	<form:form action="/SigSys/filter/visits" modelAttribute="filterVisitsForm" method="POST">
		<label for="companyCheckboxes">Company: </label>
		<form:checkboxes id="companyCheckboxes" items="${companies}" path="companies" />
		<br>
		<label for="timeInInput">Time In: </label>
		<form:input id="timeInInput" type="text" path="timeIn" />
		<br>
		<label for="timeOutInput">Time Out: </label>		
		<form:input id="timeOutInput" type="text" path="timeOut" />
		<br>
		<input type="submit" value="Filter Visits" /> 
	</form:form>
	</p>
	
	<p>
	<form:form action="/SigSys/filter/visitors" modelAttribute="filterVisitorsForm" method="POST">
		<label for="firstNameInput">First Name: </label>
		<form:input id="firstNameInput" type="text" path="firstName" />
		<br>
		<label for="lastNameInput">Last Name: </label>
		<form:input id="lastNameInput" type="text" path="lastName" />
		<br>
		<input type="submit" value="Filter Visitors" /> 
	</form:form>
	</p>
</body>
