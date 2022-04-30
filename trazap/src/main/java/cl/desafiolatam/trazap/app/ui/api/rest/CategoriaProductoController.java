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
import cl.desafiolatam.trazap.app.delegate.CategoriaProductoDelegate;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.CategoriaProductoRequest;

@RestController
@RequestMapping("/categoriaProducto")
public class CategoriaProductoController {
	@Autowired
	private CategoriaProductoDelegate categoriaProductoDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getCategoriaProductos(){
		return new ResponseEntity<ResponseServiceObject>(categoriaProductoDelegate.findAll(), HttpStatus.OK);
	}

	@PostMapping(
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> saveCategoriaProducto(@RequestBody CategoriaProductoRequest categoriaProductoRequest){
		return new ResponseEntity<ResponseServiceObject>(categoriaProductoDelegate.save(categoriaProductoRequest), HttpStatus.OK);
	}
	
	@PutMapping(
				path="{idCategoriaProducto}",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> updateCategoriaProducto(@PathVariable int idCategoriaProducto, @RequestBody CategoriaProductoRequest categoriaProductoRequest){
		return new ResponseEntity<ResponseServiceObject>(categoriaProductoDelegate.update(idCategoriaProducto,categoriaProductoRequest), HttpStatus.OK);
	}
	
	@DeleteMapping(
				path = "{idCategoriaProducto}",
				produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseServiceObject> deleteCategoriaProducto(@PathVariable int idCategoriaProducto){
		return new ResponseEntity<ResponseServiceObject>(categoriaProductoDelegate.delete(idCategoriaProducto), HttpStatus.OK);
	}
}
