package cl.desafiolatam.trazap.app.ui.model.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrazabilidadRequest {
	private int idTrazabilidad;
	private int pedidoId;
	private Date fechaInicioPreparacion;
	private Date fechaFinPreparacion;
	private Date fechaEstimadaEnvio;
	private Date fechaEnvio;
	private Date fechaRecibido;
	private String codigoTrazabilidad;
	private int trazabilidadEstadoId;
}
