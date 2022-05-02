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


import cl.desafiolatam.trazap.app.delegate.ProductosProveedoresDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosProveedoresRequest;

@RestController
@RequestMapping("/productosProveedores")
public class ProductosProveedoresController {
	@Autowired
	private ProductosProveedoresDelegate productosProveedoresDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getProductosProveedores() {
		
		return new ResponseEntity<ResponseServiceObject>(productosProveedoresDelegate.findAll(), HttpStatus.OK);
	}

	@GetMapping(
				path ="{idProductosProveedores}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<ResponseServiceObject> getProductosProveedor(@PathVariable Integer idProductosProveedores) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(productosProveedoresDelegate.findById(idProductosProveedores), HttpStatus.OK);
	}
	
	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveProductosProveedores(@RequestBody ProductosProveedoresRequest productosProveedoresRequest){
		return new ResponseEntity<ResponseServiceObject>(productosProveedoresDelegate.save(productosProveedoresRequest), HttpStatus.OK);
	}
	
	@PutMapping(
				path="{idProductosProveedores}",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> updateProductosProveedores(@PathVariable int idProductosProveedores, @RequestBody ProductosProveedoresRequest productosProveedoresRequest){
		return new ResponseEntity<ResponseServiceObject>(productosProveedoresDelegate.update(idProductosProveedores,productosProveedoresRequest), HttpStatus.OK);
	}
	
	@DeleteMapping(
				path = "{idProductosProveedores}",
				produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> deleteProductosProveedores(@PathVariable int idProductosProveedores){
		return new ResponseEntity<ResponseServiceObject>(productosProveedoresDelegate.delete(idProductosProveedores), HttpStatus.OK);
	}
	
}
