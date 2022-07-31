package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.messagemanager.MessageManager;
import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.ProductosBodegaRepository;
import cl.desafiolatam.trazap.app.repository.RolsRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.Rols;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.RolService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.RolRequest;

@Service("rolService")
public class RolServiceImpl implements RolService{
	@Autowired
	private RolsRepository rolRepository;
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
		List<Rols> rols = new ArrayList<Rols>();
		Iterable<Rols> itRols = rolRepository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itRols.forEach(rols::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(rols);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject save(RolRequest rolRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				Rols rols = new Rols();
				
				rols.setDescripcion(rolRequest.getDescripcion());
				
				responseServiceObject.setBody(rolRepository.save(rols));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject update(RolRequest rolRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Rols rols = new Rols();
		rols.setIdRols(rolRequest.getIdRols());
		rols.setDescripcion(rolRequest.getDescripcion());
		
		responseServiceObject.setBody(rolRepository.save(rols));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer id) throws ServiceException{
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		try {
			Rols rols = rolRepository.findById(id).get();
			
			responseServiceObject.setBody(rols);
			
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
	public ResponseServiceObject delete(int id) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		rolRepository.deleteById(id);
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Borrado");
		
		Iterable<Rols> itRols = rolRepository.findAll();
		List<Rols> rols = new ArrayList<Rols>();
		//se agrega a it de tipo iterable con el for each  las bodegas
		itRols.forEach(rols::add);
		
		responseServiceObject.setBody(rols);
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	

	

}
