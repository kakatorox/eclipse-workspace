package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.ProductosProveedoresDelegate;
import cl.desafiolatam.trazap.app.service.ProductosProveedoresService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosProveedoresRequest;

@Component("productosProveedoresDelegate")
public class ProductosProveedoresDelegateImpl implements ProductosProveedoresDelegate{
	@Autowired
	private ProductosProveedoresService productosProveedoresService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject findById(Integer idProductosProveedores) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject save(ProductosProveedoresRequest productosProveedoresRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject update(int idProductosProveedores,
			ProductosProveedoresRequest productosProveedoresRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject delete(int idProductosProveedores) {
		// TODO Auto-generated method stub
		return null;
	}

}
