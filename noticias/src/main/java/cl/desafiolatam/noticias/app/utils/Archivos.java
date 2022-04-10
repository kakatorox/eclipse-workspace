package cl.desafiolatam.noticias.app.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.google.gson.Gson;


public class Archivos {

	@Autowired
	ResourceLoader loader; 
	
//	public String ruta{
//		
//		
//	}
	
	public List<String> leerFichero(String nomFi ) throws IOException {

		/* 1 */Resource resource = loader.getResource("classpath:static/" + nomFi);
		/* 2 */File archivo = resource.getFile();
		/* 3 */ FileReader fr = new FileReader(archivo);
		/* 4 */ BufferedReader br = new BufferedReader(fr);
		String data  = br.readLine();
		List<String> datos = new ArrayList<String>();
		while (data != null) {
			//System.out.println(data);
			
			if (data != null  && !data.equals("")) {
				datos.add(data);				
			}
			data = br.readLine();			
		}
		br.close();
		return datos;
	}
	
	public File crearFichero(String nomFi, String nomDi) throws IOException {
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
	
	
	public File escribirFichero(String nomFi, String nomDi) throws IOException {
		
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
}
