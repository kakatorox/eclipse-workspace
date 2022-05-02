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

import cl.desafiolatam.trazap.app.delegate.ProductosBodegaDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosBodegaRequest;

@RestController
@RequestMapping("/productosBodega")
public class ProductosBodegaController {
	@Autowired
	private ProductosBodegaDelegate productosBodegaDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getProductosBodegas() {
		
		return new ResponseEntity<ResponseServiceObject>(productosBodegaDelegate.findAll(), HttpStatus.OK);
	}

	@GetMapping(
				path ="{idProductoBodega}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<ResponseServiceObject> getProductosBodega(@PathVariable Integer idProductoBodega) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(productosBodegaDelegate.findById(idProductoBodega), HttpStatus.OK);
	}
	
	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveProductosBodega(@RequestBody ProductosBodegaRequest productosBodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(productosBodegaDelegate.save(productosBodegaRequest), HttpStatus.OK);
	}
	
	@PutMapping(
				path="{idProductoBodega}",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> updateProductosBodega(@PathVariable int idProductoBodega, @RequestBody ProductosBodegaRequest productosBodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(productosBodegaDelegate.update(idProductoBodega,productosBodegaRequest), HttpStatus.OK);
	}
	
	@DeleteMapping(
				path = "{idProductoBodega}",
				produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> deleteProductosBodega(@PathVariable int idProductoBodega){
		return new ResponseEntity<ResponseServiceObject>(productosBodegaDelegate.delete(idProductoBodega), HttpStatus.OK);
	}
	
}
