package cl.desafiolatam.trazap.app.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductosBodegaRequest {
	private int idProductoBodega;
	private int productoId;
	private int bodegaId;
	private int stock;
}
