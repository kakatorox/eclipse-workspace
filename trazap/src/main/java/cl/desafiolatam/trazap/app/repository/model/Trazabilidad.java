package cl.desafiolatam.trazap.app.repository.model;

import java.sql.Date;

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
@Table(schema = "public", catalog = "trazabilidad")
@SequenceGenerator(name = "trazabilidad_id_trazabilidad_seq", initialValue = 1,allocationSize = 1,sequenceName = "trazabilidad_id_trazabilidad_seq")
public class Trazabilidad {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trazabilidad_id_trazabilidad_seq")
	@Column(name = "id_trazabilidad")
	private int idTrazabilidad;
	
	@JoinColumn(name = "pedido_id")
	@ManyToOne
	private Pedidos pedido;
	
	@Column(name = "fecha_inicio_preparacion")
	private Date fechaInicioPreparacion;
	
	@Column(name = "fecha_fin_preparacion")
	private Date fechaFinPreparacion;
	
	@Column(name = "fecha_estimada_envio")
	private Date fechaEstimadaEnvio;
	
	@Column(name = "fecha_envio")
	private Date fechaEnvio;
	
	@Column(name = "fecha_recibido")
	private Date fechaRecibido;
	
	@Column(name = "codigo_trazabilidad")
	private String codigoTrazabilidad;
	
	@JoinColumn(name = "trazabilidad_estado_id")
	@ManyToOne
	private EstadoTrazabilidad estadoTrazabilidad;
}
