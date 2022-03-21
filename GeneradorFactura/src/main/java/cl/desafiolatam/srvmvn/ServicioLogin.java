package cl.desafiolatam.srvmvn;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServicioLogin extends HttpServlet{

	/*
	 * 
	 */
	private static final long serialVersionUID = -2348782679196104587L;
	
	private String srvName;
	protected ServletContext servletContext;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.srvName = getServletConfig().getServletName();
		this.servletContext = getServletConfig().getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch (this.srvName) {
		case "srvLogin":
			this.logIn(req, resp);
			break;
		case "srvIntentoLogeo":
			this.ingresarDatos(req, resp);		
			break;
		case "srvLogout":
			this.logOut(req, resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch (this.srvName) {
		case "srvLogin":
			this.logIn(req, resp);
			break;
		case "srvIntentoLogeo":
			this.ingresarDatos(req, resp);		
			break;			
		default:
			break;
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	protected abstract void logIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	protected abstract void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	protected abstract void ingresarDatos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	
}
