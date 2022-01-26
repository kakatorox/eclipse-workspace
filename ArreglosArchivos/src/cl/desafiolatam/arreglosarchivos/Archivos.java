package cl.desafiolatam.arreglosarchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nomFichero = null;
		String nomDirectorio = null;

		System.out.println("Ingrese Nombre de Fichero con extension");
		nomFichero = "HolaFichero.txt";

		System.out.println("Ingrese Nombre de Directorio");
		nomDirectorio = "src/prueba";

		try {
			//crearFichero(nomFichero, nomDirectorio);
		
			escribirFichero(nomFichero, nomDirectorio);
		
			//leerFichero(nomFichero, nomDirectorio);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static File crearFichero(String nomFi, String nomDi) throws IOException {
		File directorio = new File(nomDi);
		File archivo = new File(directorio + "/" + nomFi);
		
		if (!directorio.exists()) {
			directorio.mkdir();
			System.out.println("Se creo el directorio : " + nomDi);
			if (!archivo.exists()) {
				archivo.createNewFile();
				System.out.println("Se creo el Fichero: " + nomFi);
			} else {
				System.out.println("Fichero ya existe");

			}

		} else {
			System.out.println("Directorio ya existe");
		}

		return archivo;
	}
	
	
	public static File escribirFichero(String nomFi, String nomDi) throws IOException {
		
	/* 1 */ File archivo = new File(nomDi + "/" + nomFi);
	/* 2 */	FileWriter fw = new FileWriter(archivo);//FileWriter(archivo)
	/* 3 */	BufferedWriter bw = new BufferedWriter(fw);
	bw.append("texto 1");
	bw.write("texto 2");
	bw.newLine();
	bw.write("Estoy Vivooo");
	bw.close();		
		return null;	
	}
	
	public static File leerFichero(String nomFi,String nomDi) throws IOException  {
		
	/* 1 */ File archivo = new File(nomDi + "/" + nomFi);
	/* 2 */	FileReader fr = new FileReader(archivo);
	/* 3 */	BufferedReader br = new BufferedReader(fr);
	
	String data = br.readLine();
	while (data != null) {
		System.out.println(data);  	 
		data = br.readLine();
	}
	br.close(); 
	return archivo;		
	}
}
