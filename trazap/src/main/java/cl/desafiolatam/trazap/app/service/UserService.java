package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.UserRequest;

public interface UserService {

	public ResponseServiceObject findById(Integer id) throws ServiceException;

	public ResponseServiceObject findAll();

	public ResponseServiceObject save(UserRequest userRequest);

	public ResponseServiceObject update(UserRequest userRequest);

	public ResponseServiceObject delete(int id);

}
