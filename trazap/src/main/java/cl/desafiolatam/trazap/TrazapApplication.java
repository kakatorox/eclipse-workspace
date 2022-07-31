package cl.desafiolatam.trazap;



import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import cl.desafiolatam.trazap.app.delegate.BodegaDelegate;
import cl.desafiolatam.trazap.app.delegate.CategoriaProductoDelegate;
import cl.desafiolatam.trazap.app.delegate.EstadoTrazabilidadDelegate;
import cl.desafiolatam.trazap.app.delegate.ProveedoresDelegate;
import cl.desafiolatam.trazap.app.delegate.TipoProductoDelegate;
import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.RolsRepository;
import cl.desafiolatam.trazap.app.repository.UserRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.Rols;
import cl.desafiolatam.trazap.app.repository.model.Users;
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
	private BodegaRepository bodegaRepository;
	@Autowired
	private CategoriaProductoDelegate categoriaProductoDelegate;
	@Autowired
	private EstadoTrazabilidadDelegate estadoTrazabilidadDelegate;
	@Autowired
	private ProveedoresDelegate proveedoresDelegate;
	@Autowired
	private TipoProductoDelegate tipoProductoDelegate;
	@Autowired
	private UserRepository usuarioRepository;
	@Autowired
	private RolsRepository rolsRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(TrazapApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner createUsers() {
//		
//		return (args) ->{
//			Users user = new Users();
//			Rols rols = new Rols();
//			rols.setDescripcion("ADMIN");
//			rolsRepository.save(rols);
//			user.setRols(rols);
//			user.setEmail("k@s.com");
//			user.setPassword(passwordEncoder.encode("1234"));
//			usuarioRepository.save(user);
//			
//			Users user1 = new Users();
//			Rols rols1 = new Rols();
//			rols1.setDescripcion("USER");
//			rolsRepository.save(rols1);
//			user1.setRols(rols1);
//			user1.setEmail("a@s.com");
//			user1.setPassword(passwordEncoder.encode("1234"));
//			usuarioRepository.save(user1);
//			
//			Users user2 = new Users();
//			Rols rols2 = new Rols();
//			rols.setDescripcion("PROVEEDOR");
//			rolsRepository.save(rols2);
//			user2.setRols(rols2);
//			user2.setEmail("p@s.com");
//			user2.setPassword(passwordEncoder.encode("1234"));
//			usuarioRepository.save(user2);
//			
//			
//			logger.info(user.toString());
//			
//		};
//	}
		
//	@Bean
//	public CommandLineRunner createBodega() {
//		
//		return (args) ->{
//			BodegaRequest bodega1 = new BodegaRequest();
//			bodega1.setDescripcion("Mi Bodega 1");
//			bodegaDelegate.save(bodega1);
//			logger.info(bodega1.toString());
//			
//		};
//	}
	
//	@Bean
//	public CommandLineRunner findAllBodega() {
//		
//		return (args) ->{
//			Bodega bodega = new Bodega();
//			bodega.setDescripcion("Mi Bodega");
//			Iterable<Bodega> itBodega = bodegaRepository.findAll();
//			Iterator<Bodega> itBod = itBodega.iterator();
//			while (itBod.hasNext()) {
//				logger.info(itBod.toString());
//				
//			}
//			
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
//			proveedoresRequest.setRutProveedor("15911702-2");
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
//	
//	

//	@Bean
//	public CommandLineRunner findAllBodega() {		
//		return (args) ->{
//			Bodega bodega = new Bodega();
//			bodega.setDescripcion("Mi Bodega");
//			ResponseServiceObject itBodega = bodegaDelegate.findAll();
//			while (itBodega.hasNext()) {
//				logger.info(itBodega.next().toString());
//				
//			}
//		};
//	}
}
