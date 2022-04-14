package cl.desafiolatam.contactmanager.app.ui.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.contactmanager.app.ui.model.Contacto;

@Component
public class ContactoDto {
	@Autowired
	private Contacto contacto;
	private String seleccion;
	private String mensaje;

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto persona) {
		this.contacto = persona;
	}
	
	public void setIdContacto(int i) {
		this.contacto.setId(i);
	}
	
	public int getIdContacto() {
		return this.contacto.getId();
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String selecion) {
		this.seleccion = selecion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
