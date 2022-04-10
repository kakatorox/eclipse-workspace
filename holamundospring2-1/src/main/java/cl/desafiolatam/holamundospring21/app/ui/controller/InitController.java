package cl.desafiolatam.holamundospring21.app.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Holamundospring21Application;

import cl.desafiolatam.holamundospring21.model.Alumno;

@Controller
public class InitController {
	private static final Logger logger = LoggerFactory.getLogger(Holamundospring21Application.class);
	@Autowired
	private Alumno alumno;
	
	
	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
	public String init(ModelMap model) {
		model.addAttribute("mensaje", "hola mundo desde spring" + alumno.getNombre());
		logger.debug("Log debug");
		logger.info("Log info");
		logger.warn("Log Warning");
		logger.error("Log error");
		
		return "init";
	}
}
