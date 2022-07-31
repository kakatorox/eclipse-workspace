package cl.desafiolatam.trazap.app.ui.front.controller.admin;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitAdminController {
	
	@GetMapping("/admin")
	public String init(ModelMap modelMap, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String[] authorities = auth.getAuthorities()
		Object details = auth.getDetails();
		Object credentials = auth.getCredentials();
		Iterator<GrantedAuthority> itCredentials = (Iterator<GrantedAuthority>) auth.getAuthorities().iterator();
		Object principal = auth.getPrincipal();
		String name = auth.getName();
		return "/admin/init";
	}
	
	@GetMapping("/admin/CategoriaProducto")
	public String categoriaProducto(ModelMap modelMap, HttpSession session) {
		
		return "/admin/CategoriaProducto";
	}
	
	@GetMapping("/admin/Proveedores")
	public String proveedores(ModelMap modelMap, HttpSession session) {
		
		return "/admin/Proveedores";
	}
	
	@GetMapping("/admin/EstadoTrazabilidad")
	public String estadoTrazabilidad(ModelMap modelMap, HttpSession session) {
		
		return "/admin/EstadoTrazabilidad";
	}
	
	@GetMapping("/admin/TipoProducto")
	public String tipoProducto(ModelMap modelMap, HttpSession session) {
		
		return "/admin/TipoProducto";
	}
	
	@GetMapping("/admin/Bodega")
	public String bodega(ModelMap modelMap, HttpSession session) {
		
		return "/admin/Bodega";
	}
	
	@GetMapping("/admin/Usuarios")
	public String usuarios(ModelMap modelMap, HttpSession session) {
		
		return "/admin/Usuarios";
	}
}
