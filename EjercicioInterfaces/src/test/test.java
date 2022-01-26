package test;

import java.util.ArrayList;
import java.util.List;

import modelo.ArchivoTexto;

public class test {

	public static void main(String[] args) {
		
		String s1 = "Primer string";
		String s2 = "Segundo string";;
		
		List<String> miContenido = new ArrayList<String>();
		miContenido.add(s1);
		miContenido.add(s2);
		
		ArchivoTexto nuevoArchivo = new ArchivoTexto("fichero/miCarpeta", "nuevo archivo.txt");
		
		nuevoArchivo.crearDirectorio();
		nuevoArchivo.crearFichero();
		nuevoArchivo.escribirArchivo(miContenido, true);
		List<String> leyendoContenido = nuevoArchivo.leerArchivo();
		
		for (String string : leyendoContenido) {
			System.out.println(string);
		}
		
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.print("\f");
	}

}
