package rp.com.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import rp.com.models.entity.Admin;
import rp.com.models.entity.Reports;
import rp.com.models.entity.Users;
import rp.com.services.AdminService;
import rp.com.services.ReportsService;

@Controller
@RequestMapping
public class UserReportCreateController {

	@Autowired
	private ReportsService reportsService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private HttpSession session;

	@GetMapping("/user/report/create")
	public String showReportCreateForm(Model model) {
		Users users = (Users) session.getAttribute("loginUserInfo");

		List<Reports> reportList = reportsService.getAllReports();
		model.addAttribute("reportList", reportList);

		List<String> adminNames = adminService.getAllAdminNames();
		model.addAttribute("adminNames", adminNames);
		model.addAttribute("users", users);
		model.addAttribute("admin", new Admin());
		return "user_report_register.html";
	}

	// 報告登録処理を行う
	@PostMapping("/user/report/create/process")
	public String processReportCreate(@RequestParam("reportTitle") String reportTitle,
			@RequestParam("reportFileName") MultipartFile reportFileName,
			@RequestParam("contentsOfReport") String contentsOfReport, @RequestParam("adminName") String adminName,
			Model model) {

		Users currentUser = (Users) session.getAttribute("loginUserInfo");
		if (currentUser == null) {
			return "redirect:/user/login";
		}

		Admin admin = adminService.getAdminName(adminName);
		if (admin == null) {
			model.addAttribute("message", "指定された管理者が存在しません。");
			return "user_report_register.html";
		}

		Reports report = new Reports();
		report.setReportTitle(reportTitle);
		report.setReportFileName(reportFileName.getOriginalFilename());
		report.setContentsOfReport(contentsOfReport);
		report.setAdminId(admin.getAdminId());
		report.setUserId(currentUser.getUserId());
		reportsService.createReport(report);

		// ファイルアップロード処理
		if (!reportFileName.isEmpty()) {
			try {
				byte[] bytes = reportFileName.getBytes();
				Path path = Paths
						.get("src/main/resources/static/uploads/directory/" + reportFileName.getOriginalFilename());
				Files.write(path, bytes);
				model.addAttribute("message", "ファイルがアップロードされました。");
			} catch (IOException e) {
				e.printStackTrace();
				model.addAttribute("message", "ファイルのアップロードに失敗しました。");
			}
		} else {
			model.addAttribute("message", "ファイルが存在しません。");
		}

		return "redirect:/user/report/list";
	}
}