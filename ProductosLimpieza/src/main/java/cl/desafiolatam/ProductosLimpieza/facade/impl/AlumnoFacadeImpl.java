package cl.desafiolatam.ProductosLimpieza.facade.impl;

import cl.desafiolatam.ProductosLimpieza.dto.AlumnoDto;
import cl.desafiolatam.ProductosLimpieza.facade.AlumnoFacade;
import cl.desafiolatam.ProductosLimpieza.service.AlumnoService;
import cl.desafiolatam.ProductosLimpieza.service.impl.AlumnoServiceImpl;

public class AlumnoFacadeImpl implements AlumnoFacade{
	private AlumnoService alumnoService = null;
	public AlumnoFacadeImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.alumnoService = new AlumnoServiceImpl();
	}

	@Override
	public AlumnoDto getAlumnos() {
		// TODO Auto-generated method stub
		return this.alumnoService.getAlumnos();
	}

}
