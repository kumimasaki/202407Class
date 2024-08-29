package ec.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Admin {
    //admin_idの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;
	
	//admin_email
	@NonNull
	private String adminEmail;
	
	//admin_name
	@NonNull
	private String adminName;
	
	//password
	@NonNull
	private String password;

//	//空のコンストラクタ
//	public Admin() {
//	}
//
//	//コンストラクタ
//	public Admin(String adminEmail, String adminName, String password) {
//		this.adminEmail = adminEmail;
//		this.adminName = adminName;
//		this.password = password;
//	}
//
//	//ゲッターとセッター
//	public Long getAdminId() {
//		return adminId;
//	}
//
//	public void setAdminId(Long adminId) {
//		this.adminId = adminId;
//	}
//
//	public String getAdminEmail() {
//		return adminEmail;
//	}
//
//	public void setAdminEmail(String adminEmail) {
//		this.adminEmail = adminEmail;
//	}
//
//	public String getAdminName() {
//		return adminName;
//	}
//
//	public void setAdminName(String adminName) {
//		this.adminName = adminName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
}
