package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

public interface TipoProductoDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(BodegaRequest bodegaRequest);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest);
}
