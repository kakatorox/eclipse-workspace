package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.Proveedores;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface ProveedoresService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(int id);
	public ResponseServiceObject save(Proveedores proveedores);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject update(Bodega bodega);
}
