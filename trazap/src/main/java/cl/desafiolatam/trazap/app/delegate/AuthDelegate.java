package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.service.request.AuthUserRequest;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface AuthDelegate {
	public ResponseServiceObject authenticateUser(AuthUserRequest authUserRequest);
}
