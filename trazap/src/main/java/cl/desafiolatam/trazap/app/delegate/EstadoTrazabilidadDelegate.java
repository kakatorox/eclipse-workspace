package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.EstadoTrazabilidadRequest;

public interface EstadoTrazabilidadDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(EstadoTrazabilidadRequest estadoTrazabilidadRequest);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject update(int idEstadoTrazabilidad, EstadoTrazabilidadRequest estadoTrazabilidadRequest);
}
