package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.ProductosBodegaDelegate;
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
		return null;
	}

	@Override
	public ResponseServiceObject findById(Integer idProductoBodega) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject save(ProductosBodegaRequest productosBodegaRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject update(int idProductoBodega, ProductosBodegaRequest productosBodegaRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject delete(int idProductoBodega) {
		// TODO Auto-generated method stub
		return null;
	}

}
