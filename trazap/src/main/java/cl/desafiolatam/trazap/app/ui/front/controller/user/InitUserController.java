package cl.desafiolatam.trazap.app.ui.front.controller.user;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitUserController {

	@GetMapping("/user")
	public String init(ModelMap modelMap, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String[] authorities = auth.getAuthorities()
		Object details = auth.getDetails();
		Object credentials = auth.getCredentials();
		Iterator<GrantedAuthority> itCredentials = (Iterator<GrantedAuthority>) auth.getAuthorities().iterator();
		Object principal = auth.getPrincipal();
		String name = auth.getName();
		return "/user/init";
	}
	
	@GetMapping("/user/CategoriaProducto")
	public String categoriaProducto(ModelMap modelMap, HttpSession session) {
		
		return "/user/CategoriaProducto";
	}
	
	@GetMapping("/user/Proveedores")
	public String proveedores(ModelMap modelMap, HttpSession session) {
		
		return "/user/Proveedores";
	}
	
	@GetMapping("/user/EstadoTrazabilidad")
	public String estadoTrazabilidad(ModelMap modelMap, HttpSession session) {
		
		return "/user/EstadoTrazabilidad";
	}
	
	@GetMapping("/user/TipoProducto")
	public String tipoProducto(ModelMap modelMap, HttpSession session) {
		
		return "/user/TipoProducto";
	}
	
	@GetMapping("/user/Bodega")
	public String bodega(ModelMap modelMap, HttpSession session) {
		
		return "/user/Bodega";
	}
	
}
