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
import cl.desafiolatam.ProductosLimpieza.dto.ProductoDto;
import cl.desafiolatam.ProductosLimpieza.facade.CategoriaFacade;
import cl.desafiolatam.ProductosLimpieza.facade.ProductoFacade;
import cl.desafiolatam.ProductosLimpieza.facade.impl.CategoriaFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.facade.impl.ProductoFacadeImpl;
import cl.desafiolatam.ProductosLimpieza.genericUtils.Utils;
@WebServlet("/Prod.srv")
public class ProductosServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7902396055303921072L;
	private ProductoFacade prodFacade;
	private CategoriaFacade catFacade;
	@Override
	public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
			this.prodFacade = new ProductoFacadeImpl();
			this.catFacade = new CategoriaFacadeImpl();
			
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		 CategoriaDto var = this.catFacade.getCategorias();
		req.setAttribute("listaProductos",this.prodFacade.getProductos().toString());
		req.setAttribute("categoriaDtos",(CategoriaDto)this.catFacade.getCategorias());
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
		ProductoDto productoDto = new ProductoDto();
		String json = Utils.getJsonString(req.getInputStream());
		String dataSplit[] = json.split("&");		
		String accion = dataSplit[dataSplit.length  - 1].split("=")[1];
		PrintWriter out = resp.getWriter();
		
		if (accion.equalsIgnoreCase("actualizarProducto")) {
			productoDto.updateProductoFromJson(json);
			productoDto = this.prodFacade.updateProducto(productoDto);
		}else if(accion.equalsIgnoreCase("eliminarProducto")) {
			productoDto.updateProductoFromJson(json);
			productoDto = this.prodFacade.deleteProducto(productoDto.getProductos().get(0).getIdProducto());
		}else if(accion.equalsIgnoreCase("crearProducto")){
			productoDto.productoFromJson(json);
			productoDto = this.prodFacade.createProducto(productoDto);
		}
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(productoDto.toString());
        out.flush();
		//req.getServletContext().getRequestDispatcher("/mantenedoralumnos.jsp").forward(req, resp);
	}
	
	
	
	
}
