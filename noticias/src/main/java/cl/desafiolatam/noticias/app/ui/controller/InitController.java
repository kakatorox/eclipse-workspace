package cl.desafiolatam.noticias.app.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.desafiolatam.noticias.app.facade.NoticiasFacade;

@Controller
public class InitController {
	private final static Logger logger = LoggerFactory.getLogger(InitController.class);
	
	@Autowired
	private NoticiasFacade noticiaFacade;
	
	@RequestMapping(value = "/noticiasinit.do", method = RequestMethod.GET)
	public String init(ModelMap model) {
		
		model.addAttribute("listadoNoticias", noticiaFacade.getNoticias().toString());
		logger.debug("Log debug");
		logger.info("Log info");
		logger.warn("Log warning");
		logger.error("Log error");
		return "index";
	}
	
	
}
