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


import cl.desafiolatam.trazap.app.delegate.TrazabilidadDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.TrazabilidadRequest;

@RestController
@RequestMapping("/ws/trazabilidad")
public class TrazabilidadController {
	@Autowired
	private TrazabilidadDelegate trazabilidadDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getTrazabilidades() {
		
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.findAll(), HttpStatus.OK);
	}

	@GetMapping(
				path ="{idTrazabilidad}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<ResponseServiceObject> getTrazabilidad(@PathVariable Integer idTrazabilidad) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.findById(idTrazabilidad), HttpStatus.OK);
	}
	
	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveTrazabilidad(@RequestBody TrazabilidadRequest trazabilidadRequest){
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.save(trazabilidadRequest), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResponseServiceObject> updateTrazabilidad(@RequestBody TrazabilidadRequest trazabilidadRequest){
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.update(trazabilidadRequest), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseServiceObject> deleteTrazabilidad(@RequestBody TrazabilidadRequest trazabilidadRequest){
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.delete(trazabilidadRequest.getIdTrazabilidad()), HttpStatus.OK);
	}
	
}
