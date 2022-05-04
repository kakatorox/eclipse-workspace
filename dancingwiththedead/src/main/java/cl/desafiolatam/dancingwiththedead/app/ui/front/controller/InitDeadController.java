package cl.desafiolatam.dancingwiththedead.app.ui.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitDeadController {
	@GetMapping("/")
	public String init(ModelMap modelMap) {
		return "/init";
	}
}
