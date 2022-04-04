var table = $('#tblProducto')
function RellenarSelect(idSelect){
	var a= JSON.parse(categodiaDtoJson).listaCategoria;
	
	var modelList = document.getElementById(idSelect); 
	for (i=0; i<a.length;i++) { 
	    // creamos un elemento de tipo option
	    var opt = document.createElement("option");
	    // le damos un valor
	    opt.value = a[i].idCategoria;
	     console.log(a[i].idCategoria)
	    // le ponemos un texto
	    opt.textContent = a[i].nombreCategoria;
	    // lo agregamos al select
	    modelList.options.add(opt); 
	} 
	
};        
$(document).ready(function () {
	RellenarSelect("idSelCat");
	RellenarSelect("idSelEditaeCat");
	
    table.bootstrapTable({
        data: JSON.parse(productosDtoJson).listaProducto,
            pagination: true,
            search: true,
            pageSize: 5,
            pageList: [5, 10],
            locale: "es-ES",
            columns: [{
                field: 'idProducto',
                title: 'ID Producto',
                width: '40px'
            }, {
                field: 'nombreProducto',
                title: 'Nombre Producto',
                width: '180px'
            }, {
                field: 'precioProducto',
                title: 'Precio Producto',
                width: '180px'
            }, {
                field: 'descripcionProducto',
                title: 'Descripcion Producto',
                width: '180px',
                
            }, {
                field: 'categoria.idCategoria',
                title: 'ID Categoria',
                width: '180px',
                visible: false
            }, {
                field: 'categoria.nombreCategoria',
                title: 'Nombre Categoria',
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
						"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarProducto' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
						"<i class='bi bi-pencil'></i>",
						"</a>  ",
						"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarProducto' onclick='onClickEliminar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Eliminar'>",
						'<i class="fa fa-trash"></i>',
						'</a>'
					].join('');
				}
			}]
        });
              
        
$("#idBtnGuardarProducto").click(function() {
		var dataProducto = {
							"nombreProducto": $("#idTxtProductoNombre").val(),
							"precioProducto": $("#idTxtProductoPrecio").val(),
							"descripcionProducto": $("#idTxtProductoDescripcion").val(),
							"idCategoria": $("#idSelCat").val()
						 };
		//console.log("DataAlumno: ", dataCategoria);

      
			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: {dataProducto,"accion" : "crearProducto"},
				//Cambiar a type: POST si necesario
				type: "PUT",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: "/ProductosLimpieza/Prod.srv",
			})
			.done(function(data, textStatus, jqXHR) {
				alert(data.mensaje);
				table.bootstrapTable('load', data.listaProducto);
				table.bootstrapTable('refresh');

				
				
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});              
	}); 
});


function onClickEditar(row) {
	//let rowObj = JSON.parse(row);
	var productoDto = JSON.parse(row);
	$("#idTxtEditarId").val(productoDto.idProducto);
	$("#idTxtProductoEditNombre").val(productoDto.nombreProducto);
	$("#idTxtProductoEditPrecio").val(productoDto.precioProducto);
	$("#idTxtProductoEditDescripcion").val(productoDto.descripcionProducto);
	
	$("#idSelEditaeCat").val(productoDto.categoria.idCategoria);
		
}

$("#idBtnEditarProducto").click(function() {
		
		var dataProducto = {
							"idProducto": $("#idTxtEditarId").val(),
							"nombreProducto": $("#idTxtProductoEditNombre").val(),
							"precioProducto": $("#idTxtProductoEditPrecio").val(),
							"descripcionProducto": $("#idTxtProductoEditDescripcion").val(),
							"idCategoria": $("#idSelEditaeCat").val()
						 };		
		 
				$.ajax({
					// En data puedes utilizar un objeto JSON, un array o un query string
					data: {dataProducto,"accion" : "actualizarProducto"},
					//Cambiar a type: POST si necesario
					type: "PUT",
					// Formato de datos que se espera en la respuesta
					dataType: "json",
					// URL a la que se enviará la solicitud Ajax
					url: "/ProductosLimpieza/Prod.srv",
				})
				.done(function(data, textStatus, jqXHR) {
					alert(data.mensaje);
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("Alumnos a refrescar", data.listaProducto);
					table.bootstrapTable('load', data.listaProducto);
					table.bootstrapTable('refresh');
					
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});
		
	});

function onClickEliminar(row){
	//console.log("Id a eliminar: " + id);
	//let rowObj = JSON.parse(row);
	var productoDto = JSON.parse(row);
	$("#idTxtEliminarId").val(productoDto.idProducto);
	
	
}

$("#idBtnEliminarProducto").click(function() {
	
	if(document.getElementById('idRadioEliminar').checked == false) {   
         $("#idRadioEliminar").addClass("is-invalid"); 
		} else {  
			$("#idRadioEliminar").addClass("is-valid");  
			var dataProducto = {
								"idProducto":$("#idTxtEliminarId").val()
							 };		
				$.ajax({
					// En data puedes utilizar un objeto JSON, un array o un query string
					data: {dataProducto,"accion" : "eliminarProducto"},
					//Cambiar a type: POST si necesario
					type: "PUT",
					// Formato de datos que se espera en la respuesta
					dataType: "json",
					// URL a la que se enviará la solicitud Ajax
					url: "/ProductosLimpieza/Prod.srv",
				})
				.done(function(data, textStatus, jqXHR) {
					alert(data.mensaje);
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("Producto a refrescar", data.listaProducto);
					table.bootstrapTable('load', data.listaProducto);
					table.bootstrapTable('refresh');
					
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});  
		} 
	

	});


