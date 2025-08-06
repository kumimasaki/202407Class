package ec.com.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ec.com.models.dao.ProductsDao;
import ec.com.models.dto.ProductsDto;
import ec.com.models.entity.Products;
import ec.com.models.form.ProductRegisterForm;
import ec.com.models.form.ProductUpdateForm;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsDao productsDao;

    // 商品登録
    public void register(ProductRegisterForm form, Long adminId, String fileName) {
       
       
        	 Products product = new Products();
             product.setProductName(form.getProductName());
             product.setProductCategory(form.getProductCategory());
             product.setProductDescription(form.getProductDescription());
             product.setProductImage(fileName);
             product.setAdminId(adminId);
             productsDao.save(product);
		
    }

    // 商品一覧
    public List<ProductsDto> getAllProducts() {
        return productsDao.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 商品IDから取得
    public ProductsDto findById(Long productId) {
        Products product = productsDao.findByProductId(productId);
        return product == null ? null : convertToDto(product);
    }

    // 商品名チェック（重複登録防止）
    public boolean isProductNameExists(String productName) {
        return productsDao.findByProductName(productName) != null;
    }

    // 商品削除
    public void delete(Long productId) {
        productsDao.deleteByProductId(productId);
    }
    public boolean update(ProductUpdateForm form, String fileName) {
        Products product = productsDao.findByProductId(form.getProductId());
        if (product != null) {
            product.setProductName(form.getProductName());
            product.setProductCategory(form.getProductCategory());
            product.setProductDescription(form.getProductDescription());
            product.setProductImage(fileName);
            productsDao.save(product);
            return true;
        }else {
        	 return false;
        }
    }
    // Entity → DTO変換
    private ProductsDto convertToDto(Products product) {
        ProductsDto dto = new ProductsDto();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setProductCategory(product.getProductCategory());
        dto.setProductDescription(product.getProductDescription());
        dto.setProductImage(product.getProductImage());
        dto.setAdminId(product.getAdminId());
        return dto;
    }
}