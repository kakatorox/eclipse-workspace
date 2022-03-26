package cl.desafiolatam.desafiorelop1.dao;

import java.util.List;

import cl.desafiolatam.desafiorelop1.dto.UsuarioDto;
import cl.desafiolatam.desafiorelop1.model.Usuario;

public interface ConsultasBDDao {
	public List<Usuario> getUsers();
}
