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

import cl.desafiolatam.trazap.app.delegate.EstadoTrazabilidadDelegate;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

import cl.desafiolatam.trazap.app.ui.model.request.EstadoTrazabilidadRequest;

@RestController
@RequestMapping("/ws/estadoTrazabilidad")
public class EstadoTrazabilidadController {
	@Autowired
	private EstadoTrazabilidadDelegate estadoTrazabilidadDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getEstadoTrazabilidades(){
		return new ResponseEntity<ResponseServiceObject>(estadoTrazabilidadDelegate.findAll(), HttpStatus.OK);
	}

	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveEstadoTrazabilidad(@RequestBody EstadoTrazabilidadRequest estadoTrazabilidadRequest){
		return new ResponseEntity<ResponseServiceObject>(estadoTrazabilidadDelegate.save(estadoTrazabilidadRequest), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResponseServiceObject> updateEstadoTrazabilidades(@RequestBody EstadoTrazabilidadRequest estadoTrazabilidadRequest){
		return new ResponseEntity<ResponseServiceObject>(estadoTrazabilidadDelegate.update(estadoTrazabilidadRequest), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseServiceObject> deleteEstadoTrazabilidad(@RequestBody EstadoTrazabilidadRequest estadoTrazabilidadRequest){
		return new ResponseEntity<ResponseServiceObject>(estadoTrazabilidadDelegate.delete(estadoTrazabilidadRequest.getIdEstadoTrazabilidad()), HttpStatus.OK);
	}
}
