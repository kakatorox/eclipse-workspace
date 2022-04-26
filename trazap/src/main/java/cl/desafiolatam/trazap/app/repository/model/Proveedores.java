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
@Table(schema = "public", catalog = "proveedores")
@SequenceGenerator(name = "proveedores_id_proveedor_seq", initialValue = 1,allocationSize = 1,sequenceName = "proveedores_id_proveedor_seq")
public class Proveedores {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedores_id_proveedor_seq")
	@Column(name = "id_proveedor")
	private int idProveedor;
	
	@Column(name = "rut_proveedor")
	private String RutProveedor;
	
	@Column(name = "razon_social")
	private String RazonSocial;
}
