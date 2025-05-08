package login.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import login.com.services.AdminService;

@Controller
public class RegisterController {
	@Autowired
	private AdminService adminService;
	
	//登録画面の表示
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("error", false);
		return "user_register.html";
	}
	
	//登録処理
	@PostMapping("/register")
	public String registerProcess(@RequestParam String adminName,@RequestParam String email,@RequestParam String password,Model model) {
		//もし、登録したEmailが存在しない場合は、登録ができているはずなので、ログイン画面にリダイレクトする
		//そうでない場合は、登録画面を表示させてエラーメッセージを表示させる
		if(adminService.createAccount(adminName, email, password)) {
			return "redirect:/login";
		}else {
			model.addAttribute("error", true);
			return "user_register.html";
		}
	}
	
}
