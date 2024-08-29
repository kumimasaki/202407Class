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
@Table(name = "products")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	@NonNull
	private String productName;
	@NonNull
	private String productCategory;
	@NonNull
	private String productMessage;
	@NonNull
	private Long adminId;
		
}
