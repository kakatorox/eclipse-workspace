package cl.desafiolatam.administracionbodega.conf;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAutentificationSuccessHandler implements AuthenticationSuccessHandler{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		 
		 if (roles.contains("ROLE_BODEGA")) {
			response.sendRedirect("/material");
		}
	}
}
