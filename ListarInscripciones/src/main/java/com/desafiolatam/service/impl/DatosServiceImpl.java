package com.desafiolatam.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.desafiolatam.daos.CursoDao;
import com.desafiolatam.daos.FormaDePagoDAO;
import com.desafiolatam.daos.InscripcionDAO;
import com.desafiolatam.entidades.CursoDTO;
import com.desafiolatam.entidades.FormaDePagoDTO;
import com.desafiolatam.entidades.InscripcionDTO;
import com.desafiolatam.service.DatosService;

public class DatosServiceImpl implements DatosService{
	
	@Override
	public int registrarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
		InscripcionDAO dao = new InscripcionDAO();
		return dao.insertarInscripcion(dto);
	}
	
	@Override
	public List<CursoDTO> obtenerCursos() throws SQLException, ClassNotFoundException{
		CursoDao dao = new CursoDao();
		return dao.obtieneCursos();
	}
	
	@Override
	public List<FormaDePagoDTO> obtenerFormasDePago() throws SQLException, ClassNotFoundException{
		FormaDePagoDAO dao = new FormaDePagoDAO();
		return dao.obtieneFormasDePago();
	}
	
	@Override
	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {
		InscripcionDAO dao = new InscripcionDAO();		
		return dao.obtieneInscripciones();	
	}

}
