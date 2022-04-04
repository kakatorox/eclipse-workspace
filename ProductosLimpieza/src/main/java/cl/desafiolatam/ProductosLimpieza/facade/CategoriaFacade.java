package cl.desafiolatam.ProductosLimpieza.facade;

import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;
import cl.desafiolatam.ProductosLimpieza.dto.CategoriaDto;

public interface CategoriaFacade {

	CategoriaDto getCategorias();

	CategoriaDto updateCategoria(CategoriaDto categoriaDto);

	CategoriaDto createCategoria(CategoriaDto cat);

	CategoriaDto deleteCategoria(int idCat);


}
