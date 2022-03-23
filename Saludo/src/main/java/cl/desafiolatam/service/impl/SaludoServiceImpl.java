package cl.desafiolatam.service.impl;

import java.util.List;

import cl.desafiolatam.dao.ConsultasBDDao;
import cl.desafiolatam.dao.impl.ConsultasBDDaoImpl;
import cl.desafiolatam.model.Saludo;
import cl.desafiolatam.service.SaludoService;

public class SaludoServiceImpl implements SaludoService{

	@SuppressWarnings("null")
	@Override
	
	public List<String> getSaludos(){
		ConsultasBDDao consulta = new ConsultasBDDaoImpl();
		
		List<String> listaSaludoString = null;
		
		for (Saludo saludo : consulta.getSaludos()) {
			
			listaSaludoString.add(saludo.getTexto() + saludo.getPais());
		}
		
		
		return listaSaludoString;
		
	} 

}
