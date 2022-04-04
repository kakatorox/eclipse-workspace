package cl.desafiolatam.ProductosLimpieza.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;
import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;

public class ProductoDto {

	private List<Producto> listaProducto;
	private String mensaje;
	
	public ProductoDto() {
		super();
		this.listaProducto = new ArrayList<Producto>();
	}

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
	public void productoFromJson(String json) {
		Producto producto = new Producto();
		Categoria categoria = new Categoria();
		
		String dataSplit[] = json.split("&");
		producto.setIdProducto(0);
		producto.setNombreProducto(dataSplit[0].split("=")[1]);
		producto.setPrecioProducto(Integer.parseInt(dataSplit[1].split("=")[1]));
		producto.setDescripcionProducto(dataSplit[2].split("=")[1]);
		categoria.setId_categoria(Integer.parseInt(dataSplit[3].split("=")[1]));
		producto.setCategoria(categoria);		
		
		this.listaProducto.add(producto);
	}
	public void updateProductoFromJson(String json) {
		Producto producto = new Producto();
		Categoria categoria = new Categoria();
		
		String dataSplit[] = json.split("&");
		System.out.println(dataSplit.length);
		if(dataSplit.length==2) {
			producto.setIdProducto(Integer.parseInt(dataSplit[0].split("=")[1]));
		}else {
			producto.setIdProducto(Integer.parseInt(dataSplit[0].split("=")[1]));
			producto.setNombreProducto(dataSplit[1].split("=")[1]);
			producto.setPrecioProducto(Integer.parseInt(dataSplit[2].split("=")[1]));
			producto.setDescripcionProducto(dataSplit[3].split("=")[1]);
			categoria.setId_categoria(Integer.parseInt(dataSplit[4].split("=")[1]));
			producto.setCategoria(categoria);
		}
	
		this.listaProducto.add(producto);
	}
}
