package ex.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "product_images")
public class ProductImageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productImageId;
	@NonNull
	private String productImage1;
	@NonNull
	private String productImage2;
	
	@NonNull
	private Long productId;
}
