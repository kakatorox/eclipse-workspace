package cl.desafiolatam.spsecurityex.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.desafiolatam.spsecurityex.app.repository.model.Rol;

public interface RolRepository extends CrudRepository<Rol, Integer>{
	public List<Rol> findByDescripcion(String descripcion);
}
