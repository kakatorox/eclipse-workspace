package com.desafiolatam.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletService extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		//super.doGet(req, resp);
		switch (this.srvName) {
		case "srvPreIns":
			this.PreIns(req, resp);
			break;
		case "srvPosIns":
			this.srvPosIns(req, resp);
			break;
		case "srvPreCon":
			this.PreCon(req, resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		switch (this.srvName) {
		case "srvPreIns":
			this.PreIns(req, resp);
			break;
		case "srvPosIns":
			this.srvPosIns(req, resp);
			break;
		case "srvPreCon":
			this.PreCon(req, resp);
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
	
	protected abstract void PreIns(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	protected abstract void srvPosIns(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	protected abstract void PreCon(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
}
