package cl.presentacion.formuval.service;

import java.util.List;
import java.util.Optional;

import cl.presentacion.formuval.model.Persona;

public interface PersonaService {

	public Persona save(Persona persona);

	public List<Persona> findAll();

	public Optional<Persona> findById(Integer id);

	public void deleteById(Integer id);

	public Persona update(Persona persona);


}
