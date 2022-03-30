package cl.desafiolatam.ProductosLimpieza.facade.impl;

import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;
import cl.desafiolatam.ProductosLimpieza.dto.CategoriaDto;
import cl.desafiolatam.ProductosLimpieza.facade.CategoriaFacade;
import cl.desafiolatam.ProductosLimpieza.service.CategoriaService;
import cl.desafiolatam.ProductosLimpieza.service.impl.CategoriaServiceImpl;

public class CategoriaFacadeImpl implements CategoriaFacade{
		
	private CategoriaService catService;

	public CategoriaFacadeImpl() {
		super();
		this.catService = new CategoriaServiceImpl();
	}
	
	@Override
	public CategoriaDto getCategorias(){
		return this.catService.getCategorias();
	}
	
	@Override
	public CategoriaDto deleteCategoria(int idCat) {
	
		CategoriaDto catDto = new CategoriaDto();
		
		int res =  catService.deleteCat(idCat);
		
		if(res == 1) {
			catDto.setMensaje("Categoria Borrada");			
		}else if (res == 0) {
			catDto.setMensaje("Categoria No Borrada");
		}else {
			catDto.setMensaje("No Realizo Nada falla");
		}
		
		return catDto;
	}
	
	@Override
	public CategoriaDto updateCategoria(Categoria cat) {
		
		CategoriaDto catDto = new CategoriaDto();
		
		int res =  catService.updateCat(cat);
		
		if(res == 1) {
			catDto.setMensaje("Categoria Actualizada");			
		}else if (res == 0) {
			catDto.setMensaje("Categoria No Actualizada");
		}else {
			catDto.setMensaje("No Realizo Nada falla");
		}
		
		return catDto;
	}
	
	@Override
	public CategoriaDto createCategoria(Categoria cat) {
		
		CategoriaDto catDto = new CategoriaDto();
		
		int res =  catService.createCat(cat);
		
		if(res == 1) {
			catDto.setMensaje("Categoria Creada");			
		}else if (res == 0) {
			catDto.setMensaje("Categoria No Creada");
		}else {
			catDto.setMensaje("No Realizo Nada falla");
		}
		
		return catDto;
	}

}
