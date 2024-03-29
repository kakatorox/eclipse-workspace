package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.UserRequest;

public interface BodegaService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(BodegaRequest bodegaRequest);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject findById(Integer id)throws ServiceException;
	public ResponseServiceObject update(BodegaRequest bodegaRequest);
	
	
}
