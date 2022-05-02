package cl.desafiolatam.trazap.app.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductosProveedoresRequest {
	private int idProductoProveedor;
	private int productoId;
	private int proveedorId;
}
