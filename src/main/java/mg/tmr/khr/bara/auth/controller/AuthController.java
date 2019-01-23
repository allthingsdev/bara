package mg.tmr.khr.bara.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

	@GetMapping("/login")
	public ModelAndView showLoginPage(ModelAndView loginPage) {
		loginPage.setViewName("login");
		return loginPage;
	}
	
	@GetMapping("/register")
	public ModelAndView showRegistrationPage(ModelAndView registrationPage) {
		registrationPage.setViewName("register");
		return registrationPage;
	}
}
