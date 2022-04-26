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
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {
	@Autowired
	private ProveedoresDelegate proveedoresDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getBodegas(){
		return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.findAll(), HttpStatus.OK);
	}

	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveBodega(@RequestBody BodegaRequest bodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.save(bodegaRequest), HttpStatus.OK);
	}
	
	@PutMapping(
				path="{idBodega}",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> updateBodegas(@PathVariable int idBodega, @RequestBody BodegaRequest bodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.save(idBodega,bodegaRequest), HttpStatus.OK);
	}
	
	@DeleteMapping(
				path = "{idBodega}",
				produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> deleteBodegas(@PathVariable int idBodega){
		return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.delete(idBodega), HttpStatus.OK);
	}
}
