package login.com.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import login.com.model.entity.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
	//データを保存insertメソッド
	Admin save(Admin admin);
	//SELECT * FROM admin WHERE email =?
	//用途：管理者を登録するときにメールアドレスが存在しているかどうかを判断する時に使用
	Admin findByEmail(String email);
	///SELECT * FROM admin WHERE email = ? AND password=?
	//用途：ログイン処理の際に使用 データがあればログイン処理ができる
	Admin findByEmailAndPassword(String email,String password);


}
