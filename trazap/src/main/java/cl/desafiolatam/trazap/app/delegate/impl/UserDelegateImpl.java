package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.BodegaDelegate;
import cl.desafiolatam.trazap.app.delegate.UserDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.UserService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.UserRequest;

@Component("userDelegate")
public class UserDelegateImpl implements UserDelegate{

	@Autowired
	private UserService userService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return userService.findAll();
	}

	@Override
	public ResponseServiceObject save(UserRequest userRequest) {
		// TODO Auto-generated method stub
		return userService.save(userRequest);
	}
	@Override
	public ResponseServiceObject update(UserRequest userRequest) {
		// TODO Auto-generated method stub
		return userService.update(userRequest);
	}

	@Override
	public ResponseServiceObject delete(int id) {
		// TODO Auto-generated method stub
		return userService.delete(id);
	}

	@Override
	public ResponseServiceObject findById(Integer id) throws ServiceException{
		// TODO Auto-generated method stub
		return userService.findById(id);
	}

	

	
}
