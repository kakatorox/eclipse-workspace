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

import cl.desafiolatam.trazap.app.delegate.ProveedoresDelegate;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProveedoresRequest;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {
	@Autowired
	private ProveedoresDelegate proveedoresDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getProveedores(){
		return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.findAll(), HttpStatus.OK);
	}

	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveProveedor(@RequestBody ProveedoresRequest proveedoresRequest){
		return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.save(proveedoresRequest), HttpStatus.OK);
	}
	
	@PutMapping(
				path="{idProveedor}",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> updateProveedores(@PathVariable int idProveedor, @RequestBody ProveedoresRequest proveedoresRequest){
		return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.update(idProveedor,proveedoresRequest), HttpStatus.OK);
	}
	
	@DeleteMapping(
				path = "{idProveedor}",
				produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> deleteProveedor(@PathVariable int idProveedor){
		return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.delete(idProveedor), HttpStatus.OK);
	}
}
