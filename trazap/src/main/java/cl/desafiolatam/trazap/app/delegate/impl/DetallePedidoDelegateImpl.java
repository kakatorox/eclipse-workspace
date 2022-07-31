package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.DetallePedidoDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.DetallePedidoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.DetallePedidoRequest;

@Component("detallePedidoDelegate")
public class DetallePedidoDelegateImpl implements DetallePedidoDelegate{
	@Autowired
	private DetallePedidoService detallePedidoService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return detallePedidoService.findAll();
	}

	@Override
	public ResponseServiceObject findById(Integer idDetallePedido) throws ServiceException {
		// TODO Auto-generated method stub
		return detallePedidoService.findById(idDetallePedido);
	}

	@Override
	public ResponseServiceObject save(DetallePedidoRequest detallePedidoRequest) {
		// TODO Auto-generated method stub
		return detallePedidoService.save(detallePedidoRequest);
	}

	@Override
	public ResponseServiceObject update(DetallePedidoRequest detallePedidoRequest) {
		// TODO Auto-generated method stub
		return detallePedidoService.update(detallePedidoRequest);
	}

	@Override
	public ResponseServiceObject delete(int idDetallePedido) {
		// TODO Auto-generated method stub
		return detallePedidoService.delete(idDetallePedido);
	}

}
