<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<title>Homepage</title>

<table>
	<tr>
		<th><a href="/SigSys/admin">Admin</a></th>
		<th><a href="/SigSys/filter">Filter</a></th>
		<th><a href="/SigSys/visitor">View Visitors</a></th>
		<th><a href="/SigSys/visit/addTest">Add Test Visits</a></th>
	</tr>
</table>

<form:form action="/SigSys/visit/add" modelAttribute="newVisitForm" method="POST">
	<table>
		<tr>
			<td><label for="firstNameInput">First Name:</label></td>
			<td><form:input id="firstNameInput" path="visitor.firstName" /></td>
		</tr>
		<tr>
			<td><label for="lastNameInput">Last Name:</label></td>
			<td><form:input id="lastNameInput" path="visitor.lastName" /></td>
		</tr>
		<tr>
			<td><label for="fromInput">From:</label></td>
			<td><form:input id="fromInput" path="visitor.from" /></td>
		</tr>
		<tr>
			<td><label for="companySelect">Visiting:</label></td>
			<td>
			<form:select id="companySelect" path="visit.company">
				<form:option value="">Select Company:</form:option>
				<c:forEach items="${companies}" var="company">
					<form:option value="${company}">${company.name}</form:option>
			 	</c:forEach>
			</form:select>
			</td>
		</tr>
		<tr>
			<td><label for="visitReasonInput">Visit Reason:</label></td>
			<td><form:input id="visitReasonInput" path="visit.visitReason" /></td>
		</tr>	
	</table>
   	<input type="submit" value="submit" />  
</form:form>

<c:choose>
	<c:when test="${isEmpty}">
		Oh, no data can be shown...
	</c:when>
	<c:otherwise>
		<tags:visitsTable />
	</c:otherwise>
</c:choose>