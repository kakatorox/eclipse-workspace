package cl.desafiolatam.poo2;

public class Estudiante extends Persona{
	private double deuda;
	public Estudiante(double deuda,String rut, String nombre, boolean presente) {
		super(rut, nombre, presente);
		this.deuda = deuda;
	}
	public Estudiante(String rut, String nombre, boolean presente) {
		super(rut, nombre, presente);
	}
	public double getDeuda() {
		return deuda;
	}
	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}
	
}
