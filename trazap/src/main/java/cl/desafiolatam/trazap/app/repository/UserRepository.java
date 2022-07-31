package cl.desafiolatam.trazap.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.desafiolatam.trazap.app.repository.model.Users;

public interface UserRepository extends CrudRepository<Users, Integer>{
	public List<Users> findByEmail(String email);
}
