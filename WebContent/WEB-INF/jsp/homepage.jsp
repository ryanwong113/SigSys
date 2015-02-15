<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Homepage</title>
</head>
<body>
	<a href="/SigSys/addVisit">Add visit</a>
	<br>
	<a href="/SigSys/addVisitor">Add visitor</a>
	<br>
	<a href="/SigSys/viewVisitors">View visitors</a>
	<br>
	<a href="/SigSys/admin">Admin Page</a>
	<br>
	<a href="<c:url value="/addTestVisits" />">Add some test visits...</a>
	<br>
	<br>
	
	<c:choose>
		<c:when test="${isEmpty == 'true'}">
			Oh, no data can be shown...
		</c:when>
		<c:otherwise>
			<table>
				<tr>
			        <td>Visit ID</td>
			        <td>Visitor</td>
			        <td>Visiting</td>
			        <td>Visit Reason</td>
			        <td>Time In</td>
			        <td>Time Out</td>
			    </tr>
			    
			    <!-- Show all visits from cache -->
		    	<c:forEach var="visit" items="${visits}">
		    		<tr>
		    			<td><c:out value="${visit.id}" /></td>
		    			<td><c:out value="${visit.visitor.firstName} ${visit.visitor.lastName}" /></td>
		    			<td><c:out value="${visit.company.name}" /></td>
		    			<td><c:out value="${visit.visitReason}" /></td>
		    			<td><c:out value="${visit.timeIn}" /></td>
		    			<td></td>
		    		</tr>
		    	</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	
</body>
</html>