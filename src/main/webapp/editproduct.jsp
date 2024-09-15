<%@page import="java.util.Base64"%>
<%@page import="dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT PRODUCT DETAILS</title>
</head>
<body>
	<h4>
	<%String message = (String) request.getAttribute("message"); %>
	<%if(message!= null){ %>
	<%= message %>
	<%} %>
	<% ProductDto p = (ProductDto)request.getAttribute("product"); %>
	<form action="updateproduct" method="post" enctype="multipart/form-data" style="background-color: black;">
	<label for="id" style="background-color: silver;" >ID : </label>
	<input type="number" value="<%= p.getId()%>" id="id" name="id" readonly="true"><br><br>
	<label style="background-color: silver;" for="name">Enter New Name : </label>
	<input type="text" value="<%=p.getName()  %>" id="name" name="newname"><br><br>
	<label style="background-color: silver;" for="brand">Enter New Brand : </label>
	<input type="text" value="<%=p.getBrand()%>" id="brand" name="newbrand"><br><br>
	<label style="background-color: silver;" for="price">Enter New Price : </label>
	<input type="number" value="<%=p.getPrice()%>"  id="price" name="newprice"><br><br>
	<label style="background-color: silver;" for="discount">Enter New Discount : </label>
	<input type="number" value="<%=p.getDiscount() %>" id="discount" name="newdiscount"><br><br>
	<label style="background-color: silver;" for="image">Enter New Image : </label>
	
	<%String base64image = new String(Base64.getEncoder().encode(p.getImage())); %>
	<img src="data:image/jpeg;base64,<%= base64image %>"height="75px"width="75px" src="" >
	<input type="file" id="image" name="newimage"><br><br>
	<input style="background-color: silver;" type="submit" value="UPDATE PRODUCT">
	
	</form>
	
	
</body>
</html>