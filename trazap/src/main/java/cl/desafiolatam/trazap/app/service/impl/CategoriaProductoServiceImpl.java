package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.CategoriaProductoRespository;
import cl.desafiolatam.trazap.app.repository.model.CategoriaProducto;
import cl.desafiolatam.trazap.app.service.CategoriaProductoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.CategoriaProductoRequest;

@Service("categoriaProductoService")
public class CategoriaProductoServiceImpl implements CategoriaProductoService{
	@Autowired
	private CategoriaProductoRespository categoriaProductoRespository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<CategoriaProducto> categoriaProductos = new ArrayList<CategoriaProducto>();
		Iterable<CategoriaProducto> itCategorias = categoriaProductoRespository.findAll();
		
		//se agrega a it de tipo iterable con el for each  las bodegas
		itCategorias.forEach(categoriaProductos::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(categoriaProductos);
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
	@Override
	public ResponseServiceObject findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseServiceObject save(CategoriaProductoRequest categoriaProductoRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		CategoriaProducto categoriaProducto = new CategoriaProducto(); 
		categoriaProducto.setDescripcion(categoriaProductoRequest.getDescripcion());
		responseServiceObject.setBody(categoriaProductoRespository.save(categoriaProducto));
		
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
		categoriaProductoRespository.deleteById(id);
		responseServiceObject.setBody("Eliminado");
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
	@Override
	public ResponseServiceObject update(int idCategoriaProducto,CategoriaProductoRequest categoriaProductoRequest) {
		// TODO Auto-generated method stub
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		CategoriaProducto categoriaProducto = new CategoriaProducto(); 
		categoriaProducto.setIdCategoriaProducto(idCategoriaProducto);
		categoriaProducto.setDescripcion(categoriaProductoRequest.getDescripcion());
		responseServiceObject.setBody(categoriaProductoRespository.save(categoriaProducto));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMensaje("Servicio Finalizado Correctamente");
		
		messageList.add(responseServiceMessage);
						
		responseServiceObject.setMessageList(messageList);
				
		return responseServiceObject;
	}
}
