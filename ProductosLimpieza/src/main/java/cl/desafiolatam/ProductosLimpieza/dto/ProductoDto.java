package cl.desafiolatam.ProductosLimpieza.dto;

import java.util.List;

import com.google.gson.Gson;

import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;

public class ProductoDto {

	private List<Producto> listaProducto;
	private String mensaje;
	
	public void setProductos(List<Producto> liProd){
		this.listaProducto = liProd;
	}
	
	public List<Producto> getProductos(){
		return this.listaProducto;
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
