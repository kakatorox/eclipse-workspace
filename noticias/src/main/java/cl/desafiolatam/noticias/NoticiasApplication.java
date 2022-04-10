package cl.desafiolatam.noticias;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cl.desafiolatam.noticias.app.ui.controller.InitController;

@SpringBootApplication
public class NoticiasApplication {
	private final static Logger logger = LoggerFactory.getLogger(NoticiasApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(NoticiasApplication.class, args);
		logger.debug("Log debug");
		logger.info("Log info");
		logger.warn("Log warning");
		logger.error("Log error");
	}

}
