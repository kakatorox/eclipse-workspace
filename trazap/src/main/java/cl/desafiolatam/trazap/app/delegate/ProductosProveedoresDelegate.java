package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosProveedoresRequest;

public interface ProductosProveedoresDelegate {

	public ResponseServiceObject findAll();

	public ResponseServiceObject findById(Integer idProductosProveedores) throws ServiceException;

	public ResponseServiceObject save(ProductosProveedoresRequest productosProveedoresRequest);

	public ResponseServiceObject update(int idProductosProveedores,ProductosProveedoresRequest productosProveedoresRequest);

	public ResponseServiceObject delete(int idProductosProveedores);

}
