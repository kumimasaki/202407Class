package blog.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  //ログイン画面の表示
  @GetMapping("/login")
  public String getLoginPage() {
	  return "login.html";
  }
  //ログイン処理
  @PostMapping("/login/process")
  public String loginProcess(@RequestParam String username,@RequestParam String password) {
	  //もし、画面から受け取った管理者の名前がadminと同じでなおかつ画面から受け取った管理者のパスワードが1234
	  if(username.equals("admin")&&password.equals("1234")) {
		  return "blog.html";
	  }else {
		  return "login.html";
	  }
  }
}
