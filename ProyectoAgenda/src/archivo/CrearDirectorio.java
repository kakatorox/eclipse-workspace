package archivo;

import java.io.File;

import interfacesArchivos.CrearCarpetaInt;

public class CrearDirectorio implements CrearCarpetaInt {

	public boolean crearDirectorio(String rutaDestino)  {
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
}
