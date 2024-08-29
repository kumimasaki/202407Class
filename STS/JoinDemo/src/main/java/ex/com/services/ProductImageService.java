package ex.com.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.com.models.dao.ProductImageDao;
import ex.com.models.entity.ProductImageEntity;

@Service
public class ProductImageService {
	@Autowired
	private ProductImageDao productImageDao;


	public boolean createProductImages(String productImage1, String productImage2,Long productId) {
		if (productId == null) {
			return false;
		} else {		 	
			productImageDao.save(new ProductImageEntity(productImage1, productImage2, productId));
			return true;
		}
	}
	public boolean editProductImages(String productImage1, String productImage2,Long productId) {
		if (productId == null) {
			return false;
		} else {
			ProductImageEntity productImg = productImageDao.findByProductId(productId);
			productImg.setProductImage1(productImage1);
			productImg.setProductImage2(productImage2); 
			productImageDao.save(productImg);
			return true;
		}
	}
	
	public boolean deleteProductImg(Long productId) {
		if (productId == null) {
			return false;
		} else {
			productImageDao.deleteByProductId(productId);
			return true;
		}
	}
}
