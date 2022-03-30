package cl.desafiolatam.ProductosLimpieza.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.desafiolatam.ProductosLimpieza.dao.CategoriaDao;
import cl.desafiolatam.ProductosLimpieza.dao.ProductoDao;
import cl.desafiolatam.ProductosLimpieza.dao.impl.CategoriaDaoImpl;
import cl.desafiolatam.ProductosLimpieza.dao.impl.ProductoDaoImpl;
import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;
import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;
import cl.desafiolatam.ProductosLimpieza.dto.CategoriaDto;
import cl.desafiolatam.ProductosLimpieza.dto.ProductoDto;
import cl.desafiolatam.ProductosLimpieza.facade.CategoriaFacade;
import cl.desafiolatam.ProductosLimpieza.facade.ProductoFacade;
import cl.desafiolatam.ProductosLimpieza.facade.impl.CategoriaFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.facade.impl.ProductoFacadeImpl;



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
