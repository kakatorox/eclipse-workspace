package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.EstadoTrazabilidadRequest;

public interface EstadoTrazabilidadService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(int idEstadoTrazabilidad);
	public ResponseServiceObject save(EstadoTrazabilidadRequest estadoTrazabilidadRequest);
	public ResponseServiceObject delete(int idEstadoTrazabilidad);
	public ResponseServiceObject update(int idEstadoTrazabilidad,EstadoTrazabilidadRequest estadoTrazabilidadRequest);
}
