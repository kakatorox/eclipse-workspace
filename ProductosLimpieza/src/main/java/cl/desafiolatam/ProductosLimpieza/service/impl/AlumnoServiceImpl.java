package cl.desafiolatam.ProductosLimpieza.service.impl;

import cl.desafiolatam.ProductosLimpieza.dao.AlumnoDao;
import cl.desafiolatam.ProductosLimpieza.dao.impl.AlumnoDaoImpl;
import cl.desafiolatam.ProductosLimpieza.dto.AlumnoDto;
import cl.desafiolatam.ProductosLimpieza.service.AlumnoService;

public class AlumnoServiceImpl implements AlumnoService{
	private AlumnoDao alumnoDao = null;
	
	
	
	public AlumnoServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.alumnoDao = new AlumnoDaoImpl();
	}



	@Override
	public AlumnoDto getAlumnos() {
		// TODO Auto-generated method stub
		AlumnoDto alumnoDto = new AlumnoDto();
		alumnoDto.setAlumnos(this.alumnoDao.getAll());
		return alumnoDto;
	}

}
