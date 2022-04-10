package cl.desafiolatam.noticias.app.facade;

import org.springframework.beans.factory.annotation.Autowired;

import cl.desafiolatam.noticias.app.dto.NoticiaDto;
import cl.desafiolatam.noticias.app.service.NoticiasService;

public class NoticiasFacade {
	
	@Autowired
	private NoticiasService noticiasService;
	
	public NoticiaDto getNoticias() {
		// TODO Auto-generated method stub
		return noticiasService.getNoticias();
		 
	}

}
