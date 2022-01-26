package cl.desafiolatam.modelo;

import java.util.List;
import java.util.Scanner;

public class ProductoServicio {

	List<Producto> listaProductos;
	
	public ProductoServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductoServicio(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public List<Producto> agregarProducto() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String articulo;
		String precio;
		String descripcion;
		String codigo;
		String talla;
		String marca;
		String color;
		System.out.println("Nombre Articulo : ");
		articulo = sc.next();
		System.out.println("Precio : ");
		precio = sc.next();
		System.out.println("Descripcion : ");
		descripcion = sc.next();
		System.out.println("Codigo : ");
		codigo = sc.next();
		System.out.println("Talla : ");
		talla = sc.next();
		System.out.println("Marca : ");
		marca = sc.next();
		System.out.println("Color : ");
		color = sc.next();
		
		Producto prod = new Producto(articulo,precio,descripcion,codigo,talla,marca,color);

		List<Producto> listaProductos = getListaProductos();
		listaProductos.add(prod);
		setListaProductos(listaProductos);
		Utilidad.limpiarPantalla();
		return getListaProductos();
	}

	public void listarProductos() {
		// TODO Auto-generated method stub
		int i=0,j=0;
		String[] parts = null;
		String codigos =null;
		String[] liCod = new String[1] ;
		
		System.out.println();
		
		for (Producto producto : this.listaProductos) {
			String string = producto.toString();
			codigos = producto.getCodigo();
			
			for (j=0;j<liCod.length;j++) {
				if(!liCod.equals(codigos))
						liCod[j]=codigos;
			}			 
			System.out.println("\n################################");
			System.out.println("\n################################");
			parts = string.split(";");
			for(i=0;i < parts.length;i++) {
				System.out.println(parts[i].toString());
			}
			System.out.println("\n################################");
			System.out.println("\n################################");
		}
		
		
		

	}
	
	
}
