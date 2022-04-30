package cl.desafiolatam.spsecurityex.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.desafiolatam.spsecurityex.app.repository.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	public List<Usuario> findByEmail(String email);
	public List<Usuario> findByNombre(String nombre);
	

}
