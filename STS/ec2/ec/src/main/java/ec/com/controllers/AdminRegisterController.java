package ec.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ec.com.models.form.AdminRegisterForm;
import ec.com.services.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminRegisterController {

    private final AdminService adminService;

    @GetMapping("/admin/register")
    public String register(AdminRegisterForm form) {
        return "admin_register";
    }

    @PostMapping("/admin/register/process")
    public String registerProcess(@Valid AdminRegisterForm form,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "admin_register";
        }

        adminService.register(form);
        return "redirect:/admin/login";
    }
}