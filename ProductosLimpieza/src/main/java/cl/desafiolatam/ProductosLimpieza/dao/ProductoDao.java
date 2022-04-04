package cl.desafiolatam.ProductosLimpieza.dao;

import java.util.HashSet;
import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;
import cl.desafiolatam.ProductosLimpieza.dto.ProductoDto;

public interface ProductoDao {

	List<Producto> getAllProductos();

	int deleteProducto(int idProd);

	int createProducto(String nombreProducto, int precioProducto, String descripcionProducto, int id_categoria);

	int updateProducto(int idProducto, String nombreProducto, int precioProducto, String descripcionProducto,
			int id_categoria);

}
