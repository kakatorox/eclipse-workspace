package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosProveedoresRequest;

public interface ProductosProveedoresService {

	public ResponseServiceObject findAll();

	public ResponseServiceObject save(ProductosProveedoresRequest productosProveedoresRequest);

	public ResponseServiceObject update(ProductosProveedoresRequest productosProveedoresRequest);

	public ResponseServiceObject findById(Integer idProductosProveedores) throws ServiceException;

	public ResponseServiceObject delete(int idProductosProveedores);

}
