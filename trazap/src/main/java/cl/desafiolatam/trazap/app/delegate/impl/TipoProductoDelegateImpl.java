package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.TipoProductoDelegate;
import cl.desafiolatam.trazap.app.service.TipoProductoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.TipoProductoRequest;

@Component("tipoProductoDelegate")
public class TipoProductoDelegateImpl implements TipoProductoDelegate{
	@Autowired
	private TipoProductoService tipoProductoService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return tipoProductoService.findAll();
	}

	@Override
	public ResponseServiceObject delete(int id) {
		// TODO Auto-generated method stub
		return tipoProductoService.delete(id);
	}

	@Override
	public ResponseServiceObject save(TipoProductoRequest tipoProductoRequest) {
		// TODO Auto-generated method stub
		return tipoProductoService.save(tipoProductoRequest);
	}

	@Override
	public ResponseServiceObject update(int idTipoProducto, TipoProductoRequest tipoProductoRequest) {
		// TODO Auto-generated method stub
		return tipoProductoService.update(idTipoProducto,tipoProductoRequest);
	}

}
