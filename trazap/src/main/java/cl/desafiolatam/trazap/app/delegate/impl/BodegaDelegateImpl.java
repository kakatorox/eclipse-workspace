package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.BodegaDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;

@Component("bodegaDelegate")
public class BodegaDelegateImpl implements BodegaDelegate{

	@Autowired
	private BodegaService bodegaService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return bodegaService.findAll();
	}

	@Override
	public ResponseServiceObject save(BodegaRequest bodegaRequest) {
		// TODO Auto-generated method stub
		return bodegaService.save(bodegaRequest);
	}
	@Override
	public ResponseServiceObject update(BodegaRequest bodegaRequest) {
		// TODO Auto-generated method stub
		return bodegaService.update(bodegaRequest);
	}

	@Override
	public ResponseServiceObject delete(int id) {
		// TODO Auto-generated method stub
		return bodegaService.delete(id);
	}

	@Override
	public ResponseServiceObject findById(Integer id) throws ServiceException{
		// TODO Auto-generated method stub
		return bodegaService.findById(id);
	}

	

	
}
