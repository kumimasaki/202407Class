package ec.com.models.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminLoginForm {
    @NotBlank
    private String adminEmail;

    @NotBlank
    private String password;
}