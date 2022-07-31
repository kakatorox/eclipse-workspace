package cl.desafiolatam.trazap.conf;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAthenticationSuccessHandler implements AuthenticationSuccessHandler{
	@Autowired
	private HttpSession session;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Set<String> roles =  AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		if(roles.contains("ROLE_ADMIN")) {
			//session.setAttribute(null, roles);
			response.setHeader("Autorization", "ROLS");
			response.sendRedirect("/trazap/admin");
		}else if(roles.contains("ROLE_USER")){
			response.setHeader("Autorization", "ROLS");
			response.sendRedirect("/trazap/user");
		}else if(roles.contains("ROLE_PROVEEDOR")){
			response.setHeader("Autorization", "ROLS");
			response.sendRedirect("/trazap/proveedor");
		}
		
	}

}
