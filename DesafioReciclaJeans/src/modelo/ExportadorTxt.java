package modelo;

import java.util.List;

public class ExportadorTxt extends Exportador{

	@Override
	public void exportarArchivo(String rutaDestino, String nombreArchivo, List<Producto> listaProductos, boolean sobreEscribir) {
		// TODO Auto-generated method stub
		super.exportarArchivo(rutaDestino, nombreArchivo, listaProductos, sobreEscribir);
	}

	@Override
	public void exportarArchivo(String ruta, String nombreArchivo, List<Producto> listaProductos) {
		// TODO Auto-generated method stub
		super.exportarArchivo(ruta, nombreArchivo, listaProductos);
	}
	
	

}
