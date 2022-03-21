package cl.desafiolatam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PCook.per")
public class PruebaCookie extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9204840385843706287L;
	@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 Cookie cookie = new Cookie("userFelipe","viernes2019");
		 cookie.setMaxAge(9000);
		 cookie.setComment("Cookie guardada con propositos pruyeba 2");
		 resp.addCookie(cookie);

		 PrintWriter print = resp.getWriter();
		 print.println("<html><body>");
		 print.println("<h2><i>Cookie guardada correctamente:</i></h2><br>");
		 print.println("Valor de la cookie: <strong>"+
		cookie.getValue() + "</strong>");
		 print.println("<br>");
		 print.println("Tiempo de la duración de la cookie:	<strong>" + cookie.getMaxAge()+"</strong>");
		 print.println("<br>");
		 print.println("Comentario: <strong>" +
		cookie.getComment() + "</strong>");
		 print.println("</body></html>");
		 
		 
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	

}
