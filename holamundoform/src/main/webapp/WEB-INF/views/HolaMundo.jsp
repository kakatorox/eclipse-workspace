<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/hola/agregarAlguien" method="POST" modelAttribute="personaDto">
		Rut Persona: <form:input path="persona.rut" id="idRutPersona" name="rutPersona"/>
		Nombre Persona: <form:input path="persona.nombre" id="idNombrePersona" name="nombrePersona"/>
		Apellido Persona: <form:input path="persona.apellido" id="idApellidoPersona" name="apellidoPersona"/>
		<hr/>
		Direccion Persona: <form:input path="persona.direccion.descripcion" id="idDireccionPersona" name="direccionsPersona"/>
		Comuna Persona: <form:input path="persona.direccion.comuna" id="idComunaPersona" name="comunaPersona"/>
		<form:button id="idButton" type="submit">Agregar</form:button>
	</form:form>
	<form:form action="/hola/eliminarAlguien" method="POST" modelAttribute="personaDto">
		<c:if test="${listaPersonaDTOS.size() >0}">
			<form:select path="selecion">	
				<c:forEach var="personaDto" items="${listaPersonaDTOS}">
					<form:option value="${personaDto.getPersona().getRut()}"></form:option>
				</c:forEach>					
			</form:select>
			<form:button id="idButtonEliminar">Eliminar</form:button>
		</c:if>
	</form:form>
	<table>
		<tr>
			<th>Rut Persona</th>
			<th>Nombre Persona</th>
			<th>Direccion Persona</th>
		</tr>
		<c:if test="${listaPersonaDTOS.size() >0}">
			<c:forEach var="personaDto" items="${listaPersonaDTOS}">
				<tr>
				<th><c:out value="${personaDto.getPersona().getRut()}"></c:out></th>
				<th><c:out value="${personaDto.getPersona().getNombre()}"></c:out></th>
				<th><c:out value="${personaDto.getPersona().getDireccion().getDescripcion()}"></c:out></th>
				</tr>
			</c:forEach>
		</c:if>	
		
	</table>
	
</body>
</html>