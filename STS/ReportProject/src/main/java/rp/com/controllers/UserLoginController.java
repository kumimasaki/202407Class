package rp.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import rp.com.services.UserService;
import rp.com.models.entity.Users;

@Controller
public class UserLoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	// ログイン画面を表示するメソッド
	@GetMapping("/user/login")
	public String getUserLoginPage() {
		return "user_login.html";
	}

	// ログイン処理を行うメソッド
	@PostMapping("/user/login/process")
	public String userLoginProcess(@RequestParam String userEmail, @RequestParam String userPassword, Model model) {

		Users users = userService.loginCheck(userEmail, userPassword);

		if (users == null) {
			model.addAttribute("errorMessage", "メールアドレスまたはパスワードが正しくありません");
			return "user_login.html";
		} else {
			session.setAttribute("loginUserInfo", users);
			return "redirect:/user/report/list";
		}
	}
}