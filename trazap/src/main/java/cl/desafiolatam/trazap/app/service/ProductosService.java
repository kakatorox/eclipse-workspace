package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosRequest;

public interface ProductosService {

	public ResponseServiceObject findAll();

	public ResponseServiceObject save(ProductosRequest productosRequest);

	public ResponseServiceObject update(int idProductos, ProductosRequest productosRequest);

	public ResponseServiceObject findById(Integer idProductos) throws ServiceException;

	public ResponseServiceObject delete(int idProductos);

}
