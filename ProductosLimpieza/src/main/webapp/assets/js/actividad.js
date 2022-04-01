$(document).ready(function(){
    //$("#idBtnGuardarCurso").click(function () {\
   
    $("#idTablaProductos").click(function () {
        $("#idContenido").load('/ProductosLimpieza/Prod.srv');
    });
    $("#idTablaCategorias").click(function () {
        $("#idContenido").load('/ProductosLimpieza/Cat.srv');
    });  
});