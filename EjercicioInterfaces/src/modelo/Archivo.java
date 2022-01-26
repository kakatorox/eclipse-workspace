package modelo;

public abstract class Archivo {

	protected String ruta;
	protected String nombre;

	protected Archivo(String ruta, String nombre) {
		this.ruta = ruta;
		this.nombre = nombre;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
