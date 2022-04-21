package cl.desafiolatam.trazap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;

@SpringBootApplication
public class TrazapApplication {

	private final static Logger logger= LoggerFactory.getLogger(TrazapApplication.class);
	@Autowired
	private BodegaRepository bodegaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TrazapApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner createBodega() {
		
		return (args) ->{
			Bodega bodega = new Bodega();
			bodega.setDescripcion("Mi Bodega");
			bodegaRepository.save(bodega);
			logger.info(bodega.toString());
		};
	}

}
