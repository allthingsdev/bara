package mg.tmr.khr.bara.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

	@GetMapping("/logout")
	public ModelAndView showLoginPage(ModelAndView loginPage) {
		loginPage.setViewName("logout");
		return loginPage;
	}
}
