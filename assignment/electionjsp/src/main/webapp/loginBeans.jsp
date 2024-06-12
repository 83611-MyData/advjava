<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.jbeans.LogginBeans" />
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="password" />
	<% lb.authenticate(); %>
	<% if(lb.getUser()!=null){ %>
	      Hello, <jsp:getProperty name="lb" property="email"/>
	      <jsp:forward page="candList.jsp" />
	      <%} else { %>
	      Login Failed
	      <%} %>
</body>
</html>