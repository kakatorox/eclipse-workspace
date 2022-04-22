package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface BodegaService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Bodega bodega);
	
}
