package cl.desafiolatam.spsecurityex.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(schema = "public", catalog = "usuario")
@SequenceGenerator(name = "usuario_id_usuario_seq", initialValue = 1,allocationSize = 1,sequenceName = "usuario_id_usuario_seq")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_usuario_seq")
	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "id_rol")
	private Rol rol;
}
