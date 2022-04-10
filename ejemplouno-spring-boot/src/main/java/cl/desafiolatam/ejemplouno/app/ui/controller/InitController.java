package cl.desafiolatam.ejemplouno.app.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.desafiolatam.ejemplouno.EjemplounoSpringBootApplication;
import cl.desafiolatam.ejemplouno.model.Alumno;

@Controller
public class InitController {
	
	private final static Logger logger = LoggerFactory.getLogger(InitController.class);
	@Autowired
	private Alumno alumno;
	
	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
	public String init(ModelMap model) {
		model.addAttribute("mensaje","Hola mundo desde Spring boot" + alumno.getNombre());
		logger.debug("Log debug");
		logger.info("Log info");
		logger.warn("Log warning");
		logger.error("Log error");
		return "init";
	}
	
	@RequestMapping(value = "/recive.do", method = RequestMethod.POST)
	public String recivePost(ModelMap model, @RequestParam(value = "apellido" , defaultValue = "Volador") String apellido) {
		model.addAttribute("mensaje","Hola mundo desde Spring boot" +alumno.getNombre() +" recive " + apellido);
		logger.debug("Log debug");
		logger.info("Log info");
		logger.warn("Log warning");
		logger.error("Log error");
		return "init";
	}
	
	@RequestMapping(value = "/recive.do/{apellido}", method = RequestMethod.GET)
	public String reciveGet(ModelMap model, @PathVariable(value="apellido")String apellido) {
		model.addAttribute("mensaje","Hola mundo desde Spring boot"+alumno.getNombre() +" recive " + apellido);
		logger.debug("Log debug");
		logger.info("Log info");
		logger.warn("Log warning");
		logger.error("Log error");
		return "init";
	}
	
	@RequestMapping(value = "/recive.do/", method = RequestMethod.GET)
	public String reciveGet2(ModelMap model, @PathVariable(value="apellido")String apellido) {
		model.addAttribute("mensaje","Hola mundo desde Spring boot"+alumno.getNombre() +" recive " + apellido);
		logger.debug("Log debug");
		logger.info("Log info");
		logger.warn("Log warning");
		logger.error("Log error");
		return "init";
	}
}
