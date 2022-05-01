package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.TipoProductoRequest;

public interface TipoProductoService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(int id);
	public ResponseServiceObject save(TipoProductoRequest tipoProductoRequest);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject update(int idTipoProducto,TipoProductoRequest tipoProductoRequest);
}
