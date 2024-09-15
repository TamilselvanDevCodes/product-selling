<%@page import="java.util.Base64"%>
<%@page import="dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body style="background-color: gray">
	<h5 style="color:aqua; text-decoration: underline;">
	<%String message = (String)request.getAttribute("loginMessage"); %>
	<%if(message != null) {%>
	<%= message %>
	<%} %>
	</h5><br>
	
	<h5 style="color: green">
	<% String addMessage = (String)request.getAttribute("addMessage"); %>
	<%if(addMessage != null) { %>
	<%= addMessage %>
	<%} %>
	</h5>
	
	<h5 style="color: green">
	<% String updateMessage = (String)request.getAttribute("updateMessage"); %>
	<%if(updateMessage != null) { %>
	<%= updateMessage %>
	<%} %>
	</h5>
	
	
	<h5 style="color: green">
	<% String deleteMessage = (String)request.getAttribute("deleteMessage"); %>
	<%if(deleteMessage != null) { %>
	<%= deleteMessage %>
	<%} %>
	</h5>
	
	<a href="addproduct.jsp"><input type="button" value="ADD PRODUCT"></a><br><br>
	
	<table style="background-color: white" border="2px">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>BRAND</th>
			<th>PRICE</th>
			<th>DISCOUNT</th>
			<th>IMAGE</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<% List<ProductDto> products = (List)request.getAttribute("products"); %>
		<% for(ProductDto p : products) { %>
			<tr>
				<td><%=  p.getId() %></td>
				<td><%=  p.getName() %></td>
				<td><%=  p.getBrand() %></td>
				<td><%=  p.getPrice() %></td>
				<td><%=  p.getDiscount() %></td>
				<%String base64image = new String(Base64.getEncoder().encode(p.getImage())); %>
				<td><img src="data:image/jpeg;base64,<%= base64image %>"height="75px"width="75px" src="" ></td>  
				
				<td><a href="editproduct?id=<%= p.getId() %>" ><input type="button" value="EDIT"></a></td>
				<td><a href="deleteproduct?id=<%= p.getId()%>"><input type="button" value="DELETE"></a></td>
			</tr>
		<%}%>
	</table>
	<br><br>
	
	<a href="home" ><input type="button" value="REFRESH"></a>	
	<a href="logout"><input type="button" value="LOG OUT"></a>	
	
</body>
</html>