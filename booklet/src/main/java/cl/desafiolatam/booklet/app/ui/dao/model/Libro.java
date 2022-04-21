package cl.desafiolatam.booklet.app.ui.dao.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data 
@Component("libro")
public class Libro {
	private int id;
	private String titulo;
	private String anio;
	private String autor;
	private String imprenta;
	private boolean disponible;

	
}
