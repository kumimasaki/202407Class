package ex.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ex.com.models.entity.ProductEntity;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface ProductDao extends JpaRepository<ProductEntity, Long> {
	ProductEntity save(ProductEntity productEntity);

	List<ProductEntity>findAll();
	
	ProductEntity findByProductId(Long productId);

	ProductEntity findByProductName(String productName);
	
	int deleteByProductId(Long productId);
	
	@Query(value="select * from products where admin_id =?1 order by product_id desc limit 1",
			nativeQuery = true)
	ProductEntity findByLatestProductId(Long adminId);
}
