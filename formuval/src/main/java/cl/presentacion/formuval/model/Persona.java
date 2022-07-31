package cl.presentacion.formuval.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", catalog = "persona")
@SequenceGenerator(name = "persona_id_seq", initialValue = 1,allocationSize = 1,sequenceName = "persona_id_seq")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_id_seq")
	@Column(name = "id")
	private int idPersona;

	@Column(name = "nombre")
	private String nombre;
		
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "email")
	private String email;
}
