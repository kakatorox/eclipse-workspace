package modelo;

public class Vendedor extends HomoSapiens{

	private String direccion;
	
	
	public Vendedor() {
		// TODO Auto-generated constructor stub
	}
	
	public Vendedor(String nombre,  String rut, String direccion) {
		super(nombre,rut);
		this.direccion=direccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}
