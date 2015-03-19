<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<title>Filter</title>

<table>
	<tr><th><a href="/SigSys/homepage">Homepage</a></th></tr>
</table>

<form:form action="/SigSys/visit/filter" modelAttribute="filterVisitsForm" method="POST">
	<table>
		<tr>
			<td><label for="firstNameInput">First Name: </label></td>
			<td><form:input id="firstNameInput" type="text" path="firstName" /></td>
		</tr>
		<tr>
			<td><label for="lastNameInput">Last Name: </label></td>
			<td><form:input id="lastNameInput" type="text" path="lastName" /></td>
		</tr>
		<tr>
			<td><label for="companyCheckboxes">Company: </label></td>
			<td><form:checkboxes id="companyCheckboxes" items="${companies}" path="companies" /></td>
		</tr>
		<tr>
			<td><label for="timeInInput">Time In: </label></td>
			<td><form:input id="timeInInput" type="text" path="timeIn" /></td>
		</tr>
		<tr>
			<td><label for="timeOutInput">Time Out: </label></td>
			<td><form:input id="timeOutInput" type="text" path="timeOut" /></td>
		</tr>
	</table>
	<input type="submit" value="Filter Visits" />
</form:form>

<form:form action="/SigSys/visitor/filter" modelAttribute="filterVisitorsForm" method="POST">
	<table>
		<tr>
			<td><label for="firstNameInput">First Name: </label></td>
			<td><form:input id="firstNameInput" type="text" path="firstName" /></td>
		</tr>
		<tr>
			<td><label for="lastNameInput">Last Name: </label></td>
			<td><form:input id="lastNameInput" type="text" path="lastName" /></td>
		<tr>
	</table>
	<input type="submit" value="Filter Visitors" />		
</form:form>