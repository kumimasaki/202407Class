package ec.com.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.models.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {

	//保存処理と更新処理　insertとupdate
	Admin save(Admin admin);
	
	//SELECT * FROM admin WHERE admin_email = ?
	//用途：管理者の登録処理をするときに、同じメールアドレスがあったらば登録させないようにする
	//1行だけしかレコードは取得できない
	Admin findByAdminEmail(String adminEmail);
	
	//SELECT * FROM admin WHERE admin_email=? AND password=?
	//用途：ログイン処理に使用。入力したメールアドレスとパスワードが一致してるときだけデータを取得する
	Admin findByAdminEmailAndPassword(String adminEmail, String password);
	
}
