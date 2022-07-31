$(document).ready(function () {
    $('#table').bootstrapTable({        	
        	url:'',
            pagination: true,
            search: true,
            pageSize: 5,
            pageList: [5, 10],
            locale: "es-ES",
            columns: [ {
                field: 'materialID',
                title: 'ID',
                width: '180px'
            },{
                field: 'precio',
                title: 'Precio',
                width: '180px'
            }, {
                field: 'nombre',
                title: 'Nombre',
                width: '180px'
            }, {
                field: 'bodega',
                title: 'Bodega',
                width: '180px',
            }, {
                field: 'fechaIngreso',
                title: 'Fecha Ingreso',
                width: '180px'
            }, {
			field: '',
			title: 'Acción',
			align: 'center',
			valign: 'middle',
			width: '150px',
			clickToSelect: false,
			formatter: function(value, row, index) {
				//Aqui defines el boton y en tu caso tendras que ponerle el onClick, 
				//recuerda que row tiene el objeto del renglon actual, 
				//en este ejemplo agrege funcionPorDefinir y le envio el row.id
							//console.log("row");
				//console.log(row.idAlumno);
				console.log(JSON.stringify(row));
				console.log($.param(row))
				return [
					"<a class='like' href='#' data-toggle='modal' data-target='#modalEditar' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Edit'>",
					"<i class='bi bi-pencil'></i>",
					"</a>  ",
					"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminar' onclick='onClickEliminar(\"" + row.deadID + "\");' title='Delete'>",
					'<i class="fa fa-trash"></i>',
					'</a>'
				].join('');
			}
		}]
        });
              
const hoy = new Date();

function formatoFecha(fecha, formato) {
	const map = {
        dd: fecha.getDate(),
        mm: fecha.getMonth() + 1,
        yy: fecha.getFullYear().toString().slice(-2),
        yyyy: fecha.getFullYear()
    }

    return formato.replace(/dd|mm|yy|yyyy/gi, matched => map[matched])
}


$("#idBtnEditarAlumno").click(function() {
	
	alert("asd")
	
		var dataAlumno = {
							"idAlumno":$("#idTxtEditarId").val(),
							"nombre": $("#idTxtEditarNombre").val(), 
							"apellido": $("#idTxtEditarApellido").val(),
							"fechaNac": $("#idTxtEditarFecNacimiento").val(),
							"idCurso": $("#idSelEditarCurso").val() 
						 };		
		 
				$.ajax({
					// En data puedes utilizar un objeto JSON, un array o un query string
					data: {dataAlumno,"accion" : "actualizarAlumno"},
					//Cambiar a type: POST si necesario
					type: "PUT",
					// Formato de datos que se espera en la respuesta
					dataType: "json",
					// URL a la que se enviará la solicitud Ajax
					url: "/schoolsystem-1.0.0/mantenedoralumnos.srv",
				})
				.done(function(data, textStatus, jqXHR) {
					alert(data.mensaje);
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("Alumnos a refrescar", data.alumnos);
					$table.bootstrapTable('load', data.alumnos);
					$table.bootstrapTable('refresh');
					
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});
		
	});  
$("#idBtnGuardar").click(function() {
		var dataProducto = {
							"precio": $("#idprecio").val(),
							"nombre": $("#idNombre").val(),
							"bodega": $("#idBodega").val(),
							"fechaIngreso": formatoFecha(hoy, 'dd/mm/yy')
						 };
			$.ajax({
				
				data: JSON.stringify(dataProducto),
				type: "POST",
				contentType: "application/json",
				url: '/deadAppoinment',
				
			})
			.done(function(data, textStatus, jqXHR) {
				
					  $.ajax({
		                    type:"GET",
		                    url:"/deadAppoinment",
		                    dataType:"json",
		                    success: function(data) {
		                        //si todo sale bien, se agrega la funcionalidad
		                        console.log(data);
		                        $('#table').bootstrapTable('load', data);
		                    },
		                    error: function(dataError) {
		                        console.log(dataError);
		                    },
		                    async: true,
	                	});
	
	                console.log("Termino");
	         });

			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});
});


function onClickEliminar(row){
		alert(row)
		var dataDead = {
			"idDead" : row
		}
	console.log(JSON.stringify(dataDead));
	//let rowObj = JSON.parse(row);
	$.ajax({
				
				data: dataDead,
				type: 'DELETE',
				contentType: "application/json",
				accept: "application/json",
				url: '/deadAppoinment',
				
			})
			.done(function(data, textStatus, jqXHR) {
				
					  $.ajax({
		                    type:"GET",
		                    url:"/deadAppoinment",
		                    dataType:"json",
		                    success: function(data) {
		                        //si todo sale bien, se agrega la funcionalidad
		                        console.log(data);
		                        $('#table').bootstrapTable('load', data);
		                    },
		                    error: function(dataError) {
		                        console.log(dataError);
		                    },
		                    async: true,
	                	});
	
	                console.log("Termino");
	         });

			
			
		
}
$("#idBtnEliminar").click(function() {
	
	if(document.getElementById('idRadioEliminar').checked == false) {   
         $("#idRadioEliminar").addClass("is-invalid"); 
		} else {  
			console.log("Antes");
			console.log($("#idTxtEliminarId").val());
			$("#idRadioEliminar").addClass("is-valid");  
			var dataAlumno = {
								"idAlumno":$("#idTxtEliminarId").val()

							 };
							 console.log("despues");
							 console.log($("#idTxtEliminarId").val());
				
		} 
	

	});
	
	function onClickEditar(row) {
	alert(row)
	//let rowObj = JSON.parse(row);
	var deadDto = JSON.parse(row);
	$("#idTxtEditarId").val(deadDto.idAlumno);
	$("#idTxtEditarNombre").val(deadDto.nombre);
	$("#idTxtEditarApellido").val(deadDto.apellido);
	$("#idTxtEditarFecNacimiento").val(deadDto.fechaNac);
	
}