package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class LibroVenta {
	String DIRECTORIO = "src/ficheros";
	String FICHERO = "nombre venta.txt";
	private String nombreVenta;
	private String fechaVenta;
	
	public LibroVenta() {
		// TODO Auto-generated constructor stub
	}
	
	public LibroVenta(String nombreVenta, String fechaVenta) {
		this.nombreVenta = nombreVenta;
		this.fechaVenta = fechaVenta;
	}

	public String getNombreVenta() {
		return nombreVenta;
	}

	public void setNombreVenta(String nombreVenta) {
		this.nombreVenta = nombreVenta;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	public void guardarVenta(Cliente cli,Vehiculo vec ) throws Exception {
				
		validardirectorio();
		
		File arc= validarFichero();
		
		FileWriter fw = new FileWriter(arc,true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String fecha = this.fechaVenta.replace("/", "");
		 fecha = fecha.replace("-", "");
		
		bw.append(vec.getPatente()+","+cli.getEdad()+","+Integer.parseInt(fecha) +"\n");
			
		bw.close();					
		
	}
	
	public void validardirectorio() {
		File dir = new File(DIRECTORIO);
		try {
				dir.mkdirs();
		}catch(Exception er){
				System.out.println("Error al Crear En la ruta \n" + dir + " ya existe");
		}
			
	}
	
	public File validarFichero() {
		File dir = new File(DIRECTORIO);
		File arc = new File(dir + "/" + FICHERO);
		
		try {
			arc.createNewFile();
		}catch(Exception err){
			System.out.println("Fichero Existe");
		}
		
		return arc;
	}
	
}
