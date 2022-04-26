package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.TipoProductoDelegate;
import cl.desafiolatam.trazap.app.service.TipoProductoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

@Component("tipoProductoDelegate")
public class TipoProductoDelegateImpl implements TipoProductoDelegate{
	@Autowired
	private TipoProductoService tipoProductoService;
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
