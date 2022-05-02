package cl.desafiolatam.trazap.app.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoRequest {
	private int idDetallePedido;
	private int proveedorProductoId;
	private int pedidoId;
	private int cantidad;
}
