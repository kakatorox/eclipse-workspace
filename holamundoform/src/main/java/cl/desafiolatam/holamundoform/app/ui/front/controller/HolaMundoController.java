package cl.desafiolatam.holamundoform.app.ui.front.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.desafiolatam.holamundoform.app.ui.dto.PersonaDto;

@Controller
@RequestMapping(value="hola")
public class HolaMundoController {
	
	@Autowired
	private PersonaDto personaDTO;
	@Autowired
	@Qualifier("listaPersonaDTOS")
	private List<PersonaDto> listaPersonaDTOS;
	
	
	@RequestMapping(value = "/holamundoform", method= {RequestMethod.GET,RequestMethod.POST})
	public String holaMundo(ModelMap model, @ModelAttribute("personaDto")PersonaDto personaDTO) {
		model.addAttribute("personaDto",personaDTO);
		model.addAttribute("listaPersonaDTOS",listaPersonaDTOS);
		return "HolaMundo";
	}
	
	@RequestMapping(value = "/agregarAlguien", method= {RequestMethod.POST})
	public String agregarAlguien(ModelMap model,@ModelAttribute("personaDto")PersonaDto personaDTO) {
		listaPersonaDTOS.add(personaDTO);
		model.addAttribute("listaPersonaDTOS",listaPersonaDTOS);
		return "forward:/hola/holamundoform";
	}
	
	@RequestMapping(value = "/eliminarAlguien", method= {RequestMethod.POST})
	public String eliminarsAlguien(ModelMap model,@ModelAttribute("personaDto")PersonaDto personaDTO) {
		int i = 0;	
		PersonaDto pDto = null;
		
			for (Iterator iterator = listaPersonaDTOS.iterator(); iterator.hasNext();) {
					pDto = (PersonaDto) iterator.next();
					if (pDto.getPersona().getRut().contentEquals(personaDTO.getSelecion())) {
						listaPersonaDTOS.remove(i);
						break;
					}
					i++;
			}	
		
		model.addAttribute("listaPersonaDTOS",listaPersonaDTOS);
		return "forward:/hola/holamundoform";
	}

}
