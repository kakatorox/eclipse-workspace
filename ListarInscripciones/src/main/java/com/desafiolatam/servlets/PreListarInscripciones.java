package com.desafiolatam.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.entidades.InscripcionDTO;
import com.desafiolatam.facade.Facade;
import com.desafiolatam.facade.impl.FacadeImpl;

public class PreListarInscripciones extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2480868703503466327L;
	private Facade facade;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		facade = new FacadeImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		facade = new FacadeImpl();
	      List<InscripcionDTO> listaIncripciones = null;
			try {
				listaIncripciones = facade.obtieneInscripciones();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	       // el resultado lo adjunto como atributo en el request
	     
		req.setAttribute("inscripciones",listaIncripciones);
		
		req.getRequestDispatcher("/ListaInscripciones.jsp").forward(req, resp);
		
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	
}
