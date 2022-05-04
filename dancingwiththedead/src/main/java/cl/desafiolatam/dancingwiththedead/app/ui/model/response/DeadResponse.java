package cl.desafiolatam.dancingwiththedead.app.ui.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DeadResponse {
	private String deadID;
	private String precio;
	private String nombre;
	private String bodega;
	private String fechaIngreso;

}
