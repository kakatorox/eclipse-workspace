package cl.desafiolatam.booklet.app.ui.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import cl.desafiolatam.booklet.app.ui.dao.model.Libro;
import lombok.Data;

@Data
@Component
public class LibroDto {
	@Autowired
	private Libro libro;
	
	

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
}
