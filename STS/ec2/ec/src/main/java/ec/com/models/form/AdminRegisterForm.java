package ec.com.models.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminRegisterForm {
    @NotBlank
    private String adminName;

    @NotBlank
    @Email
    private String adminEmail;

    @NotBlank
    private String password;
}