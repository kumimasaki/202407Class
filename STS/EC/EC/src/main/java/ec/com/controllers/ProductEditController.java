package ec.com.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ec.com.models.dto.AdminDto;
import ec.com.models.dto.ProductsDto;
import ec.com.models.form.ProductUpdateForm;
import ec.com.services.ProductsService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductEditController {

    private final ProductsService productsService;

    // 編集画面表示
    @GetMapping("/product/edit/{productId}")
    public String edit(@PathVariable("productId") Long productId,
                       Model model,
                       HttpSession session) {

        AdminDto admin = (AdminDto) session.getAttribute("loginAdmin");
        if (admin == null) {
            return "redirect:/admin/login";
        }

        ProductsDto products = productsService.findById(productId);
        if (products == null) {
            return "redirect:/product/list";
          
        }
        model.addAttribute("products", products);

        return "product_edit";
    }

    // 編集処理
    @PostMapping("/product/edit/process")
    public String editProcess(@Valid ProductUpdateForm form,
                              BindingResult result,
                              HttpSession session,
                              Model model) throws IOException {

        if (result.hasErrors()) {
            return "product_edit";
        }

        AdminDto admin = (AdminDto) session.getAttribute("loginAdmin");
        if (admin == null) {
            return "redirect:/admin/login";
        }

        String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())+form.getProductImage();
		//ファイルの保存作業
		try {
			Files.copy(form.getProductImage().getInputStream(), Path.of("src/main/resources/static/product-img/"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(productsService.update(form, fileName)) {
			return "redirect:/product/list";
		}else {
			return "redirect:/product/edit/"+form.getProductId();
		}
        
        
    }
}