package cl.desafiolatam.facade;

import cl.desafiolatam.dto.UsuarioDTO;

public interface LoginFacade {
	public UsuarioDTO login(String usuario, String password);
}
