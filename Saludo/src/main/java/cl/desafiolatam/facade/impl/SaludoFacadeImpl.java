package cl.desafiolatam.facade.impl;

import java.util.List;

import cl.desafiolatam.dto.SaludoDTO;
import cl.desafiolatam.facade.SaludoFacade;
import cl.desafiolatam.service.SaludoService;
import cl.desafiolatam.service.impl.SaludoServiceImpl;

public class SaludoFacadeImpl implements  SaludoFacade{

	
	private SaludoService saludoService;

	public SaludoFacadeImpl() {
		super();
		saludoService = new SaludoServiceImpl();
	}
	
	public List<String> traerSaludo() {
		return saludoService.getSaludos();
	}
	
}
