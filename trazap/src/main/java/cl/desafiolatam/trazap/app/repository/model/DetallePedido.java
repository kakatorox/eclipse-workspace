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
@Table(schema = "public", catalog = "detalle_pedido")
@SequenceGenerator(name = "detalle_pedido_id_detalle_pedido_seq", initialValue = 1,allocationSize = 1,sequenceName = "detalle_pedido_id_detalle_pedido_seq")
public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_pedido_id_detalle_pedido_seq")
	@Column(name = "id_detalle_pedido")
	private int idDetallePedido;
	
	@JoinColumn(name = "proveedor_producto_id")
	@ManyToOne
	private ProductosProveedores productosProveedores;
	
	@JoinColumn(name = "pedido_id")
	@ManyToOne
	private Pedidos pedido;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	
	
}
