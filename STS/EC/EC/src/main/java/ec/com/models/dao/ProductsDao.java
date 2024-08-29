package ec.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.models.entity.Products;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ProductsDao extends JpaRepository<Products, Long> {
    //保存処理と更新処理　insertとupdate
	Products save(Products products);
	
	//SELECT * FROM products
	//用途：商品の一覧を表示させるときに使用
	List<Products>findAll();
	
	//SELECT * FROM products WHERE product_name = ?
	//用途：商品の登録チェックに使用（同じ商品名が登録されないようにするチェックに使用）
	Products findByProductName(String productName);
	
	//SELECT * FROM products WHERE product_id = ?
	//用途：編集画面を表示する際に使用。
	Products findByProductId(Long productId);
	
	//DLETE FROM products WHERE product_id = ?
	//用途：削除使用します。
	void deleteByProductId(Long productId);
}
