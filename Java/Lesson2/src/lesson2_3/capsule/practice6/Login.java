package lesson2_3.capsule.practice6;

public class Login {

	// メンバ変数
	// ユーザー名
	private String userName;
	// パスワード
	private String password;
	
	// この設計書で唯一のインスタンス（実体）を保持する。
	private static Login login = new Login();

	// 外部からインスタンスが作成されないようにprivateにする
	private Login() {
		this.userName = "Admin";
		this.password = "1234abcd";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Login getLogin() {
		return login;
	}
	
	public void auth() {
		// ログイン成功した場合
		if (userName.equals("Admin") && password.equals("1234abcd")) {
			System.out.println("ログイン成功しました");
		}
	}
}
