package cl.desafiolatam.holamundoform.app.ui.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
public class Persona {
	private String rut;
	private String nombre;
	private String apellido;
	@Autowired
	private Direccion direccion;
	
	
	
	
	
}
