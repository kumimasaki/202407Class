package rp.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import rp.com.services.UserService;
import rp.com.models.entity.Admin;
import rp.com.models.entity.Reports;
import rp.com.models.entity.Users;

import java.util.List;
import java.util.Optional;

@Controller
public class UserListController {

	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;

	// ユーザー一覧画面を表示するメソッド
	@GetMapping("/user/list")
	public String showUserList(Model model) {
		Admin admin = (Admin) session.getAttribute("loginAdminInfo");
		if (admin != null) {
			model.addAttribute("adminId", admin.getAdminId());
			model.addAttribute("adminName", admin.getAdminName());
			model.addAttribute("adminIconPath", admin.getAdminIconPath());
			// すべてのユーザーリストを取得
			List<Users> usersList = userService.getAllUserList();
			model.addAttribute("usersList", usersList);
			model.addAttribute("users", new Users());
			return "user_list";
		} else {
			return "redirect:/admin/login";
		}
	}

	// ユーザー検索を処理するメソッド
	@PostMapping("/user/search")
	public String searchUsers(@RequestParam("keyword") String keyword, Model model) {
		Admin admin = (Admin) session.getAttribute("loginAdminInfo");
		if (admin != null) {
			List<Users> searchResults = userService.searchUserByNameOrEmail(keyword);
			model.addAttribute("adminId", admin.getAdminId());
			model.addAttribute("adminName", admin.getAdminName());
			model.addAttribute("adminIconPath", admin.getAdminIconPath());
			model.addAttribute("searchResults", searchResults);

			return "user_list";
		} else {
			return "redirect:/admin/login";
		}
	}

	// ユーザーを削除するメソッド
	@PostMapping("/user/delete")
	public String deleteUser(@RequestParam("userId") Long userId) {
		userService.deleteUser(userId);
		return "redirect:/user/list";
	}
}