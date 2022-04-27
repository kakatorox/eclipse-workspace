package cl.desafiolatam.spsecurityex.app.ui.front.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitAdminController {

	@GetMapping("/admin")
	public String init(ModelMap modelMap) {
		return "/admin/init";
	}
}
