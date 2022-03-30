package cl.desafiolatam.ProductosLimpieza.dao;

import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;

public interface CategoriaDao {

	List<Categoria> getAllCategorias();

	int deleteCategoria(int idCat);

	int updateCategoria(int idCat, String nombreCat);

	int createCategoria(int idCat, String nombreCat);

}
