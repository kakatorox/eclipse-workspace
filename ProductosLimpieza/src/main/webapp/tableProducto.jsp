<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page import="cl.desafiolatam.ProductosLimpieza.dto.CategoriaDto"%>
<!DOCTYPE html>
<html lang="es">
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

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
        integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
  <link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
<script

	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table-locale-all.min.js"></script>

<script>
	let productosDtoJson = '<%= request.getAttribute("listaProductos")%>'
	let categodiaDtoJson = '<%= request.getAttribute("categoriaDtos")%>'
</script>
<script src="assets/js/productos.js"></script>
    <title>Document</title>
</head>

<body>
<!-- Button trigger modal -->
	<div class=" pt-5">
		<button id="idBtnNuevoProd" type="button" class="btn btn-warning " data-toggle="modal" data-target="#modalNuevoProducto">Agregar Producto</button>
	</div>

    <table class="table table-hover" id="tblProducto">
   	
    </table>
  
<!-- Modal Crear Producto-->
	<div class="modal fade " id="modalNuevoProducto" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Nuevo Producto</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body justify-align-center">
					<form class="needs-validation" novalidate>
						<div class=form-row>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <label for="idTxtProductoNombre">Nombre Producto</label>
				                    <div class="form-inline">
				                        <input type="text" class="form-control" id="idTxtProductoNombre" placeholder="Ingrese Producto" required>
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un nombre válido
					                    </div>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <label for="idTxtProductoPrecio">Precio Producto</label>
				                    <div class="form-inline">
				                        <input type="number" class="form-control" id="idTxtProductoPrecio" placeholder="Ingrese Precio" required>
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un apellido válido
					                    </div>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <label for="idTxtProductoDescripcion">Descripcion Producto</label>
				                    <div class="form-inline">
				                        <input type="text" class="form-control" id="idTxtProductoDescripcion" placeholder="Ingrese Descripcion" required>
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar una fecha válida
					                    </div>
				                    </div>
				                </div>
				            </div>
				         </div>
				          <div class="form-row">
				            <div class="col-md-5 mb-5">
				                <div class="form-group">
				                    <label for="idSelCat">Curso</label>
				                    <select class="form-control" id="idSelCat">
				                    	<option value="-1">-Seleccione Categoria-</option>

				                    </select>
				                    <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un curso válido
					                	</div>
					                </div>
				                </div>
				            </div>
			    	</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary" id="idBtnGuardarProducto">Guardar</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal Editar Categoria-->
	<div class="modal fade" id="modalEditarProducto" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Editar Producto</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body justify-align-center">
					<form class="needs-validation" novalidate>
						<div class=form-row>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                <input type="text" class="d-none form-control" id="idTxtEditarId" required>
				                        
				                    <label for="idTxtProductoEditNombre">Nombre Producto</label>
				                    <div class="form-inline">
				                        <input type="text" class="form-control" id="idTxtProductoEditNombre" placeholder="Ingrese Producto" required>
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un nombre válido
					                    </div>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <label for="idTxtProductoEditPrecio">Precio Producto</label>
				                    <div class="form-inline">
				                        <input type="number" class="form-control" id="idTxtProductoEditPrecio" placeholder="Ingrese Precio" required>
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un apellido válido
					                    </div>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <label for="idTxtProductoEditDescripcion">Descripcion Producto</label>
				                    <div class="form-inline">
				                        <input type="text" class="form-control" id="idTxtProductoEditDescripcion" placeholder="Ingrese Descripcion" required>
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar una fecha válida
					                    </div>
				                    </div>
				                </div>
				            </div>
				         </div>
				          <div class="form-row">
				            <div class="col-md-5 mb-5">
				                <div class="form-group">
				                    <label for="idSelEditaeCat">Curso</label>
				                    <select class="form-control" id="idSelEditaeCat">
				                    	<option value="-1">-Seleccione Categoria-</option>

				                    </select>
				                    <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un curso válido
					                	</div>
					                </div>
				                </div>
				            </div>
			    	</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary" id=idBtnEditarProducto>Actualizar</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal Eliminar Producto-->
	<div class="modal fade" id="modalEliminarProducto" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Eliminar Producto</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="needs-validation" novalidate>
						<div class=form-row>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <div class="form-inline">
				                         <input type="text" class="d-none form-control" id="idTxtEliminarId" disabled >
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un nombre válido
					                    </div>
				                    </div>
				                </div>
				            </div>			            
				         </div>	
				         <div class="form-check justify-align-center">
							  <input class="form-check-input" type="radio" name="flexRadioDefault" id="idRadioEliminar">
							  <label class="form-check-label" for="idRadioEliminar">
							    Si, Deseo Eliminar
							  </label>
						</div>
				</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary" id=idBtnEliminarProducto>Eliminar</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>