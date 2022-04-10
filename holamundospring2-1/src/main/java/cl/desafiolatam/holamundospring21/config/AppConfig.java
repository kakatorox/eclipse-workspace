package cl.desafiolatam.holamundospring21.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cl.desafiolatam.holamundospring21.model.Alumno;


//esta clase se unsa al inico por el segmento diciendole al spring configuration
@Configuration
@ComponentScan("cl.desafiolatam.holamundospring.*")
public class AppConfig {
	
	@Bean
	public Alumno alumno() {
		return new Alumno();
	}
	
}
