package cl.desafiolatam.ProductosLimpieza.dao.model;

import java.util.List;

public class Producto {

	private int idProducto;
	private String nombreProducto;
	private int precioProducto;
	private String descripcionProducto;
	private List<Categoria> listaCategoria;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}
	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
	
	
	
}
