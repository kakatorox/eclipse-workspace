<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cl.desafiolatam.desafiorelop1.dto.UsuarioDto" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% 

	List<UsuarioDto> listaUsuario;
	listaUsuario     = (List) request.getAttribute("Nombres");

%>
<body>
				<% 
				  	for(UsuarioDto dto: listaUsuario){
				  %>
				  	<label>
				  			<%=dto.getUsuario().getNombre()%>
				  	</label>
				  <% 
				  	}
				  %>


</body>
</html>