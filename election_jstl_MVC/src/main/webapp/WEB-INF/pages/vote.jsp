<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${initParam.appTitle}</h3>
	Hello Voter, ${lb.user.firstName} ${lb.user.lastName} <hr/>
<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
<jsp:setProperty name="vb" property="candidateId" param="candidate"/>
<jsp:setProperty name="vb" property="userId" value="${lb.user.id}"/>

${vb.registerVote()}
<c:choose>
	<c:when test="${vb.count == 1}">
		Voted Successfully.... Thank you
		<br/>
		<hr/>
			<%--<a href="logout.jsp">Logout</a> --%>
			<a href="ctl?page=logout">Logout</a>
		
	</c:when>
	
	<c:otherwise>
		
		Voting is failed<br/>
		<%--<a href="index.jsp">Login Again</a> --%>
		<a href="ctl?page=index">Login Again</a>
	</c:otherwise>
</c:choose>



${vb.incrementStatus() }
<c:choose>
<c:when test="${lb.user.status==1}">
Already voted
</c:when>
<c:otherwise></c:otherwise>
</c:choose>




</body>
</html>