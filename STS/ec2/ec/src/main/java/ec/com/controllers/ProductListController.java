package ec.com.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ec.com.models.dto.ProductsDto;
import ec.com.services.ProductsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductListController {

    private final ProductsService productsService;

    @GetMapping("/product/list")
    public String list(Model model, HttpSession session) {
        List<ProductsDto> productList = productsService.getAllProducts();
        model.addAttribute("productList", productList);
        return "product_list";
    }
}