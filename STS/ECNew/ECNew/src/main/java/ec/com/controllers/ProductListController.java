package ec.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ec.com.models.entity.Admin;
import ec.com.models.entity.Products;
import ec.com.services.ProductsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductListController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ProductsService productsService;
	
	//商品一覧画面を表示する
	@GetMapping("/product/list")
	public String getProductList(Model model) {
		//セッションからログインしている人の情報を取得
		Admin admin = (Admin) session.getAttribute("loginAdminInfo");
	    //もし、admin==null　ログイン画面にリダイレクトする
		//そうでない場合
		//ログインしている人の名前の情報を画面に渡して商品一覧のhtmlを表示。
		if(admin == null) {
			return "redirect:/admin/login";
		}else{
			//商品の情報を取得する。
			List<Products> productList = productsService.selectAllProductList(admin.getAdminId());
			model.addAttribute("adminName", admin.getAdminName());
			model.addAttribute("productList", productList);
			return "product_list.html";
		}
	}
	
}
