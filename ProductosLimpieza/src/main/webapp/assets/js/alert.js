$(document).ready( function(){  
	if($('.mensajeLoginIncorrecto').hasClass("Error")){
		alert('Credenciales Erroneas'); 
	}
    
    $('.mensajeLoginIncorrecto').removeClass("Error");
        
    $("select#language").change(function(){
		
    	var selectedLanguage = $(this).children("option:selected").val();
    	$.ajax({
    			url: '/GeneradorFactura/srvLogin',
    			data: { idiomaSeleccionado: selectedLanguage }
		});
	});
});