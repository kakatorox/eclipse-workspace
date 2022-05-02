package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosRequest;

public interface ProductosDelegate {

	public ResponseServiceObject findAll();

	public ResponseServiceObject findById(Integer idProducto);

	public ResponseServiceObject save(ProductosRequest productosRequest);

	public ResponseServiceObject update(int idProducto, ProductosRequest productosRequest);

	public ResponseServiceObject delete(int idProducto);

}
