package cl.desafiolatam.ProductosLimpieza.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cl.desafiolatam.ProductosLimpieza.dao.model.Alumno;
import cl.desafiolatam.ProductosLimpieza.dto.AlumnoDto;
import cl.desafiolatam.ProductosLimpieza.facade.AlumnoFacade;
import cl.desafiolatam.ProductosLimpieza.facade.CursoFacade;
import cl.desafiolatam.ProductosLimpieza.facade.impl.AlumnoFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.facade.impl.CursoFacadeImpl;


public class MantenedorAlumnosServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlumnoFacade alumnoFacade = null;
	private CursoFacade cursoFacade = null;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.alumnoFacade = new AlumnoFacadeImpl();
		this.cursoFacade = new CursoFacadeImpl();
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		//String pattern = "dd-MM-yyyy";
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		req.setAttribute("alumnoDtoJson", this.alumnoFacade.getAlumnos().toString());
		req.setAttribute("cursoDto", this.cursoFacade.getCursos());
		req.getServletContext().getRequestDispatcher("/mantenedoralumnos.jsp").forward(req, resp);
	}



	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPut(req, resp);
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
		req.setAttribute("mensaje", "EXITOOOO!");
		System.out.println("Nombre: " + json);
		req.getServletContext().getRequestDispatcher("/mantenedoralumnos.jsp").forward(req, resp);
	}
	
	
	
	
	
}
