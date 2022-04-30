package cl.desafiolatam.spsecurityex;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import cl.desafiolatam.spsecurityex.app.repository.RolRepository;
import cl.desafiolatam.spsecurityex.app.repository.UsuarioRepository;
import cl.desafiolatam.spsecurityex.app.repository.model.Rol;
import cl.desafiolatam.spsecurityex.app.repository.model.Usuario;


@SpringBootApplication
public class SpsecurityexApplication {
	private final static Logger logger= LoggerFactory.getLogger(SpsecurityexApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpsecurityexApplication.class, args);
	}

	@Autowired
	RolRepository rolRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	//crear usuario
	
	@Bean
	public CommandLineRunner createUsuario() {
		return (args) -> {
			
			Rol rol1= new Rol();
			//SUPERSAYA
			//ADMIN
			//USER
			rol1.setDescripcion("USER");
			rolRepository.save(rol1);
			
			Usuario usuario1 = new Usuario();
			
			usuario1.setNombre("kato");			
			usuario1.setPassword(passwordEncoder.encode("1234"));
			usuario1.setEmail("raton@hotmail.com");
			usuario1.setRol(rol1);
			usuarioRepository.save(usuario1);
			
			Rol rol2= new Rol();
			rol2.setDescripcion("ADMIN");
			rolRepository.save(rol2);
			
			Usuario usuario = new Usuario();
			
			usuario.setNombre("tox");			
			usuario.setPassword(passwordEncoder.encode("1234"));
			usuario.setEmail("ran@h.com");
			usuario.setRol(rol2);
			usuarioRepository.save(usuario);
			
			
			
			
			logger.info(usuario.toString());
		};
	}
	//buscar todos los usuarios
	
	//buscar un usuario por el nombre usuario o email

}
