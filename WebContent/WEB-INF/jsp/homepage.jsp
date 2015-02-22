<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Homepage</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/addVisit">Add visit</a>
	<br>
	<a href="${pageContext.request.contextPath}/addVisitor">Add visitor</a>
	<br>
	<a href="${pageContext.request.contextPath}/viewVisitors">View visitors</a>
	<br>
	<a href="${pageContext.request.contextPath}/admin">Admin Page</a>
	<br>
	<a href="${pageContext.request.contextPath}/addTestVisit">Add test visits...</a>
	<br>
	
	<c:choose>
		<c:when test="${isEmpty eq 'true'}">
			Oh, no data can be shown...
		</c:when>
		<c:otherwise>
			<table>
				<tr>
			        <td>Visit ID</td>
			        <td>Visitor</td>
			        <td>From</td>
			        <td>Visiting</td>
			        <td>Visit Reason</td>
			        <td>Time In</td>
			        <td>Time Out</td>
			        <td></td>
			    </tr>
			    
			    <!-- Show all visits from cache -->
		    	<c:forEach var="visit" items="${visits}">
		    		<tr>
		    			<td><c:out value="${visit.id}" /></td>
		    			<td><c:out value="${visit.visitor.firstName} ${visit.visitor.lastName}" /></td>
		    			<td><c:out value="${visit.visitor.from}" /></td>
		    			<td><c:out value="${visit.company.name}" /></td>
		    			<td><c:out value="${visit.visitReason}" /></td>
		    			<td><c:out value="${visit.timeIn}" /></td>
		    			<td></td>
		    			<c:url value="/endVisit" var="endVisitUrl">
		    				<c:param name="visitId" value="${visit.id}"/>
		    			</c:url>
		    			<td><a href="${endVisitUrl}">End visit</a></td>
		    		</tr>
		    	</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	
</body>
</html>