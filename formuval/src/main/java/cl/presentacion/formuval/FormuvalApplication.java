package cl.presentacion.formuval;

import java.util.Iterator;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.presentacion.formuval.app.delegate.PersonaDelegate;
import cl.presentacion.formuval.model.Persona;

@SpringBootApplication
public class FormuvalApplication {
	
	@Autowired
	private PersonaDelegate personaDelegate;
	
	
	
	private final static Logger logger= LoggerFactory.getLogger(FormuvalApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FormuvalApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner findAll() {
//		
//		return (args) ->{
//			Iterable<Persona> itPersona = personaDelegate.findAll();
//			System.out.println("Delegate");
//			for (Iterator iterator = itPersona.iterator(); iterator.hasNext();) {
//				 System.out.println(iterator.next());	
//			}
//		};
//	}
//	
//	@Bean
//	public CommandLineRunner findById() {
//		
//		return (args) ->{
//			Integer id = 1;
//			Optional<Persona> persona = personaDelegate.findById(id);
//			System.out.println(persona.toString());
//			
//		};
//	}
//	
//	@Bean
//	public CommandLineRunner save() {
//		
//		return (args) ->{
//			Persona per = new Persona();
//			per.setNombre("KAKATO");
//			per.setApellido("Rox");
//			per.setEmail("kakatorox@gmail.com");
//			personaDelegate.save(per);
//			System.out.println(personaDelegate.toString());
//			
//		};
//	}
//	
//	@Bean
//	public CommandLineRunner update() {
//		
//		return (args) ->{
//			Persona per = new Persona();
//			per.setIdPersona(4);
//			per.setNombre("KAKATOc");
//			per.setApellido("Roxasdas");
//			per.setEmail("kakatorasdasdox@gmail.com");
//			personaDelegate.update(per);
//			System.out.println(personaDelegate.toString());
//			
//		};
//	}
//	
//	@Bean
//	public CommandLineRunner deleteById() {
//		
//		return (args) ->{
//			Integer id = 6 ;
//			personaDelegate.delete(id);
//			System.out.println(personaDelegate.toString());
//			
//		};
//	}
	
}
