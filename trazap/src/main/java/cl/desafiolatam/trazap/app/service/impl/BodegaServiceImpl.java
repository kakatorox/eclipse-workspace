package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolata.trazap.app.messagemanager.MessageManager;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

@Service("bodegaService")
public class BodegaServiceImpl implements BodegaService{
	@Autowired
	private BodegaRepository bodegaRepository;
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
		List<Bodega> bodegas = new ArrayList<Bodega>();
		Iterable<Bodega> itBodegas = bodegaRepository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itBodegas.forEach(bodegas::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(bodegas);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(BodegaRequest bodegaRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				Bodega bodega = new Bodega();
				bodega.setIdBodega(bodegaRequest.getIdBodega());
				bodega.setDescripcion(bodegaRequest.getDescripcion());
				
				responseServiceObject.setBody(bodegaRepository.save(bodega));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Bodega bodega = new Bodega();
		bodega.setIdBodega(idBodega);
		bodega.setDescripcion(bodegaRequest.getDescripcion());
		
		responseServiceObject.setBody(bodegaRepository.save(bodega));
		
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
			Bodega bodega =bodegaRepository.findById(id).get();
			
			responseServiceObject.setBody(bodega);
			
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
        bodegaRepository.deleteById(id);
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Borrado");
		
		Iterable<Bodega> itBodegas = bodegaRepository.findAll();
		List<Bodega> bodegas = new ArrayList<Bodega>();
		//se agrega a it de tipo iterable con el for each  las bodegas
		itBodegas.forEach(bodegas::add);
		
		responseServiceObject.setBody(bodegas);
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	

	

}
