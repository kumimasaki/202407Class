package rp.com.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

import rp.com.models.entity.Admin;
import rp.com.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminEditController {

    @Autowired
    private AdminService adminService;

	@Autowired
	private HttpSession session;

	@GetMapping("/info/edit/{adminId}")
	public String showEditForm(@PathVariable("adminId") Long adminId, Model model) {

		Admin admin = (Admin) session.getAttribute("loginAdminInfo");

		if (admin != null) {
			model.addAttribute("admin", admin);
			model.addAttribute("adminId", adminId);
			String adminIconPath = "/uploads/" + admin.getAdminIcon();
			model.addAttribute("adminIconPath", adminIconPath);
			return "admin_info_change.html";
		} else {
			model.addAttribute("errorMessage", "管理者が見つかりません");
			return "admin_register.html";
		}
	}

	@PostMapping("/info/update")
	public String updateAdminInfo(@RequestParam Long adminId, @RequestParam String adminName,
			@RequestParam String adminEmail, @RequestParam String adminPassword,
			@RequestParam("adminIcon") MultipartFile adminIcon, Model model) {

		try {
			Admin admin = adminService.getAdminById(adminId);
			if (admin != null) {
				admin.setAdminName(adminName);
				admin.setAdminEmail(adminEmail);
				admin.setAdminPassword(adminPassword);

				adminService.updateAdminInfoWithIcon(admin, adminIcon);

				model.addAttribute("successMessage", "管理者情報が更新されました");
				return "admin_info_changed.html";
			} else {
				throw new RuntimeException("指定の管理者は存在しません");
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "管理者情報の更新中にエラーが発生しました");
			return "admin_info_change.html";
		}

	}
}
