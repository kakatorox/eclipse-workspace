package cl.desafiolatam.noticias.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cl.deafiolatam.noticias.app.model.Noticia;
import cl.desafiolatam.noticias.app.dto.NoticiaDto;
import cl.desafiolatam.noticias.app.facade.NoticiasFacade;
import cl.desafiolatam.noticias.app.service.NoticiasService;
import cl.desafiolatam.noticias.app.utils.Archivos;



@Configuration
@ComponentScan("cl.desafiolatam.noticias.*")
public class AppConfig {

	@Bean
	public Noticia noticia() {
		return new Noticia();
	}
	
	@Bean
	public NoticiaDto noticiaDto() {
		return new NoticiaDto();
	}
	
	@Bean
	public Archivos archivos() {
		return new Archivos();
	}
	
	@Bean
	public NoticiasFacade noticiaFacade() {
		return new NoticiasFacade();
	}
	
	@Bean
	public NoticiasService noticiaService() {
		return new NoticiasService();
	}
}
