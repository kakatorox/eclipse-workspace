package modelo;

public class Vehiculo {
	
	protected String color;
	protected String patente;
	protected int cantidadAsientos;
	
	protected Vehiculo() {
		
	}
	
	protected Vehiculo(String color, String patente, int cantidadAsientos) {
		this.color = color;
		this.patente = patente;
		this.cantidadAsientos = cantidadAsientos;
	}
	
	public Vehiculo(String color, String patente) {
		this.color = color;
		this.patente = patente;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	protected int getCantidadAsientos() {
		return cantidadAsientos;
	}

	protected void setCantidadAsientos(int cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
	}

}
