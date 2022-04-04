package cl.desafiolatam.ProductosLimpieza.dao;

import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;

public interface CategoriaDao {

	List<Categoria> getAllCategorias();

	int deleteCategoria(int idCat);

	int updateCategoria(Categoria cate);

	int createCategoria(String nombreCat);

}
