package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface BodegaDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Bodega bodega);
}
