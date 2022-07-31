package cl.desafiolatam.trazap.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", catalog = "users")
@SequenceGenerator(name = "users_id_seq", initialValue = 1,allocationSize = 1,sequenceName = "users_id_seq")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
	@Column(name = "id")
	private int idUsers;

	@Column(name = "email")
	private String email;
		
	@Column(name = "password")
	private String password;
	
	@JoinColumn(name = "rols_id")
	@ManyToOne
	private Rols rols;
}
