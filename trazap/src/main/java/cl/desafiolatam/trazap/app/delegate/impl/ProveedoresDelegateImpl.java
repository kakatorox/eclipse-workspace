package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.ProveedoresDelegate;
import cl.desafiolatam.trazap.app.service.ProveedoresService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.BodegaRequest;
import cl.desafiolatam.trazap.app.ui.model.request.ProveedoresRequest;

@Component("proveedoresDelegate")
public class ProveedoresDelegateImpl implements ProveedoresDelegate{
	@Autowired
	private ProveedoresService proveedoresService;
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return proveedoresService.findAll();
	}

	@Override
	public ResponseServiceObject delete(int idProveedores) {
		// TODO Auto-generated method stub
		return proveedoresService.delete(idProveedores);
	}

	@Override
	public ResponseServiceObject save(ProveedoresRequest proveedoresRequest) {
		// TODO Auto-generated method stub
		return proveedoresService.save(proveedoresRequest);
	}
	
	@Override
	public ResponseServiceObject update(int idProveedor, ProveedoresRequest proveedoresRequest) {
		// TODO Auto-generated method stub
		return proveedoresService.update(idProveedor,proveedoresRequest);
	}

}
