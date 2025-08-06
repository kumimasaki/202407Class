package ec.com.models.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductUpdateForm {
	private Long productId;
    @NotBlank
    private String productName;

    @NotBlank
    private String productCategory;

    private MultipartFile productImage;

    @NotBlank
    private String productDescription;
}