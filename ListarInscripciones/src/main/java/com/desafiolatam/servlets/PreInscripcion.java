package com.desafiolatam.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.entidades.CursoDTO;
import com.desafiolatam.entidades.FormaDePagoDTO;
import com.desafiolatam.facade.Facade;


public class PreInscripcion extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8943487508675173140L;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//obtenemos el facade
		Facade facade = new Facade();
		try {
			//obtenemos las listas
			List<CursoDTO> listaCursos = null;
			try {
				listaCursos = facade.obtenerCursos();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			List<FormaDePagoDTO> listaFormasPago = null;
			try {
				listaFormasPago = facade.obtenerFormasDePago();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			//guardo las listas al request
			request.setAttribute("cursos", listaCursos);
			request.setAttribute("formasPago", listaFormasPago);
			
			//mandamos el request a la pagina jsp
			request.getServletContext().getRequestDispatcher("/inscripcion.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}


	
}
