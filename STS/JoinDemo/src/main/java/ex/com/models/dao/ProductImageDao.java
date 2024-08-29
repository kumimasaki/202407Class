package ex.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ex.com.models.entity.ProductImageEntity;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface ProductImageDao extends JpaRepository<ProductImageEntity, Long> {
	ProductImageEntity save(ProductImageEntity productImageEntity);
	ProductImageEntity findByProductId(Long productId);
	int deleteByProductId(Long productId);
}
