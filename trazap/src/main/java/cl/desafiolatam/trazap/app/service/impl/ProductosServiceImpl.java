package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolata.trazap.app.messagemanager.MessageManager;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.repository.ProductosRepository;
import cl.desafiolatam.trazap.app.repository.model.CategoriaProducto;
import cl.desafiolatam.trazap.app.repository.model.Productos;
import cl.desafiolatam.trazap.app.repository.model.TipoProducto;
import cl.desafiolatam.trazap.app.service.ProductosService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosRequest;

@Service("productosService")
public class ProductosServiceImpl implements ProductosService{
	@Autowired
	private ProductosRepository productosRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Autowired
	private MessageManager messageManager;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Productos> productos = new ArrayList<Productos>();
		Iterable<Productos> itProductos = productosRepository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itProductos.forEach(productos::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(productos);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(ProductosRequest productosRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				Productos productos = new Productos();
				CategoriaProducto categoriaProducto = new CategoriaProducto();
				TipoProducto tipoProducto = new TipoProducto();
				categoriaProducto.setIdCategoriaProducto(productosRequest.getCategoriaProductoId());
				tipoProducto.setIdTipoProducto(productosRequest.getTipoProductoId());
				productos.setIdProducto(productosRequest.getIdProducto());
				productos.setDescripcion(productosRequest.getDescripcion());
				productos.setCategoriaProducto(categoriaProducto);
				productos.setTipoProducto(tipoProducto);
				
				
				responseServiceObject.setBody(productosRepository.save(productos));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject update(int idProductos, ProductosRequest productosRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Productos productos = new Productos();
		CategoriaProducto categoriaProducto = new CategoriaProducto();
		TipoProducto tipoProducto = new TipoProducto();
		categoriaProducto.setIdCategoriaProducto(productosRequest.getCategoriaProductoId());
		tipoProducto.setIdTipoProducto(productosRequest.getTipoProductoId());
		productos.setIdProducto(idProductos);
		productos.setDescripcion(productosRequest.getDescripcion());
		productos.setCategoriaProducto(categoriaProducto);
		productos.setTipoProducto(tipoProducto);
		
		
		responseServiceObject.setBody(productosRepository.save(productos));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idProductos) throws ServiceException{
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			Productos productos =productosRepository.findById(idProductos).get();
			
			responseServiceObject.setBody(productos);
			
			responseServiceMessage.setTimestamp(new Date());
			responseServiceMessage.setCode("200");
			responseServiceMessage.setType(ResponseServiceMessageType.OK);
			responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
			messageList.add(responseServiceMessage);
			
			responseServiceObject.setMessageList(messageList);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new ServiceException("No existe ese elemento");
		}catch (Exception e) {
			// TODO: handle exception
			throw new ServiceException("No existe ese elemento");
		}
		return responseServiceObject;
		
	}

	@Override
	public ResponseServiceObject delete(int idProductos) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		productosRepository.deleteById(idProductos);
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Borrado");
		
		Iterable<Productos> itproductos = productosRepository.findAll();
		List<Productos> productos = new ArrayList<Productos>();
		//se agrega a it de tipo iterable con el for each  las bodegas
		itproductos.forEach(productos::add);
		
		responseServiceObject.setBody(productos);
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
}
