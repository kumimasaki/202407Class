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
	public String getLoginPage(Model model) {
		model.addAttribute("error", false);
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
		String[] test = {"aa", "bb", "cc", "dd"};
		Cat cat = new Cat("Alice", 3);
		
		// もしメールアドレスが「test@test.com」で
		// かつパスワードが「admin」だった場合は「success.html」を表示
		if(email.equals("test@test.com") && password.equals("admin")) {
			mav.addObject("userEmail", email);
			mav.addObject("userPassword", password);
			mav.addObject("array", test);
			mav.addObject("alice", cat);
			mav.setViewName("success.html");
			return mav;
		} else {
			mav.addObject("error", true);
			mav.setViewName("login.html");
			return mav;
		}
	}
	
}
