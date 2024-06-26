<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<div style="background-color:beige"><center><u><h1>Register User</h1></u></center></div>
<div style="background-color:#97d5f3 ; margin-top:200px">
<form method="post" action="register.jsp">
<label>First Name:</label>
<input type="text" name="firstName"/>
<br/>
<br/>
<label>Last Name:</label>
<input type="text" name="lastName"/>
<br/>
<br/>
<label>Email:</label>
<input type="email" name="email"/>
<br/>
<br/>
<label>Password:</label>
<input type="password" name="password"/>
<br/>
<br/>
<label>dob:</label>
<input type="date" name="dob"/>
<br/>
<br/>
<label>Role:</label>
<input type="text" name="role"/>
<br/>
<br/>
<input type="submit"/>
<br/>
<br/>
<br/>
Already have an account / <a href="index.jsp">SignIn</a> 
</form>
</div>
</body>
</html>