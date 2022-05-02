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

import cl.desafiolatam.trazap.app.delegate.DetallePedidoDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.DetallePedidoRequest;

@RestController
@RequestMapping("/detallePedido")
public class DetallePedidoController {
	@Autowired
	private DetallePedidoDelegate detallePedidoDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getDetallePedidos() {
		
		return new ResponseEntity<ResponseServiceObject>(detallePedidoDelegate.findAll(), HttpStatus.OK);
	}

	@GetMapping(
				path ="{idDetallePedido}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<ResponseServiceObject> getDetallePedido(@PathVariable Integer idDetallePedido) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(detallePedidoDelegate.findById(idDetallePedido), HttpStatus.OK);
	}
	
	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveDetallePedido(@RequestBody DetallePedidoRequest detallePedidoRequest){
		return new ResponseEntity<ResponseServiceObject>(detallePedidoDelegate.save(detallePedidoRequest), HttpStatus.OK);
	}
	
	@PutMapping(
				path="{idDetallePedido}",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> updateDetallePedido(@PathVariable int idDetallePedido, @RequestBody DetallePedidoRequest detallePedidoRequest){
		return new ResponseEntity<ResponseServiceObject>(detallePedidoDelegate.update(idDetallePedido,detallePedidoRequest), HttpStatus.OK);
	}
	
	@DeleteMapping(
				path = "{idDetallePedido}",
				produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> deleteDetallePedido(@PathVariable int idDetallePedido){
		return new ResponseEntity<ResponseServiceObject>(detallePedidoDelegate.delete(idDetallePedido), HttpStatus.OK);
	}
	
}
