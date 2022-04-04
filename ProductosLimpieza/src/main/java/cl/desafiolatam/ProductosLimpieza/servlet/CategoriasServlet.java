package cl.desafiolatam.ProductosLimpieza.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cl.desafiolatam.ProductosLimpieza.dto.CategoriaDto;
import cl.desafiolatam.ProductosLimpieza.facade.CategoriaFacade;
import cl.desafiolatam.ProductosLimpieza.facade.ProductoFacade;
import cl.desafiolatam.ProductosLimpieza.facade.impl.CategoriaFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.facade.impl.ProductoFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.genericUtils.Utils;
@WebServlet("/Cat.srv")
public class CategoriasServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7902396055303921072L;
	private CategoriaFacade catFacade;
	@Override
	public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
			this.catFacade = new CategoriaFacadeImpl();
			
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		req.setAttribute("listaCategorias",this.catFacade.getCategorias().toString());
		req.getServletContext().getRequestDispatcher("/tableCategoria.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPut(req, resp);

		CategoriaDto categoriaDto = new CategoriaDto();
		String json = Utils.getJsonString(req.getInputStream());
		String dataSplit[] = json.split("&");		
		String accion = dataSplit[dataSplit.length  - 1].split("=")[1];
		PrintWriter out = resp.getWriter();
		
		if (accion.equalsIgnoreCase("actualizarCategoria")) {
			categoriaDto.updateCategoriaFromJson(json);
			categoriaDto = this.catFacade.updateCategoria(categoriaDto);
		}else if(accion.equalsIgnoreCase("eliminarCategoria")) {
			categoriaDto.updateCategoriaFromJson(json);
			categoriaDto = this.catFacade.deleteCategoria(categoriaDto.getCategoria().get(0).getId_categoria());
		} else if(accion.equalsIgnoreCase("crearCategoria")){
			categoriaDto.categoriaFromJson(json);
			categoriaDto = this.catFacade.createCategoria(categoriaDto);
		}
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(categoriaDto.toString());
        out.flush();
		
		//req.getServletContext().getRequestDispatcher("/mantenedoralumnos.jsp").forward(req, resp);
	}
	
	
	
}
