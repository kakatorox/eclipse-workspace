package cl.desafiolatam.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.desafiolatam.model.Persona;

@WebServlet("/inicio.srv")
public class IndexSrvlt extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7922838228937010267L;
	
	@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
			System.out.println("ingreso els ervlet");
			
		
		}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//1.- se debe crear el js antes de hacer esta linea
		
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		
		List<Persona>listaPersona = new ArrayList<Persona>();
		
		p1.setRut("11111-11");
		p1.setNombre("Ignacio");
		p1.setApellido("Silva");
		p1.setFechaNac("10-06-1997");
		
		p2.setRut("122211-11");
		p2.setNombre("Patricia");
		p2.setApellido("Moya");
		p2.setFechaNac("10-06-1987");
		
		listaPersona.add(p1);
		listaPersona.add(p2);
		
		System.out.println("ingreso al doget");
		req.setAttribute("titulo", "Prueba Lista de Personas!!");
		req.setAttribute("listaPersona",listaPersona);
		req.getServletContext().getRequestDispatcher("/Index2.jsp").forward(req, resp);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	
	
	
}
