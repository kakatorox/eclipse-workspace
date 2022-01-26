package cl.desafiolatam.clase.model1;

public class Persona {

	private String nombre;
	private String apellido;
	private int edad;
	private char genero;
	private String fechaNacimiento;
	private String rut;
	private String lenguaje;
	
	protected String getNombre() {
		
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getApellido() {
		return apellido;
	}
	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}
	protected int getEdad() {
		return edad;
	}
	protected void setEdad(int edad) {
		this.edad = edad;
	}
	protected char getGenero() {
		return genero;
	}
	protected void setGenero(char genero) {
		this.genero = genero;
	}
	protected String getFechaNacimiento() {
		return fechaNacimiento;
	}
	protected void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	protected String getRut() {
		return rut;
	}
	protected void setRut(String rut) {
		this.rut = rut;
	}
	protected String getLenguaje() {
		return lenguaje;
	}
	protected void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}	
}
