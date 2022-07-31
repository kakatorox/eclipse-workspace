package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.messagemanager.MessageManager;
import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.ProductosBodegaRepository;
import cl.desafiolatam.trazap.app.repository.UserRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.repository.model.Rols;
import cl.desafiolatam.trazap.app.repository.model.Users;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.UserService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.UserRequest;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Autowired
	private MessageManager messageManager;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Users> users = new ArrayList<Users>();
		Iterable<Users> itUsers = userRepository.findAll();
		
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itUsers.forEach(users::add);
		
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(users);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject save(UserRequest userRequest) {
		// TODO Auto-generated method stub
				List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
				Users User = new Users();
				Rols rol = new Rols();
				rol.setIdRols(userRequest.getRolsId()); 
				User.setEmail(userRequest.getEmail());
				User.setPassword(userRequest.getEmail());
				User.setRols(rol);
				
				responseServiceObject.setBody(userRepository.save(User));
				
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setCode("201");
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
				
				messageList.add(responseServiceMessage);
								
				responseServiceObject.setMessageList(messageList);
						
				return responseServiceObject;
	}
	
	@Override
	public ResponseServiceObject update(UserRequest userRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Users user = new Users();
		Rols rol = new Rols();
		rol.setIdRols(userRequest.getRolsId()); 
		user.setIdUsers(userRequest.getIdUsers() );
		user.setEmail(userRequest.getEmail());
		user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		user.setRols(rol);
		
		responseServiceObject.setBody(userRepository.save(user));
		
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
			Users user =userRepository.findById(id).get();
			
			responseServiceObject.setBody(user);
			
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
		userRepository.deleteById(id);
		
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Borrado");
		
		Iterable<Users> itUsers = userRepository.findAll();
		List<Users> users = new ArrayList<Users>();
		//se agrega a it de tipo iterable con el for each  las bodegas
		itUsers.forEach(users::add);
		
		responseServiceObject.setBody(users);
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}

	

	

}
