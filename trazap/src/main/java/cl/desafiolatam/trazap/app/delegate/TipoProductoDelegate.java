package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.TipoProductoRequest;

public interface TipoProductoDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(TipoProductoRequest tipoProductoRequest);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject update(int idTipoProducto, TipoProductoRequest tipoProductoRequest);
}
