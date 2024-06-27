<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<h3>${initParam.appTitle}</h3>
	Thank You, ${lb.user.firstName} ${lb.user.lastName} <hr/>
	<%--<a href="index.jsp">Login Again</a> --%>
	<a href="ctl?page=index">Login Again</a>


</body>
</html>