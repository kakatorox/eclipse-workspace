package cl.desafiolatam.desafiorelop1.facade.impl;

import java.util.List;

import cl.desafiolatam.desafiorelop1.dto.UsuarioDto;
import cl.desafiolatam.desafiorelop1.facade.UsuarioFacade;
import cl.desafiolatam.desafiorelop1.service.impl.UsuarioServiceImpl;
import cl.desafiolatam.desafiorelop1.services.UsuarioService;

public class UsuarioFacadeImpl implements UsuarioFacade{

	UsuarioService usuarioService;

	public UsuarioFacadeImpl() {
		super();
		usuarioService = new UsuarioServiceImpl();
	}
	
	public List<UsuarioDto> getUsuariodesdeService() {
		List<UsuarioDto> usuario = usuarioService.getUsers();
		return usuario;
	}
	
}
