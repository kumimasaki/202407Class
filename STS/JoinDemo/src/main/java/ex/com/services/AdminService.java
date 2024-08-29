package ex.com.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.com.models.dao.AdminDao;
import ex.com.models.entity.AdminEntity;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	//ログインチェック処理
	public AdminEntity loginCheck(String adminEmail,String password) {
		AdminEntity admin = adminDao.findByAdminEmailAndPassword(adminEmail, password);
		if(admin == null) {
			return null;
		}else {
			return admin;
		}
	}
	
	//保存処理
	public boolean registerCheck(String adminName,String adminEmail,String password) {
		AdminEntity admin = adminDao.findByAdminEmail(adminEmail);
		if(admin == null) {
			//現在の日時を取得
			LocalDateTime createAtDate = LocalDateTime.now();
			adminDao.save(new AdminEntity(adminName,adminEmail,password,createAtDate));
			return true;
		}else {
			return false;
		}
	}
 
}
