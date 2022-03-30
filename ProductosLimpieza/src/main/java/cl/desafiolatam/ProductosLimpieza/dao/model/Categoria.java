package cl.desafiolatam.ProductosLimpieza.dao.model;

public class Categoria {

	private int idCategoria;
	private String nombreCategoria;
	public int getId_categoria() {
		return idCategoria;
	}
	public void setId_categoria(int id_categoria) {
		this.idCategoria = id_categoria;
	}
	public String getNombre_categoria() {
		return nombreCategoria;
	}
	public void setNombre_categoria(String nomCat) {
		this.nombreCategoria = nomCat;
	}
	
}
