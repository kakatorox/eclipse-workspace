package cl.desafiolatam.trazap.app.repository.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", catalog = "rols")
@SequenceGenerator(name = "rols_id_seq", initialValue = 1,allocationSize = 1,sequenceName = "rols_id_seq")
public class Rols {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rols_id_seq")
	@Column(name = "id")
	private int idRols;

	@Column(name = "descripcion")
	private String descripcion;
	
	
}
