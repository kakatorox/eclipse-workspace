package modelo;

public class Cliente extends HomoSapiens{
	private int edad;

	public Cliente() {
		
	}
	
	public Cliente(String nombre ,String rut ,int edad) {
		super(nombre,rut);
		this.edad=edad;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
