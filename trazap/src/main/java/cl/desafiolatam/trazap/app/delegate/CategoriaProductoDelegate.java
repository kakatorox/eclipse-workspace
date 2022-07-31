package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.CategoriaProductoRequest;

public interface CategoriaProductoDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(CategoriaProductoRequest categoriaProductoRequest);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject update(CategoriaProductoRequest categoriaProductoRequest);

}
