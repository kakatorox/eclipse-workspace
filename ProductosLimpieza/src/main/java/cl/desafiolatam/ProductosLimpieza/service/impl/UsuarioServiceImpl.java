package cl.desafiolatam.ProductosLimpieza.service.impl;

import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.ConsultasBDDao;
import cl.desafiolatam.ProductosLimpieza.dao.impl.ConsultasBDDaoImpl;
import cl.desafiolatam.ProductosLimpieza.dao.model.Users;
import cl.desafiolatam.ProductosLimpieza.service.UsuarioService;


public class UsuarioServiceImpl implements UsuarioService{

	ConsultasBDDao consultasBDDao = null;
	
	public UsuarioServiceImpl() {
		super();
		this.consultasBDDao = new ConsultasBDDaoImpl();
	}
	
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		
		return consultasBDDao.getUsers();
	}


}
