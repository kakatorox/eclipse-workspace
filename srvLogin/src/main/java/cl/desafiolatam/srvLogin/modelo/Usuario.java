package cl.desafiolatam.srvLogin.modelo;

import java.util.List;

public class Usuario {
	
	private String usuario;
	private String password;
	private String nombreUsuario;
	private List<Rol> listaRoles;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public List<Rol> getListaRoles() {
		return listaRoles;
	}
	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}
	
	
}
