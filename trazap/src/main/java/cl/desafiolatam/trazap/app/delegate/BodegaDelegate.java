package cl.desafiolatam.trazap.app.delegate;

import java.util.NoSuchElementException;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

public interface BodegaDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(BodegaRequest bodegaRequest);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest);
	public ResponseServiceObject findById(Integer id) throws ServiceException;
}
