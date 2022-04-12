package cl.desafiolatam.contactmanager.app.ui.front.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.desafiolatam.contactmanager.app.ui.dto.ContactoDto;

@Controller
public class ContactManagerController {
	
	
	@Autowired
	@Qualifier("listaContactoDTO")
	private List<ContactoDto> listaContactoDTO;
	
	
	@RequestMapping(value = "/contactManager", method= {RequestMethod.GET,RequestMethod.POST})
	public String holaMundo(ModelMap model, @ModelAttribute("contactoDto")ContactoDto personaDTO) {
		model.addAttribute("contactoDto",personaDTO);
		model.addAttribute("listaContactoDTO",listaContactoDTO);
		return "index";
	}
	
	@RequestMapping(value = "/contactManager/addContact", method= {RequestMethod.POST})
	public String agregarContacto(ModelMap model,@ModelAttribute("contactoDto")ContactoDto personaDTO) {
		
		int i = 1;
		
		if (listaContactoDTO.isEmpty()) {
			personaDTO.setIdContacto(i);
			listaContactoDTO.add(personaDTO);
		}else {
			int lastIdx = listaContactoDTO.size() - 1;
			ContactoDto lastElement = listaContactoDTO.get(lastIdx);
			i = lastElement.getContacto().getId();
			
			personaDTO.setIdContacto(i+1);
			listaContactoDTO.add(personaDTO);
		}
		model.addAttribute("listaContactoDTO",listaContactoDTO);
		return "forward:/contactManager";
	}
	
	@RequestMapping(value = "/contactManager/deleteContact", method= {RequestMethod.GET})
	public String eliminarsAlguien(ModelMap model, @RequestParam("id") int id) {
		int i = 0;	
		ContactoDto pDto = null;
		
			for (Iterator iterator = listaContactoDTO.iterator(); iterator.hasNext();) {
					pDto = (ContactoDto) iterator.next();
					if (pDto.getContacto().getId() == id) {	
						listaContactoDTO.remove(i);
						break;
					}
					i++;
			}	
		
		model.addAttribute("listaContactoDTO",listaContactoDTO);
		return "forward:/contactManager";
	}

}
