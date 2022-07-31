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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", catalog = "productos")
@SequenceGenerator(name = "productos_id_producto_seq", initialValue = 1,allocationSize = 1,sequenceName = "productos_id_producto_seq")
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_id_producto_seq")
	@Column(name = "id_producto")
	private int idProducto;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@JoinColumn(name = "categoria_producto_id")
	@ManyToOne
	private CategoriaProducto categoriaProducto;
	
	@JoinColumn(name = "tipo_producto_id")
	@ManyToOne
	private TipoProducto tipoProducto;
	
	
}
