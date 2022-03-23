package cl.desafiolatam.dto;

import cl.desafiolatam.model.Users;

public class UsuarioDTO {
	private Users usuarioConectado;
	private String mensaje;
	private boolean isConectado;

	public Users getUsuarioConectado() {
		return usuarioConectado;
	}

	public void setUsuarioConectado(Users usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isConectado() {
		return isConectado;
	}

	public void setConectado(boolean isConectado) {
		this.isConectado = isConectado;
	}
	
	
	
	
}
