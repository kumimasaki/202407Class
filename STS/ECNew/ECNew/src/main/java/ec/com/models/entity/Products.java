package ec.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
//product_idの設定
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productId;
	
	//product_categoryの設定
	private String productCategory;
	
	//product_descriptionの設定
	private String productDescription;
	
	//product_imageの設定
	private String productImage;
	
	//product_nameの設定
	private String productName;
	
	//admin_idの設定
	private Long adminId;

	//空のコンストラクタ
	public Products() {
	}

	//コンストラクタ
	public Products(String productCategory, String productDescription, String productImage, String productName,
			Long adminId) {
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productName = productName;
		this.adminId = adminId;
	}

	//ゲッターとセッター
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	
	
	
	
	
	
	
	
	
}
