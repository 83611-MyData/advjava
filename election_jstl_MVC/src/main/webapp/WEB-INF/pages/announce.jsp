<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ano" class ="com.sunbeam.beans.AnnouncementBean" scope="application" />
<jsp:setProperty property="announce" name="ano" param="ann"/>

<jsp:forward page="result.jsp" />

</body>
</html>