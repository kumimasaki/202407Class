package rp.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import rp.com.models.entity.Admin;
import rp.com.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private HttpSession session;

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin_login";
	}

	@PostMapping("/login/process")
	public String processLogin(@RequestParam String adminEmail, @RequestParam String adminPassword, Model model) {
		Admin admin = adminService.loginAdmin(adminEmail, adminPassword);
		if (admin != null) {
			session.setAttribute("loginAdminInfo", admin);
			return "redirect:/admin/report/list";
		} else {
			model.addAttribute("errorMessage", "メールアドレスまたはパスワードが間違っています");
			return "admin_login.html";
		}
	}

	@GetMapping("/forgot-password")
	public String showForgotPasswordForm() {
		return "admin_change_pw.html";
	}
}
