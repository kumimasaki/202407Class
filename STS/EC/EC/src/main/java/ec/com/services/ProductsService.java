package ec.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.models.dao.ProductsDao;
import ec.com.models.entity.Products;

@Service
public class ProductsService {
	@Autowired
	private ProductsDao productsDao;

	// 商品一覧のチェック
	// もしadminId==null 戻り値としてnull
	// findAll内容をコントローラークラスに渡す
	public List<Products> selectAllProductList(Long adminId) {
		if (adminId == null) {
			return null;
		} else {
			return productsDao.findAll();
		}
	}

	//商品の登録処理チェック
	//もし、findByProductNameが==nullだったら、
	//保存処理
	//true
	//そうでない場合
	//false
	public boolean createProduct(String productCategory,
			String productDescription,
			String productImage,
			String productName,
			Long adminId) {
		if(productsDao.findByProductName(productName)==null) {
			productsDao.save(new Products(productCategory,productDescription,productImage,productName,adminId));
			return true;
		}else {
			return false;
		}

	}

	//編集画面を表示するときのチェック
	//もし、productId == null  null
	//そうでない場合、
	//	　findByProductIdの情報をコントローラークラスに渡す
	public Products productEditCheck(Long productId) {
		if(productId == null) {
			return null;
		}else {
			return productsDao.findByProductId(productId);
		}
	}
	
	//更新処理のチェックの
	
	//もし、productId==nullだったら、更新処理はしない
	//false
	//そうでない場合、
	//更新処理をする
	//コントローラークラスからもらった、productIdを使って、編集する前の、データを取得
	//変更するべきところだけ、セッターを使用してデータの更新をする。
	//trueを返す
	public boolean productUpdate(Long productId,
			String productCategory,
			String productDescription,
			String productImage,
			String productName,
			Long adminId) {
		if(productId == null) {
			return false;
		}else {
			Products products = productsDao.findByProductId(productId);
			products.setProductCategory(productCategory);
			products.setProductDescription(productDescription);
			products.setProductImage(productImage);
			products.setProductName(productName);
			products.setAdminId(adminId);
			productsDao.save(products);
			return true;
		}
	}
	
	//削除処理のチェック
	//もし、コントローラークラスから受け取ったproductIdがnull
	//false
	//そうでない場合、deleteByProductIdを使って削除処理
	//true
	public boolean deleteProduct(Long productId) {
		if(productId == null) {
			return false;
		}else {
			productsDao.deleteByProductId(productId);
			return true;
		}
	}
	

}
