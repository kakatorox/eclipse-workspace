package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.ProductosBodegaDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.ProductosBodegaService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosBodegaRequest;

@Component("productosBodegaDelegate")
public class ProductosBodegaDelegateImpl implements ProductosBodegaDelegate{
	@Autowired
	private ProductosBodegaService productosBodegaService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return productosBodegaService.findAll();
	}

	@Override
	public ResponseServiceObject findById(Integer idProductoBodega) throws ServiceException {
		// TODO Auto-generated method stub
		return productosBodegaService.findById(idProductoBodega);
	}

	@Override
	public ResponseServiceObject save(ProductosBodegaRequest productosBodegaRequest) {
		// TODO Auto-generated method stub
		return productosBodegaService.save(productosBodegaRequest);
	}

	@Override
	public ResponseServiceObject update(ProductosBodegaRequest productosBodegaRequest) {
		// TODO Auto-generated method stub
		return productosBodegaService.update(productosBodegaRequest);
	}

	@Override
	public ResponseServiceObject delete(int idProductoBodega) {
		// TODO Auto-generated method stub
		return productosBodegaService.delete(idProductoBodega);
	}

}
