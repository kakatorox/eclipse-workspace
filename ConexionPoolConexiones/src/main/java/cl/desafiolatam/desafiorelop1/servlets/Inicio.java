package cl.desafiolatam.desafiorelop1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.desafiolatam.desafiorelop1.dto.UsuarioDto;
import cl.desafiolatam.desafiorelop1.facade.UsuarioFacade;
import cl.desafiolatam.desafiorelop1.facade.impl.UsuarioFacadeImpl;

public class Inicio extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4682323159439240452L;

	private UsuarioFacade usuarioFacade;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		usuarioFacade = new UsuarioFacadeImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<UsuarioDto> listaUsuario = usuarioFacade.getUsuariodesdeService();
					
		req.setAttribute("Nombres", listaUsuario);
		
		req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	
	
	
}
