package cl.desafiolatam.trazap.app.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProductoResponse {
	
	private int idCategoriaProducto;
	private String descripcion;
}
