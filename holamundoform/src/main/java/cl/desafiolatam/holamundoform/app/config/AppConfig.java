package cl.desafiolatam.holamundoform.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cl.desafiolatam.holamundoform.app.ui.dto.PersonaDto;

@Configuration
@ComponentScan("cl.desafiolatam.holamundoform.app.*")
public class AppConfig {

	@Bean(name="listaPersonaDTOS")
	
	public List<PersonaDto> getListaPersonaDto(){
		return new ArrayList<PersonaDto>();
	}
}
