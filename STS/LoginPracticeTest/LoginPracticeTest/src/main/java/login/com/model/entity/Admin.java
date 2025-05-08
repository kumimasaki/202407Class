package login.com.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	//管理者Id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long adminId;
	
	//管理者の名前
	private String adminName;
	
	//メールアドレス
	private String email;
	
	//パスワード
	private String password;

	public Admin() {
	}

	public Admin(String adminName, String email, String password) {
		this.adminName = adminName;
		this.email = email;
		this.password = password;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
