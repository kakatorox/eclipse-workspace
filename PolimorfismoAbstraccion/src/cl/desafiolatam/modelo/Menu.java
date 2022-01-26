package cl.desafiolatam.modelo;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	private final String direccion = "src/Productos";
	private final String fichero = "listaProductos.txt";
	private final String ruta = direccion + "/"+ fichero;
	private List<Producto> liProductos;
	private boolean resp=true;
	
	ProductoServicio listadoProductos;
	
	ExportarTxt exportadorTxt;
	
	public Menu(List<Producto> productos) {		
		// TODO Auto-generated constructor stub
		this.liProductos = productos;
	}

	public void menuVer() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int op = 4;
		while(resp) {			
			System.out.println("1 Listar Producto\n"
							 + "2 Agregar Producto\n"
							 + "3 Exportar Datos\n"
							 + "4 Salir\n");
			System.out.println("Ingrese una opción : ");
			op=sc.nextInt();			
			switch (op) {
			case 1:
				listadoProductos = new ProductoServicio(liProductos);
				Utilidad.limpiarPantalla();
				Utilidad.tEspera(1);
				listadoProductos.listarProductos();
				//exportadorTxt.leerArchivo(ruta,liProductos);
				break;
			case 2:
				listadoProductos = new ProductoServicio(liProductos);
				Utilidad.limpiarPantalla();
				Utilidad.tEspera(1);
				this.liProductos = listadoProductos.agregarProducto();
				break;
			case 3:
				exportadorTxt= new ExportarTxt(direccion, fichero);
				Utilidad.limpiarPantalla();
				Utilidad.tEspera(1);
				try {
					exportadorTxt.escribirLinea(this.ruta,this.liProductos);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			default:
				Utilidad.limpiarPantalla();
				Utilidad.tEspera(2);
				System.out.println("Hasta Pronto");
				resp=false;
				break;
			}
		}	
	}
}
