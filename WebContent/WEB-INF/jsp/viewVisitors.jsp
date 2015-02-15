<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Visitors</title>
</head>
<body>
	<a href="/SigSys/homepage">Homepage</a>
	<br>
	
	<c:choose>
		<c:when test="${isEmpty == 'true'}">
			Oh, no visitors can be shown...
		</c:when>
		<c:otherwise>
			<table>
				<tr>
			        <td>Visitor ID</td>
			        <td>Visitor Name</td>
			        <td>From</td>
			    </tr>
			    
			    <!-- Show all visits from cache -->
		    	<c:forEach var="visitor" items="${visitors}">
		    		<tr>
		    			<td><c:out value="${visitor.id}" /></td>
		    			<td><c:out value="${visitor.firstName} ${visitor.lastName}" /></td>
		    			<td><c:out value="${visitor.from}" /></td>
		    		</tr>
		    	</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	
</body>
</html>