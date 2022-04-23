package cl.desafiolatam.trazap.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", catalog = "tipo_producto")
@SequenceGenerator(name = "tipo_producto_id_tipo_producto_seq", initialValue = 1,allocationSize = 1,sequenceName = "tipo_producto_id_tipo_producto_seq")
public class TipoProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_producto_id_tipo_producto_seq")
	@Column(name = "id_tipo_producto")
	private int idTipoProducto;
	
	@Column(name = "descripcion")
	private String descripcion;
}
