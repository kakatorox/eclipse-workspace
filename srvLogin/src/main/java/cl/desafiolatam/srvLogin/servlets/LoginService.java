package cl.desafiolatam.srvLogin.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class LoginService extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 112946180761262166L;
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
		case "srvPrincipal":
			this.inicio(req, resp);		
					break;
		case "srvLogOut":
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
		case "srvPrincipal":
			this.inicio(req, resp);		
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
	
	protected abstract void inicio(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	protected abstract void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
