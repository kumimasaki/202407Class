package rp.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import rp.com.models.entity.Admin;
import rp.com.models.entity.Reports;
import rp.com.models.entity.Users;
import rp.com.services.AdminService;
import rp.com.services.ReportsService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class UserReportDetailsController {

	@Autowired
	private ReportsService reportsService;
	@Autowired
	private HttpSession session;
	@Autowired
	private AdminService adminService;

	// レポート詳細ページを表示するメソッド
	@GetMapping("/user/report/details")
	public String showReportDetails(@RequestParam("reportId") Long reportId, Model model) {
		Users users = (Users) session.getAttribute("loginUserInfo");
		Optional<Reports> reportOptional = reportsService.getReportById(reportId);
		if (reportOptional.isPresent()) {
			Reports report = reportOptional.get();
			model.addAttribute("report", report);
			model.addAttribute("users", users);

			Long adminId = report.getAdminId();
			Admin admin = adminService.getAdminById(adminId);
			model.addAttribute("admin", admin);
			return "user_report_detail.html";
		} else {
			return "redirect:/user/report/list";
		}
	}

	// レポート編集ページを表示するメソッド
	@GetMapping("/user/report/edit")
	public String showEditReport(@RequestParam("reportId") Long reportId, Model model) {
		Optional<Reports> reportOptional = reportsService.getReportById(reportId);
		if (reportOptional.isPresent()) {
			Reports report = reportOptional.get();
			model.addAttribute("report", report);
			return "/user/edit_report";
		} else {
			return "redirect:/user/report/list";
		}
	}

	// レポートの更新を処理するメソッド
	@PostMapping("/user/report/update")
	public String updateReport(@RequestParam("reportId") Long reportId, @RequestParam("title") String title,
			@RequestParam("contentsOfReport") String contentsOfReport,
			@RequestParam("reportFileName") MultipartFile file) throws IOException {
		Optional<Reports> reportOptional = reportsService.getReportById(reportId);
		if (reportOptional.isPresent()) {
			Reports report = reportOptional.get();
			report.setReportTitle(title);
			report.setContentsOfReport(contentsOfReport);

			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				String filePath = "path/to/save/files/" + fileName;
				file.transferTo(new File(filePath));
				report.setReportFileName(fileName);
			}
			reportsService.saveReport(report);
			return "redirect:/user/report/details?reportId=" + reportId;
		} else {
			return "redirect:/user/report/list";
		}
	}
}