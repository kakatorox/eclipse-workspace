<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="cl.desafiolatam.model.Persona"%>
<%
	List<Persona> listaPersona = (ArrayList<Persona>) request.getAttribute("listaPersona");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("titulo") %>
	<table>
		<thead>
			<tr>
				<td>Rut</td>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>Fecha Nacimiento</td>
			</tr>
		</thead>
		<tbody>	
			<%
				for(Persona p : listaPersona){
			%>
				<tr>
					<td><%=p.getRut() %></td>
					<td><%=p.getNombre() %></td>
					<td><%=p.getApellido() %></td>
					<td><%=p.getFechaNac() %></td>
				</tr>
			<%	}%>
		</tbody>
	</table>
</body>
</html>