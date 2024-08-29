package ex.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.com.models.dao.ProductAndProductImgDao;
import ex.com.models.dao.ProductDao;
import ex.com.models.entity.ProductAndProductImgEntity;
import ex.com.models.entity.ProductEntity;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductAndProductImgDao productAndProductImgDao;

	public List<ProductAndProductImgEntity> selectAllProduct(Long adminId) {
		if (adminId == null) {
			return null;
		} else {
			return productAndProductImgDao.findProductAll(adminId);
		}
	}

	public boolean createProduct(Long adminId, String productName, String productCategory, String productMessage) {
		if (adminId == null) {
			return false;
		} else {
			productDao.save(new ProductEntity(productName, productCategory, productMessage, adminId));
			return true;
		}
	}

	public ProductEntity findLatestProduct(Long adminId) {
		if (adminId == null) {
			return null;
		} else {
			return productDao.findByLatestProductId(adminId);
		}
	}

	public ProductAndProductImgEntity findProduct(Long productId) {
		if (productId == null) {
			return null;
		} else {
			return productAndProductImgDao.findProductData(productId);
		}
	}

	public boolean editProduct(Long productId, Long adminId, String productName, String productCategory,
			String productMessage) {
		if (adminId == null || productId == null) {
			return false;
		} else {
			productDao.save(new ProductEntity(productId, productName, productCategory, productMessage, adminId));
			return true;
		}
	}

	public boolean deleteProduct(Long productId) {
		if (productId == null) {
			return false;
		} else {
			productDao.deleteByProductId(productId);
			return true;
		}
	}

}
