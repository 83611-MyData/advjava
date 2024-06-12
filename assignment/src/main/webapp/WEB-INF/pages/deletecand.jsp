<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>

<h3>${initParam.appTitle}</h3>
	<jsp:useBean id="fcb" class="com.sunbeam.beans.DeleteCandidateBean"/>
	<jsp:setProperty name="fcb" property="id" param="id"/>
	${ fcb.DeleteCandidate() }
	<jsp:forward page="result.jsp"/>
	
</body>
</html>