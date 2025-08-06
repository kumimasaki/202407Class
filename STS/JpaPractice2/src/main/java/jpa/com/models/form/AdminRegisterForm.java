package jpa.com.models.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AdminRegisterForm {
    @NotBlank
    private String adminName;

    @NotBlank
    @Email
    private String adminEmail;

    @NotBlank
    private String password;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}