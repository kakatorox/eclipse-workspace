package cl.desafiolatam.dancingwiththedead.app.ui.api.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.dancingwiththedead.app.ui.model.request.DeadRequest;
import cl.desafiolatam.dancingwiththedead.app.ui.model.response.DeadResponse;

@RestController
@RequestMapping("/deadAppoinment")
public class DeadController {
	/*GET, POT, PUT, DELETE*/
	private Map<String, DeadResponse> dead;
	private List<DeadResponse> deadlList;
	
//	Con este metodo se hacen las api inmmeriatamnete
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<DeadResponse>> getMateriales() {

		if (dead == null) {
			return new ResponseEntity<ArrayList<DeadResponse>> (HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<ArrayList<DeadResponse>> ( (ArrayList<DeadResponse>) this.deadlList,HttpStatus.OK);
		}			
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public ResponseEntity<DeadResponse> createMaterial(@RequestBody DeadRequest deadRequest){
		
		DeadResponse deadResponse = new DeadResponse();
		deadResponse.setPrecio(deadRequest.getPrecio());
		deadResponse.setNombre(deadRequest.getNombre());
		deadResponse.setBodega(deadRequest.getBodega());
		deadResponse.setFechaIngreso(deadRequest.getFechaIngreso());
		
		String deadId = UUID.randomUUID().toString();
		deadResponse.setDeadID(deadId);
		
		if (this.dead == null) {
			this.dead = new HashMap<String, DeadResponse>();
			this.deadlList = new ArrayList<DeadResponse>();
		}		
		dead.put(deadId, deadResponse);
		deadlList.add(deadResponse);
		
		
		return new ResponseEntity<DeadResponse>(deadResponse, HttpStatus.CREATED);
		
	}
	
	@PutMapping(
			path="/{idDead}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
		)
	public ResponseEntity<DeadResponse> updateBodegas(@PathVariable String idDead, @RequestBody DeadRequest deadRequest){
		
		if (this.deadlList == null) {
			this.deadlList = new ArrayList<DeadResponse>();
			
			for (DeadResponse deadResponse : deadlList) {
				if (deadResponse.getDeadID().equals(idDead)) {
					System.out.println("Actualizado");
				} 
			}
			
		}	
		return new ResponseEntity<DeadResponse>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{idDead}",method={RequestMethod.DELETE, RequestMethod.GET})
	public ResponseEntity<DeadResponse> deleteBodegas(@PathVariable("idDead") String idDead){
		
		if (this.deadlList == null) {
			this.deadlList = new ArrayList<DeadResponse>();			
		}else {
			for (DeadResponse deadResponse : deadlList) {
				if (idDead.contentEquals(deadResponse.getDeadID())) {
					System.out.println("Borrado");
					
				} 
			}
		}	
		
		return new ResponseEntity<DeadResponse>(HttpStatus.OK);
	}
	
}
