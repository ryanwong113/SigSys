<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<table>
	<tr><th><a href="/SigSys/homepage">Homepage</a></th></tr>
</table>

<table>
	<tr>
		<td>Visit ID</td>
		<td>${visit.id}</td>
	</tr>
	<tr>
		<td>Visitor Name</td>
		<td>${visit.visitor.firstName visit.visitor.lastName}</td>
	</tr>
	<tr>
		<td>From</td>
		<td>${visit.visitor.from}</td>
	</tr>
	<tr>
		<td>Visiting</td>
		<td>${visit.company}</td>
	</tr>
	<tr>
		<td>Visiting reason</td>
		<td>${visit.visitReason}</td>
	</tr>
	<tr>
		<td>Time In</td>
		<td>${visit.timeIn}</td>
	</tr>
	<tr>
		<td>Time Out</td>
		<td>${visit.timeOut}</td>
	</tr>
</table>