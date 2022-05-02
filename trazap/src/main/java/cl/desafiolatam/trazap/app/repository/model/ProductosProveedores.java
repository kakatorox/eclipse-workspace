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
import javax.persistence.ManyToOne;
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
@Table(schema = "public", catalog = "productos_proveedores")
@SequenceGenerator(name = "productos_proveedores_id_producto_proveedor_seq", initialValue = 1,allocationSize = 1,sequenceName = "productos_proveedores_id_producto_proveedor_seq")
public class ProductosProveedores {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_proveedores_id_producto_proveedor_seq")
	@Column(name = "id_productos_proveedores")
	private int idProductosProveedores;
	
	@JoinColumn(name = "proveedores_id")
	@ManyToOne
	private Proveedores proveedores;
	
	@JoinColumn(name = "producto_id")
	@ManyToOne
	private Productos productos;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_detalle_id")
	private List<DetallePedido> detallePedido;
}
