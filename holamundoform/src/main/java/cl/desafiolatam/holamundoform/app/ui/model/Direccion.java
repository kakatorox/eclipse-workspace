package cl.desafiolatam.holamundoform.app.ui.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Direccion {
	@Value("Divinidad")
	private String descripcion;
	@Value("Olimpo")
	private String comuna;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	
}
