package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.UserRequest;

public interface UserDelegate {

	public ResponseServiceObject findAll();

	public ResponseServiceObject findById(Integer idUser) throws ServiceException;

	public ResponseServiceObject save(UserRequest userRequest);

	public ResponseServiceObject update(UserRequest userRequest);

	public ResponseServiceObject delete(int idUser);

}
