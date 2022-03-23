package cl.desafiolatam.service;

import cl.desafiolatam.dto.UsuarioDTO;

public interface LoginService {

	UsuarioDTO login(String usuario, String password);

}
