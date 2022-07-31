package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.DetallePedidoRequest;

public interface DetallePedidoDelegate {

	public ResponseServiceObject findAll();

	public ResponseServiceObject findById(Integer idDetallePedido) throws ServiceException;

	public ResponseServiceObject save(DetallePedidoRequest detallePedidoRequest);

	public ResponseServiceObject update(DetallePedidoRequest detallePedidoRequest);

	public ResponseServiceObject delete(int idDetallePedido);

}
