package com.desafiolatam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosInscripcion extends HttpServlet 
{
   /**
	 * 
	 */
	private static final long serialVersionUID = -1557782014765652237L;

	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}



	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
   {
      // obtengo los datos del formulario
      String nombre = request.getParameter("nombre");
      String celular = request.getParameter("celular");
      int idCurso = Integer.parseInt(request.getParameter("idCurso"));
      int idFormaDePago = Integer.parseInt(request.getParameter("idFormaPago"));
       
      request.setAttribute("nombre", nombre);
      request.setAttribute("celular", celular);
      request.setAttribute("idCurso", idCurso);
      request.setAttribute("idFormaDePago", idFormaDePago);
       // redirecciono el control hacia la siguiente vista,
       // es decir: hacia su servlet de pre-confirmacion
      request.getRequestDispatcher("/confirmacion.jsp").forward(request, response);
   }
}
