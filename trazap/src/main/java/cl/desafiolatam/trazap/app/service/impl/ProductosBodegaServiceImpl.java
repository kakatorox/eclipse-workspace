package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.messagemanager.MessageManager;
import cl.desafiolatam.trazap.app.repository.ProductosBodegaRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.Productos;
import cl.desafiolatam.trazap.app.repository.model.ProductosBodega;
import cl.desafiolatam.trazap.app.service.ProductosBodegaService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProductosBodegaRequest;

@Service("productosBodegaService")
public class ProductosBodegaServiceImpl implements ProductosBodegaService {
	@Autowired
	private ProductosBodegaRepository productosBodegaRepository;
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
		List<ProductosBodega> productosBodegas = new ArrayList<ProductosBodega>();
		Iterable<ProductosBodega> itProductosBodegas = productosBodegaRepository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itProductosBodegas.forEach(productosBodegas::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(productosBodegas);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(ProductosBodegaRequest productosBodegaRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				ProductosBodega productosBodega = new ProductosBodega();
				Bodega bodega = new Bodega();
				Productos productos = new Productos();
				
				bodega.setIdBodega(productosBodegaRequest.getBodegaId());
				productos.setIdProducto(productosBodegaRequest.getProductoId());
				
				productosBodega.setIdProductoBodega(productosBodegaRequest.getIdProductoBodega());
				productosBodega.setStock(productosBodegaRequest.getStock());
				productosBodega.setBodega(bodega);
				productosBodega.setProductos(productos);
				
				responseServiceObject.setBody(productosBodegaRepository.save(productosBodega));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject update(ProductosBodegaRequest productosBodegaRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		ProductosBodega productosBodega = new ProductosBodega();
		Bodega bodega = new Bodega();
		Productos productos = new Productos();
		
		bodega.setIdBodega(productosBodegaRequest.getBodegaId());
		productos.setIdProducto(productosBodegaRequest.getProductoId());
		
		productosBodega.setIdProductoBodega(productosBodegaRequest.getIdProductoBodega());
		productosBodega.setStock(productosBodegaRequest.getStock());
		productosBodega.setBodega(bodega);
		productosBodega.setProductos(productos);
		
		
		responseServiceObject.setBody(productosBodegaRepository.save(productosBodega));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idProductosBodega) throws ServiceException{
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			ProductosBodega productosBodega =productosBodegaRepository.findById(idProductosBodega).get();
			
			responseServiceObject.setBody(productosBodega);
			
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
	public ResponseServiceObject delete(int idProductosBodega) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		productosBodegaRepository.deleteById(idProductosBodega);
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Borrado");
		
		Iterable<ProductosBodega> itProductosBodega = productosBodegaRepository.findAll();
		List<ProductosBodega> productosBodega = new ArrayList<ProductosBodega>();
		//se agrega a it de tipo iterable con el for each  las bodegas
		itProductosBodega.forEach(productosBodega::add);
		
		responseServiceObject.setBody(productosBodega);
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
}
