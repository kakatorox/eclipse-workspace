package cl.desafiolatam.ProductosLimpieza.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.desafiolatam.ProductosLimpieza.dao.model.Users;
import cl.desafiolatam.ProductosLimpieza.dto.UsuarioDTO;
import cl.desafiolatam.ProductosLimpieza.facade.UsuariosFacade;
import cl.desafiolatam.ProductosLimpieza.facade.impl.UsuariosFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.service.UsuarioService;
import cl.desafiolatam.ProductosLimpieza.service.impl.UsuarioServiceImpl;



public class Login extends ServicioLogin{

	/**
	 * 
	 */
	private static final long serialVersionUID = 549875162514592464L;
	private UsuariosFacade usuarioFacade;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.usuarioFacade = new UsuariosFacadeImpl() ;
	}

	

	@Override
	protected void logIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(10);
		
		if (session.isNew()) {
			this.servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
		}else {
			if(session.getAttribute("logeado") != null && (Boolean) session.getAttribute("logeado")) {
				this.servletContext.getRequestDispatcher("/index.jsp").forward(req, resp);
			}else {
				this.servletContext.getRequestDispatcher("/srvLogin").forward(req, resp);
			}
			
			
		}
	}
	
	@Override
	protected void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("/ProductosLimpieza/srvLogin");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}



	@Override
	protected void existeUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String usuarioComparar = "";
		String passwordComparar= "";
		UsuarioDTO usuarioDto = new UsuarioDTO();
		usuarioDto.setConectado(false);
		
		
		Cookie cookie = null;
		if (!session.isNew()) {
			usuarioComparar = req.getParameter("UserName");
			passwordComparar = req.getParameter("Password");
			
			
			for (Users usuario : usuarioFacade.getUsers()) {
				
				if (usuario.getNombre().contentEquals(usuarioComparar) && usuario.getPassword().contentEquals(passwordComparar)) {
					cookie = new Cookie(usuarioComparar,passwordComparar);
					cookie.setMaxAge(10);
					resp.addCookie(cookie);
					usuarioDto.setConectado(true);
				}
			}
			
			if (usuarioDto.isConectado()) {
				Cookie ck[]=req.getCookies(); 
				for(int i=0;i<ck.length;i++){  
					System.out.println("Hello22 "+ck[i].getName().toString()); 
					}  
				
				req.setAttribute("nombreUsuario", ck[0].getName());
				session.setAttribute("usuarioConectado", usuarioComparar);
				session.setAttribute("logeado", true);
				this.servletContext.getRequestDispatcher("/index.jsp").forward(req, resp);
			
			}else if(!usuarioDto.isConectado()) {
				req.setAttribute("mensajeLoginIncorrecto", "Error");
				this.servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		}
	}

}
