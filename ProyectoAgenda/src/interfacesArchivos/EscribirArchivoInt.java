package interfacesArchivos;

import java.util.List;

public interface EscribirArchivoInt {
	public int escribirArchivo(String rutaDestino, String nombreArchivo, List<String> arreglo, boolean sobreEscribir);
}
