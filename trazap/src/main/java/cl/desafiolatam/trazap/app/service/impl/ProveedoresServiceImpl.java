package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.ProveedoresRespository;
import cl.desafiolatam.trazap.app.repository.model.Proveedores;
import cl.desafiolatam.trazap.app.service.ProveedoresService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.ProveedoresRequest;

@Service("proveedoresService")
public class ProveedoresServiceImpl implements ProveedoresService {
	@Autowired
	private ProveedoresRespository proveedoresRespository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Override
	public ResponseServiceObject save(ProveedoresRequest proveedoresRequest ) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				Proveedores proveedores = new Proveedores();
				proveedores.setRazonSocial(proveedoresRequest.getRazonSocial());
				proveedores.setRutProveedor(proveedoresRequest.getRutProveedor());
				responseServiceObject.setBody(proveedoresRespository.save(proveedores));
				
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
		
		responseServiceObject.setBody(proveedoresRespository.findById(id));
		
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
		proveedoresRespository.deleteById(id);
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
	public ResponseServiceObject update(ProveedoresRequest proveedoresRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Proveedores proveedores = new Proveedores();
		proveedores.setIdProveedor(proveedoresRequest.getIdProveedor());
		proveedores.setRazonSocial(proveedoresRequest.getRazonSocial());
		proveedores.setRutProveedor(proveedoresRequest.getRutProveedor());
		proveedoresRespository.save(proveedores);
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
		List<Proveedores> proveedores = new ArrayList<Proveedores>();
		Iterable<Proveedores> itProveedores = proveedoresRespository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itProveedores.forEach(proveedores::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(proveedores);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	

}
