package cl.desafiolatam.desafiorelop1.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cl.desafiolatam.desafiorelop1.dao.ConsultasBDDao;
import cl.desafiolatam.desafiorelop1.dao.impl.ConsultasBDDaoImpl;
import cl.desafiolatam.desafiorelop1.dto.UsuarioDto;
import cl.desafiolatam.desafiorelop1.model.Usuario;
import cl.desafiolatam.desafiorelop1.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	ConsultasBDDao consultasBDDao = null;
	
	public UsuarioServiceImpl() {
		super();
		this.consultasBDDao = new ConsultasBDDaoImpl();
	}
	
	
	public  List<UsuarioDto> getUsers() {
		List<UsuarioDto> listaUsuarioDto = new ArrayList<UsuarioDto>() ;		
		
		for (Usuario usuario : consultasBDDao.getUsers()) {
			UsuarioDto usuariodto = new UsuarioDto();
			usuariodto.setUsuarios(usuario);
			listaUsuarioDto.add(usuariodto);
		}
		return listaUsuarioDto;
	}


}
