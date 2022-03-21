package cl.desafiolatam.srvmvn;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.desafiolatam.model.Item;
import cl.desafiolatam.model.Persona;

//@WebServlet("/indexGenFac")
public class IngresoValores extends HttpServlet{

	/*
	 * 
	 */
	private static final long serialVersionUID = 3723716014571741556L;
	
	@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getServletContext().getRequestDispatcher("/ingresoValores.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DecimalFormat formatea = new DecimalFormat("###,###.##");
		Persona p = new Persona(req.getParameter("idNombreCompleto"),
								req.getParameter("idEmpresa"),
								req.getParameter("idRut"),
								req.getParameter("idDireccion"),
								req.getParameter("idCiudad"),
								req.getParameter("idPais"));
		Item item1 = new Item(Integer.parseInt(req.getParameter("idCant1" )),120000);
		Item item2 = new Item(Integer.parseInt(req.getParameter("idCant2" )),1700000);
		Item item3 = new Item(Integer.parseInt(req.getParameter("idCant3" )),760000);
		Item item4 = new Item(Integer.parseInt(req.getParameter("idCant4" )),2300000);
		Item item5 = new Item(Integer.parseInt(req.getParameter("idCant5" )),10000);
		int valorNeto = item1.valortotal + item2.valortotal + item3.valortotal + item4.valortotal + item5.valortotal;
		int descuento = 10;
		int valorTotalItems= valorNeto-(valorNeto/descuento);
		req.setAttribute("idPersona",p);
		req.setAttribute("idValorTotal1",formatea.format(item1.valortotal));
		req.setAttribute("idValorTotal2",formatea.format(item2.valortotal));
		req.setAttribute("idValorTotal3",formatea.format(item3.valortotal));
		req.setAttribute("idValorTotal4",formatea.format(item4.valortotal));
		req.setAttribute("idValorTotal5",formatea.format(item5.valortotal));
		req.setAttribute("idValorNeto",formatea.format(valorNeto));
		req.setAttribute("idDescuento",formatea.format(descuento));
		req.setAttribute("idValorTotalItems",formatea.format(valorTotalItems));
		req.getServletContext().getRequestDispatcher("/Factura.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	

	
}
