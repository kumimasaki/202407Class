package ex.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ex.com.models.entity.AdminEntity;
import ex.com.services.AdminService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "admin_login.html";
	}
	
	@PostMapping("/login/process")
	public String login(@RequestParam String adminEmail,@RequestParam String password) {
		AdminEntity admin = adminService.loginCheck(adminEmail, password);
		if(admin == null) {
			return "redirect:/login";
		}else {
			session.setAttribute("loginInfo", admin);
			return "redirect:/product/list";
		}
	}
	
}
