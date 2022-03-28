package cl.desafiolatam.ProductosLimpieza.service.impl;

import cl.desafiolatam.ProductosLimpieza.dao.CursoDao;
import cl.desafiolatam.ProductosLimpieza.dao.impl.CursoDaoImpl;
import cl.desafiolatam.ProductosLimpieza.dto.CursoDto;
import cl.desafiolatam.ProductosLimpieza.service.CursoService;

public class CursoServiceImpl implements CursoService{
	private CursoDao cursoDao = null;
	
	

	public CursoServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.cursoDao = new CursoDaoImpl();
	}



	@Override
	public CursoDto getCursos() {
		// TODO Auto-generated method stub
		CursoDto cursoDto = new CursoDto();
		cursoDto.setCursos(this.cursoDao.getAll());
		return cursoDto;
	}

}
