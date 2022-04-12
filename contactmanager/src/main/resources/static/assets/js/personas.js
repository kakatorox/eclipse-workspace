let SelectId = 0;
$('document').ready(function () { 

    var table = document.getElementById("idTableSelect");
    var rows = table.getElementsByTagName("tr");
    for (i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = function (row) {
            return function () {
                var cell = row.getElementsByTagName("th")[0];
               SelectId = cell.innerHTML;
               console.log(SelectId);
               document.getElementById("idText").value = SelectId;
            };
        };
        currentRow.onclick = createClickHandler(currentRow);
    }     
    idButtonEliminar.onclick = function eliminar(SelectId){		
		alert(SelectId);	
	};
	
});
$('#idTableSelect tbody tr').click(function() {
    $(this).addClass('bg-success').siblings().removeClass('bg-success');
});
function deleteRow(){
	if(SelectId != 0){
		window.location.href = "/contactManager/deleteContact/?id=" +SelectId;
	}else{
		alert("No a Seleccionado algun elemento");
	}
}
	