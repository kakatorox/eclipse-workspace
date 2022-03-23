package cl.desafiolatam.facade.impl;

import cl.desafiolatam.dto.UsuarioDTO;
import cl.desafiolatam.facade.LoginFacade;
import cl.desafiolatam.service.LoginService;
import cl.desafiolatam.service.impl.LoginServiceImpl;

public class LoginFacadeImpl implements LoginFacade{
	private LoginService loginService;
	
	
	
	public LoginFacadeImpl() {
		super();
		// TODO Auto-generated constructor stub
		loginService = new LoginServiceImpl();
	}



	@Override
	public UsuarioDTO login(String usuario, String password) {
		// TODO Auto-generated method stub
		return loginService.login(usuario, password);
	}

}
