package cl.desafiolatam.ProductosLimpieza.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;

public class CategoriaDto {
	
	private List<Categoria> listaCategoria;
	private String mensaje;
	
	public CategoriaDto() {
		super();
		// TODO Auto-generated constructor stub
		this.listaCategoria = new ArrayList<Categoria>();
	}
	
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
	public void categoriaFromJson(String json) {
		Categoria categoria = new Categoria();
		
		String dataSplit[] = json.split("&");
		categoria.setId_categoria(0);
		categoria.setNombre_categoria(dataSplit[0].split("=")[1]);
		
		
		this.listaCategoria.add(categoria);
	}
	public void updateCategoriaFromJson(String json) {
		Categoria categoria = new Categoria();
		
		String dataSplit[] = json.split("&");
		categoria.setId_categoria(Integer.parseInt(dataSplit[0].split("=")[1]));
		categoria.setNombre_categoria(dataSplit[1].split("=")[1]);
		
		
		this.listaCategoria.add(categoria);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub}
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
