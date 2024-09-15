<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body  style="background-color: gray;">
	<form action="signup" method="post">
	<label for="id">ID :</label>
	<input type="number" id="id" name = "id"><br>
	<label for="name">NAME :</label>
	<input type="text" id="name" name="name"><br>
	<label for="email">EMAIL :</label>
	<input type="email" id="email" name = "email"><br>
	<label for="contact">CONTACT NUMBER :</label>
	<input type="number" id="contact" name = "contact"><br>
	<label for="password">PASSWORD :</label>
	<input type="password" id="password" name="password"><br>
	<input type="submit" value="REGISTER">
	</form>
</body>
</html>