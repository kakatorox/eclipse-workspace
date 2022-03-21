package cl.desafiolatam.srvLogin.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletInit extends LoginService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5638551096570643904L;
	
	@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
		}
	protected void logIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		if(session.isNew()) {
			session.setMaxInactiveInterval(5);
			this.servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
		}else {
			if(session.getAttribute("loged") != null && (Boolean) session.getAttribute("loged")) {
				this.servletContext.getRequestDispatcher("/principal.jsp").forward(req, resp);
			}
			else {
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Ha cerrado sesion correctamente');");
				out.println("</script>");
				session.invalidate();
				req.setAttribute("mensajeLoginIncorrecto", "Error en las Credenciales");
				this.servletContext.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			}	
		}
	}
	
	protected void inicio(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String user = "mermelada";
		String pass = "1234";
		String usuarioConectado = "Charmander";
		String usuarioRecibido = "";
		String passwordRecibido = "";
		
		HttpSession session = req.getSession();
		
		if (!session.isNew()) {
			
			usuarioRecibido = req.getParameter("UserName");
			passwordRecibido = req.getParameter("Password");
			
			if (user.contentEquals(usuarioRecibido) && pass.contentEquals(passwordRecibido)) {
				
				session.setAttribute("usuarioConectado", usuarioConectado);
				session.setAttribute("loged", true);
				this.servletContext.getRequestDispatcher("/principal.jsp").forward(req, resp);
			
			}else {
				System.out.println("se fue al login");
				this.servletContext.getRequestDispatcher("/srvLogin.srv").forward(req, resp);
			}
		}else {
			resp.sendRedirect("/srvLogin/login.srv");
		}	
	}
	
	protected void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("/srvLogin/login.jsp");
		
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		HttpSession misesion = req.getSession();
//		String srvName = getServletConfig().getServletName();
//		if("srvLogin".equals(srvName)) {
//			resp.sendRedirect("/srvLogin/login.jsp");
//			//req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
//		}else if("srvPrincipal".equals(srvName)) {
//			if (!misesion.isNew()) {
//				//req.getServletContext().getRequestDispatcher("/principal.jsp").forward(req, resp);
//				req.getServletContext().getRequestDispatcher("/principal.jsp").forward(req, resp);
//			}else {
//				//req.getServletContext().getRequestDispatcher("/srvLogin.srv").forward(req, resp);
//				resp.sendRedirect("/srvLogin/login.jsp");
//			}	
//		}
//		
//		
//		
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		HttpSession misesion = req.getSession();
//		String user = "mermelada";
//		String pass = "pan";
//		if(user.contentEquals(req.getParameter("UserName")) || pass.contentEquals(req.getParameter("Password"))){
//			
//			//Se crea variable de sesion y se recibe desde el request
//			System.out.println("Ingrese al Principal");
//				req.setAttribute("UsuarioName", req.getParameter("UserName"));
//				req.getServletContext().getRequestDispatcher("/principal.jsp").forward(req, resp);
//			
//			}else {
//				
//				PrintWriter out = resp.getWriter();
//			
//				out.println("<script type=\"text/javascript\">");
//			out.println("alert('Ha cerrado sesion correctamente');");
//			out.println("</script>");
//			req.getServletContext().getRequestDispatcher("/srvLogin.srv/login.jsp").forward(req, resp);
//			
//			
//			//resp.sendRedirect("/srvLogin/login.jsp");
//		
//			}
//		
//		
//		
//			
//		//misesion.invalidate();
//		//resp.sendRedirect("index.jsp");
//		
//	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	
	
}
