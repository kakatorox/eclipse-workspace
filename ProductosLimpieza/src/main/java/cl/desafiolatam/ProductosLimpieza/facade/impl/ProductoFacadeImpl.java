package cl.desafiolatam.ProductosLimpieza.facade.impl;

import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;
import cl.desafiolatam.ProductosLimpieza.dto.CategoriaDto;
import cl.desafiolatam.ProductosLimpieza.dto.ProductoDto;
import cl.desafiolatam.ProductosLimpieza.facade.ProductoFacade;
import cl.desafiolatam.ProductosLimpieza.service.ProductoService;
import cl.desafiolatam.ProductosLimpieza.service.impl.ProductoServiceImpl;

public class ProductoFacadeImpl implements ProductoFacade{

	private ProductoService prodService;

	public ProductoFacadeImpl() {
		super();
		this.prodService = new ProductoServiceImpl();
	}
	
	@Override
	public ProductoDto getProductos() {
		return this.prodService.getProducto();
	}
	
	@Override
	public ProductoDto deleteProducto(int idProd) {
		
		ProductoDto prodDto = new ProductoDto();
		
		int res =  prodService.deleteProd(idProd);
		
		if(res == 1) {
			prodDto.setMensaje("Producto Borrado");			
		}else if (res == 0) {
			prodDto.setMensaje("Producto No Borrado");
		}else {
			prodDto.setMensaje("No Realizo Nada falla");
		}
		
		return prodDto;
	}
	
	@Override
	public ProductoDto updateProducto(Producto prod) {
		
		ProductoDto prodDto = new ProductoDto();
		
		int res =  prodService.updateProd(prod);
		
		if(res == 1) {
			prodDto.setMensaje("Producto Actualizado");			
		}else if (res == 0) {
			prodDto.setMensaje("Producto No Actualizado");
		}else {
			prodDto.setMensaje("No Realizo Nada falla");
		}
		
		return prodDto;
	}
	
	@Override
	public ProductoDto createProducto(Producto prod) {
		
		ProductoDto prodDto = new ProductoDto();
		
		int res =  prodService.createProd(prod);
		
		if(res == 1) {
			prodDto.setMensaje("Producto Creado");			
		}else if (res == 0) {
			prodDto.setMensaje("Producto No Creado");
		}else {
			prodDto.setMensaje("No Realizo Nada falla");
		}
		
		return prodDto;
	}
}
