package cl.desafiolatam.booklet.app.ui.dao;

import java.util.List;

import cl.desafiolatam.booklet.app.ui.dto.LibroDto;

public interface LibroDao {

	public List<LibroDto> getLibros();

	public boolean addLibro(LibroDto libroDto);

	public boolean deleteLibro(int i);

	public boolean updateLibro(LibroDto libroDto);
}
