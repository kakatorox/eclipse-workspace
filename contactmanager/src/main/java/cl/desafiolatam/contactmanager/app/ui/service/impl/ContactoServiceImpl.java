package cl.desafiolatam.contactmanager.app.ui.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.contactmanager.app.ui.dto.ContactoDto;
import cl.desafiolatam.contactmanager.app.ui.service.ContactoService;

@Service("ContactoService")
public class ContactoServiceImpl implements ContactoService{
	@Autowired
	private List<ContactoDto> listaContacto;
	@Autowired
	private ContactoDto contactoDto;
	private String mensaje;
	@Override
	public boolean agregarContacto(ContactoDto contactoDto) {
		// TODO Auto-generated method stub
		int i = 1;
		
		boolean add = false;
		if (listaContacto.get(0).getContacto().getId() == 0 ) {
			contactoDto.setIdContacto(i);
			setMensaje("Contacto Agregado");
			listaContacto.remove(0);
			listaContacto.add(contactoDto);
			add = true;
			
		}else {
			int lastIdx = listaContacto.size() - 1;
			ContactoDto lastElement = listaContacto.get(lastIdx);
			i = lastElement.getContacto().getId();
			contactoDto.setIdContacto(i+1);
			setMensaje("Contacto Agregado");
			listaContacto.add(contactoDto);
			add = true;
		}
		
		
		return add;
	}

	@Override
	public List<ContactoDto> getContacto() {
		// TODO Auto-generated method stub
		return this.listaContacto;
	}

	@Override
	public boolean borrarContacto(int id) {
		// TODO Auto-generated method stub		
		boolean borrar = false;
		int i = 0;	
		ContactoDto pDto = null;
		
			for (Iterator iterator = listaContacto.iterator(); iterator.hasNext();) {
					pDto = (ContactoDto) iterator.next();
					if (pDto.getContacto().getId() == id) {	
						listaContacto.remove(i);
						setMensaje("Contacto Borrado");
						break;
					}
					i++;
			}
			
			if (listaContacto.isEmpty()) {
				setMensaje("Ya no Hay Registros");
				listaContacto.add(contactoDto);
			}
		
		return borrar;
	}
	
	@Override
	public String getMensaje() {
		return mensaje;
	}

	@Override
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
