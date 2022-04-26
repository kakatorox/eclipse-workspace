package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.CategoriaProductoDelegate;
import cl.desafiolatam.trazap.app.service.CategoriaProductoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

@Component("categoriaProductoDelegate")
public class CategoriaProductoDelegateImpl implements CategoriaProductoDelegate{

	@Autowired
	private CategoriaProductoService categoriaProductoService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject save(BodegaRequest bodegaRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
