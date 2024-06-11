 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
     <%@ page import="jspprac.LoginBean" %>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="ISO-8859-1">
 <title>Java Beans</title>
 </head>
 <body>
 	<jsp:useBean id="lb" class="jspprac.LoginBean"/>
 	<jsp:setProperty name="lb" property="email" param="email"/>
 	<jsp:setProperty name="lb" property="password" param="passwd"/>
 	<% lb.authenticate(); %>
 	<% if(lb.getUser() != null) { %>
 		Welcome, <jsp:getProperty name="lb" property="email" />
 	<% } else { %>
 		Login Failed.
 	<% } %>
 </body>
 </html>