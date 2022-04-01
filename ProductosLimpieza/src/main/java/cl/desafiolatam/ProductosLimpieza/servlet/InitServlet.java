package cl.desafiolatam.ProductosLimpieza.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.desafiolatam.ProductosLimpieza.facade.CategoriaFacade;
import cl.desafiolatam.ProductosLimpieza.facade.ProductoFacade;
import cl.desafiolatam.ProductosLimpieza.facade.impl.CategoriaFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.facade.impl.ProductoFacadeImpl;


@WebServlet("/Index.srv")
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoriaFacade catFacade;
	private ProductoFacade prodFacade;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.catFacade = new CategoriaFacadeImpl();
		this.prodFacade =  new ProductoFacadeImpl();
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
}
