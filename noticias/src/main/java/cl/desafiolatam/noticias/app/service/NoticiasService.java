package cl.desafiolatam.noticias.app.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.aop.target.SimpleBeanTargetSource;
import org.springframework.beans.factory.annotation.Autowired;

import cl.deafiolatam.noticias.app.model.Noticia;
import cl.desafiolatam.noticias.app.dto.NoticiaDto;
import cl.desafiolatam.noticias.app.utils.Archivos;

public class NoticiasService {
	
	@Autowired
	private Archivos archivo;
	
	@Autowired
	private NoticiaDto noticiaDto;
	
	public NoticiaDto getNoticias() {

		List<Noticia> listaNoticias = new ArrayList<Noticia>();
				
//					Noticia noticia = new Noticia();
//					noticia.setTitulo("titulo1");
//					noticia.setBody("body1");
//					noticia.setImagen("img1");
//					listaNoticias.add(noticia);
		try {
			List<String> archivoLeido = archivo.leerFichero("noticias.txt");
			
			for (String string : archivoLeido) {
				Noticia noticia = new Noticia();
				String[] div = string.split("@@");	
				noticia.setTitulo(div[0].replace("\"", "\\\""));
				noticia.setBody(div[1].replace("\"", "\\\""));
				noticia.setImagen(div[2]);
				listaNoticias.add(noticia);
				
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		noticiaDto.setNoticias(listaNoticias);
		
		return noticiaDto;

	}
}
