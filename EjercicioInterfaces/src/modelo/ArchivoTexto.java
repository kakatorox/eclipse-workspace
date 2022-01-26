package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.ManejoArchivos;

public class ArchivoTexto extends Archivo implements ManejoArchivos {

	public ArchivoTexto(String ruta, String nombre) {
		super(ruta, nombre);
	}
	
	public boolean crearDirectorio() {
		boolean directorioCreado = false;
		File directorio = new File(this.getRuta());
		if (!directorio.exists()) {
			if (directorio.mkdirs()) {
				directorioCreado = true;
			} else {
				System.out.println("Error al crear directorio");
			}
		}
		return directorioCreado;
	}
	
	public boolean crearFichero() {
		boolean archivoCreado = false;
		File nuevoArchivo = new File(this.getRuta()+"/"+this.getNombre());
		if (!nuevoArchivo.exists()) {
			try {
				archivoCreado = nuevoArchivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return archivoCreado;
	}
	
	public int escribirArchivo(List<String>contenido, boolean sobreEscribir) {
		
		File leerArchivo = new File(this.getRuta() + "/" + this.getNombre());
		int lineasInsertadas = 0;
		try {
			FileWriter fW = new FileWriter(leerArchivo, !sobreEscribir);
			BufferedWriter br = new BufferedWriter(fW);
			for (int i = 0; i < contenido.size(); i++) {
				br.append(contenido.get(i));
				br.newLine();
				lineasInsertadas++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineasInsertadas;
	}
	
	public List<String> leerArchivo(){
		List<String> arreglo = new ArrayList<String>();
		File leerArchivo = new File(this.getRuta()+"/"+this.getNombre());
		try {
			FileReader fr = new FileReader(leerArchivo);
			BufferedReader br = new BufferedReader(fr);
			try {
				String linea;
				while ( (linea = br.readLine()) != null) {
					arreglo.add(linea);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arreglo;
	}
	
}
