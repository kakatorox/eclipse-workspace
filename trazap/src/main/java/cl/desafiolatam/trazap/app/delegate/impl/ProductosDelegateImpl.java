package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.ProductosDelegate;
import cl.desafiolatam.trazap.app.service.ProductosService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosRequest;

@Component("productosDelegate")
public class ProductosDelegateImpl implements ProductosDelegate{
	@Autowired
	private ProductosService productosService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject findById(Integer idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject save(ProductosRequest productosRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject update(int idProducto, ProductosRequest productosRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject delete(int idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

}
