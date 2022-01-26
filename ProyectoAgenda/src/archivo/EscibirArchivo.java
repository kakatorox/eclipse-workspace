package archivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import interfacesArchivos.EscribirArchivoInt;

public class EscibirArchivo implements EscribirArchivoInt {
	
	public int escribirArchivo(String rutaDestino, String nombreArchivo, List<String> arreglo, boolean sobreEscribir) {
		File leerArchivo = new File(rutaDestino + "/" + nombreArchivo);
		int lineasInsertadas = 0;
		try {
			FileWriter fW = new FileWriter(leerArchivo, !sobreEscribir);
			BufferedWriter br = new BufferedWriter(fW);
			for (int i = 0; i < arreglo.size(); i++) {
				br.append(arreglo.get(i).toString());
				br.newLine();
				lineasInsertadas++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineasInsertadas;
	}

}
