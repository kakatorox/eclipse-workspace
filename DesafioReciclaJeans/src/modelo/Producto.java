package modelo;

public class Producto {
	
	protected String articulo;
	protected String precio;
	protected String descripcion;
	protected String codigo;
	protected String talla;
	protected String marca;
	protected String color;
	
	
	public Producto() {
		
	}
	
	public Producto(String articulo, String precio, String descripcion, String codigo, String talla, String marca,
			String color) {
		super();
		this.articulo = articulo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.talla = talla;
		this.marca = marca;
		this.color = color;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(articulo);
		builder.append(",");
		builder.append(precio);
		builder.append(",");
		builder.append(descripcion);
		builder.append(",");
		builder.append(codigo);
		builder.append(",");
		builder.append(talla);
		builder.append(",");
		builder.append(marca);
		builder.append(",");
		builder.append(color);
		return builder.toString();
	}

}
