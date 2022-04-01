package cl.desafiolatam.ProductosLimpieza.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cl.desafiolatam.ProductosLimpieza.facade.CategoriaFacade;
import cl.desafiolatam.ProductosLimpieza.facade.ProductoFacade;
import cl.desafiolatam.ProductosLimpieza.facade.impl.CategoriaFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.facade.impl.ProductoFacadeImpl;
@WebServlet("/Prod.srv")
public class ProductosServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7902396055303921072L;
	private ProductoFacade prodFacade;
	@Override
	public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
			this.prodFacade = new ProductoFacadeImpl();
			
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		req.setAttribute("listaProductos",this.prodFacade.getProductos().toString());
		req.getServletContext().getRequestDispatcher("/tableProducto.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		//super.doPut(req, resp);
//		AlumnoDto alumnoDto = new AlumnoDto();
//		String json = Utils.getJsonString(req.getInputStream());
//		String dataSplit[] = json.split("&");
//		String accion = dataSplit[5].split("=")[1];
//		PrintWriter out = resp.getWriter();
//		
//		if (accion.equalsIgnoreCase("actualizarAlumno")) {
//			alumnoDto.alumnoFromJson(json);
//			alumnoDto = this.alumnoFacade.updateAlumno(alumnoDto);
//		}else if(accion.equalsIgnoreCase("eliminarAlumno")) {
//			alumnoDto.alumnoFromJson(json);
//			alumnoDto = this.alumnoFacade.deleteAlumno(alumnoDto);
//		} else if(accion.equalsIgnoreCase("crearAlumno")){
//			alumnoDto.alumnoFromJson(json);
//			alumnoDto = this.alumnoFacade.addAlumno(alumnoDto); 
//		}
//		resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        out.print(alumnoDto.toString());
//        out.flush();
//		
		//req.getServletContext().getRequestDispatcher("/mantenedoralumnos.jsp").forward(req, resp);
	}
	
	
	
	
}
