package cl.desafiolatam.ProductosLimpieza.dao;

import java.util.HashSet;
import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;

public interface ProductoDao {

	List<Producto> getAllProductos();

	int updateProducto(int idProducto, String nomProd, int precioProd, String desProd, int idCat);

	int deleteProducto(int idProd);

	int createProducto(String nomProd, int precioProd, String desProd, int idCat);

}
