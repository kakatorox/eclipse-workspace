package cl.desafiolatam.ProductosLimpieza.service;

import cl.desafiolatam.ProductosLimpieza.dao.model.Producto;
import cl.desafiolatam.ProductosLimpieza.dto.ProductoDto;

public interface ProductoService {

	ProductoDto getProducto();

	int deleteProd(int idProd);

	int updateProd(Producto prod);

	int createProd(Producto prod);

}
