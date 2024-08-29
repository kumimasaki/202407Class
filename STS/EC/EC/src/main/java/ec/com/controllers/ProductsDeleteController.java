package ec.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import ec.com.models.entity.Admin;
import ec.com.services.ProductsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductsDeleteController {
   @Autowired
   private HttpSession session;
   
   @Autowired
   private ProductsService productsService;
   
   @PostMapping("/product/delete")
   public String productsDelete(Long productId) {
	// セッションからログインしている人の情報をadminという変数に格納
			Admin admin = (Admin) session.getAttribute("loginAdminInfo");
			// もしadmin==null ログイン画面にリダイレクトする
			if (admin == null) {
				return "redirect:/admin/login";
			} else {
				//もしdeleteProductの結果がtrueの時に、商品一覧にリダイレクトする
				//そうでない場合、　編集画面にリダイレクトする
				if(productsService.deleteProduct(productId)) {
					return "redirect:/product/list";
				}else {
					return "redirect:/product/edit"+productId;
				}
			}
   }
   
}
