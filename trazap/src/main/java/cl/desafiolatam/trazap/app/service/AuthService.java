package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.service.request.AuthUserRequest;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface AuthService {
	public ResponseServiceObject authenticateUser(AuthUserRequest authUserRequest);
}
