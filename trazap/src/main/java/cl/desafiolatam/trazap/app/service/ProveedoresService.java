package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProveedoresRequest;

public interface ProveedoresService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(int idProveedores);
	public ResponseServiceObject save(ProveedoresRequest proveedoresRequest);
	public ResponseServiceObject delete(int idProveedores);
	public ResponseServiceObject update(int idProveedores,ProveedoresRequest proveedoresRequest);
}
