package cl.desafiolatam.noticias.app.dto;

import java.util.List;

import com.google.gson.Gson;

import cl.deafiolatam.noticias.app.model.Noticia;

public class NoticiaDto {
	
	private List<Noticia> listaNoticias;

	public List<Noticia> getNoticias(){
		return listaNoticias;
	}

	public void setNoticias(List<Noticia> listaNoticias) {
		// TODO Auto-generated method stub
		this.listaNoticias = listaNoticias;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub}
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
