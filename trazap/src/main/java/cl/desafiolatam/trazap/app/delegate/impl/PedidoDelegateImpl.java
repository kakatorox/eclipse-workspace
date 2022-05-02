package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.PedidoDelegate;
import cl.desafiolatam.trazap.app.service.PedidoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.PedidoRequest;

@Component("pedidoDelegate")
public class PedidoDelegateImpl implements PedidoDelegate{
	@Autowired
	private PedidoService pedidoService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject findById(Integer idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject save(PedidoRequest pedidoRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject update(int idPedido, PedidoRequest pedidoRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject delete(int idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

}
