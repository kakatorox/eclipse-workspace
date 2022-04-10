package cl.desafiolatam.ejemplouno;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cl.desafiolatam.ejemplouno.config.AppConfig;
import cl.desafiolatam.ejemplouno.model.Alumno;

@SpringBootApplication
public class EjemplounoSpringBootApplication {
	private final static Logger logger = LoggerFactory.getLogger(EjemplounoSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EjemplounoSpringBootApplication.class, args);
		ApplicationContext appContex = new AnnotationConfigApplicationContext(AppConfig.class);
		
		logger.debug("Log debug");
		logger.info("Log info");
		logger.warn("Log warning");
		logger.error("Log error");
		
		Alumno alumno = appContex.getBean(Alumno.class);
		
		System.out.println(alumno.toString());
	}

}
