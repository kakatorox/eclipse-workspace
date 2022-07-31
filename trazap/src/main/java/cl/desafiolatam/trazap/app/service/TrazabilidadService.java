package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.TrazabilidadRequest;

public interface TrazabilidadService {

	public ResponseServiceObject findAll();

	public ResponseServiceObject save(TrazabilidadRequest trazabilidadRequest);

	public ResponseServiceObject update(TrazabilidadRequest trazabilidadRequest);

	public ResponseServiceObject findById(Integer idTrazabilidad) throws ServiceException;

	public ResponseServiceObject delete(int idTrazabilidad);

}
