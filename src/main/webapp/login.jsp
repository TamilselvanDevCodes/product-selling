<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body style="background-color: gray; justify-content: center;text-align: center;">	

	<%String logmessage = (String)request.getAttribute("logmessage"); %>
	<%if(logmessage!= null){ %>
	<h4><%=logmessage %></h4>
	<%} %>
	<%String logoutmessage = (String)request.getAttribute("logoutmess"); %>
	<%if(logoutmessage!= null){ %>
	<h4><%=logoutmessage %></h4>
	<%} %>
	<h4>USER LOGIN</h4>
	<form action="login" method="post">
	<label  for="email"> E-MAIL :</label>
	<input type="email" placeholder="Enter Email Address" id="email" name="email"><br><br>
	<label for="password"> PASSWORD :</label>
	<input type="password" placeholder="Enter Password" id="password" name="password"><br><br>
	<%String message = (String)request.getAttribute("message"); %>
	<%if(message != null){ %>
	<h6 style="color: red"><%= message %></h6>
	<%} %>
	<input type = "submit" value="LOGIN"> 
	</form>

</body>
</html>