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
import cl.desafiolatam.trazap.app.repository.model.DetallePedido;
import cl.desafiolatam.trazap.app.repository.model.Pedido;
import cl.desafiolatam.trazap.app.repository.model.ProductosProveedores;
import cl.desafiolatam.trazap.app.service.DetallePedidoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.DetallePedidoRequest;

@Service("detallePedidoService")
public class DetallePedidoServiceImpl implements DetallePedidoService {
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
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
		List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();
		Iterable<DetallePedido> itDetallePedidos = detallePedidoRepository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itDetallePedidos.forEach(detallePedidos::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(detallePedidos);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(DetallePedidoRequest detallePedidoRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				DetallePedido detallePedido = new DetallePedido();
				Pedido pedido = new Pedido();
				ProductosProveedores productosProveedores = new ProductosProveedores();
				pedido.setIdPedido(detallePedidoRequest.getPedidoId());
				productosProveedores.setIdProductosProveedores(detallePedidoRequest.getProveedorProductoId());
				detallePedido.setIdDetallePedido(detallePedidoRequest.getIdDetallePedido());
				detallePedido.setCantidad(detallePedidoRequest.getCantidad());
				detallePedido.setPedido(pedido);
				detallePedido.setProductosProveedores(productosProveedores);
				
				responseServiceObject.setBody(detallePedidoRepository.save(detallePedido));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject update(int idDetallePedido, DetallePedidoRequest detallePedidoRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		DetallePedido detallePedido = new DetallePedido();
		Pedido pedido = new Pedido();
		ProductosProveedores productosProveedores = new ProductosProveedores();
		pedido.setIdPedido(detallePedidoRequest.getPedidoId());
		productosProveedores.setIdProductosProveedores(detallePedidoRequest.getProveedorProductoId());
		detallePedido.setIdDetallePedido(idDetallePedido);
		detallePedido.setCantidad(detallePedidoRequest.getCantidad());
		detallePedido.setPedido(pedido);
		detallePedido.setProductosProveedores(productosProveedores);
		
		
		responseServiceObject.setBody(detallePedidoRepository.save(detallePedido));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idDetallePedido) throws ServiceException{
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			DetallePedido detallePedido =detallePedidoRepository.findById(idDetallePedido).get();
			
			responseServiceObject.setBody(detallePedido);
			
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
	public ResponseServiceObject delete(int DetallePedido) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		detallePedidoRepository.deleteById(DetallePedido);
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Borrado");
		
		Iterable<DetallePedido> itDetallePedidos = detallePedidoRepository.findAll();
		List<DetallePedido> detallePedido = new ArrayList<DetallePedido>();
		//se agrega a it de tipo iterable con el for each  las bodegas
		itDetallePedidos.forEach(detallePedido::add);
		
		responseServiceObject.setBody(detallePedido);
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
}
