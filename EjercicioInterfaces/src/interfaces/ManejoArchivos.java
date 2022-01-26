package interfaces;

import java.util.List;


public interface ManejoArchivos {
	
	int escribirArchivo(List<String> contenido, boolean sobreEscribir);
	List<String> leerArchivo();
	boolean crearDirectorio();
	boolean crearFichero();

}
