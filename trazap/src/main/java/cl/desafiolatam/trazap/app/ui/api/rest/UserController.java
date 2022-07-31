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
import cl.desafiolatam.trazap.app.delegate.UserDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.UserRequest;

@RestController
@RequestMapping("/ws/user")
public class UserController {
	
	@Autowired
	private UserDelegate userDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getUsers() {
		
		return new ResponseEntity<ResponseServiceObject>(userDelegate.findAll(), HttpStatus.OK);
	}

	@GetMapping(
				path = "{idUser}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<ResponseServiceObject> getUser(@PathVariable Integer idUser) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(userDelegate.findById(idUser), HttpStatus.OK);
	}
	
	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveUser(@RequestBody UserRequest userRequest){
		return new ResponseEntity<ResponseServiceObject>(userDelegate.save(userRequest), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResponseServiceObject> updateUser(@RequestBody UserRequest userRequest){
		return new ResponseEntity<ResponseServiceObject>(userDelegate.update(userRequest), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseServiceObject> deleteBodegas(@RequestBody UserRequest userRequest){
		return new ResponseEntity<ResponseServiceObject>(userDelegate.delete(userRequest.getIdUsers()), HttpStatus.OK);
	}

}
