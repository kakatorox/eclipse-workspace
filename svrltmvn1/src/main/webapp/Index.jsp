<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="cl.desafiolatam.model.Persona"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
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
			<c:forEach var="p" items="${listaPersona}">
				<tr>
					<td><c:out value="${p.rut}"/></td>
					<td><c:out value="${p.nombre}"/></td>
					<td><c:out value="${p.apellido}"/></td>
					<td><c:out value="${p.fechanac}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>