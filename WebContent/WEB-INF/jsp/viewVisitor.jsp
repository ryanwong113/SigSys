<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<table>
	<tr><th><a href="/SigSys/homepage">Homepage</a></th></tr>
</table>

<table>
	<tr>
		<td>Visitor ID</td>
		<td>${visitor.id}</td>
	</tr>
	<tr>
		<td>First Name</td>
		<td>${visitor.firstName}</td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td>${visitor.lastName}</td>
	</tr>
	<tr>
		<td>From</td>
		<td>${visitor.from}</td>
	</tr>
</table>