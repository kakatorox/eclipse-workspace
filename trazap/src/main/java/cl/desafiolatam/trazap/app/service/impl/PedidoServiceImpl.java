package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.messagemanager.MessageManager;
import cl.desafiolatam.trazap.app.repository.DetallePedidoRepository;
import cl.desafiolatam.trazap.app.repository.PedidoRepository;
import cl.desafiolatam.trazap.app.repository.model.DetallePedido;
import cl.desafiolatam.trazap.app.repository.model.Pedidos;
import cl.desafiolatam.trazap.app.repository.model.ProductosProveedores;
import cl.desafiolatam.trazap.app.service.PedidoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.DetallePedidoRequest;
import cl.desafiolatam.trazap.app.ui.model.request.PedidoRequest;

@Service("pedidoService")
public class PedidoServiceImpl implements PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
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
		List<Pedidos> pedidos = new ArrayList<Pedidos>();
		Iterable<Pedidos> itPedidos = pedidoRepository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itPedidos.forEach(pedidos::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(pedidos);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(PedidoRequest pedidoRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				
				Pedidos pedido = new Pedidos();
								
				pedido.setIdPedido(pedidoRequest.getIdPedido());
				pedido.setFechaIngreso(pedidoRequest.getFechaIngreso());
				pedido.setFechaRecibido(pedidoRequest.getFechaRecibido());
				
				
				responseServiceObject.setBody(pedidoRepository.save(pedido));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject update(PedidoRequest pedidoRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Pedidos pedido = new Pedidos();
		
		pedido.setIdPedido(pedidoRequest.getIdPedido());
		pedido.setFechaIngreso(pedidoRequest.getFechaIngreso());
		pedido.setFechaRecibido(pedidoRequest.getFechaRecibido());
		
		
		
		responseServiceObject.setBody(pedidoRepository.save(pedido));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idPedido) throws ServiceException{
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			Pedidos pedido =pedidoRepository.findById(idPedido).get();
			
			responseServiceObject.setBody(pedido);
			
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
	public ResponseServiceObject delete(int idPedido) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		pedidoRepository.deleteById(idPedido);
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Borrado");
		
		Iterable<Pedidos> itPedidos = pedidoRepository.findAll();
		List<Pedidos> pedidos = new ArrayList<Pedidos>();
		//se agrega a it de tipo iterable con el for each  las bodegas
		itPedidos.forEach(pedidos::add);
		
		responseServiceObject.setBody(pedidos);
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
}
