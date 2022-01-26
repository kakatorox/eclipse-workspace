package cl.desafiolatam.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public abstract class Exportador {

	protected String ruta;
	protected String nombre;

	protected Exportador(String ruta, String nombre) {
		this.ruta = ruta;
		this.nombre = nombre;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		File nuevoArchivo = new File(this.getRuta() + "/" + this.getNombre());
		if (!nuevoArchivo.exists()) {
			try {
				archivoCreado = nuevoArchivo.createNewFile();
				archivoCreado = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return archivoCreado;
	}

	public int escribirArchivo(List<String> contenido, boolean sobreEscribir) {

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

	public void escribirLinea(String ruta, List<Producto> pro) throws FileNotFoundException {

		crearDirectorio();

		File path = new File(ruta);
		@SuppressWarnings("resource")
		PrintWriter print = new PrintWriter(path);
		int i = 0;
		for (i = 0; i < pro.size(); i++) {

			print.append(pro.get(i).toString() + "\n");

		}

		print.close();

	}

	/*
	 * public List<Producto> leerArchivo(String ruta,ArrayList<Producto> pro){
	 * String stLine;
	 * 
	 * 
	 * if(crearFichero()) {
	 * 
	 * escribirLinea
	 * 
	 * }
	 * 
	 * 
	 * List<Producto> arreglo = pro; File leerArchivo = new File(ruta); try {
	 * FileReader fr = new FileReader(leerArchivo); BufferedReader br = new
	 * BufferedReader(fr); try { while ((stLine = br.readLine()) != null) {
	 * System.out.println(stLine); if (busqueda.equalsIgnoreCase(stLine)) { cont++;
	 * } } br.close(); //String array[] = pro.split(";"); pro.spliterator();
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace(); } return arreglo; }
	 */

}
