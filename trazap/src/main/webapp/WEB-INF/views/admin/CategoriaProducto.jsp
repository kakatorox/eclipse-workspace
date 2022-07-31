<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Dependencias CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
        integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!-- Dependencias Jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Dependencias Popper -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <!-- Dependencias bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
        <!--fontawesome-->
        <script src="https://kit.fontawesome.com/b279ed8e94.js" crossorigin="anonymous"></script>   

 <link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table-locale-all.min.js"></script>
	
<script src="<%=request.getContextPath()%>/assets/js/categoriaproducto.js"></script>	

<title>Categoria Producto</title>
</head>
<body>
<div class="container mt-5">
	<div class="d-flex justify-content-center">
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalAgregar">Agregar</button>
	</div>
</div>
<div class="container">
	<table id="table">
	  
	</table>
</div>
<!-- Modal Agregar-->
<div class="modal fade" id="modalAgregar" tabindex="-1" role="dialog" aria-labelledby="eModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleLongTitle">Agregar Categoria Producto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="descripcion">Descripcion</label>
		      <input type="text" class="form-control" id="descripcion">
		    </div>
		  </div>		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="idBtnGuardar">Guardar</button>
      </div>
    </div>
  </div>
</div>
<!-- Modal Editar-->
<div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="eModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleLongTitle">Agregar Categoria Producto</h5>
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <div class="form-row">
       		<div class="form-group col-md-6">
		      <label for="idEditar">ID a Editar</label>
		      <input type="text" class="form-control" id="idEditar" disabled>
		    </div>
		    <div class="form-group col-md-6">
		      <label for="descripcionEditar">Descripcion</label>
		      <input type="text" class="form-control" id="descripcionEditar">
		    </div>
		  </div>		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="idBtnActualizar">Actualizar</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>