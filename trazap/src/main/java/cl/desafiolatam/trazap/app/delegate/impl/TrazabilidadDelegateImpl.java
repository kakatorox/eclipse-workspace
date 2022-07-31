package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.TrazabilidadDelegate;
import cl.desafiolatam.trazap.app.exceptions.ServiceException;
import cl.desafiolatam.trazap.app.service.TrazabilidadService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.TrazabilidadRequest;

@Component("trazabilidadDelegate")
public class TrazabilidadDelegateImpl implements TrazabilidadDelegate{
	@Autowired
	private TrazabilidadService trazabilidadService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return trazabilidadService.findAll();
	}

	@Override
	public ResponseServiceObject findById(Integer idTrazabilidad) throws ServiceException {
		// TODO Auto-generated method stub
		return trazabilidadService.findById(idTrazabilidad);
	}

	@Override
	public ResponseServiceObject save(TrazabilidadRequest trazabilidadRequest) {
		// TODO Auto-generated method stub
		return trazabilidadService.save(trazabilidadRequest);
	}

	@Override
	public ResponseServiceObject update(TrazabilidadRequest trazabilidadRequest) {
		// TODO Auto-generated method stub
		return trazabilidadService.update(trazabilidadRequest);
	}

	@Override
	public ResponseServiceObject delete(int idTrazabilidad) {
		// TODO Auto-generated method stub
		return trazabilidadService.delete(idTrazabilidad);
	}

}
