package ex.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ex.com.models.entity.ProductAndProductImgEntity;


public interface ProductAndProductImgDao extends JpaRepository<ProductAndProductImgEntity, Long> {
	@Query(value="select p.admin_id,p.product_id,p.product_name,p.product_category,p.product_message,pi.product_image_id,pi.product_image1,pi.product_image2 from products p inner join product_images pi on p.product_id = pi.product_id where p.admin_id =?1",nativeQuery = true)
	List<ProductAndProductImgEntity>findProductAll(Long adminId);
	
	@Query(value="select p.admin_id,p.product_id,p.product_name,p.product_category,p.product_message,pi.product_image_id,pi.product_image1,pi.product_image2 from products p inner join product_images pi on p.product_id = pi.product_id where p.product_id =?1",nativeQuery = true)
	ProductAndProductImgEntity findProductData(Long productId);
	
}
