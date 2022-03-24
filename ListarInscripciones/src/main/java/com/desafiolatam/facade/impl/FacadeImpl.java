package com.desafiolatam.facade.impl;

import java.sql.SQLException;
import java.util.List;

import com.desafiolatam.entidades.CursoDTO;
import com.desafiolatam.entidades.FormaDePagoDTO;
import com.desafiolatam.entidades.InscripcionDTO;
import com.desafiolatam.facade.Facade;
import com.desafiolatam.service.DatosService;
import com.desafiolatam.service.impl.DatosServiceImpl;

public class FacadeImpl implements Facade {
	
	private DatosService datosService;
	
	
	
	public FacadeImpl() {
		super();
		datosService = new DatosServiceImpl();
	}
	@Override
	public int registrarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
		return datosService.registrarInscripcion(dto);
	}
	
	@Override
	public List<CursoDTO> obtenerCursos() throws SQLException, ClassNotFoundException{
		return datosService.obtenerCursos();
	}

	@Override
	public List<FormaDePagoDTO> obtenerFormasDePago() throws SQLException, ClassNotFoundException {
		return datosService.obtenerFormasDePago();
	}
	@Override
	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {
		return datosService.obtieneInscripciones();
	}
}

