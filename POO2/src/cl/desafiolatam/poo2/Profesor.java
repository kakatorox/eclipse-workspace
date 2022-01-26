package cl.desafiolatam.poo2;

public class Profesor extends Persona{
	private float sueldo;
	
	public Profesor(float sueldo, String rut, String nombre, boolean presente) {
		// TODO Auto-generated constructor stub
		super(rut, nombre, presente);
		this.sueldo = sueldo;
	}
	public Profesor(String rut, String nombre, boolean presente) {
		super(rut, nombre, presente);
		// TODO Auto-generated constructor stub
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	
}
