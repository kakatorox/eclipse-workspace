package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.EstadoTrazabilidadRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.EstadoTrazabilidad;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.EstadoTrazabilidadService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Service("estadoTrazabilidadService")
public class EstadoTrazabilidadServiceImpl implements EstadoTrazabilidadService{
	@Autowired
	private EstadoTrazabilidadRepository estadoTrazabilidadRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Override
	public ResponseServiceObject save(EstadoTrazabilidad estadoTrazabilidad) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
			
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
	public ResponseServiceObject findById(int id) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(estadoTrazabilidadRepository.findById(id));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
		
	}

	@Override
	public ResponseServiceObject delete(int id) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		estadoTrazabilidadRepository.deleteById(id);
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
	public ResponseServiceObject update(Bodega bodega) {
		// TODO Auto-generated method stub
//		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
//        bodegaRepository.;
//		responseServiceObject.setBody("Borrado");
//		
//		responseServiceMessage.setTimestamp(new Date());
//		responseServiceMessage.setCode("201");
//		responseServiceMessage.setType(ResponseServiceMessageType.OK);
//		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
//		
//		messageList.add(responseServiceMessage);
//						
//		responseServiceObject.setMessageList(messageList);
//				
//		return responseServiceObject;
		return null;
	}

	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
