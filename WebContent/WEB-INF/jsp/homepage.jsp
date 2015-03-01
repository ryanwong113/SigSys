<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<title>Homepage</title>
</head>
<body>
	<a href="/SigSys/visit/add">Add visit</a>
	<br>
	<a href="/SigSys/visitor/add">Add visitor</a>
	<br>
	<a href="/SigSys/visitor/view">View visitors</a>
	<br>
	<a href="/SigSys/admin">Admin Page</a>
	<br>
	<a href="/SigSys/visit/addTest">Add test visits...</a>
	<br>
	
	<c:choose>
		<c:when test="${isEmpty eq 'true'}">
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