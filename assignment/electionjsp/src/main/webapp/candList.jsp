<%@page import="com.sunbeam.pojos.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Online voting App</h1>
<jsp:useBean id="lb" class="com.sunbeam.jbeans.CandBeans" />
<% lb.getAll(); %>
     

<% List<Candidate> c1 = lb.getC(); %>
<% for (Candidate cand : c1) { %>
	<form method="post" action="vote.jsp">
  <input type='radio' name='candidate' value='<%= cand.getId() %>'/> <%= cand.getName() %> (<%= cand.getParty() %>) <br/>
<% } %>
<input type='submit' value='Vote'/>
</form>
</body>
</html>