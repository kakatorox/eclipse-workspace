package cl.desafiolatam.poo2;

public class Persona {
	protected String rut;
	protected String nombre;
	protected boolean presente;
	
	public Persona(String rut,String nombre,boolean presente) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.rut = rut ;
		this.presente = presente;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}
	
	@Override
	public String toString() {
		return "Persona [rut=" + rut + 
				", nombre=" + nombre + 
				", presente=" + presente + 
				"]";
	}
	
}
