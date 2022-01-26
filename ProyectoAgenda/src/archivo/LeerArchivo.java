package archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfacesArchivos.LeerArchivoInt;

public class LeerArchivo implements LeerArchivoInt {

	public List<String> leerArchivo(String rutaOrigen, String nombreArchivo) {
		
		List<String> arreglo = new ArrayList<String>();
		File leerArchivo = new File(rutaOrigen + "/" + nombreArchivo);
		try {
			FileReader fr = new FileReader(leerArchivo);
			BufferedReader br = new BufferedReader(fr);
			try {
				String linea;
				while ((linea = br.readLine()) != null) {
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
