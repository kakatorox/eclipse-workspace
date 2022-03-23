package cl.desafiolatam.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import cl.desafiolatam.facade.SaludoFacade;
import cl.desafiolatam.facade.impl.SaludoFacadeImpl;

public class Index extends HttpServlet{

	private SaludoFacade saludoFacade; 
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		saludoFacade = new SaludoFacadeImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("mensajes", saludoFacade.traerSaludo()); 
		req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}



}
