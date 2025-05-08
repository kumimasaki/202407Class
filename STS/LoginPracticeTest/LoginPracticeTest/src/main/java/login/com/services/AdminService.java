package login.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.com.model.dao.AdminDao;
import login.com.model.entity.Admin;

@Service
public class AdminService {
  @Autowired
  private AdminDao adminDao;
  
  //保存処理をするためのメソッド
  //もし、メールアドレスがテーブル内に存在しなかったら、登録処理をする
  //　→true
  //そうでない場合は登録処理はしない
  //　→false
  public boolean createAccount(String adminName,String email,String password) {
	  if(adminDao.findByEmail(email)==null) {
		  adminDao.save(new Admin(adminName,email,password));
		  return true;
	  }else {
		  return false;
	  }
  }
  
  //ログイン処理をするためのメソッド
  //もし、メールアドレスとパスワードに一致するデータがなかった場合→false
  //そうでない場合→true
  
  public boolean loginCheck(String email,String password) {
	  if(adminDao.findByEmailAndPassword(email, password)==null) {
		  return false;
	  }else {
		  return true;
	  }
  }
  
}
