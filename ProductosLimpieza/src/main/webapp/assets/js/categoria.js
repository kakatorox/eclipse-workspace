$(document).ready(function () {

    // console.log("ready!", JSON.parse(alumnoDtoJson);
    console.log('Entro');
    console.log(categoriasDtoJson);
    //tblProducto
    $('#tblCategoria').bootstrapTable({
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
				console.log(JSON.stringify(row));
				console.log($.param(row))
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


}); 