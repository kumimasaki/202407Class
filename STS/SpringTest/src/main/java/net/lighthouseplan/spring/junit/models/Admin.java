package net.lighthouseplan.spring.junit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	// admin_id の設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;
	// admine_email
	private String adminEmail;
	// admin_name
	private String adminName;
	// password
	private String password;

	// 空のコンストラクタ
	public Admin() {
	}

	// コンストラクタ(No adminId)
	public Admin(String adminEmail, String adminName, String password) {
		this.adminEmail = adminEmail;
		this.adminName = adminName;
		this.password = password;
	}

	// 全てのgetterとsetter
	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
