$(document).ready(function(){

	$('#tableUser').bootstrapTable({ 	
	        	url:'',
	            pagination: true,
	            search: true,
	            pageSize: 5,
	            pageList: [5, 10],
	            sortOrder: "desc",
	            sortName: "idUsers",
	            locale: "es-ES",
	            columns: [ {
	                field: 'idUsers',
	                title: 'ID User',	                
	                sortable: true,
	                width: '180px'
	            },{
	                field: 'email',
	                title: 'Email',
	                width: '180px'
	            },{
	                field: 'rols.idRols',
	                title: 'ID Rol',
	                visible:false,
	                width: '180px'
	            },{
	                field: 'rols.descripcion',
	                title: 'Rol',
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
							"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarUsuario' onclick='onClickEditarUsuario(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Editar'>",						
							'<i class="fa-solid fa-pen-to-square"></i>',
							"</a>  ",
							"<a class='remove' href='#' onclick='onClickEliminarUsuario(\"" + row.idUsers + "\");' title='Borrar'>",
							'<i class="fa fa-trash"></i>',
							'</a>'
						].join('');
					}
				}]
	            
	            
	 });
	 $('#tableRol').bootstrapTable({ 	
	        	url:'',
	            pagination: true,
	            search: true,
	            pageSize: 5,
	            pageList: [5, 10],
	            sortOrder: "desc",
	            sortName: "idRols",
	            locale: "es-ES",
	            columns: [ {
	                field: 'idRols',
	                title: 'ID Rol',	                
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
							"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarRol' onclick='onClickEditarRol(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Editar'>",						
							'<i class="fa-solid fa-pen-to-square"></i>',
							"</a>  ",
							"<a class='remove' href='#' onclick='onClickEliminarRol(\"" + row.idRols + "\");' title='Borrar'>",
							'<i class="fa fa-trash"></i>',
							'</a>'
						].join('');
					}
				}]
	            
	            
	 });
	
	 $.ajax({
                type:"GET",
                url:"http://localhost:8080/trazap/ws/rol",
                dataType:"json",
                success: function(data) {
                    //si todo sale bien, se agrega la funcionalidad
                    
                    var datos = data.body;
                    console.log(datos);
                    const select = document.querySelector('#selectRol');
                    const selectEditar = document.querySelector('#selectRolEditar');
					
						for (var i = 0,optionsLength = datos.length; i < optionsLength; i++) {
							var option = document.createElement('option');
							option.value = datos[i].idRols;
							option.text = datos[i].descripcion;
							select.appendChild(option);
													
					    }
					    for (var i = 0,optionsLength = datos.length; i < optionsLength; i++) {
							var option = document.createElement('option');
							option.value = datos[i].idRols;
							option.text = datos[i].descripcion;
							selectEditar.appendChild(option);
													
					    }                                            
                },
                error: function(dataError) {
                    console.log(dataError);
                },
                async: true,
                
        	});	
		$.ajax({
                type:"GET",
                url:"http://localhost:8080/trazap/ws/user",
                dataType:"json",
                success: function(data) {
                    //si todo sale bien, se agrega la funcionalidad
                    
                    console.log(data);
                    $('#tableUser').bootstrapTable('load', data.body);
                   
                    $.ajax({
			                type:"GET",
			                url:"http://localhost:8080/trazap/ws/rol",
			                dataType:"json",
			                success: function(data) {
			                    //si todo sale bien, se agrega la funcionalidad
			                    
			                    $('#tableRol').bootstrapTable('load', data.body);
			                },
			                error: function(dataError) {
			                    console.log(dataError);
			                },
			                async: true,
			                
			        	});	
			         
                },
                error: function(dataError) {
                    console.log(dataError);
                },
                async: true,
                
        	});
     
   
	        
	       
	$("#idBtnGuardarUsuario").click(function() {
	 	var idRol = document.getElementById('selectRol');
		var pro = idRol.options[idRol.selectedIndex].value; 
		
		var dataProducto = {
							"email": $("#email").val(),
							"rolsId": pro,	
							"password": $("#password").val()					
						 };
			$.ajax({
				
				data: JSON.stringify(dataProducto),
				type: "POST",
				contentType: "application/json",
				url: 'http://localhost:8080/trazap/ws/user',
				
			})
			.done(function(data, textStatus, jqXHR) {
				 
				window.location.reload();	
	         });

	})
	$("#idBtnGuardarRol").click(function() {
	
		var dataProducto = {
							"descripcion": $("#descripcionRol").val()							
						 };
			$.ajax({
				
				data: JSON.stringify(dataProducto),
				type: "POST",
				contentType: "application/json",
				url: 'http://localhost:8080/trazap/ws/rol',
				
			})
			.done(function(data, textStatus, jqXHR) {
				 
				window.location.reload();	
	         });

	})
	
	$("#idBtnActualizarRol").click(function() {
	
		var dataProducto = {
							"idRols":  $("#idEditarRol").val(),
							"descripcion": $("#descripcionEditarRol").val()							
						 };
			$.ajax({
				
				data: JSON.stringify(dataProducto),
				type: "PUT",
				contentType: "application/json",
				url: 'http://localhost:8080/trazap/ws/rol',
				
			})
			.done(function(data, textStatus, jqXHR) {
				 
				window.location.reload();	
	         });

	})		
	
	$("#idBtnActualizarUsuario").click(function() {
		
		
		var dataProducto = {
							"idUsers":  $("#idEditarUsuario").val(),
							"email": $("#emailEditar").val(),
							"password": $('passwordEditar').val(),
							"idRols":$("#selectRolEditar").val() 							
						 };
			$.ajax({
				
				data: JSON.stringify(dataProducto),
				type: "PUT",
				contentType: "application/json",
				url: 'http://localhost:8080/trazap/ws/user',
				
			})
			.done(function(data, textStatus, jqXHR) {
				 
				window.location.reload();	
	         });

	})		
});

