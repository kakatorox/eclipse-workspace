package com.desafiolatam.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.entidades.InscripcionDTO;
import com.desafiolatam.facade.impl.FacadeImpl;

public class PreConfirmacion extends HttpServlet
{
   /**
	 * 
	 */
	private static final long serialVersionUID = -4755211552146954511L;
	private FacadeImpl facade;
		
		
		@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		facade = new FacadeImpl();
	}
		
	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException,IOException
   {
		
		// obtengo los datos del formulario
	      String nombre = request.getParameter("nombre");
	      String celular = request.getParameter("celular");
	      int idCurso = Integer.parseInt(request.getParameter("idCurso"));
	      int idFormaDePago = Integer.parseInt(request.getParameter("idFormaDePago"));
	       // instancio el DTO y le asigno los datos
	      InscripcionDTO dto = new InscripcionDTO();
	      dto.setNombre(nombre);
	      dto.setCelular(celular);
	      dto.setIdCurso(idCurso);
	      dto.setIdFormaDePago(idFormaDePago);
	      // invoco al facade para procesar la inscripcion
	      int idInsc = 0;
			try {
					idInsc = facade.registrarInscripcion(dto);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	       // el resultado lo adjunto como atributo en el request
	      request.setAttribute("idInsc", idInsc);
	     
		request.getRequestDispatcher("/PreListarInscripciones").forward(request, response);
   }
}
