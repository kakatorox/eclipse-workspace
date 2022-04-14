package cl.desafiolatam.contactmanager.app.ui.service;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.desafiolatam.contactmanager.app.ui.dto.ContactoDto;


public interface ContactoService {

	public boolean agregarContacto(ContactoDto contactoDto);

	public List<ContactoDto> getContacto();

	public boolean borrarContacto(int id);

	public String getMensaje();

	public void setMensaje(String mensaje);


}
