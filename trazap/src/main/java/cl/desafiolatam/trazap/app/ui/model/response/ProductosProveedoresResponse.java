package cl.desafiolatam.trazap.app.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductosProveedoresResponse {
	private int idProductoProveedor;
	private int productoId;
	private int proveedorId;
}
