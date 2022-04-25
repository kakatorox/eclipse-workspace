package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.EstadoTrazabilidad;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface EstadoTrazabilidadService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(int id);
	public ResponseServiceObject save(EstadoTrazabilidad estadoTrazabilidad);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject update(Bodega bodega);
}
