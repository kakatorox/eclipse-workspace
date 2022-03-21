package cl.desafiolatam.srvmvn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.desafiolatam.dao.ConsultasBDDao;
import cl.desafiolatam.dao.impl.ConsultasBDDaoImpl;
import cl.desafiolatam.model.Users;
import cl.desafiolatam.service.UsuarioService;
import cl.desafiolatam.service.impl.UsuarioServiceImpl;

public class Login extends ServicioLogin{

	/**
	 * 
	 */
	private static final long serialVersionUID = 549875162514592464L;
    protected String username = "ale";
    protected String password = "1234";

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	

	@Override
	protected void logIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(10);
		String idioma = "";
		
		if (session.isNew()) {
			req.setAttribute(idioma, req.getLocale().toString());
			System.out.println(req.getAttribute(idioma));
			this.servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
		}else {
			if(session.getAttribute("logeado") != null && (Boolean) session.getAttribute("logeado")) {
				this.servletContext.getRequestDispatcher("/ingresoValores.jsp").forward(req, resp);
			}else {
				req.setAttribute(idioma, req.getParameter("idiomaSeleccionado"));
				System.out.println(req.getAttribute(idioma));
				this.servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			
			
		}
	}

	

	@Override
	protected void ingresarDatos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String usuarioComparar = "";
		String passwordComparar= "";
		UsuarioService usuariosSistema = new UsuarioServiceImpl();;
		
		if (!session.isNew()) {
			usuarioComparar = req.getParameter("UserName");
			passwordComparar = req.getParameter("Password");
			usuariosSistema.getUsers();
			boolean existe = false;
			for (Users usuario : usuariosSistema.getUsers()) {
				
				if (usuario.getNombre().contentEquals(usuarioComparar) && usuario.getPassword().contentEquals(passwordComparar)) {
					
					existe = true;
				}
			}
			
			if (existe) {
				
				session.setAttribute("usuarioConectado", usuarioComparar);
				session.setAttribute("logeado", true);
				this.servletContext.getRequestDispatcher("/ingresoValores.jsp").forward(req, resp);
			
			}else {
				req.setAttribute("mensajeLoginIncorrecto", "Error");
				this.servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		}
		
	}
	
	@Override
	protected void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("/GeneradorFactura/login.jsp");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
