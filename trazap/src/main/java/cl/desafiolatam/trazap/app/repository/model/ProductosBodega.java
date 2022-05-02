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
@Table(schema = "public", catalog = "productos_bodega")
@SequenceGenerator(name = "productos_bodega_id_producto_bodega_seq", initialValue = 1,allocationSize = 1,sequenceName = "productos_bodega_id_producto_bodega_seq")
public class ProductosBodega {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_bodega_id_producto_bodega_seq")
	@Column(name = "id_producto_bodega")
	private int idProductoBodega;
	
	@JoinColumn(name = "producto_id")
	@ManyToOne
	private Productos productos;
	
	@JoinColumn(name = "bodega_id")
	@ManyToOne
	private Bodega bodega;
	
	@Column(name = "stock")
	private int stock;
		
}
