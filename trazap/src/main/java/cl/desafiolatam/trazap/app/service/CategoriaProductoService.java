package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.repository.model.CategoriaProducto;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface CategoriaProductoService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(int id);
	public ResponseServiceObject save(CategoriaProducto categoriaProducto);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject update(CategoriaProducto categoriaProducto);
}
