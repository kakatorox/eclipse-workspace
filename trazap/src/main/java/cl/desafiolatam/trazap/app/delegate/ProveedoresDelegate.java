package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.ProveedoresRequest;

public interface ProveedoresDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(ProveedoresRequest proveedoresRequest);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject update(int idProveedor, ProveedoresRequest proveedoresRequest);
}
