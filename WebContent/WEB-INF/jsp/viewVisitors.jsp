<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<head>
<title>Visitors</title>
</head>
<body>
	<a href="/SigSys/homepage">Homepage</a>
	<br>
	<c:choose>
		<c:when test="${isEmpty eq 'true'}">
			Oh, no visitors can be shown...
		</c:when>
		<c:otherwise>
			<display:table id="visitor" name="visitors">
				<display:column title="ID" >${visitor.id}</display:column>
				<display:column title="First Name">${visitor.firstName}</display:column>
				<display:column title="Last Name">${visitor.lastName}</display:column>				
				<display:column title="From">${visitor.from}</display:column>
			</display:table>
		</c:otherwise>
	</c:choose>
</body>