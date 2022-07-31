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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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