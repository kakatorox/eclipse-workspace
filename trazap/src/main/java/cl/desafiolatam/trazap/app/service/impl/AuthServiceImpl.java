package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.UserRepository;
import cl.desafiolatam.trazap.app.repository.model.Users;
import cl.desafiolatam.trazap.app.service.AuthService;
import cl.desafiolatam.trazap.app.service.request.AuthUserRequest;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("authService")
public class AuthServiceImpl implements UserDetailsService, AuthService{
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository usuariosRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<Users> listaUsuarios = usuariosRepository.findByEmail(username);
		Users usuario = null;
		UserBuilder builder = null;
		
		if(listaUsuarios == null || listaUsuarios.size() != 1) {
			throw new UsernameNotFoundException(username);
		}else {
			usuario = listaUsuarios.get(0);
			builder = User.withUsername(username);
			//builder.password(new BCryptPasswordEncoder().encode(usuario.getPassword()));
			builder.password(usuario.getPassword());
			String[] roles = {usuario.getRols().getDescripcion()};
			builder.roles(roles);
		}
		
		return builder.build();
	}

	@Override
	public ResponseServiceObject authenticateUser(AuthUserRequest authUserRequest) {
		// TODO Auto-generated method stub
		ResponseServiceObject responseServiceObject = null;
		ResponseServiceMessage responseServiceMessage = null;
		List<ResponseServiceMessage> messageList = null;
		List<Users> listaUsuarios = null;
		
		try {
			responseServiceObject = new ResponseServiceObject();
			responseServiceMessage = new ResponseServiceMessage();
			messageList = new ArrayList<ResponseServiceMessage>();
			
			listaUsuarios = usuariosRepository.findByEmail(authUserRequest.getEmail());
			
			if(listaUsuarios != null && listaUsuarios.size() == 1) {
				if(encoder.matches(authUserRequest.getPassword(), listaUsuarios.get(0).getPassword())) {
					String token = getJWTToken(listaUsuarios.get(0));
					responseServiceMessage.setCode(String.valueOf(HttpStatus.OK.value()));
					responseServiceMessage.setTimestamp(new Date());
					responseServiceMessage.setType(ResponseServiceMessageType.OK);
					responseServiceMessage.setMensaje("Usuario autenticado");
					messageList.add(responseServiceMessage);
					responseServiceObject.setMessageList(messageList);
					responseServiceObject.setBody(token);
				}else {
					responseServiceMessage.setCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
					responseServiceMessage.setTimestamp(new Date());
					responseServiceMessage.setType(ResponseServiceMessageType.OK);
					responseServiceMessage.setMensaje("Usuario NO autenticado: Password incorrecta");
					messageList.add(responseServiceMessage);
					responseServiceObject.setMessageList(messageList);
					responseServiceObject.setBody(null);
				}
			}else {
				responseServiceMessage.setCode(String.valueOf(HttpStatus.FORBIDDEN.value()));
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Usuario NO autenticado: Usuario no existe o esta duplicado");
				messageList.add(responseServiceMessage);
				responseServiceObject.setMessageList(messageList);
				responseServiceObject.setBody(null);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return responseServiceObject;
	}
	
	private String getJWTToken(Users usuario) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + usuario.getRols().getDescripcion());
		String token = Jwts
							.builder()
							.setId("deafiolatamJWT")
							.setSubject(usuario.getEmail())
							.claim("authorities", 
									grantedAuthorities.stream()
										.map(GrantedAuthority::getAuthority)
										.collect(Collectors.toList()))
										.setIssuedAt(new Date(System.currentTimeMillis()))
										.setExpiration(new Date(System.currentTimeMillis() + 600000))
										.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		return "Alien " + token;
	}

}
