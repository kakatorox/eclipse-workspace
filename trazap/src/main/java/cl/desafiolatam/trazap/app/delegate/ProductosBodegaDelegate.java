package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosBodegaRequest;

public interface ProductosBodegaDelegate {

	public ResponseServiceObject findAll();

	public ResponseServiceObject findById(Integer idProductoBodega);

	public ResponseServiceObject save(ProductosBodegaRequest productosBodegaRequest);

	public ResponseServiceObject update(int idProductoBodega, ProductosBodegaRequest productosBodegaRequest);

	public ResponseServiceObject delete(int idProductoBodega);

}
