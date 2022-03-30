package cl.desafiolatam.ProductosLimpieza.service.impl;

import cl.desafiolatam.ProductosLimpieza.dao.CategoriaDao;
import cl.desafiolatam.ProductosLimpieza.dao.impl.CategoriaDaoImpl;
import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;
import cl.desafiolatam.ProductosLimpieza.dto.CategoriaDto;
import cl.desafiolatam.ProductosLimpieza.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoriaDao catDao;

	public CategoriaServiceImpl() {
		super();
		this.catDao = new CategoriaDaoImpl();
	}
	
	@Override
	public CategoriaDto getCategorias() {
		
		CategoriaDto catDto = new CategoriaDto();
		
		catDto.setCategorias(catDao.getAllCategorias());
		
		return catDto;
	}
	
	@Override
	public int deleteCat(int idCat) {
		return catDao.deleteCategoria(idCat);
	}
	
	@Override
	public int updateCat(Categoria cat) {
		//si se debe hacer alguna transformacion es aca
		return catDao.updateCategoria(cat.getId_categoria(),cat.getNombre_categoria());
	}
	
	@Override
	public int createCat(Categoria cat) {
		//si se debe hacer alguna transformacion es aca
		return  catDao.createCategoria(cat.getId_categoria(),cat.getNombre_categoria());
	}
}
