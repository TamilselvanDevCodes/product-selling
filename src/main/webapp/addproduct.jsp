<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD PRODUCT</title>
</head>
<body  style="background-color: gray;">
	
	<form action="addproduct" method="post" enctype="multipart/form-data" style=" background-color: black;">
	<label style="background-color: silver;" for="id">Enter Id : </label>
	<input type="number" id="id" name="id"><br><br>
	<label style="background-color: silver;" for="name">Enter Name : </label>
	<input type="text" id="name" name="name"><br><br>
	<label style="background-color: silver;" for="brand">Enter Brand : </label>
	<input type="text" id="brand" name="brand"><br><br>
	<label style="background-color: silver;" for="price">Enter Price : </label>
	<input type="number" id="price" name="price"><br><br>
	<label style="background-color: silver;" for="discount">Enter Discount : </label>
	<input type="number" id="discount" name="discount"><br><br>
	<label style="background-color: silver;" for="image">Enter Image : </label>
	<input type="file" id="image" name="image"><br><br>
	<input style="background-color: silver;" type="submit" value="ADD PRODUCT">
	
	
	<%String message = (String) request.getAttribute("notAddMessage"); %>
	<%if(message!= null) { %>
	<h6 style="color: red"><%= message %></h6> 
	<%} %>
	</form>
</body>
</html>