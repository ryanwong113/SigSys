<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

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
		<display:table id="visit" name="visits" requestURI="/SigSys/">
			<display:column title="Visit ID" >${visit.id}</display:column>
			<display:column title="Visitor">${visit.visitor.firstName} ${visit.visitor.lastName}</display:column>
			<display:column title="From">${visit.visitor.from}</display:column>
			<display:column title="Visiting">${visit.company.name}</display:column>
			<display:column title="Visit Reason">${visit.visitReason}</display:column>
			<display:column title="Time In" sortable="true">${visit.timeIn}</display:column>
			<display:column title="Time Out" sortable="true">${visit.timeOut != null ? visit.timeOut : ''}</display:column>
			<display:column title="End Visit"><a href="/SigSys/visit/end/${visit.id}">End visit</a></display:column>
		</display:table>
	</c:otherwise>
</c:choose>