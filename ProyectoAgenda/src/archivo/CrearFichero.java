package archivo;

import java.io.File;
import java.io.IOException;

import interfacesArchivos.CrearFicheroInt;

public class CrearFichero implements CrearFicheroInt {

	public boolean crearFichero(String rutaDestino, String nombreArchivo) {
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
}
