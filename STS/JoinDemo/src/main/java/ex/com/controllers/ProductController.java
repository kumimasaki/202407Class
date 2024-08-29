package ex.com.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ex.com.models.entity.AdminEntity;
import ex.com.models.entity.ProductAndProductImgEntity;
import ex.com.models.entity.ProductEntity;
import ex.com.services.ProductImageService;
import ex.com.services.ProductService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductImageService productImageService;

	@Autowired
	private HttpSession session;

	//商品一覧画面を表示させる
	@GetMapping("/product/list")
	public String getProductListPage(Model model) {
		//セッションからログインしている人の情報を取得してadminという変数に格納する
		AdminEntity admin = (AdminEntity) session.getAttribute("loginInfo");
		if (admin == null) {
			return "redirect:/login";
		} else {
			List<ProductAndProductImgEntity> productList = productService.selectAllProduct(admin.getAdminId());
			model.addAttribute("adminName", admin.getAdminName());
			model.addAttribute("productList", productList);
			return "item_list.html";
		}

	}

	@GetMapping("/product/register")
	public String getProductRegisterPage(Model model) {
		AdminEntity admin = (AdminEntity) session.getAttribute("loginInfo");
		if (admin == null) {
			return "redirect:/login";
		} else {
			model.addAttribute("adminName", admin.getAdminName());
			return "product_register.html";
		}
	}

	@PostMapping("/product/register/process")
	public String productRegister(@RequestParam String productName, @RequestParam String productCategory,
			@RequestParam MultipartFile productImage1, @RequestParam MultipartFile productImage2,
			@RequestParam String productMessage) {
		AdminEntity admin = (AdminEntity) session.getAttribute("loginInfo");
		if (admin == null) {
			return "redirect:/login";
		} else {
			String fileName1;
			String fileName2;

			if (productImage1.getOriginalFilename() == null || productImage1.getOriginalFilename().isEmpty()) {
				fileName1 = "no-img.jpg";
			} else {
				fileName1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
						+ productImage1.getOriginalFilename();
			}
			if (productImage2.getOriginalFilename() == null || productImage2.getOriginalFilename().isEmpty()) {
				fileName2 = "no-img.jpg";
			} else {
				fileName2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
						+ productImage2.getOriginalFilename();
			}

			if (productService.createProduct(admin.getAdminId(), productName, productCategory, productMessage)) {
				ProductEntity product = productService.findLatestProduct(admin.getAdminId());
				Long productId = product.getProductId();
				if (productImageService.createProductImages(fileName1, fileName2, productId)) {
					try {
						if (!fileName1.equals("no-img.jpg")) {
							Files.copy(productImage1.getInputStream(),
									Path.of("src/main/resources/static/product-img/" + fileName1));
						}

						if (!fileName2.equals("no-img.jpg")) {
							Files.copy(productImage2.getInputStream(),
									Path.of("src/main/resources/static/product-img/" + fileName2));
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "redirect:/product/list";
				} else {
					return "redirect:/product/register";
				}

			} else {
				return "redirect:/product/register";
			}

		}
	}

	@GetMapping("/product/edit/{productId}")
	public String getProductEditPage(@PathVariable Long productId, Model model) {
		AdminEntity admin = (AdminEntity) session.getAttribute("loginInfo");
		if (admin == null) {
			return "redirect:/login";
		} else {
			ProductAndProductImgEntity productList = productService.findProduct(productId);
			if (productList == null) {
				return "redirect:/product/list";
			} else {
				model.addAttribute("productList", productList);
			}
			return "product_edit.html";

		}
	}

	@PostMapping("/product/edit/process")
	public String productEdit(@RequestParam Long productId, @RequestParam String productName,
			@RequestParam String productCategory, @RequestParam MultipartFile productImage1,
			@RequestParam MultipartFile productImage2, @RequestParam String productMessage) {
		AdminEntity admin = (AdminEntity) session.getAttribute("loginInfo");
		if (admin == null) {
			return "redirect:/login";
		} else {
			String fileName1;
			String fileName2;

			if (productImage1.getOriginalFilename() == null || productImage1.getOriginalFilename().isEmpty()) {
				fileName1 = "no-img.jpg";
			} else {
				fileName1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
						+ productImage1.getOriginalFilename();
			}
			if (productImage2.getOriginalFilename() == null || productImage2.getOriginalFilename().isEmpty()) {
				fileName2 = "no-img.jpg";
			} else {
				fileName2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
						+ productImage2.getOriginalFilename();
			}

			if (productService.editProduct(productId, admin.getAdminId(), productName, productCategory,
					productMessage)) {
				if (productImageService.editProductImages(fileName1, fileName2, productId)) {
					try {
						if (!fileName1.equals("no-img.jpg")) {
							Files.copy(productImage1.getInputStream(),
									Path.of("src/main/resources/static/product-img/" + fileName1));
						}

						if (!fileName2.equals("no-img.jpg")) {
							Files.copy(productImage2.getInputStream(),
									Path.of("src/main/resources/static/product-img/" + fileName2));
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "redirect:/product/list";
				} else {
					return "redirect:/product/edit/" + productId;
				}

			} else {
				return "redirect:/product/edit/" + productId;

			}
		}
	}
	
	@PostMapping("/product/delete")
	public String delete(@RequestParam Long productId) {
		AdminEntity admin = (AdminEntity) session.getAttribute("loginInfo");
		if (admin == null) {
			return "redirect:/login";
		}else {
			if(productImageService.deleteProductImg(productId)) {
				if(productService.deleteProduct(productId)) {
					return "redirect:/product/list";	
				}else {
					return "redirect:/product/edit/"+productId;
				}
			}else {
				return "redirect:/product/edit/"+productId;
			}	
		}
		
	}

}
