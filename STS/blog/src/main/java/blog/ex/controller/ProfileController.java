package blog.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.ex.model.entity.UserEntity;
import blog.ex.service.UserService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class ProfileController {
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/profile")
	public String getProfilePage() { 
		return "profile.html";
	}
	
	@PostMapping("/profile/process")
	public String profile(@RequestParam String nickname, Model model) {
		UserEntity userList = (UserEntity) session.getAttribute("user");
		Long userId = userList.getUserId();
		model.addAttribute("nickname", nickname);
		return "profile.html";
	}
}
