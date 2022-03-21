$(document).ready( function(){  
	if($('.mensajeLoginIncorrecto').hasClass("Error")){
		alert('Credenciales Erroneas'); 
	}
    
    $('.mensajeLoginIncorrecto').removeClass("Error");
    
//    $("#language").change(function (){
//   		var selected = $('#language').find(":selected").val();
//  			$.get('${pageContext.request.contextPath}/setLang?lang='+selected,
//  					function(response) {
//         		 console.log(response);
//        		});
//        location.reload(); 
//    });
        
    $("select#language").change(function(){
		
    	var selectedLanguage = $(this).children("option:selected").val();
    	$.ajax({
    			url: '/GeneradorFactura/srvLogin',
    			data: { idiomaSeleccionado: selectedLanguage }
		});
	});
	
    
});