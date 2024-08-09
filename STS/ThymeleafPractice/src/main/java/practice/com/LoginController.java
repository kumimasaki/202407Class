package practice.com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	// ログイン画面を表示
	@GetMapping("/login")
	public String getLoginPage() {
		return "login.html";
	}
	
//	@PostMapping("/login/process")
//	public String login(@RequestParam String email, @RequestParam String password, Model model) {
//		model.addAttribute("userEmail", email);
//		model.addAttribute("userPassword", password);
//		return "success.html";
//	}
	
	@PostMapping("/login/process")
	public ModelAndView login(@RequestParam String email, @RequestParam String password, ModelAndView mav) {
		mav.addObject("userEmail", email);
		mav.addObject("userPassword", password);
		mav.setViewName("success.html");
		return mav;
	}
	
}
