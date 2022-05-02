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

import cl.desafiolatam.trazap.app.delegate.PedidoDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.PedidoRequest;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoDelegate pedidoDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getPedidos() {
		
		return new ResponseEntity<ResponseServiceObject>(pedidoDelegate.findAll(), HttpStatus.OK);
	}

	@GetMapping(
				path ="{idPedido}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<ResponseServiceObject> getPedido(@PathVariable Integer idPedido) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(pedidoDelegate.findById(idPedido), HttpStatus.OK);
	}
	
	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> savePedido(@RequestBody PedidoRequest pedidoRequest){
		return new ResponseEntity<ResponseServiceObject>(pedidoDelegate.save(pedidoRequest), HttpStatus.OK);
	}
	
	@PutMapping(
				path="{idPedido}",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> updatePedido(@PathVariable int idPedido, @RequestBody PedidoRequest pedidoRequest){
		return new ResponseEntity<ResponseServiceObject>(pedidoDelegate.update(idPedido,pedidoRequest), HttpStatus.OK);
	}
	
	@DeleteMapping(
				path = "{idPedido}",
				produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> deletePedido(@PathVariable int idPedido){
		return new ResponseEntity<ResponseServiceObject>(pedidoDelegate.delete(idPedido), HttpStatus.OK);
	}
}
