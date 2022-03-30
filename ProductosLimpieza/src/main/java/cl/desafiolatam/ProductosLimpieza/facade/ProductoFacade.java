package cl.desafiolatam.ProductosLimpieza.facade;

import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;
import cl.desafiolatam.ProductosLimpieza.dto.ProductoDto;

public interface ProductoFacade {

	ProductoDto getProductos();

	ProductoDto deleteProducto(int idProd);

	ProductoDto updateProducto(Producto prod);

	ProductoDto createProducto(Producto prod);

}
