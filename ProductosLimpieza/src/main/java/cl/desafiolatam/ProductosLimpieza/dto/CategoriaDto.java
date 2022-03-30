package cl.desafiolatam.ProductosLimpieza.dto;

import java.util.List;

import com.google.gson.Gson;

import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;

public class CategoriaDto {
	
	private List<Categoria> listaCategoria;
	private String mensaje;
	
	public void setCategorias(List<Categoria> liCat){
		this.listaCategoria = liCat;
	}
	
	public List<Categoria> getCategoria(){
		return this.listaCategoria;
	}	
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub}
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
