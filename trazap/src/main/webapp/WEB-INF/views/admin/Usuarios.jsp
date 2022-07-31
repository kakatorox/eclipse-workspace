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
	
<script src="<%=request.getContextPath()%>/assets/js/user.js"></script>	

<title>Usuario</title>
</head>
<body>
<div class="container mt-5">
	<div class="d-flex justify-content-center">
		<div class="mr-5">
			<div class="d-flex justify-content-center">
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalAgregarUsuario">Agregar Usuario</button>
			</div>
			<table id="tableUser">
			</table>
		</div>
		<div>
			<div class="d-flex justify-content-center">
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalAgregarRol">Agregar Rol</button>
			</div>
			<table id="tableRol">
			</table>
		</div>
	</div>
</div>
<!-- Modal Agregar Usuario-->
<div class="modal fade" id="modalAgregarUsuario" tabindex="-1" role="dialog" aria-labelledby="eModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleLongTitle">Agregar Usuario</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="email">Email</label>
		      <input type="text" class="form-control" id="email">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="password">Password</label>
		      <input type="text" class="form-control" id="password">
		    </div>
		    <div class="form-group col-md-6">
		    	<label for="rol">Rol</label>
		    	<select id="selectRol" class="form-control">
                	<option value="-1">-Seleccione Rol-</option>
            	</select>
		    </div>
		  </div>		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="idBtnGuardarUsuario">Guardar</button>
      </div>
    </div>
  </div>
</div>
<!-- Modal Editar Usuario-->
<div class="modal fade" id="modalEditarUsuario" tabindex="-1" role="dialog" aria-labelledby="eModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleLongTitle">Editar Usuario</h5>
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <div class="form-row">
       		<div class="form-group col-md-6">
		      <label for="idEditarUsuario">ID a Editar</label>
		      <input type="text" class="form-control" id="idEditarUsuario" disabled>
		    </div>
		    <div class="form-group col-md-6">
		      <label for="emailEditar">Email</label>
		      <input type="text" class="form-control" id="emailEditar">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="passwordEditar">Password</label>
		      <input type="text" class="form-control" id="passwordEditar">
		      <input type="text" class="d-none form-control" id="passwordEditarNormal" disabled>	
		    </div>
		    <div class="form-group col-md-6">
		    	<label for="rol">Rol</label>
		    	<select id="selectRolEditar" class="form-control">
                	<option value="-1">-Seleccione Rol-</option>
            	</select>
		    </div>
		  </div>		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="idBtnActualizarUsuario">Actualizar</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal Agregar Rol-->
<div class="modal fade" id="modalAgregarRol" tabindex="-1" role="dialog" aria-labelledby="eModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleLongTitle">Agregar Rol</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="descripcionRol">Descripcion</label>
		      <input type="text" class="form-control" id="descripcionRol">
		    </div>
		  </div>		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="idBtnGuardarRol">Guardar</button>
      </div>
    </div>
  </div>
</div>
<!-- Modal Editar Rol-->
<div class="modal fade" id="modalEditarRol" tabindex="-1" role="dialog" aria-labelledby="eModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleLongTitle">Editar Rol</h5>
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <div class="form-row">
       		<div class="form-group col-md-6">
		      <label for="idEditarRol">ID a Editar</label>
		      <input type="text" class="form-control" id="idEditarRol" disabled>
		    </div>
		    <div class="form-group col-md-6">
		      <label for="descripcionEditarRol">Descripcion</label>
		      <input type="text" class="form-control" id="descripcionEditarRol">
		    </div>
		  </div>		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="idBtnActualizarRol">Actualizar</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>