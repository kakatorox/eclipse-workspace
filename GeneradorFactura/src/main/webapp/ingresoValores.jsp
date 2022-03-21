<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="justify-content-center">
	<div class="row justify-content-center">
	
	
		<div class="container-fluid my-5">
			 <div class="row ml-5 mb-5">
				<div class="float-left" style="margin-left:10%; position: relative;display: block;width : 100px;font-size: 12px;">
					<img src="<%=request.getContextPath()%>/assets/img/Desafio.jpg"width="100" height="50">
				</div>
				<div class="float-right w-120" style="margin-left: 50%;position: relative;display: block;width : 200px;font-size: 12px;">
					<label><b> Generador Factura 2019</b></label>
					<label><b>Competition Part Ltda.</b></label>
					<label>Año 2019 April JC.</label>
					<form action="/GeneradorFactura/srvLogout" method="get">
						<button type="submit" class="btn btn-danger ">Cerrar Session</button>
					</form>
					
				</div>
			</div>
		</div>
		<div class="row m-5">
			<form action="/GeneradorFactura/srvIngresoValores" method="post">
				  <div class="row form-group">
				  	<div class="col-4">
					  	<label>Nombre Completo</label>
					    <input type="text" class="form-control" name="idNombreCompleto">
				  	</div>
				  	<div class="col-4">
					  	<label>Empresa</label>
					    <input type="text" class="form-control" name="idEmpresa">
				  	</div>
				  	<div class="col-4">
					  	<label>Rut</label>
					    <input type="text" class="form-control" name="idRut">
				  	</div>
				   
				  </div>
				  <div class="row form-group">
				    <div class="col-4">
					  	<label>Direccion</label>
					    <input type="text" class="form-control" name="idDireccion">
				  	</div>
				  	<div class="col-4">
					  	<label>Ciudad</label>
					    <input type="text" class="form-control" name="idCiudad">
				  	</div>
				  	<div class="col-4">
					  	<label>Pais</label>
					    <input type="text" class="form-control" name="idPais">
				  	</div>
				  </div>
				  
				  <table class="table table-dark">
					  <thead>
					    <tr>
					      <th scope="col">ITEM</th>
					      <th scope="col">DESCRIPCION</th>
					      <th scope="col">VALOR UNIDAD</th>
					      <th scope="col">CANTIDAD</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <td>Valvula Titanio</td>
					      <td>Valvulas de carrera</td>
					      <td>$120.000</td>
					      <td> <input type="number" name="idCant1"></td>
					    </tr>
					    <tr>
					      <td>Turbo Full Carrera</td>
					      <td>Turbo de competicion multimarca</td>
					      <td>$1.700.000</td>
					      <td> <input type="number" name="idCant2"></td>
					    </tr>
					    <tr>
					      <td>Kit de Freno Competicion</td>
					      <td>Juego de disco, balatas, caliper de competición</td>
					      <td>$760.000</td>
					      <td> <input type="number" name="idCant3"></td>
					    </tr>
					    <tr>
					      <td>Sistema de Refrigeración</td>
					      <td>Sistema de enfriamiento motor Carrera</td>
					      <td>$2.300.000</td>
					      <td> <input type="number" name="idCant4"></td>
					    </tr>
					    <tr>
					      <td>Plumilla Limpiaparabrisa Standar</td>
					      <td>Plumilla para la lluvia</td>
					      <td>$10.000</td>
					      <td> <input type="number" name="idCant5"></td>
					    </tr>
					  </tbody>
				</table>  
				  <div class="float-right">
					  <button type="submit" class="btn btn-success ">Generar Factura</button>
					  <button type="reset" class="btn btn-primary">Limpiar</button>
				  </div>
			</form>
		
		</div>
	</div>
	
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
</body>
</html>