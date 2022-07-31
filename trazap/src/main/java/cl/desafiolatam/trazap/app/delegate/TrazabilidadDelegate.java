package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.TrazabilidadRequest;

public interface TrazabilidadDelegate {

	public ResponseServiceObject findAll();

	public ResponseServiceObject findById(Integer idTrazabilidad) throws ServiceException;

	public ResponseServiceObject save(TrazabilidadRequest trazabilidadRequest);

	public ResponseServiceObject update(TrazabilidadRequest trazabilidadRequest);

	public ResponseServiceObject delete(int idTrazabilidad);

}
