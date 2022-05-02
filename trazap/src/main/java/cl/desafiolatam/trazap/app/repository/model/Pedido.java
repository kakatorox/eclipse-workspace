package cl.desafiolatam.trazap.app.repository.model;

import java.sql.Date;
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
@Table(schema = "public", catalog = "pedidos")
@SequenceGenerator(name = "pedidos_id_pedido_seq", initialValue = 1,allocationSize = 1,sequenceName = "pedidos_id_pedido_seq")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_id_pedido_seq")
	@Column(name = "id_pedido")
	private int idPedido;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name = "fecha_recibido")
	private Date fechaRecibido;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_detalle_id")
	private List<DetallePedido> detallePedido;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "trazabilidad_id")
	private List<Trazabilidad> trazabilidad;
}
