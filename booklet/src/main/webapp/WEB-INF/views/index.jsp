<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Biblioteca</title>

<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"	crossorigin="anonymous">
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link rel="stylesheet"	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"	crossorigin="anonymous">
<link rel="stylesheet"	href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
	
	<!-- CSS -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
	<!-- Default theme -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
	<!-- Semantic UI theme -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
	<!-- Bootstrap theme -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
	
	<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
	<!--     Custom styles -->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/styles.css">
	


<script src="https://code.jquery.com/jquery-3.6.0.min.js"	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="	crossorigin="anonymous"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"	crossorigin="anonymous"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"	crossorigin="anonymous"></script>
<script	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
<script	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table-locale-all.min.js"></script>
<script src="https://kit.fontawesome.com/bedf425191.js" crossorigin="anonymous"></script>
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>

<script type="text/javascript">
		let mensaje = "${mensaje}";
		let libroDtoJson = ${libroDtoJson};
	</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5" style="border:1px;" >	
	
	<fieldset class="border p-2 flex">
	 <legend  class="float-none w-auto ">Mantenedor de Libros</legend>
		<form:form class="form-inline " action="/Booklet/addLibro" method="POST" modelAttribute="libroDto">
		   <label for="idTitulo" class="">Titulo:</label>
		   <form:input path="libro.titulo" id="idTitulo" name="titulo" cssClass="m-2" />
		   <label for="idAnio"  class="">Año:</label>
		   <form:input path="libro.anio" id="idAnio" name="anio" cssClass="m-2" type="text"/>
		   <label for="idAutor" class="">Autor:</label>
		   <form:input path="libro.autor" id="idAutor" name="autor" cssClass="m-2"/>
		   <label for="idImprenta"  class="">Imprenta:</label>
		   <form:input path="libro.imprenta" id="idImprenta" name="imprenta" cssClass="m-2"/>
		   <label for="idDisponible"  class="">Disponible:</label>
		   <form:checkbox path="libro.disponible" id="idDisponible" name="disponible" cssClass="m-2"/>
		<form:button id="idButton" type="submit">Agregar</form:button>
	
		</form:form>
	</fieldset>
	</div>
	<div class="container mt-5">
		<fieldset class="border p-2 flex">
		 <legend  class="float-none w-auto ">Mantenedor de Libros</legend>
		 	<table id="idTableSelect" class="table table-hover" >
			
		 	</table>
		 </fieldset> 
	 </div>
	 
	 <!-- Modal Editar-->

	<div class="modal fade" id="modalEditarLibro" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Editar Libro</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form:form class="form-inline " action="/Booklet/updateLibro" method="POST" modelAttribute="libroDto">
					   <form:input path="libro.id" id="idIdEditar" name="titulo" cssClass="m-2" class="hidden" />
					   <label for="idTituloEditar" class="">Titulo:</label>
					   <form:input path="libro.titulo" id="idTituloEditar" name="titulo" cssClass="m-2" />
					   <label for="idAnioEditar"  class="">Año:</label>
					   <form:input path="libro.anio" id="idAnioEditar" name="anio" cssClass="m-2" type="text"/>
					   <label for="idAutorEditar" class="">Autor:</label>
					   <form:input path="libro.autor" id="idAutorEditar" name="autor" cssClass="m-2"/>
					   <label for="idImprentaEditar"  class="">Imprenta:</label>
					   <form:input path="libro.imprenta" id="idImprentaEditar" name="imprenta" cssClass="m-2"/>
					   <label for="idDisponibleEditar"  class="">Disponible:</label>
					   <form:checkbox path="libro.disponible" id="idDisponibleEditar" name="disponible" cssClass="m-2"/>
					<hr>
					<form:button id="idButtonEditar" class="btn btn-primary"  type="submit">Editar</form:button>
				
					</form:form>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/libros.js"></script>
</body>
</html>