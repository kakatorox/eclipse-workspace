package cl.desafiolatam.holamundoform.app.ui.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.holamundoform.app.ui.model.Persona;

@Component

public class PersonaDto {
	@Autowired
	private Persona persona;
	private String selecion;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getSelecion() {
		return selecion;
	}

	public void setSelecion(String selecion) {
		this.selecion = selecion;
	}
	
	

}
