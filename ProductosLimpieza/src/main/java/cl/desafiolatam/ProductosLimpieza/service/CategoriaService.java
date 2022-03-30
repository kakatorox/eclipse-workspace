package cl.desafiolatam.ProductosLimpieza.service;

import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;
import cl.desafiolatam.ProductosLimpieza.dto.CategoriaDto;

public interface CategoriaService {

	public CategoriaDto getCategorias();

	int deleteCat(int idCat);

	int updateCat(Categoria cat);

	int createCat(Categoria cat);

}
