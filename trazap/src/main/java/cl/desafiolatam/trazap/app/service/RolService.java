package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.RolRequest;

public interface RolService {

	public ResponseServiceObject findAll();

	public ResponseServiceObject delete(int idRol);

	public ResponseServiceObject save(RolRequest rolRequest);

	public ResponseServiceObject update(RolRequest rolRequest);

	public ResponseServiceObject findById(Integer id) throws ServiceException;

	

}
