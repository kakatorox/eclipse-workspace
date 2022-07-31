package cl.presentacion.formuval.app.ui.api.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.presentacion.formuval.app.delegate.PersonaDelegate;
import cl.presentacion.formuval.model.Persona;

@RestController
@RequestMapping("/api")
public class PersonaController {
		
	@Autowired
	private PersonaDelegate personaDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> findAllPersonas() {
		
		return new ResponseEntity<List<Persona>>(personaDelegate.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(
				value = "{id}"
			)
	public ResponseEntity<Optional<Persona>> findPersonaById(@PathVariable int id ) {
		 
		return new ResponseEntity<Optional<Persona>>(personaDelegate.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
		)
	public ResponseEntity<Persona> createPersona(@RequestBody Persona persona){
				
		return new ResponseEntity<Persona>(personaDelegate.save(persona), HttpStatus.OK);
		
	}
	
	@PutMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona){
		return new ResponseEntity<Persona>(personaDelegate.save(persona), HttpStatus.OK);
		
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deletePersona(@RequestBody Persona persona){
		personaDelegate.deleteById(persona.getIdPersona());
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
	
}
