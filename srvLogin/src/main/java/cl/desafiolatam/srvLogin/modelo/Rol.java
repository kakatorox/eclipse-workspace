package cl.desafiolatam.srvLogin.modelo;

public class Rol {

	private String tipo; //Administrador (Admin), (Rol Usuario)
	private String descripcion;//administrador,usuario
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
