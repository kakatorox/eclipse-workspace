package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.PedidoRequest;

public interface PedidoDelegate {

	public ResponseServiceObject findAll();

	public ResponseServiceObject findById(Integer idPedido) throws ServiceException;

	public ResponseServiceObject save(PedidoRequest pedidoRequest);

	public ResponseServiceObject update(PedidoRequest pedidoRequest);

	public ResponseServiceObject delete(int idPedido);


}
