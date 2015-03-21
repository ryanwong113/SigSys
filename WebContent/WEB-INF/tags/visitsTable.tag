<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<display:table id="visit" name="visits" requestURI="/SigSys/">
	<display:column title="Visit ID" >${visit.id}</display:column>
	<display:column title="Visitor">${visit.visitor.firstName} ${visit.visitor.lastName}</display:column>
	<display:column title="From">${visit.visitor.from}</display:column>
	<display:column title="Visiting">${visit.company.name}</display:column>
	<display:column title="Visit Reason">${visit.visitReason}</display:column>			
	<display:column title="Time In" sortable="true"><joda:format value="${visit.timeIn}" pattern="dd/MM/yyyy hh:mm:ss a" /></display:column>
	<display:column title="Time Out" sortable="true"><joda:format value="${visit.timeOut}" pattern="dd/MM/yyyy hh:mm:ss a" /></display:column>
	<display:column title="End Visit"><a href="/SigSys/visit/end/${visit.id}">End visit</a></display:column>
</display:table>