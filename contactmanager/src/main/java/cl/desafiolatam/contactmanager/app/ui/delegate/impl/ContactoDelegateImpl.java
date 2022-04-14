package cl.desafiolatam.contactmanager.app.ui.delegate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.contactmanager.app.ui.delegate.ContactoDelegate;
import cl.desafiolatam.contactmanager.app.ui.dto.ContactoDto;
import cl.desafiolatam.contactmanager.app.ui.service.ContactoService;

@Component("ContactoDelegate")
public class ContactoDelegateImpl implements ContactoDelegate{
	
	@Autowired
	private ContactoService contactoService;
	
	@Override
	public List<ContactoDto> getContactos() {
		// TODO Auto-generated method stub
		return contactoService.getContacto();
	}

	@Override
	public List<ContactoDto> agregarContacto(ContactoDto contactoDto) {
		// TODO Auto-generated method stub
		if(contactoService.agregarContacto(contactoDto)) {
			
			return contactoService.getContacto();
		}else {
			return contactoService.getContacto();
		}
		
	}

	@Override
	public List<ContactoDto> borrarContacto(int id) {
		// TODO Auto-generated method stub
		if(contactoService.borrarContacto(id)) {
			
			return contactoService.getContacto();
		}else {
			return contactoService.getContacto();
		}
	}
	
	@Override
	public String getMensaje() {
		return contactoService.getMensaje();
				
	}

}
