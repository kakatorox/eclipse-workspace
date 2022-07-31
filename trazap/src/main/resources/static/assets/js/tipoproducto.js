$(document).ready(function(){

	$('#table').bootstrapTable({ 	
	        	url:'',
	            pagination: true,
	            search: true,
	            pageSize: 5,
	            pageList: [5, 10],
	            sortOrder: "desc",
	            sortName: "idTipoProducto",
	            locale: "es-ES",
	            columns: [ {
	                field: 'idTipoProducto',
	                title: 'ID Tipo Producto',	                
	                sortable: true,
	                width: '180px'
	            },{
	                field: 'descripcion',
	                title: 'Descripcion',
	                width: '180px'
	            }, {
					field: '',
					title: 'Acción',
					align: 'center',
					valign: 'middle',
					width: '150px',
					clickToSelect: false,
					formatter: function(value, row, index) {
						return [
							"<a class='like' href='#' data-toggle='modal' data-target='#modalEditar' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Editar'>",						
							'<i class="fa-solid fa-pen-to-square"></i>',
							"</a>  ",
							"<a class='remove' href='#' onclick='onClickEliminar(\"" + row.idTipoProducto + "\");' title='Borrar'>",
							'<i class="fa fa-trash"></i>',
							'</a>'
						].join('');
					}
				}]
	            
	            
	 });
	
		$.ajax({
                type:"GET",
                url:"http://localhost:8080/trazap/ws/tipoProducto",
                dataType:"json",
                success: function(data) {
                    //si todo sale bien, se agrega la funcionalidad
                    
                    console.log(data);
                    $('#table').bootstrapTable('load', data.body);
                },
                error: function(dataError) {
                    console.log(dataError);
                },
                async: true,
                
        	});
	        
	$("#idBtnGuardar").click(function() {
	
		var dataProducto = {
							"descripcion": $("#descripcion").val()							
						 };
			$.ajax({
				
				data: JSON.stringify(dataProducto),
				type: "POST",
				contentType: "application/json",
				url: 'http://localhost:8080/trazap/ws/tipoProducto',
				
			})
			.done(function(data, textStatus, jqXHR) {
				 
				window.location.reload();	
	         });

	})
	
	$("#idBtnActualizar").click(function() {
	
		var dataProducto = {
							"idTipoProducto":  $("#idEditar").val(),
							"descripcion": $("#descripcionEditar").val()							
						 };
			$.ajax({
				
				data: JSON.stringify(dataProducto),
				type: "PUT",
				contentType: "application/json",
				url: 'http://localhost:8080/trazap/ws/tipoProducto',
				
			})
			.done(function(data, textStatus, jqXHR) {
				 
				window.location.reload();	
	         });

	})		
	
});

function onClickEditar(row) {
	
	var raw = JSON.parse(row);
	console.log(raw);
	$('#descripcionEditar').val(raw.descripcion);
	$('#idEditar').val(raw.idTipoProducto);
	
	
}

function onClickEliminar(id){
	var dataEli = {
							"idTipoProducto": id							
						 };
	$.ajax({
				
				data: JSON.stringify(dataEli),
				type: "DELETE",
				contentType: "application/json",
				url: 'http://localhost:8080/trazap/ws/tipoProducto',
				
			})
			.done(function(data, textStatus, jqXHR) {
				 
				window.location.reload();	
	         

			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});	
}