function addOption(datos){
	var select = document.querySelector('#selectRol');

	for (var i = 0; i < datos; i++) {
		var option = document.createElement('option');
		option.value = datos[i].idRols;
		option.text = datos[i].descripcion;
		select.appendChild(option);
								
    }
	
}
function onClickEditarUsuario(row) {
	
	var raw = JSON.parse(row);
	console.log(raw);
	$('#idEditarUsuario').val(raw.idUsers);
	$('#emailEditar').val(raw.email);
	passwordEditarNormal.val(raw.password)
	var select = document.getElementById('selectRolEditar');

	for (var i = 0, optionsLength = select.length; i < optionsLength; i++) {
		console.log(select[i].value);
		console.log(raw.rols.idRols);
        if (select[i].value == raw.rols.idRols) {
	
            select.selectedIndex = i;
            return true;
        }
    }
}
function onClickEditarRol(row) {
	
	var raw = JSON.parse(row);
	console.log(raw);
	$('#descripcionEditarRol').val(raw.descripcion);
	$('#idEditarRol').val(raw.idRols);
	
	
}
function onClickEliminarUsuario(id){
	var dataEli = {
							"idUsers": id							
						 };
	$.ajax({
				
				data: JSON.stringify(dataEli),
				type: "DELETE",
				contentType: "application/json",
				url: 'http://localhost:8080/trazap/ws/user',
				
			})
			.done(function(data, textStatus, jqXHR) {
				 
				window.location.reload();	
	         

			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});	
}
function onClickEliminarRol(id){
	var dataEli = {
							"idRols": id							
						 };
	$.ajax({
				
				data: JSON.stringify(dataEli),
				type: "DELETE",
				contentType: "application/json",
				url: 'http://localhost:8080/trazap/ws/rol',
				
			})
			.done(function(data, textStatus, jqXHR) {
				 
				window.location.reload();	
	         

			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});	
}