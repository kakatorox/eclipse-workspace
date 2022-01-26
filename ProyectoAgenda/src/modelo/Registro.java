package modelo;

import java.util.Scanner;

public class Registro {

	private int id;
	private String nombre;
	private String apellido;
	private String numTelefono;
	private String apodo;
	private String tag;
	private static int contadorRegistro;

	public Registro(String nombre, String apellido, String numTelefono, String apodo, String tag) {
		super();
		this.id = ++contadorRegistro;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numTelefono = numTelefono;
		this.apodo = apodo;
		this.tag = tag;
	}
	public Registro() {
		super();
		crearRegistro();
	}
	private void crearRegistro() {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.println("Nombre: ");
		String nombre=sc.nextLine();
		System.out.println("Apellido: ");
		String apellido=sc.nextLine();
		System.out.println("numTelefono: ");
		String numTelefono=sc.nextLine();
		System.out.println("Apodo: ");
		String apodo=sc.nextLine();
		System.out.println("Tag: ");
		String tag=sc.nextLine();
		
		
		this.id = ++contadorRegistro;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numTelefono = numTelefono;
		this.apodo = apodo;
		this.tag = tag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(",");
		builder.append(nombre);
		builder.append(",");
		builder.append(apellido);
		builder.append(",");
		builder.append(numTelefono);
		builder.append(",");
		builder.append(apodo);
		builder.append(",");
		builder.append(tag);
		return builder.toString();
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public static int getContadorRegistro() {
		return contadorRegistro;
	}

	public static void setContadorRegistro(int contadorRegistro) {
		Registro.contadorRegistro = contadorRegistro;
	}

}
