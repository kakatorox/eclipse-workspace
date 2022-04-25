package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.TipoProducto;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface TipoProductoService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(int id);
	public ResponseServiceObject save(TipoProducto tipoProducto);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject update(TipoProducto tipoProducto);
}
