package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosRequest;

public interface ProductosDelegate {

	public ResponseServiceObject findAll();

	public ResponseServiceObject findById(Integer idProducto) throws ServiceException;

	public ResponseServiceObject save(ProductosRequest productosRequest);

	public ResponseServiceObject update(ProductosRequest productosRequest);

	public ResponseServiceObject delete(int idProducto);

}
