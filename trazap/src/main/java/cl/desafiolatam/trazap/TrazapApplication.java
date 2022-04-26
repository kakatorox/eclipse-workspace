package cl.desafiolatam.trazap;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.desafiolatam.trazap.app.delegate.BodegaDelegate;
import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.TipoProductoRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.TipoProducto;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

@SpringBootApplication
public class TrazapApplication {

	private final static Logger logger= LoggerFactory.getLogger(TrazapApplication.class);
	
	@Autowired
	private BodegaDelegate bodegaDelegate;
	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	public static void main(String[] args) {
		SpringApplication.run(TrazapApplication.class, args);
	}
	
	
//	@Bean
//	public CommandLineRunner createBodega() {
//		
//		return (args) ->{
//			BodegaRequest bodega1 = new BodegaRequest();
//			BodegaRequest bodega2 = new BodegaRequest();
//			bodega1.setDescripcion("Mi Bodega7");
//			bodegaDelegate.save(bodega1);
//			bodega2.setDescripcion("Mi Bodega8");
//			bodegaDelegate.save(bodega2);
//			
//			//bodegaRepository.save(bodega);
//			logger.info(bodega1.toString());
//			logger.info(bodega2.toString());
//		};
//	}
	
//	@Bean
//	public CommandLineRunner createTipoProducto() {
//		return (args) -> {
//			TipoProducto tipoProducto1 = new TipoProducto();
//			TipoProducto tipoProducto2 = new TipoProducto();
//			tipoProducto1.setDescripcion("TipoProducto 1");
//			tipoProducto2.setDescripcion("TipoProducto 2");
//			tipoProductoRepository.save(tipoProducto1);
//			tipoProductoRepository.save(tipoProducto2);
//			logger.info(tipoProducto1.toString());
//			logger.info(tipoProducto2.toString());
//		};
//	}
	
//
//	@Bean
//	public CommandLineRunner findAllBodega() {
//		
//		return (args) ->{
//			Bodega bodega = new Bodega();
//			bodega.setDescripcion("Mi Bodega");
//			//Iterator<Bodega> itBodega = bodegaDelegate.findAll().toString();
////			while (itBodega.hasNext()) {
////				logger.info(itBodega.next().toString());
////				
////			}
//			while (bodegaDelegate.findAll()) {
//				type type = (type) en.nextElement();
//				
//			}
//		};
//	}
}
