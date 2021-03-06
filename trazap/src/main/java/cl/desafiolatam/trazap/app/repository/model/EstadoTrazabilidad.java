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
@Table(schema = "public", catalog = "estado_trazabilidad")
@SequenceGenerator(name = "estado_trazabilidad_id_estado_trazabilidad_seq", initialValue = 1,allocationSize = 1,sequenceName = "estado_trazabilidad_id_estado_trazabilidad_seq")
public class EstadoTrazabilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_trazabilidad_id_estado_trazabilidad_seq")
	@Column(name = "id_estado_trazabilidad")
	private int idEstadoTrazabilidad;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "trazabilidad_id")
	private List<Trazabilidad> trazabilidad;
}
