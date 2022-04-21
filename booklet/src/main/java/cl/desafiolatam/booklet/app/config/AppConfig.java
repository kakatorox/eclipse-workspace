package cl.desafiolatam.booklet.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cl.desafiolatam.booklet.app.ui.dto.LibroDto;


@Configuration
@ComponentScan("cl.desafiolatam.booklet.app.*")
public class AppConfig {
	
	@Bean(name = "listaLibroDTO")
	public List<LibroDto> getListaLibroDTO(){
		return new ArrayList<LibroDto>();
	}
}
