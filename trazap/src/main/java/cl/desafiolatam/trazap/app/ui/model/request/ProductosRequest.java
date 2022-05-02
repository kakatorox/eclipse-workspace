package cl.desafiolatam.trazap.app.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductosRequest {
	private int idProducto;
	private String descripcion;
	private int categoriaProductoId;
	private int tipoProductoId;
}
