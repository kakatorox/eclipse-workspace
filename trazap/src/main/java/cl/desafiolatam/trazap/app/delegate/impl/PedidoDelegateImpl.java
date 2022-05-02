package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.PedidoDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
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
		return pedidoService.findAll();
	}

	@Override
	public ResponseServiceObject findById(Integer idPedido) throws ServiceException {
		// TODO Auto-generated method stub
		return pedidoService.findById(idPedido);
	}

	@Override
	public ResponseServiceObject save(PedidoRequest pedidoRequest) {
		// TODO Auto-generated method stub
		return pedidoService.save(pedidoRequest);
	}

	@Override
	public ResponseServiceObject update(int idPedido, PedidoRequest pedidoRequest) {
		// TODO Auto-generated method stub
		return pedidoService.update(idPedido, pedidoRequest);
	}

	@Override
	public ResponseServiceObject delete(int idPedido) {
		// TODO Auto-generated method stub
		return pedidoService.delete(idPedido);
	}

}
