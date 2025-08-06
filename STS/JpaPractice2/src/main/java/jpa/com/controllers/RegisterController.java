package jpa.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jpa.com.models.form.AdminRegisterForm;
import jakarta.validation.Valid;
import jpa.com.models.dao.AdminDao;
import jpa.com.models.entity.Admin;
import jpa.com.services.AdminService;

@Controller
public class RegisterController {
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminService adminService;
	
	// 登録画面表示
	// 表示するためのURL：/register
	// メソッド名：getRegisterPage
	// 表示するファイルの名前：register.html
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("adminRegisterForm", new AdminRegisterForm()); 
		model.addAttribute("error", false);
		return "register.html";
	}
	
	@PostMapping("/register/process")
	public String registerProcess(@Valid AdminRegisterForm form,
									Model model) {
//		// もし、adminEmailが既に存在していた場合、エラーメッセージを出して登録処理をしないようにする
//		// そうでない場合、登録処理を行ってログイン画面を表示する
//		if(adminDao.findByAdminEmail(form.getAdminEmail()) != null) {
//			model.addAttribute("error", true);
//			return "register.html";
//		} else {
//			// 登録処理
//			adminDao.save(new Admin(form.getAdminEmail(), form.getAdminName(), form.getPassword()));
//			return "login.html";
//		}
		
		if(!adminService.createAdmin(form)) {
			model.addAttribute("error", true);
			return "register.html";
		} else {
			List<Admin> admin = adminDao.findAll();
			return "redirect:/login";
		}
	}
	
}
