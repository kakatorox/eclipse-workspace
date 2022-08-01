package cl.desafiolatam.spsecurityex.app.ui.front.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(ModelMap modelMap) {
		return "login";
	}
	
	@GetMapping("/logout")
	public String login(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		return "login";
	}
}