package jpa.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.com.models.form.AdminRegisterForm;
import jpa.com.models.form.AdminLoginForm;
import jpa.com.models.dao.AdminDao;
import jpa.com.models.dto.AdminDto;
import jpa.com.models.entity.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;

	// もし、adminEmailが既に存在していた場合、エラーメッセージを出して登録処理をしないようにする
	// そうでない場合、登録処理を行ってログイン画面を表示する
	// 登録処理が成功：true, 失敗：false
	public boolean createAdmin(AdminRegisterForm form) {
		if(adminDao.findByAdminEmail(form.getAdminEmail()) != null) {
			return false;
		} else {
			// 登録処理
			adminDao.save(new Admin(form.getAdminEmail(), form.getAdminName(), form.getPassword()));
			return true;
		}
	}
	
	// ログインチェック用のメソッド　メソッド名「loginCheck」
	// もし、「emailとpasswordの組み合わせ」が存在していない場合、nullを返す
	// そうでない場合、AdminDtoを返す
	public AdminDto loginCheck(AdminLoginForm form) {
        Admin admin = adminDao.findByAdminEmailAndPassword(
                form.getAdminEmail(), form.getPassword());
        if (admin == null) {
            return null;
        }
        return convertToDto(admin);
	}
	
    private AdminDto convertToDto(Admin admin) {
        AdminDto dto = new AdminDto();
        dto.setAdminId(admin.getAdminId());
        dto.setAdminEmail(admin.getAdminEmail());
        dto.setAdminName(admin.getAdminName());
        return dto;
    }
	
	
	
	
	
	
	
	
	
}
