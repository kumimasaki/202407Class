package ec.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.com.services.ProductsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductDeleteController {

    private final ProductsService productsService;

    @PostMapping("/product/delete")
    public String delete(@RequestParam Long productId,
                         HttpSession session) {
        if (session.getAttribute("loginAdmin") == null) {
            return "redirect:/admin/login";
        }

        productsService.delete(productId);
        return "redirect:/product/list";
    }
}
