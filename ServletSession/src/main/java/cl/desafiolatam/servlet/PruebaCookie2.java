package cl.desafiolatam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PCook2")
public class PruebaCookie2 extends HttpServlet{

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
		Cookie cookies [] = req.getCookies();
		Cookie cookie = null;
		for (int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];
			if(cookie.getName().equals("userjorge")) {
				break;
			}
			cookie.setMaxAge(9000);
			cookie.setComment("Cookie guardada con propositos educativos");
			resp.addCookie(cookie);

		}

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
