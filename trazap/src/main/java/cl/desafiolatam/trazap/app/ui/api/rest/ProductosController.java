package cl.desafiolatam.trazap.app.ui.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.trazap.app.delegate.ProductosDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosRequest;

@RestController
@RequestMapping("/ws/productos")
public class ProductosController {
	@Autowired
	private ProductosDelegate productosDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getProductos() {
		
		return new ResponseEntity<ResponseServiceObject>(productosDelegate.findAll(), HttpStatus.OK);
	}

	@GetMapping(
				path ="{idProducto}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<ResponseServiceObject> getProducto(@PathVariable Integer idProducto) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(productosDelegate.findById(idProducto), HttpStatus.OK);
	}
	
	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveProducto(@RequestBody ProductosRequest productosRequest){
		return new ResponseEntity<ResponseServiceObject>(productosDelegate.save(productosRequest), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResponseServiceObject> updateProducto(@RequestBody ProductosRequest productosRequest){
		return new ResponseEntity<ResponseServiceObject>(productosDelegate.update(productosRequest), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseServiceObject> deleteProducto(@RequestBody ProductosRequest productosRequest){
		return new ResponseEntity<ResponseServiceObject>(productosDelegate.delete(productosRequest.getIdProducto()), HttpStatus.OK);
	}
	
}
