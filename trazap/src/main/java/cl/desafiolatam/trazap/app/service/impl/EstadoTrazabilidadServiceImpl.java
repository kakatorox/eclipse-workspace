package cl.desafiolatam.trazap.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.EstadoTrazabilidadRepository;
import cl.desafiolatam.trazap.app.repository.model.Bodega;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.EstadoTrazabilidadService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
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
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseServiceObject findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseServiceObject save(Bodega bodega) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseServiceObject delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseServiceObject update(Bodega bodega) {
		// TODO Auto-generated method stub
		return null;
	}
}
