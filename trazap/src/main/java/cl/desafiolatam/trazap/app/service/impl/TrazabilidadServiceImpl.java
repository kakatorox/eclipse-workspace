package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolata.trazap.app.messagemanager.MessageManager;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.repository.TrazabilidadRepository;
import cl.desafiolatam.trazap.app.repository.model.EstadoTrazabilidad;
import cl.desafiolatam.trazap.app.repository.model.Pedido;
import cl.desafiolatam.trazap.app.repository.model.Trazabilidad;
import cl.desafiolatam.trazap.app.service.TrazabilidadService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.TrazabilidadRequest;

@Service("trazabilidadService")
public class TrazabilidadServiceImpl implements TrazabilidadService{
	@Autowired
	private TrazabilidadRepository trazabilidadRepository;
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
		List<Trazabilidad> trazabilidad = new ArrayList<Trazabilidad>();
		Iterable<Trazabilidad> itTrazabilidad = trazabilidadRepository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itTrazabilidad.forEach(trazabilidad::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(trazabilidad);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(TrazabilidadRequest trazabilidadRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				Trazabilidad trazabilidad = new Trazabilidad();
				Pedido pedido = new Pedido();
				EstadoTrazabilidad estadoTrazabilidad = new EstadoTrazabilidad();
				estadoTrazabilidad.setIdEstadoTrazabilidad(trazabilidadRequest.getTrazabilidadEstadoId());
				pedido.setIdPedido(trazabilidadRequest.getPedidoId());
				trazabilidad.setIdTrazabilidad(trazabilidadRequest.getIdTrazabilidad());
				trazabilidad.setPedido(pedido);
				trazabilidad.setFechaInicioPreparacion(trazabilidadRequest.getFechaInicioPreparacion());
				trazabilidad.setFechaFinPreparacion(trazabilidadRequest.getFechaFinPreparacion());
				trazabilidad.setFechaEstimadaEnvio(trazabilidadRequest.getFechaEstimadaEnvio());
				trazabilidad.setFechaEnvio(trazabilidadRequest.getFechaEnvio());
				trazabilidad.setFechaRecibido(trazabilidadRequest.getFechaRecibido());
				trazabilidad.setCodigoTrazabilidad(trazabilidadRequest.getCodigoTrazabilidad());
				trazabilidad.setEstadoTrazabilidad(estadoTrazabilidad);
				
				responseServiceObject.setBody(trazabilidadRepository.save(trazabilidad));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject update(int idTrazabilidad, TrazabilidadRequest trazabilidadRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Trazabilidad trazabilidad = new Trazabilidad();
		Pedido pedido = new Pedido();
		EstadoTrazabilidad estadoTrazabilidad = new EstadoTrazabilidad();
		estadoTrazabilidad.setIdEstadoTrazabilidad(trazabilidadRequest.getTrazabilidadEstadoId());
		pedido.setIdPedido(trazabilidadRequest.getPedidoId());
		trazabilidad.setIdTrazabilidad(idTrazabilidad);
		trazabilidad.setPedido(pedido);
		trazabilidad.setFechaInicioPreparacion(trazabilidadRequest.getFechaInicioPreparacion());
		trazabilidad.setFechaFinPreparacion(trazabilidadRequest.getFechaFinPreparacion());
		trazabilidad.setFechaEstimadaEnvio(trazabilidadRequest.getFechaEstimadaEnvio());
		trazabilidad.setFechaEnvio(trazabilidadRequest.getFechaEnvio());
		trazabilidad.setFechaRecibido(trazabilidadRequest.getFechaRecibido());
		trazabilidad.setCodigoTrazabilidad(trazabilidadRequest.getCodigoTrazabilidad());
		trazabilidad.setEstadoTrazabilidad(estadoTrazabilidad);
		
		responseServiceObject.setBody(trazabilidadRepository.save(trazabilidad));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idTrazabilidad) throws ServiceException{
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			Trazabilidad trazabilidad =trazabilidadRepository.findById(idTrazabilidad).get();
			
			responseServiceObject.setBody(trazabilidad);
			
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
	public ResponseServiceObject delete(int idTrazabilidad) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		trazabilidadRepository.deleteById(idTrazabilidad);
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Borrado");
		
		Iterable<Trazabilidad> itTrazabilidades = trazabilidadRepository.findAll();
		List<Trazabilidad> trazabilidad = new ArrayList<Trazabilidad>();
		//se agrega a it de tipo iterable con el for each  las bodegas
		itTrazabilidades.forEach(trazabilidad::add);
		
		responseServiceObject.setBody(trazabilidad);
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
}
