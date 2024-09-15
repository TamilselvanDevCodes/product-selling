<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="background-color:silver;">
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body  style="background-color:gray;">
	
	<%String message = (String)request.getAttribute("message"); %>
	
	<% if(message != null){ %>
	<h4><%= message %></h4>
	<%} %>
	
	
	<a style="align-self: center;" href="login.jsp">LOGIN</a><br>
	<a style="align-self: center;" href="signup.jsp">SIGNUP</a><br>
</body>
</html>