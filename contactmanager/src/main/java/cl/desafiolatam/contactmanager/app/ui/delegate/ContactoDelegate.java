package cl.desafiolatam.contactmanager.app.ui.delegate;

import java.util.List;


import cl.desafiolatam.contactmanager.app.ui.dto.ContactoDto;


public interface ContactoDelegate {

	public List<ContactoDto> getContactos();
	public List<ContactoDto> agregarContacto(ContactoDto contactoDto);
	public List<ContactoDto> borrarContacto(int id);
	public String getMensaje();

}
