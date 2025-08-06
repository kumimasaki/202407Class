package ec.com.models.dto;

import lombok.Data;

@Data
public class ProductsDto {
    private Long productId;
    private String productName;
    private String productCategory;
    private String productImage;
    private String productDescription;
    private Long adminId;
}