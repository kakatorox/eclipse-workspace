package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosBodegaRequest;

public interface ProductosBodegaService {

	public ResponseServiceObject findAll();

	public ResponseServiceObject save(ProductosBodegaRequest productosBodegaRequest);

	public ResponseServiceObject update(int idProductosBodega, ProductosBodegaRequest productosBodegaRequest);

	public ResponseServiceObject findById(Integer idProductosBodega) throws ServiceException;

	public ResponseServiceObject delete(int idProductosBodega);

}
