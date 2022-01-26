package cl.desafiolatam.modelo;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ExportarTxt extends Exportador{
    
	protected ExportarTxt(String ruta, String nombre) {
		super(ruta, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getRuta() {
		// TODO Auto-generated method stub
		return super.getRuta();
	}

	@Override
	public void setRuta(String ruta) {
		// TODO Auto-generated method stub
		super.setRuta(ruta);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}

	@Override
	public boolean crearDirectorio() {
		// TODO Auto-generated method stub
		return super.crearDirectorio();
	}

	@Override
	public boolean crearFichero() {
		// TODO Auto-generated method stub
		return super.crearFichero();
	}

	@Override
	public int escribirArchivo(List<String> contenido, boolean sobreEscribir) {
		// TODO Auto-generated method stub
		return super.escribirArchivo(contenido, sobreEscribir);
	}

	@Override
	public void escribirLinea(String ruta, List<Producto> pro) throws FileNotFoundException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese opcion 1 para exportar: ");
		int op;
		op= sc.nextInt();
		if(op==1)
			super.escribirLinea(ruta,pro);
		else
			System.out.println("No hago nada");
		Utilidad.limpiarPantalla();
	}

	
}
