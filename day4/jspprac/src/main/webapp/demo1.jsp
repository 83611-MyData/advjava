<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jsp syntax</title>
</head>
<body>

<h1>jsp syntax demo</h1>
<%-- jsp declarartion --%>
<%! int count = 0;
public void jspInit() {
	
	System.out.println("demo1 jspInit() called");
}

public void jspDestroy() {
	System.out.println("demo1 jspDestroy() called");
}

%>

<%--jsp scriplet--%>
<% Date now = new Date();
   out.println("Server Time: " +now);
%>

<br/>
<%count++; %>
<%if(count % 2 == 0) { %>
Even Coutn: <%= count %>
<% } else { %>
	Odd Count: <%= count %>
	<% } %>
	<br/>
	
	<%
	
	if(count % 2 == 0)
		out.println("Even Count: " + count);
	else 
		out.println("Odd Count: " + count);
	
	%>

</body>
</html>