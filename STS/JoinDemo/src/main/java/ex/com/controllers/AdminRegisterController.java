package ex.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ex.com.services.AdminService;

@Controller
public class AdminRegisterController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/register")
	public String getRegisterPage() {
		return "admin_register.html";
	}
	
	@PostMapping("/register/process")
	public String register(@RequestParam String adminName,@RequestParam String adminEmail,@RequestParam String password) {
		if(adminService.registerCheck(adminName, adminEmail, password)) {
			return "redirect:/login";
		}else {
			return "redirect:/register";
		}
	}

}
