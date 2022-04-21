$('document').ready(function () { 
    
    
    if(mensaje != ""){
		if(mensaje === 'Libro Agregado'){
			alertify.success(mensaje); 
		}
		if(mensaje === 'Libro Borrado'){
			alertify.success(mensaje); 
		}
		if(mensaje === 'Libro Actualizado'){
			alertify.success(mensaje); 
		}
		if(mensaje === 'Datos Vacios'){
			alertify.error(mensaje); 
		}
		if(mensaje === 'Ya no Hay Registros'){
			alertify.warning(mensaje); 
		}
    }
    
	$('#idTableSelect').bootstrapTable({
		data: libroDtoJson,
		pagination: true,
		search: true,
		pageSize: 5,
		pageList: [5, 10],
		locale: "es-ES",
		columns: [{
			field: 'libro.id',
			title: 'ID',
			width: '40px'
		}, {
			field: 'libro.titulo',
			title: 'Titulo',
			width: '180px'
		}, {
			field: 'libro.anio',
			title: 'Año',
			width: '180px'
		}, {
			field: 'libro.autor',
			title: 'Autor',
			width: '180px'
		}, {
			field: 'libro.imprenta',
			title: 'Imprenta',
			width: '180px'
		}, {
			field: 'libro.disponible',
			title: 'Disponible',
			width: '180px',
			formatter: function(value, row, index) {
				if(value){
					return 'Si';
				}else{
					return 'No';
				};
			}
			
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
				
				return [
					"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarLibro' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Editar'>",						
					'<i class="fa-solid fa-pen-to-square"></i>',
					"</a>  ",
					"<a class='remove' href='#' onclick='onClickEliminar(\"" + row.libro.id + "\");' title='Borrar'>",
					'<i class="fa fa-trash"></i>',
					'</a>'
				].join('');
			}
		}
		]
	});
   
    $('#idAnio').datepicker({
                  format: " yyyy",
              viewMode: "years", 
            minViewMode: "years"
                });  
    
    $('#idAnioEditar').datepicker({
                  format: " yyyy",
              viewMode: "years", 
            minViewMode: "years"
                });            
                
     	
});
 function onClickEditar(row) {
	
	var libroDto = JSON.parse(row);
	$('#idIdEditar').val(libroDto.libro.id);
	$("#idTituloEditar").val(libroDto.libro.titulo);
	$("#idAnioEditar").val(libroDto.libro.anio);
	$("#idAutorEditar").val(libroDto.libro.autor);
	$("#idImprentaEditar").val(libroDto.libro.imprenta);
	if(libroDto.libro.disponible){
		document.getElementById("idDisponibleEditar").checked = true;
	}else{
		document.getElementById("idDisponibleEditar").checked = false;
	}
	
}

function onClickEliminar(id){
	window.location.href = "/Booklet/deleteLibro/?id=" +id;
}

	