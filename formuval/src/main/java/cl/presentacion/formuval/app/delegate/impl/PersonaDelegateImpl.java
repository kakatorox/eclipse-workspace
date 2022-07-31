package cl.presentacion.formuval.app.delegate.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.presentacion.formuval.app.delegate.PersonaDelegate;
import cl.presentacion.formuval.model.Persona;
import cl.presentacion.formuval.service.PersonaService;

@Component("personaDelegate")
public class PersonaDelegateImpl implements PersonaDelegate{

	@Autowired
	private PersonaService personaService;
	
	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaService.findAll();
	}
	
	@Override
	public Optional<Persona> findById(Integer id) {
		// TODO Auto-generated method stub
		return personaService.findById(id);
	}
	
	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return personaService.save(persona);
	}
	
	@Override
	public Persona update(Persona persona) {
		// TODO Auto-generated method stub
		return personaService.update(persona);
	}
	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		personaService.deleteById(id);
	}

}
