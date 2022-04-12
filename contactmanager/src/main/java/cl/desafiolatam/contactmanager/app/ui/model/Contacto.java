package cl.desafiolatam.contactmanager.app.ui.model;


import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Contacto {
	
	private int id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion;
	private String telefono;
}
