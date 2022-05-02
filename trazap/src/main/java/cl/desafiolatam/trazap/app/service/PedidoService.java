package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.PedidoRequest;

public interface PedidoService {

	public ResponseServiceObject findAll();

	public ResponseServiceObject save(PedidoRequest pedidoRequest);

	public ResponseServiceObject update(int idPedido, PedidoRequest pedidoRequest);

	public ResponseServiceObject findById(Integer idPedido) throws ServiceException;

	public ResponseServiceObject delete(int idPedido);

}
