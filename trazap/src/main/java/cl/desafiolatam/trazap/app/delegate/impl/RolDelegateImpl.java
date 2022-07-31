package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.RolDelegate;
import cl.desafiolatam.trazap.app.service.RolService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.RolRequest;

@Component("rolDelegate")
public class RolDelegateImpl implements RolDelegate{
	@Autowired
	private RolService rolService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return rolService.findAll();
	}

	@Override
	public ResponseServiceObject delete(int idRol) {
		// TODO Auto-generated method stub
		return rolService.delete(idRol);
	}

	@Override
	public ResponseServiceObject save(RolRequest rolRequest) {
		// TODO Auto-generated method stub
		return rolService.save(rolRequest);
	}
	
	@Override
	public ResponseServiceObject update(RolRequest rolRequest) {
		// TODO Auto-generated method stub
		return rolService.update(rolRequest);
	}

	@Override
	public ResponseServiceObject findById(Integer idRol) {
		// TODO Auto-generated method stub
		return null;
	}

}
