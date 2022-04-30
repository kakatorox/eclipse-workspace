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
import cl.desafiolatam.trazap.app.delegate.CategoriaProductoDelegate;
import cl.desafiolatam.trazap.app.delegate.EstadoTrazabilidadDelegate;
import cl.desafiolatam.trazap.app.delegate.ProveedoresDelegate;
import cl.desafiolatam.trazap.app.delegate.TipoProductoDelegate;
import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.TipoProductoRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.TipoProducto;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.CategoriaProductoRequest;
import cl.desafiolatam.trazap.app.ui.model.request.EstadoTrazabilidadRequest;
import cl.desafiolatam.trazap.app.ui.model.request.ProveedoresRequest;
import cl.desafiolatam.trazap.app.ui.model.request.TipoProductoRequest;

@SpringBootApplication
public class TrazapApplication {

	private final static Logger logger= LoggerFactory.getLogger(TrazapApplication.class);
	
	@Autowired
	private BodegaDelegate bodegaDelegate;
	@Autowired
	private CategoriaProductoDelegate categoriaProductoDelegate;
	@Autowired
	private EstadoTrazabilidadDelegate estadoTrazabilidadDelegate;
	@Autowired
	private ProveedoresDelegate proveedoresDelegate;
	@Autowired
	private TipoProductoDelegate tipoProductoDelegate;
	public static void main(String[] args) {
		SpringApplication.run(TrazapApplication.class, args);
	}
		
	@Bean
	public CommandLineRunner createBodega() {
		
		return (args) ->{
			BodegaRequest bodega1 = new BodegaRequest();
			bodega1.setDescripcion("Mi Bodega 1");
			bodegaDelegate.save(bodega1);
			logger.info(bodega1.toString());
			
		};
	}
	
//	@Bean
//	public CommandLineRunner findAllBodega() {
//		
//		return (args) ->{
//			Bodega bodega = new Bodega();
//			bodega.setDescripcion("Mi Bodega");
//			Iterator<Bodega> itBodega = bodegaDelegate.findByAll().toString();
//			while (itBodega.hasNext()) {
//				logger.info(itBodega.next().toString());
//				
//			}
//			while (bodegaDelegate.findByAll()) {
//				type type = (type) en.nextElement();
//				
//			}
//		};
//	}
	
//	@Bean
//	public CommandLineRunner createCategoriaProducto() {
//		
//		return (args) ->{
//			CategoriaProductoRequest categoriaProducto = new CategoriaProductoRequest();
//			categoriaProducto.setDescripcion("Mi CategoriaProducto 1");			
//			categoriaProductoDelegate.save(categoriaProducto);
//			
//			logger.info(categoriaProducto.toString());
//			
//		};
//	}
//	@Bean
//	public CommandLineRunner createEstadoTrazabilidad() {
//		
//		return (args) ->{
//			EstadoTrazabilidadRequest estadoTrazabilidadRequest = new EstadoTrazabilidadRequest();
//			estadoTrazabilidadRequest.setDescripcion("Mi Trazabilidad 1");
//			estadoTrazabilidadDelegate.save(estadoTrazabilidadRequest);
//			logger.info(estadoTrazabilidadRequest.toString());
//			
//		};
//	}
//	@Bean
//	public CommandLineRunner createProveedores() {
//		
//		return (args) ->{
//			ProveedoresRequest proveedoresRequest = new ProveedoresRequest();
//			proveedoresRequest.setRazonSocial("Proveedor 1");
//			proveedoresRequest.setRutProveedor("rut proveedor 1");
//			proveedoresDelegate.save(proveedoresRequest);
//			logger.info(proveedoresRequest.toString());
//			
//		};
//	}
//	@Bean
//	public CommandLineRunner createTipoProducto() {
//		
//		return (args) ->{
//			TipoProductoRequest tipoProductoRequest = new TipoProductoRequest();
//			tipoProductoRequest.setDescripcion("Mi Bodega 1");
//			tipoProductoDelegate.save(tipoProductoRequest);
//			logger.info(tipoProductoRequest.toString());
//			
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
//			while (itBodega.hasNext()) {
//				logger.info(itBodega.next().toString());
//				
//			}
//			while (bodegaDelegate.findAll()) {
//				type type = (type) en.nextElement();
//				
//			}
//		};
//	}
}
