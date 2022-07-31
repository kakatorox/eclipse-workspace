package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.AuthDelegate;
import cl.desafiolatam.trazap.app.service.AuthService;
import cl.desafiolatam.trazap.app.service.request.AuthUserRequest;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Component("authDelegate")
public class AuthDelegateImpl implements AuthDelegate{
	@Autowired
	private AuthService authService;
	@Override
	public ResponseServiceObject authenticateUser(AuthUserRequest authUserRequest) {
		// TODO Auto-generated method stub
		return authService.authenticateUser(authUserRequest);
	}

}
