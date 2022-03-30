<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

    <!-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script> -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
        integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
     <link href="assets/css/styles.css" rel="stylesheet" />
     <title>Document</title>
<title>Insert title here</title>
</head>
<body class="sb-nav-fixed">

 <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
     <!-- Navbar Brand-->
     <a class="navbar-brand ps-3" href="Index">Productos y Limpieza</a>
    <div class="float-right" style="position: relative;display: block;"> 
		<div class="btn-group mr-2 ">
		  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Productos
		  </button>
			  <div class="dropdown-menu">
			    <a class="dropdown-item" href="#" id="idProdVer">Ver</a>
			    <a class="dropdown-item" href="#" id="idProdCrear">Crear</a>
			    <a class="dropdown-item" href="#" id="idProdActualizar">Actualizar</a>
			    <div class="dropdown-divider"></div>
			    <a class="dropdown-item" href="#" id="idProdEliminar">Eliminar</a>
			  </div>
		</div>
		<div class="btn-group m">
		  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Categorias
		  </button>
			  <div class="dropdown-menu">
			    <a class="dropdown-item" href="#" id="idCatVer">Ver</a>
			    <a class="dropdown-item" href="#" id="idCatCrear">Crear</a>
			    <a class="dropdown-item" href="#" id="idCatActualizar">Actualizar</a>
			    <div class="dropdown-divider"></div>
			    <a class="dropdown-item" href="#" id="idCatEliminar">Eliminar</a>
			  </div>
		</div>
	</div>
 </nav>
 
<div id="idContenido" class="container">
        Pagina de inicio
    </div>


<script src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
    <script src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table-locale-all.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
<script src="assets/js/actividad.js"></script>
   
</body>
</html>