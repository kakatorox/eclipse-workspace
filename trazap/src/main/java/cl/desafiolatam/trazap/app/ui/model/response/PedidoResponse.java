package cl.desafiolatam.trazap.app.ui.model.response;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {
	private int idPedido;
	private Date fechaIngreso;
	private Date fechaRecibido;
}
