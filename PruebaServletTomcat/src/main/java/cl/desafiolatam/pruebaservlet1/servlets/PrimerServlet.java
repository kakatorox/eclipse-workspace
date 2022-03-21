package cl.desafiolatam.pruebaservlet1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/primerSrv")
public class PrimerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1233867309292238582L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Init servlet primerSrv OK");
		
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//resp.setContentType("text/html");
		//PrintWriter out = resp.getWriter();
		//out.println("<h1>HolaMundo desde Servlet" + req.getParameter("nombre") + "</h1>");
		System.out.println("Parametro Nombre: " + req.getParameter("inputName"));
		req.setAttribute("genero","M");
		req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//resp.setContentType("text/html");
		//PrintWriter out = resp.getWriter();
		//out.println("<h1>HolaMundo desde Servlet" + req.getParameter("nombre") + "</h1>");
		System.out.println("Parametro Nombre Post: " + req.getParameter("inputName"));
		req.setAttribute("genero","M");
		req.getServletContext().getRequestDispatcher("/prueba1.jsp").forward(req, resp);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	
	
	
}
