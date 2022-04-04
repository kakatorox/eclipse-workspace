var table = $('#tblCategoria')
$(document).ready(function () {

    // console.log("ready!", JSON.parse(alumnoDtoJson);
    //console.log('Entro');
    //console.log(categoriasDtoJson);
    //tblProducto
    
    table.bootstrapTable({
        data: JSON.parse(categoriasDtoJson).listaCategoria,
            pagination: true,
            search: true,
            pageSize: 5,
            pageList: [5, 10],
            locale: "es-ES",
            columns: [{
                field: 'idCategoria',
                title: 'ID Categoria',
                width: '40px'
            }, {
                field: 'nombreCategoria',
                title: 'Descripcion Categoria',
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
				//console.log(JSON.stringify(row));
				//console.log($.param(row))
					return [
						"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarCategoria' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
						"<i class='bi bi-pencil'></i>",
						"</a>  ",
						"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarCategoria' onclick='onClickEliminar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Eliminar'>",
						'<i class="fa fa-trash"></i>',
						'</a>'
					].join('');
				}
			}]
        });
        
$("#idBtnGuardarCategoria").click(function() {
		var dataCategoria = {
							"nomCat": $("#idTxtNombreCategoria").val() 
						 };
		console.log("DataAlumno: ", dataCategoria);

        if(validaFormNuevo()){	
			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: {dataCategoria,"accion" : "crearCategoria"},
				//Cambiar a type: POST si necesario
				type: "PUT",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: "/ProductosLimpieza/Cat.srv",
			})
			.done(function(data, textStatus, jqXHR) {
				alert(data.mensaje);
				console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
				console.log("Alumnos a refrescar", data.listaCategoria);
				table.bootstrapTable('load', data.listaCategoria);
				table.bootstrapTable('refresh');
//				table.ajax.reload( function ( data ) {
//							    $('#tblCategoria').val( data.listaCategoria );
//							} );
				
				
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});
			
			
		}                
		
	}); 
});
function validaFormNuevo(){
	if($("#idTxtNombreCategoria").val().length == 0){
			$("#idTxtNombreCategoria").addClass("is-invalid");
			$("#idTxtNombreCategoria").removeClass("is-valid");
			idTxtNombreCategoria = false;
		}else{
			$("#idTxtNombreCategoria").removeClass("is-invalid");
			$("#idTxtNombreCategoria").addClass("is-valid");
			idTxtNombreCategoria = true;
		}
		return idTxtNombreCategoria;
}

function onClickEditar(row) {
	//let rowObj = JSON.parse(row);
	var categoriaDto = JSON.parse(row);
	$("#idTxtEditarId").val(categoriaDto.idCategoria);
	$("#idTxtEditarNombre").val(categoriaDto.nombreCategoria);
	
}

$("#idBtnEditarCategoria").click(function() {
		var dataCategoria = {
							"idCategoria":$("#idTxtEditarId").val(),
							"nombreCategoria": $("#idTxtEditarNombre").val()
						 };		
		 
				$.ajax({
					// En data puedes utilizar un objeto JSON, un array o un query string
					data: {dataCategoria,"accion" : "actualizarCategoria"},
					//Cambiar a type: POST si necesario
					type: "PUT",
					// Formato de datos que se espera en la respuesta
					dataType: "json",
					// URL a la que se enviará la solicitud Ajax
					url: "/ProductosLimpieza/Cat.srv",
				})
				.done(function(data, textStatus, jqXHR) {
					alert(data.mensaje);
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("Alumnos a refrescar", data.listaCategoria);
					table.bootstrapTable('load', data.listaCategoria);
					table.bootstrapTable('refresh');
					
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});
		
	});

function onClickEliminar(row){
	//console.log("Id a eliminar: " + id);
	//let rowObj = JSON.parse(row);
	var categoriaDto = JSON.parse(row);
	$("#idTxtEliminarId").val(categoriaDto.idCategoria);
	
	
}

$("#idBtnEliminarCategoria").click(function() {
	
	if(document.getElementById('idRadioEliminar').checked == false) {   
         $("#idRadioEliminar").addClass("is-invalid"); 
		} else {  
			$("#idRadioEliminar").addClass("is-valid");  
			var dataCategoria = {
								"idCategoria":$("#idTxtEliminarId").val()
							 };		
				$.ajax({
					// En data puedes utilizar un objeto JSON, un array o un query string
					data: {dataCategoria,"accion" : "eliminarCategoria"},
					//Cambiar a type: POST si necesario
					type: "PUT",
					// Formato de datos que se espera en la respuesta
					dataType: "json",
					// URL a la que se enviará la solicitud Ajax
					url: "/ProductosLimpieza/Cat.srv",
				})
				.done(function(data, textStatus, jqXHR) {
					alert(data.mensaje);
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("Alumnos a refrescar", data.listaCategoria);
					table.bootstrapTable('load', data.listaCategoria);
					table.bootstrapTable('refresh');
					
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});  
		} 
	

	});


