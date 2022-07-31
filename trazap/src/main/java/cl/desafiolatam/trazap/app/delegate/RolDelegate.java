package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;
import cl.desafiolatam.trazap.app.ui.model.request.RolRequest;

public interface RolDelegate {

	public ResponseServiceObject findAll();

	public ResponseServiceObject findById(Integer idRol);

	public ResponseServiceObject save(RolRequest rolRequest);

	public ResponseServiceObject update(RolRequest rolRequest);

	public ResponseServiceObject delete(int idRol);

}
