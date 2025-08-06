package ec.com.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ec.com.models.entity.Admin;
import ec.com.services.ProductsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductRegisterController {
   @Autowired
   private ProductsService productsService;
   
   @Autowired
   private HttpSession session;
   
   //商品画面の表示
   @GetMapping("/product/register")
   public String getProductRegisterPage(Model model) {
	   //セッションからログインしている人の情報をadminという変数に格納
	   Admin admin = (Admin) session.getAttribute("loginAdminInfo");
	   //もしadmin==null ログイン画面にリダイレクトする
	   //そうでない場合は、ログインしている人の名前を画面に渡す
	   //商品登録のhtmlを表示させる
	   if(admin == null) {
		   return "redirect:/admin/login";
	   }else {
		   model.addAttribute("adminName", admin.getAdminName());
		   return "product_register.html";
	   }
	   
   }
   
   //商品の登録処理
   @PostMapping("/product/register/process")
   public String productRegisterProcess(@RequestParam String productName,
		   @RequestParam String productCategory,
		   @RequestParam MultipartFile productImage,
		   @RequestParam String productDescription) {
	     //セッションからログインしている人の情報をadminという変数に格納
	     Admin admin = (Admin) session.getAttribute("loginAdminInfo");
	     
	     //もし、admin==nullだったら、ログイン画面にリダイレクトする
	     //そうでない場合は、画像のファイル名を取得
	     //画像のアップロード
	     //もし、同じファイルの名前がなかったら保存
	     //商品の一覧画面にリダイレクトする
	     //そうでない場合、商品登録画面にとどまります。
	     
	     if(admin == null) {
	    	 return "redirect:/admin/login";
	     }else {
	    	 //ファイルの名前を取得
	    	 /**
				 * 現在の日時情報を元に、ファイル名を作成しています。SimpleDateFormatクラスを使用して、日時のフォーマットを指定している。
				 * 具体的には、"yyyy-MM-dd-HH-mm-ss-"の形式でフォーマットされた文字列を取得している。
				 * その後、blogImageオブジェクトから元のファイル名を取得し、フォーマットされた日時文字列と連結して、fileName変数に代入
				 **/
	    	 String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())+productImage.getOriginalFilename();
	    	 
	    	 //ファイルの保存作業
	    	 try {
				Files.copy(productImage.getInputStream(), Path.of("src/main/resources/static/product-img/"+fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	 
	    	if(productsService.createProduct(productCategory, productDescription, fileName, productName, admin.getAdminId())) {
	    		return "redirect:/product/list";
	    	}else{
	    		 return "product_register.html";
	    	}
	     }
	     
	   
   }
}
