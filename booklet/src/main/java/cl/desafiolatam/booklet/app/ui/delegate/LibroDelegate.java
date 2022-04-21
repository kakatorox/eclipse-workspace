package cl.desafiolatam.booklet.app.ui.delegate;

import java.util.List;

import cl.desafiolatam.booklet.app.ui.dto.LibroDto;

public interface LibroDelegate {
	public String getLibros();
	public String addLibro(LibroDto libroDTO);
	public String deleteLibro(int i);
	public String updateLibro(LibroDto libroDTO);
	public String getMensaje();
}
