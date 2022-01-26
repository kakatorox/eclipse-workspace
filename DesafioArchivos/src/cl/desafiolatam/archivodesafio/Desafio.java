package cl.desafiolatam.archivodesafio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Desafio {

	public static void main(String[] args) {
//		String nomFichero = "fichero";
//		String nomDirectorio = "src/directorio";
//		String texto = "Perro";
//		ArrayList<String> lista = new ArrayList<String>();
//		lista.add("Perro");
//		lista.add("Gato");
//		lista.add("Juan");
//		lista.add("Daniel");
//		lista.add("Juan");
//		lista.add("Gato");
//		lista.add("Perro");
//		lista.add("Camila");
//		lista.add("Daniel");
//		lista.add("Camila");
//		try {
//			creaArchivo(nomDirectorio,nomFichero,lista);
//			buscarTexto(nomDirectorio,nomFichero,texto);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		Scanner scanner ;
		double remaining = 0;
		int amount;
		int i =0;
		scanner = new Scanner(System.in);
		amount = scanner.nextInt();
		while(i<3){
		
		remaining=amount*0.10;
		i++;
		}
		System.out.println(remaining);
	}

	public static void creaArchivo(String directorio, String fichero, ArrayList<String> lista) throws IOException {

		File dir = new File(directorio);
		File arc = new File(dir + "/" + fichero + ".txt");

		if (!dir.exists()) {
			dir.mkdir();
			System.out.println("Hemos Creado el Directorio");
		} else if (dir.exists()) {
			System.out.println("Error al Crear En la ruta \n" + dir + " ya existe");
		} else {
			System.out.println("Error al Crear el Directorio");
		}
		
		if(arc.exists()) {
			System.out.println("El archivo existe");
		}else {
			System.out.println("Se creo el archivo");
			arc.createNewFile();
		}	

		FileWriter fw = new FileWriter(arc,true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		Iterator<String> itLista = lista.iterator();
		while(itLista.hasNext()) {
			bw.append(itLista.next()+"\n");
			
		}
		
		bw.close();
	}

	public static void buscarTexto(String directorio,String nombreFichero,String texto) throws IOException{
		
		File archivo = new File(directorio + "/" + nombreFichero + ".txt");
		int cont=0;		
		String sCadena;
		if(!archivo.exists()) {
			System.out.println("El fichero ingresado no existe");
		}else {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);				
			while ((sCadena = br.readLine())!=null) {
					 if(sCadena.equals(texto)) {
						cont++; 
					 }				
				}
			br.close();
			System.out.print("cantidad de repeticiones del texto -> " + cont);
		} 	
	}
}
