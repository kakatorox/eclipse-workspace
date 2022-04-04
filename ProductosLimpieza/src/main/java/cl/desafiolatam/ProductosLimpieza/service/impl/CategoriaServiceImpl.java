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
	public int updateCat(CategoriaDto cat) {
		//si se debe hacer alguna transformacion es aca
		Categoria cate = new Categoria();
		cate = cat.getCategoria().get(0);
		return catDao.updateCategoria(cate);
	}
	
	@Override
	public int createCat(CategoriaDto cat) {
		//si se debe hacer alguna transformacion es aca
		Categoria cate = new Categoria();
		cate = cat.getCategoria().get(0);
		return  catDao.createCategoria(cate.getNombre_categoria());
	}
}
