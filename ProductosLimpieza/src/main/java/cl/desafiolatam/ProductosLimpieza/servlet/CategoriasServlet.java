package cl.desafiolatam.ProductosLimpieza.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cl.desafiolatam.ProductosLimpieza.facade.CategoriaFacade;
import cl.desafiolatam.ProductosLimpieza.facade.ProductoFacade;
import cl.desafiolatam.ProductosLimpieza.facade.impl.CategoriaFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.facade.impl.ProductoFacadeImpl;
@WebServlet("/Cat.srv")
public class CategoriasServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7902396055303921072L;
	private CategoriaFacade catFacade;
	@Override
	public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
			this.catFacade = new CategoriaFacadeImpl();
			
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		req.setAttribute("listaCategorias",this.catFacade.getCategorias().toString());
		req.getServletContext().getRequestDispatcher("/tableCategoria.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
	
	
}
