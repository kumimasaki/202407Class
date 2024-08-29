package ex.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductAndProductImgEntity {
	@Id
	private Long productId;
	private Long adminId;
	private Long productImageId;
	private String productName;
	private String productCategory;
	private String productMessage;
	private String productImage1;
	private String productImage2;
	
}
