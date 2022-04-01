$(document).ready(function () {

    $('#tblProducto').bootstrapTable({
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
				console.log(JSON.stringify(row));
				console.log($.param(row))
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


}); 