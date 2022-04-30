package cl.desafiolatam.spsecurityex.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.desafiolatam.spsecurityex.app.repository.UsuarioRepository;
import cl.desafiolatam.spsecurityex.app.repository.model.Usuario;
@Service
public class AuthServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<Usuario> listUsers = usuarioRepository.findByEmail(username);
		Usuario usuario = null;
		UserBuilder userBuilder = null;
		if(listUsers == null || listUsers.size() != 1) {
			throw new UsernameNotFoundException(username);
		}else {
			usuario = listUsers.get(0);
			userBuilder = User.withUsername(username);
			userBuilder.password(usuario.getPassword());
			//userBuilder.password(new BCryptPasswordEncoder().encode(usuario.getPassword()));
			String[] roles = {usuario.getRol().getDescripcion()};
			userBuilder.roles(roles);			
		}
		return userBuilder.build();
	}
}
