package cl.desafiolatam.trazap.app.service;

import java.util.NoSuchElementException;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

public interface BodegaService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(BodegaRequest bodegaRequest);
	public ResponseServiceObject delete(int id);
	public ResponseServiceObject findById(Integer id)throws ServiceException;
	public ResponseServiceObject update(int idBodega, BodegaRequest bodegaRequest);
	
}
