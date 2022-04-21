package cl.desafiolatam.booklet.app.ui.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import cl.desafiolatam.booklet.app.ui.delegate.LibroDelegate;
import cl.desafiolatam.booklet.app.ui.dto.LibroDto;

@Controller
public class LibroController {

	@Autowired
	private LibroDelegate libroDelegate;
	
	@RequestMapping(value = "/Booklet", method = {RequestMethod.GET, RequestMethod.POST})
	public String holaMundo(ModelMap model, @ModelAttribute("libroDTO") LibroDto libroDto) {
		model.addAttribute("libroDto", libroDto);
		model.addAttribute("libroDtoJson",libroDelegate.getLibros());
		//, @ModelAttribute("listaPersonaDTO") List<PersonaDTO> listaPersonaDTO
		//model.addAttribute("listaLibroDtoJson", libroDelegate.getLibros());
		return "index";
	}
	
	@RequestMapping(value = "/Booklet/addLibro", method= {RequestMethod.POST})
	public String addLibro(ModelMap model,@ModelAttribute("LibroDto")LibroDto libroDto) {
		
		model.addAttribute("libroDtoJson",libroDelegate.addLibro(libroDto));
		model.addAttribute("mensaje",libroDelegate.getMensaje());
		return "forward:/Booklet";
	}
	
	@RequestMapping(value = "/Booklet/deleteLibro", method= {RequestMethod.GET})
	public String deleteLibro(ModelMap model, @RequestParam("id") int id) {
		model.addAttribute("libroDtoJson",libroDelegate.deleteLibro(id));
		model.addAttribute("mensaje",libroDelegate.getMensaje());
		return "forward:/Booklet";
	}
	@RequestMapping(value = "/Booklet/updateLibro", method= {RequestMethod.POST})
	public String updateLibro(ModelMap model,@ModelAttribute("LibroDto")LibroDto libroDto) {
		
		model.addAttribute("libroDtoJson",libroDelegate.updateLibro(libroDto));
		model.addAttribute("mensaje",libroDelegate.getMensaje());
		return "forward:/Booklet";
	}
}
