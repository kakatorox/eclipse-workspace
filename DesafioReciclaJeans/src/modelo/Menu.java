package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private final String DIRECCION = "fichero";
	private final String NOMBRE = "listaProductos.csv";
	private List<Producto> listadoProductos;

	public Menu() {
		this.listadoProductos = ArchivoServicio.leerArchivo(this.DIRECCION, this.NOMBRE);
	}

	ProductoServicio listaProductos;
	ExportadorTxt exportadorTxt;

	public void menuVer() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int op;

		boolean continuar = true;
		while (continuar) {
			System.out.println("\n1 Listar Producto" + "\n2 Agregar Producto" + "\n3 Exportar Datos" + "\n4 Importar Datos" + "\n5 Editar Datos" + "\n6 Salir");
			System.out.println("\nIngrese una opción : ");
			op = sc.nextInt();
			switch (op) {
			case 1:
				listaProductos = new ProductoServicio(this.listadoProductos);
				listaProductos.listarProductos();
				Utilidad.pressEnterToContinue();
				break;
			case 2:
				listaProductos = new ProductoServicio(this.listadoProductos);
				this.listadoProductos = listaProductos.agregarProducto();
				break;
			case 3:
				exportadorTxt = new ExportadorTxt();
				exportadorTxt.exportarArchivo(this.DIRECCION, this.NOMBRE, this.listadoProductos);
				break;
			case 4:
				Scanner datos = new Scanner(System.in);
				System.out.println("Ingresar la ruta:");
				String ruta = datos.nextLine();
				System.out.println("Ingresar el nombre del archivo:");
				String nombreArchivo = datos.nextLine();
				for (Producto producto : ArchivoServicio.leerArchivo(ruta, nombreArchivo)) {
					this.listadoProductos.add(producto);
				}
				break;
			case 5:
				int contador = 1;
				for (Producto producto : this.listadoProductos) {
					System.out.println("Producto " + contador++ + ": "+ producto.toString());
				}
				Scanner scan = new Scanner(System.in);
				System.out.println("\nIndique el producto a editar:");
				int indiceProd = scan.nextInt();
				Producto producto = this.listadoProductos.get(indiceProd-1);
				
				String[] productoSt = producto.toString().split(",");
				
				List<String> atributos = new ArrayList<String>();
				atributos.add("Artículo:");
				atributos.add("Precio:");
				atributos.add("Descripción:");
				atributos.add("Código:");
				atributos.add("Talla:");
				atributos.add("Marca:");
				atributos.add("Color:");
				
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < atributos.size(); i++) {
					sb.append("\n " + (i+1) + ". "+ atributos.get(i));
					sb.append(" " + productoSt[i]);
				}
				sb.toString();
				
				System.out.println(sb);
				
				System.out.println("\nIndique el atributo a modificar:");
				int indiceAtributo = scan.nextInt();
				System.out.println("Indique nuevo valor para " + atributos.get(indiceAtributo-1));
				
				Scanner conten = new Scanner(System.in);
				String contenido = conten.nextLine();
				
				switch (indiceAtributo) {
				case 1:
					producto.setArticulo(contenido);
					break;
				case 2:
					producto.setPrecio(contenido);
					break;
				case 3:
					producto.setDescripcion(contenido);
					break;
				case 4:
					producto.setCodigo(contenido);
					break;
				case 5:
					producto.setTalla(contenido);
					break;
				case 6:
					producto.setMarca(contenido);
					break;
				default:
					producto.setColor(contenido);
					break;
				}
				
				this.listadoProductos.set(indiceProd-1, producto);
				contador = 1;
				for (Producto prod : this.listadoProductos) {
					System.out.println("Producto " + contador++ + ": "+ prod.toString());
				}
				break;
			default:
				System.out.println("Gracias, vuelva pronto");
				continuar = false;
				break;
			}
			Utilidad.tEspera(1);
			Utilidad.ClearConsole();
		}

	}

}
