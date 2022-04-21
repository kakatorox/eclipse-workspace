package cl.desafiolatam.booklet.app.ui.service;

import java.util.List;

import cl.desafiolatam.booklet.app.ui.dto.LibroDto;



public interface LibroService {

	public boolean addLibro(LibroDto libroDTO);

	public String getLibros();

	public boolean deleteLibro(int i);

	public boolean updateLibro(LibroDto libroDTO);

}
