<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.desafiolatam.entidades.CursoDTO" %>
<%@ page import="com.desafiolatam.entidades.FormaDePagoDTO" %>
<%@ page import="com.desafiolatam.entidades.InscripcionDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de inscripciones</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<%
   	String nombre = (String)request.getAttribute("nombre");
	String celular = (String)request.getAttribute("celular");
	int idCurso = (int)request.getAttribute("idCurso");
	int idFormaDePago = (int)request.getAttribute("idFormaDePago");
%>
<body>

	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Mantenedor de Cursos</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="srvPreIns">Inscribir Cursos</a></li>
	    </ul>
	  </div>
	</nav>


	<div class="container">
	         <form action="/ListarInscripciones/srvPreCon" method="get">
				  <div class="form-group">
				    <label for="">Nombre</label>
				    <input readonly value=<%=nombre %> name="nombre" type="text" class="form-control">
				     </div>
				  <div class="form-group">
				    <label for="">Telefono</label>
				    <input readonly value=<%=celular %> name="celular" type="text" class="form-control">
				  </div>
				  <div class="form-group">
				    <label for="">ID del Curso</label>
				    <input readonly value=<%=idCurso %> name="idCurso" type="text" class="form-control">
				  </div>
				  <div class="form-group">
				    <label for="">ID Forma de Pago</label>
				    <input readonly value=<%=idFormaDePago %> name="idFormaDePago" type="text" class="form-control">
				  </div>
				  <button type="submit" class="btn btn-danger">Inscribir</button>
			</form>    
	</div>
</body>
</html>
