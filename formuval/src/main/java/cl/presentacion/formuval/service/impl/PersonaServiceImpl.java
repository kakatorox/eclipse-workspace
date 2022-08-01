package cl.presentacion.formuval.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cl.presentacion.formuval.model.Persona;
import cl.presentacion.formuval.repository.PersonaRepository;
import cl.presentacion.formuval.service.PersonaService;

@Service("personaService")
public class PersonaServiceImpl  implements PersonaService{
	@Autowired
	private PersonaRepository personaRepository;	
	
	@Override
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}
	
	@Override
	public Persona update(Persona persona) {
		return personaRepository.save(persona);
	}
	
	@Override
	public List<Persona> findAll(){
		return personaRepository.findAll(Sort.by(Sort.Direction.DESC,"idPersona"));
//		return personaRepository.findAll(Sort.by(Sort.Direction.ASC,"idPersona"));
	}
	
	@Override
	public Optional<Persona> findById(Integer id){
		return personaRepository.findById(id);
	}
	
	@Override
	public void deleteById(Integer id) {
		personaRepository.deleteById(id);
	}

	
	
}
