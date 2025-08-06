package jpa.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jpa.com.models.dto.AdminDto;
import jpa.com.models.form.AdminLoginForm;
import jakarta.validation.Valid;
import jpa.com.services.AdminService;

@Controller
public class LoginController {
	
	@Autowired
	AdminService adminService;
	
	// ログイン画面表示
	// URL  「/login」
	// メソッド名　「getLoginPage」
	// エラーの可否の情報を画面に渡す
	// login.htmlを表示させる
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		// Thymeleafで th:field="*{adminEmail}" を使うとき
		// 値を入れる場所を用意しておく
		model.addAttribute("adminLoginForm", new AdminLoginForm()); 
		model.addAttribute("error", false);
		return "login.html";
	}
	
	// URL  「/login/process」
	// メソッド名　「login」
	// 入力された情報を引数で受け取る
	@PostMapping("/login/process")
	public String login(@Valid AdminLoginForm form,
						Model model) {
		// ログインチェック
		// もし、loginCheckの結果がnullではない場合、「email」のデータを渡しwelcome.htmlを表示する
		// そうでない場合、エラーの可否の情報を画面に渡す⇒login.htmlを表示
		AdminDto admin = adminService.loginCheck(form);
		if(admin != null) {
			model.addAttribute("loginAdmin", admin);
			return "welcome.html";
		} else {
			model.addAttribute("error", true);
			return "login.html";
		}
	}
}
