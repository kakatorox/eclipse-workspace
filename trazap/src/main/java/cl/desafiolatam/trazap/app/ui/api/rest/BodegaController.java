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

import cl.desafiolatam.trazap.app.delegate.BodegaDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

@RestController
@RequestMapping("/ws/bodegas")
public class BodegaController {
	
	@Autowired
	private BodegaDelegate bodegaDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getBodegas() {
		
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.findAll(), HttpStatus.OK);
	}

	@GetMapping(
				path = "{idBodega}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<ResponseServiceObject> getBodega(@PathVariable Integer idBodega) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.findById(idBodega), HttpStatus.OK);
	}
	
	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveBodega(@RequestBody BodegaRequest bodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.save(bodegaRequest), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResponseServiceObject> updateBodegas(@RequestBody BodegaRequest bodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.update(bodegaRequest), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseServiceObject> deleteBodegas(@RequestBody BodegaRequest bodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.delete(bodegaRequest.getIdBodega()), HttpStatus.OK);
	}
//	@DeleteMapping
//	public ResponseEntity<ResponseServiceObject> deleteBodegas(@RequestParam(value ="idBodega") int idBodega){
//		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.delete(idBodega), HttpStatus.OK);
//	}
//	@DeleteMapping("{idBodega}")
//	public ResponseEntity<ResponseServiceObject> deleteBodegas(@PathVariable("idBodega") int idBodega){
//		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.delete(idBodega), HttpStatus.OK);
//	}
}
