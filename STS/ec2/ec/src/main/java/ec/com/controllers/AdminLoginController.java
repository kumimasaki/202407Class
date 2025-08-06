package ec.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ec.com.models.dto.AdminDto;
import ec.com.models.form.AdminLoginForm;
import ec.com.services.AdminService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminLoginController {

    private final AdminService adminService;

    @GetMapping("/admin/login")
    public String login(AdminLoginForm form) {
        return "admin_login";
    }

    @PostMapping("/admin/login/process")
    public String loginProcess(@Valid AdminLoginForm form,
                               BindingResult bindingResult,
                               HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "admin_login";
        }

        AdminDto admin = adminService.loginCheck(form);
        System.out.println(admin+"controllerのソース");
        if (admin == null) {
            bindingResult.reject("loginError", "メールアドレスまたはパスワードが間違っています。");
            return "admin_login";
        }
       
        session.setAttribute("loginAdmin", admin);
        return "redirect:/product/list";
    }
}