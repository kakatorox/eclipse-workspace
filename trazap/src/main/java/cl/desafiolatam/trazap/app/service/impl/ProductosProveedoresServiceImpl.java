package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolata.trazap.app.messagemanager.MessageManager;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.repository.DetallePedidoRepository;
import cl.desafiolatam.trazap.app.repository.ProductosProveedoresRepository;
import cl.desafiolatam.trazap.app.repository.model.DetallePedido;
import cl.desafiolatam.trazap.app.repository.model.Pedido;
import cl.desafiolatam.trazap.app.repository.model.Productos;
import cl.desafiolatam.trazap.app.repository.model.ProductosProveedores;
import cl.desafiolatam.trazap.app.repository.model.Proveedores;
import cl.desafiolatam.trazap.app.service.ProductosProveedoresService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.DetallePedidoRequest;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosProveedoresRequest;

@Service("productosProveedoresService")
public class ProductosProveedoresServiceImpl implements ProductosProveedoresService {
	@Autowired
	private ProductosProveedoresRepository productosProveedoresRepository;
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
		List<ProductosProveedores> productosProveedores = new ArrayList<ProductosProveedores>();
		Iterable<ProductosProveedores> itProductosProveedores = productosProveedoresRepository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itProductosProveedores.forEach(productosProveedores::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(productosProveedores);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(ProductosProveedoresRequest productosProveedoresRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				
				ProductosProveedores productosProveedores = new ProductosProveedores();
				Pedido pedido = new Pedido();
				Productos productos = new Productos();
				Proveedores proveedores = new Proveedores();
				productos.setIdProducto(productosProveedoresRequest.getProductoId());
				proveedores.setIdProveedor(productosProveedoresRequest.getProveedorId());
				productosProveedores.setIdProductosProveedores(productosProveedoresRequest.getIdProductoProveedor());
				productosProveedores.setProductos(productos);
				productosProveedores.setProveedores(proveedores);
				
				responseServiceObject.setBody(productosProveedoresRepository.save(productosProveedores));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject update(int idProductosProveedores, ProductosProveedoresRequest productosProveedoresRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		ProductosProveedores productosProveedores = new ProductosProveedores();
		Pedido pedido = new Pedido();
		Productos productos = new Productos();
		Proveedores proveedores = new Proveedores();
		productos.setIdProducto(productosProveedoresRequest.getProductoId());
		proveedores.setIdProveedor(productosProveedoresRequest.getProveedorId());
		productosProveedores.setIdProductosProveedores(idProductosProveedores);
		productosProveedores.setProductos(productos);
		productosProveedores.setProveedores(proveedores);
		
		responseServiceObject.setBody(productosProveedoresRepository.save(productosProveedores));
				
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idProductosProveedores) throws ServiceException{
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			ProductosProveedores productosProveedores =productosProveedoresRepository.findById(idProductosProveedores).get();
			
			responseServiceObject.setBody(productosProveedores);
			
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
	public ResponseServiceObject delete(int idProductosProveedores) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		productosProveedoresRepository.deleteById(idProductosProveedores);
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Borrado");
		
		Iterable<ProductosProveedores> itProductosProveedores = productosProveedoresRepository.findAll();
		List<ProductosProveedores> productosProveedores = new ArrayList<ProductosProveedores>();
		//se agrega a it de tipo iterable con el for each  las bodegas
		itProductosProveedores.forEach(productosProveedores::add);
		
		responseServiceObject.setBody(productosProveedores);
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
}
