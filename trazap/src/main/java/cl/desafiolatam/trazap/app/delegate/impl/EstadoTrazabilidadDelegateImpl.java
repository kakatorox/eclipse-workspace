package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.EstadoTrazabilidadDelegate;
import cl.desafiolatam.trazap.app.service.EstadoTrazabilidadService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.EstadoTrazabilidadRequest;

@Component("estadoTrazabilidadDelegate")
public class EstadoTrazabilidadDelegateImpl implements EstadoTrazabilidadDelegate{

	@Autowired
	private EstadoTrazabilidadService estadoTrazabilidadService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject save(EstadoTrazabilidadRequest estadoTrazabilidadRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject update(int idEstadoTrazabilidad, EstadoTrazabilidadRequest estadoTrazabilidadRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
