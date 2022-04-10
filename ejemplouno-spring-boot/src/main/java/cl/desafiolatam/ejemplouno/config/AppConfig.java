package cl.desafiolatam.ejemplouno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cl.desafiolatam.ejemplouno.model.Alumno;

@Configuration
@ComponentScan("cl.desafiolatam.ejemplouno.*")
public class AppConfig {
	
	@Bean
	public Alumno alumno() {
		return new Alumno();
	}
}
