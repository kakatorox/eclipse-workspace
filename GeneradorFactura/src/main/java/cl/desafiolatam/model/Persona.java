package cl.desafiolatam.model;

public class Persona {

	public String nombreCompleto;
	public String empresa;
	public String rut;
	public String direccion;
	public String ciudad;
	public String pais;
	
	public Persona(String nombreCompleto, String empresa,String rut, String direccion,String ciudad,String pais) {
		// TODO Auto-generated constructor stub
		this.nombreCompleto = nombreCompleto;
		this.empresa = empresa;
		this.rut = rut;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Persona [nombreCompleto=" + nombreCompleto + ", empresa=" + empresa + ", rut=" + rut + ", direccion="
				+ direccion + ", ciudad=" + ciudad + ", pais=" + pais + "]";
	}
	
	
}
