package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.CategoriaProductoRequest;

public interface CategoriaProductoService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(int idCategoriaProducto);
	public ResponseServiceObject save(CategoriaProductoRequest categoriaProductoRequest);
	public ResponseServiceObject delete(int idCategoriaProducto);
	public ResponseServiceObject update(CategoriaProductoRequest categoriaProductoRequest);
}
