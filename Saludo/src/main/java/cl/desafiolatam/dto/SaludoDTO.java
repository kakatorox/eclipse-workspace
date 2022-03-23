package cl.desafiolatam.dto;

import java.util.List;

import cl.desafiolatam.dao.ConsultasBDDao;
import cl.desafiolatam.dao.impl.ConsultasBDDaoImpl;
import cl.desafiolatam.model.Saludo;

public class SaludoDTO {

	private List<Saludo> saludoRecibido;
	
	public List<Saludo> getSaludos(){
		ConsultasBDDao consulta = new ConsultasBDDaoImpl();
		
		return this.saludoRecibido = consulta.getSaludos();
	} 
}
