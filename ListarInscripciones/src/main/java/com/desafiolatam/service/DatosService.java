package com.desafiolatam.service;

import java.sql.SQLException;
import java.util.List;

import com.desafiolatam.entidades.CursoDTO;
import com.desafiolatam.entidades.FormaDePagoDTO;
import com.desafiolatam.entidades.InscripcionDTO;

public interface DatosService  {
	public int registrarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException;
	public List<CursoDTO> obtenerCursos() throws SQLException, ClassNotFoundException;
	public List<FormaDePagoDTO> obtenerFormasDePago() throws SQLException, ClassNotFoundException;
	public List<InscripcionDTO> obtieneInscripciones () throws SQLException, ClassNotFoundException;
}
