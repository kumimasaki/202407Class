package login.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import login.com.services.AdminService;

@Controller
public class LoginController {
	@Autowired
	private AdminService adminService;
	
	//ログイン画面の表示
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("error", false);
		return "user_login.html";
	}
	
	//ログイン処理
	@PostMapping("/login")
	public String loginProcess(@RequestParam String email,@RequestParam String password,Model model) {
		//もし、email passwordが一致したらメニュー画面を表示させて、画面にメールアドレスが表示できるように設定
		//そうでない場合、ログインに画面にとどまってエラーメッセージを表示する
		if(adminService.loginCheck(email, password)) {
			model.addAttribute("email", email);
			return "user_menu.html";
		}else {
			model.addAttribute("error", true);
			return "user_login.html";
		}
	}
}
