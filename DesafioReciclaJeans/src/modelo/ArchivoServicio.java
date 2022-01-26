package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoServicio {

	private static ArchivoServicio archivoServicio;

	private ArchivoServicio() {
	}

	public static List<Producto> leerArchivo(String rutaOrigen, String nombreArchivo) {
		if (archivoServicio == null) {
			synchronized (ArchivoServicio.class) {
				if (archivoServicio == null) {
					archivoServicio = new ArchivoServicio();
				}
			}
		}
		List<String> arreglo = new ArrayList<String>();
		File leerArchivo = new File(rutaOrigen + "/" + nombreArchivo);
		try {
			FileReader fr = new FileReader(leerArchivo);
			BufferedReader br = new BufferedReader(fr);
			try {
				String linea;
				while ((linea = br.readLine()) != null) {
					arreglo.add(linea);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<Producto> productos = productosImportados(arreglo);
		return productos;
	}
	
	private static List<Producto> productosImportados(List<String> archivo){
		List<Producto> productos = new ArrayList<Producto>();
		for (String st : archivo) {
			Producto producto = new Producto();
			String[] productoSt = st.split(",");
			producto.setArticulo(productoSt[0]);
			producto.setPrecio(productoSt[1]);
			producto.setDescripcion(productoSt[2]);
			producto.setCodigo(productoSt[3]);
			producto.setTalla(productoSt[4]);
			producto.setMarca(productoSt[5]);
			producto.setColor(productoSt[6]);
			productos.add(producto);
		}
		return productos;
	}
	
}
