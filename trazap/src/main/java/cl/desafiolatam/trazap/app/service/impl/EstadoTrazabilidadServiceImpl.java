package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.EstadoTrazabilidadRepository;
import cl.desafiolatam.trazap.app.repository.model.EstadoTrazabilidad;
import cl.desafiolatam.trazap.app.service.EstadoTrazabilidadService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.EstadoTrazabilidadRequest;

@Service("estadoTrazabilidadService")
public class EstadoTrazabilidadServiceImpl implements EstadoTrazabilidadService{
	@Autowired
	private EstadoTrazabilidadRepository estadoTrazabilidadRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Override
	public ResponseServiceObject save(EstadoTrazabilidadRequest estadoTrazabilidadRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				EstadoTrazabilidad estadoTrazabilidad = new EstadoTrazabilidad();
				estadoTrazabilidad.setDescripcion(estadoTrazabilidadRequest.getDescripcion());
				responseServiceObject.setBody(estadoTrazabilidadRepository.save(estadoTrazabilidad));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(int idEstadoTrazabilidad) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(estadoTrazabilidadRepository.findById(idEstadoTrazabilidad));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
		
	}

	@Override
	public ResponseServiceObject delete(int idEstadoTrazabilidad) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		estadoTrazabilidadRepository.deleteById(idEstadoTrazabilidad);
		responseServiceObject.setBody("Borrado");
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject update(int idEstadoTrazabilidad,EstadoTrazabilidadRequest estadoTrazabilidadRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		EstadoTrazabilidad estadoTrazabilidad = new EstadoTrazabilidad();
		estadoTrazabilidad.setIdEstadoTrazabilidad(idEstadoTrazabilidad);
		estadoTrazabilidad.setDescripcion(estadoTrazabilidadRequest.getDescripcion());
		estadoTrazabilidadRepository.save(estadoTrazabilidad);
		responseServiceObject.setBody("Actualizado");
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
		
	}

	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<EstadoTrazabilidad> estadoTrazabilidades = new ArrayList<EstadoTrazabilidad>();
		Iterable<EstadoTrazabilidad> itEstadoTrazabilidades = estadoTrazabilidadRepository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itEstadoTrazabilidades.forEach(estadoTrazabilidades::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(estadoTrazabilidades);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
}
