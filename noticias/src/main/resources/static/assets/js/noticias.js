var table = $('#tblNoticia')
$(document).ready(function () {

console.log(listNoti);
	
    $('#tblNoticia').bootstrapTable({
        data: JSON.parse(listNoti).listaNoticias,
        pagination: true,
        search: true,
        pageSize: 5,
        pageList: [5, 10],
        locale: "es-ES",
        columns: [{
            field: 'titulo',
            title: 'Titulo Noticia',
            width: '40px'
        }, {
            field: 'body',
            title: 'Noticia',
            width: '180px'
        },  {
			field: '',
			title: 'imagen',
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
					"<img src=\"" + row.imagen + "\" width=\""+300+"\" height=\""+150+"\">"
					
				].join('');
			}
         }]
    });
})