package cl.desafiolatam.contactmanager.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cl.desafiolatam.contactmanager.app.ui.dto.ContactoDto;


@Configuration
@ComponentScan("cl.desafiolatam.contactmanager.app.*")
public class AppConfig {

	@Bean(name="listaContactoDTO")
	
	public List<ContactoDto> getListaPersonaDto(){
		return new ArrayList<ContactoDto>();
	}
}
