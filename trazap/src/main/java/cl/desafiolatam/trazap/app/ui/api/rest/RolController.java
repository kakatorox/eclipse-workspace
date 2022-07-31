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

import cl.desafiolatam.trazap.app.delegate.RolDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.RolRequest;

@RestController
@RequestMapping("/ws/rol")
public class RolController {
	
	@Autowired
	private RolDelegate rolDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getRols() {
		
		return new ResponseEntity<ResponseServiceObject>(rolDelegate.findAll(), HttpStatus.OK);
	}

	@GetMapping(
				path = "{idRol}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getRol(@PathVariable Integer idRol) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(rolDelegate.findById(idRol), HttpStatus.OK);
	}
	
	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveRol(@RequestBody RolRequest rolRequest){
		return new ResponseEntity<ResponseServiceObject>(rolDelegate.save(rolRequest), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResponseServiceObject> updateRol(@RequestBody RolRequest rolRequest){
		return new ResponseEntity<ResponseServiceObject>(rolDelegate.update(rolRequest), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseServiceObject> deleteRol(@RequestBody RolRequest rolRequest){
		return new ResponseEntity<ResponseServiceObject>(rolDelegate.delete(rolRequest.getIdRols()), HttpStatus.OK);
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
