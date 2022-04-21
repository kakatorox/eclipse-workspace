package cl.desafiolatam.booklet.app.ui.delegate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import cl.desafiolatam.booklet.app.ui.delegate.LibroDelegate;
import cl.desafiolatam.booklet.app.ui.dto.LibroDto;
import cl.desafiolatam.booklet.app.ui.service.LibroService;
import lombok.Data;

@Component("libroDelegate")
@Data
public class LibroDelegateImpl implements LibroDelegate {

	@Autowired
	private LibroService libroService;
	private String mensaje;
	@Override
	public String getLibros() {
		// TODO Auto-generated method stub
		return libroService.getLibros();
	}

	@Override
	public String addLibro(LibroDto libroDTO) {
		// TODO Auto-generated method stub
		if (libroService.addLibro(libroDTO)) {
			this.setMensaje("Libro Agregado");
			return libroService.getLibros();
		}else {
			this.setMensaje("Libro No Agregado");
			return null;
		}
		
	}

	@Override
	public String deleteLibro(int i) {
		// TODO Auto-generated method stub
		if (libroService.deleteLibro(i)) {
			this.setMensaje("Libro Borrado");
			return libroService.getLibros();
		}else {
			this.setMensaje("Libro No Borrado");
			return null;
		}
	}

	@Override
	public String updateLibro(LibroDto libroDTO) {
		// TODO Auto-generated method stub
		if (libroService.updateLibro(libroDTO)) {
			this.setMensaje("Libro Actualizado");
			return libroService.getLibros();
		}else {
			this.setMensaje("Libro No Actualizado");
			return null;
		}
	}
	
	@Override
	public String getMensaje() {
		return mensaje;
	}
	
	

}
