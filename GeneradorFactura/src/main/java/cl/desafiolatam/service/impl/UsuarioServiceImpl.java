package cl.desafiolatam.service.impl;

import java.util.List;

import cl.desafiolatam.dao.ConsultasBDDao;
import cl.desafiolatam.dao.impl.ConsultasBDDaoImpl;
import cl.desafiolatam.model.Users;
import cl.desafiolatam.service.UsuarioService;

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
