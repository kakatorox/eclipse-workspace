package cl.desafiolatam.ProductosLimpieza.facade.impl;


import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.model.Users;
import cl.desafiolatam.ProductosLimpieza.facade.UsuariosFacade;
import cl.desafiolatam.ProductosLimpieza.service.UsuarioService;
import cl.desafiolatam.ProductosLimpieza.service.impl.UsuarioServiceImpl;

public class UsuariosFacadeImpl implements UsuariosFacade {
	
	UsuarioService usuariosService;
	
	public UsuariosFacadeImpl() {
		super();
		this.usuariosService = new UsuarioServiceImpl();
	}
	
	
		
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return this.usuariosService.getUsers();
		
	}

}
