package cl.desafiolatam.trazap.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.CategoriaProductoRespository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.CategoriaProductoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Service("categoriaProductoService")
public class CategoriaProductoServiceImpl implements CategoriaProductoService{
	@Autowired
	private CategoriaProductoRespository categoriaProductoRespository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseServiceObject findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseServiceObject save(Bodega bodega) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseServiceObject delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseServiceObject update(Bodega bodega) {
		// TODO Auto-generated method stub
		return null;
	}
}
