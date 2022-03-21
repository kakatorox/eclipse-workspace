<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	String nombre = request.getParameter("inputName");
	String genero = (String) request.getAttribute("genero");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hola <%if(genero.equalsIgnoreCase("M")){ %>
				<%= nombre %> es Hombre
				<%}else{ %>
				<%= nombre %> no es hombre
				<%}%>
	</h1>
</body>
</html>