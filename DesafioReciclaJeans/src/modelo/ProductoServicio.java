package modelo;

import java.util.List;
import java.util.Scanner;

public class ProductoServicio {
	
	private List<Producto> listaProductos;
	
	public ProductoServicio(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public List<Producto> agregarProducto() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresar nombre de artículo:");
		String articulo = sc.nextLine();
		System.out.println("Ingresar precio de artículo:");
		String precio = sc.nextLine();
		System.out.println("Ingresar descripción de artículo:");
		String descripcion = sc.nextLine();
		System.out.println("Ingresar código de artículo:");
		String codigo = sc.nextLine();
		System.out.println("Ingresar talla de artículo:");
		String talla = sc.nextLine();
		System.out.println("Ingresar marca de artículo:");
		String marca = sc.nextLine();
		System.out.println("Ingresar color de artículo:");
		String color = sc.nextLine();
		Producto producto = new Producto(articulo, precio, descripcion, codigo, talla, marca, color);
		List<Producto> productos = getListaProductos();
		productos.add(producto);
		setListaProductos(productos);
		
		return getListaProductos();
		
	}
	
	public void listarProductos() {
		for (Producto producto : this.listaProductos) {
			System.out.println(producto.toString());
		}
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	

}
