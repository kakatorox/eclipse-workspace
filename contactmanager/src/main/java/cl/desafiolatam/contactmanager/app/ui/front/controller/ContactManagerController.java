package cl.desafiolatam.contactmanager.app.ui.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.desafiolatam.contactmanager.app.ui.delegate.ContactoDelegate;
import cl.desafiolatam.contactmanager.app.ui.dto.ContactoDto;

@Controller
public class ContactManagerController {
	
	
	@Autowired
	@Qualifier("listaContactoDTO")
	private List<ContactoDto> listaContactoDTO;
	@Autowired
	private ContactoDelegate contactoDelegate;
	
	
	@RequestMapping(value = "/contactManager", method= {RequestMethod.GET,RequestMethod.POST})
	public String holaMundo(ModelMap model, @ModelAttribute("contactoDto")ContactoDto personaDTO) {
		model.addAttribute("contactoDto",personaDTO);
		model.addAttribute("listaContactoDTO",contactoDelegate.getContactos());
		return "index";
	}
	
	@RequestMapping(value = "/contactManager/addContact", method= {RequestMethod.POST})
	public String agregarContacto(ModelMap model,@ModelAttribute("contactoDto")ContactoDto contactoDto) {
		
		model.addAttribute("listaContactoDTO",contactoDelegate.agregarContacto(contactoDto));
		model.addAttribute("mensajeAccion",contactoDelegate.getMensaje());
		return "forward:/contactManager";
	}
	
	@RequestMapping(value = "/contactManager/deleteContact", method= {RequestMethod.GET})
	public String eliminarsAlguien(ModelMap model, @RequestParam("id") int id) {
		model.addAttribute("listaContactoDTO",contactoDelegate.borrarContacto(id));
		model.addAttribute("mensajeAccion",contactoDelegate.getMensaje());
		return "forward:/contactManager";
	}

}
