package cl.desafiolatam.ProductosLimpieza.facade.impl;

import cl.desafiolatam.ProductosLimpieza.dto.CursoDto;
import cl.desafiolatam.ProductosLimpieza.facade.CursoFacade;
import cl.desafiolatam.ProductosLimpieza.service.CursoService;
import cl.desafiolatam.ProductosLimpieza.service.impl.CursoServiceImpl;

public class CursoFacadeImpl implements CursoFacade{
	CursoService cursoService = null;
	
	
	
	public CursoFacadeImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.cursoService = new CursoServiceImpl();
	}



	@Override
	public CursoDto getCursos() {
		// TODO Auto-generated method stub
		return this.cursoService.getCursos();
	}

}
