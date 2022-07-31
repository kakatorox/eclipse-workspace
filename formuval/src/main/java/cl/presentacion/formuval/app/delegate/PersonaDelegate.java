package cl.presentacion.formuval.app.delegate;

import java.util.List;
import java.util.Optional;

import cl.presentacion.formuval.model.Persona;

public interface PersonaDelegate {

	public List<Persona> findAll();

	public Optional<Persona> findById(Integer id);

	public Persona save(Persona persona);

	public Persona update(Persona persona);

	public void deleteById(Integer id);

	

}
