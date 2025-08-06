package jpa.com.models.form;

import jakarta.validation.constraints.NotBlank;

public class AdminLoginForm {
    @NotBlank
    private String adminEmail;

    @NotBlank
    private String password;

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