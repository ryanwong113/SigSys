<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<title>Visitors</title>

<table>
<tr><th><a href="/SigSys/homepage">Homepage</a></th></tr>
</table>

<h2>Visitors</h2>

<c:choose>
	<c:when test="${isEmpty}">
		Oh, no visitors can be shown...
	</c:when>
	<c:otherwise>
		<tags:visitorsTable />
	</c:otherwise>
</c:choose>