package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.CategoriaProductoDelegate;
import cl.desafiolatam.trazap.app.service.CategoriaProductoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.CategoriaProductoRequest;

@Component("categoriaProductoDelegate")
public class CategoriaProductoDelegateImpl implements CategoriaProductoDelegate{

	@Autowired
	private CategoriaProductoService categoriaProductoService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return categoriaProductoService.findAll();
	}

	@Override
	public ResponseServiceObject save(CategoriaProductoRequest categoriaProductoRequest) {
		// TODO Auto-generated method stub
		return categoriaProductoService.save(categoriaProductoRequest);
	}

	@Override
	public ResponseServiceObject delete(int idCategoriaProducto) {
		// TODO Auto-generated method stub
		return categoriaProductoService.delete(idCategoriaProducto);
	}

	@Override
	public ResponseServiceObject update(CategoriaProductoRequest categoriaProductoRequest) {
		// TODO Auto-generated method stub
		return categoriaProductoService.update(categoriaProductoRequest);
	}

}
