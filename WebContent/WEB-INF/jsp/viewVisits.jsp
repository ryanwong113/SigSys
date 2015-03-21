<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<title>Visits</title>

<table>
<tr><th><a href="/SigSys/homepage">Homepage</a></th></tr>
</table>

<h2>Visits</h2>

<c:choose>
	<c:when test="${isEmpty}">
		Oh, no visits can be shown...
	</c:when>
	<c:otherwise>
		<tags:visitsTable />
	</c:otherwise>
</c:choose>