package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public abstract class Exportador {

	protected void exportarArchivo(String rutaDestino, String nombreArchivo, List<Producto> listaProductos, boolean sobreEscribir) {
		crearDirectorio(rutaDestino);
		crearFichero(rutaDestino, nombreArchivo);
		escribirArchivo(rutaDestino, nombreArchivo, listaProductos, sobreEscribir);
	}
	
	protected void exportarArchivo(String ruta, String nombreArchivo, List<Producto> listaProductos) {
		crearDirectorio(ruta);
		try {
			PrintWriter pw = new PrintWriter(ruta + "/" + nombreArchivo);
			for (Producto producto : listaProductos) {
				pw.append(producto.toString() + "\n");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean crearDirectorio(String rutaDestino) {
		boolean directorioCreado = false;
		File directorio = new File(rutaDestino);
		if (!directorio.exists()) {
			if (directorio.mkdirs()) {
				directorioCreado = true;
			} else {
				System.out.println("Error al crear directorio");
			}
		}
		return directorioCreado;
	}

	private boolean crearFichero(String rutaDestino, String nombreArchivo) {
		boolean archivoCreado = false;
		File nuevoArchivo = new File(rutaDestino + "/" + nombreArchivo);
		if (!nuevoArchivo.exists()) {
			try {
				archivoCreado = nuevoArchivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return archivoCreado;
	}

	private int escribirArchivo(String rutaDestino, String nombreArchivo, List<Producto> listaProductos, boolean sobreEscribir) {

		File leerArchivo = new File(rutaDestino + "/" + nombreArchivo);
		int lineasInsertadas = 0;
		try {
			FileWriter fW = new FileWriter(leerArchivo, !sobreEscribir);
			BufferedWriter br = new BufferedWriter(fW);
			for (int i = 0; i < listaProductos.size(); i++) {
				br.append(listaProductos.get(i).toString());
				br.newLine();
				lineasInsertadas++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineasInsertadas;
	}

}
