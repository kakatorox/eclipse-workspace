package cl.desafiolatam.trazap.app.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoResponse {
	private int idDetallePedido;
	private int proveedorProductoId;
	private int pedidoId;
	private int cantidad;
}
