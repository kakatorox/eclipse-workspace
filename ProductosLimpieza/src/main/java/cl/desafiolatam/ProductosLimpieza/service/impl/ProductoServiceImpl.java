package cl.desafiolatam.ProductosLimpieza.service.impl;

import java.util.List;

import cl.desafiolatam.ProductosLimpieza.dao.ProductoDao;
import cl.desafiolatam.ProductosLimpieza.dao.impl.ProductoDaoImpl;
import cl.desafiolatam.ProductosLimpieza.dao.model.Categoria;
import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;
import cl.desafiolatam.ProductosLimpieza.dto.CategoriaDto;
import cl.desafiolatam.ProductosLimpieza.dto.ProductoDto;
import cl.desafiolatam.ProductosLimpieza.service.ProductoService;

public class ProductoServiceImpl implements ProductoService{

	private ProductoDao prodDao;

	public ProductoServiceImpl() {
		super();
		this.prodDao = new ProductoDaoImpl();
	}
	
	@Override
	public ProductoDto getProducto() {
		
		ProductoDto prodDto = new ProductoDto();
		
		prodDto.setProductos(prodDao.getAllProductos());
		
		return prodDto;
	}
	
	@Override
	public int deleteProd(int idProd) {
		return prodDao.deleteProducto(idProd);
	}
	
	@Override
	public int updateProd(ProductoDto prod) {
		//si se debe hacer alguna transformacion es aca
		Producto producto = new Producto();
		producto = prod.getProductos().get(0);
		return prodDao.updateProducto(producto.getIdProducto(),
										producto.getNombreProducto(),
										producto.getPrecioProducto(),
										producto.getDescripcionProducto(),
										producto.getCategoria().getId_categoria());
	}
	
	@Override
	public int createProd(ProductoDto prod) {
		//si se debe hacer alguna transformacion es aca
		Producto producto = new Producto();
		producto = prod.getProductos().get(0);
		return  prodDao.createProducto(producto.getNombreProducto(),
										producto.getPrecioProducto(),
										producto.getDescripcionProducto(),
										producto.getCategoria().getId_categoria());
	}
	
	
}
