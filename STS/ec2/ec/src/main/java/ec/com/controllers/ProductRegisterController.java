package ec.com.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import ec.com.models.dto.AdminDto;
import ec.com.models.form.ProductRegisterForm;
import ec.com.services.ProductsService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductRegisterController {

	private final ProductsService productsService;
    
	@GetMapping("/product/register")
	public String register(ProductRegisterForm form) {
		return "product_register";
	}

	@PostMapping("/product/register/process")
	public String registerProcess(@Valid ProductRegisterForm form,
			BindingResult result,
			HttpSession session) {

		if (result.hasErrors()) {
			return "product_register";
		}

		AdminDto admin = (AdminDto) session.getAttribute("loginAdmin");
		if (admin == null) {
			return "redirect:/admin/login";
		}

		// 同じ商品名が既に登録されているか確認
		if (productsService.isProductNameExists(form.getProductName())) {
			result.rejectValue("productName", "error.productName", "同じ商品名が既に存在します。");
			return "product_register";
		}

		//ファイルの名前を取得
		/**
		 * 現在の日時情報を元に、ファイル名を作成しています。SimpleDateFormatクラスを使用して、日時のフォーマットを指定している。
		 * 具体的には、"yyyy-MM-dd-HH-mm-ss-"の形式でフォーマットされた文字列を取得している。
		 * その後、blogImageオブジェクトから元のファイル名を取得し、フォーマットされた日時文字列と連結して、fileName変数に代入
		 **/
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())+form.getProductImage();
		//ファイルの保存作業
		try {
			Files.copy(form.getProductImage().getInputStream(), Path.of("src/main/resources/static/product-img/"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		productsService.register(form, admin.getAdminId(), fileName);
		return "redirect:/product/list";


	}
}